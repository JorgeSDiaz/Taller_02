package org.myorg.server.http;

import org.myorg.server.pages.FormPage;
import org.myorg.server.pages.SimplePage;
import org.myorg.server.services.RESTService;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Http server making resolves connection with fronted
 */
public class HttpServer {

    static HttpServer _instance = new HttpServer();
    Map<String, RESTService> services = new HashMap<>();
    Map<String, String> pageCache = new HashMap<String, String>();
    HttpConnection httpConnection = new HttpConnection("https://www.omdbapi.com/", "&apikey=2701988f");

    public HttpServer() {
    }

    public static HttpServer getInstance() {
        return _instance;
    }

    public void run() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(32000);
        } catch (IOException e) {
            System.out.println("Couldn't listen on port: 32000");
            System.exit(1);
        }

        Socket clientSocket = null;
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Ready to receive");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Accept failed");
                System.exit(1);
            }

            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter output = new PrintWriter(outputStream, true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean firstLine = true;
            String path = "/Simple";
            while ((inputLine = input.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (firstLine) {
                    if (!inputLine.split(" ")[1].equals("/")) {
                        path = inputLine.split(" ")[1];
                    }
                    firstLine = false;
                }
                if (!input.ready()) {
                    break;
                }
            }

            List<String> header = getHeader(path);

            for (String line : header) {
                output.println(line);
            }
            output.println();

            if (path.endsWith(".jpg")) {
                byte[] data = getFileByteData(path);
                outputStream.write(data);
            } else {
                String data = getResp(path);
                output.println(data);
            }

            output.close();
            input.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    public void addService(String key, RESTService restService) {
        services.put(key, restService);
    }

    private String executeService(String serviceName) {
        String header = "";
        String body = "";
        if (services.containsKey(serviceName)) {
            RESTService restService = this.services.get(serviceName);
            body = restService.getResponse();
        } else {
            header = getHeader("/").toString();
            body = "Service not found";
        }

        return body;
    }

    private String getResp(String path) throws IOException {
        String data = new SimplePage().getContent();

        if (path.startsWith("/json")) {
            data = getJsonResp(path);
        } else if (path.startsWith("/apps")) {
            data = executeService(path.split("/").length > 2 ? path.split("/")[2] : "");
        } else if (path.startsWith("/form")) {
            data = new FormPage().getContent();
        } else if (path.endsWith(".html") || path.endsWith(".css") || path.endsWith(".js")) {
            data = getFileTextResponse(path);
        }

        return data;
    }

    private String getJsonResp(String path) throws IOException {
        String title = path.split("=")[1];
        String data = "";
        if (pageCache.containsKey(title)) {
            data = pageCache.get(title);
        } else {
            data = httpConnection.getData(path.split("/")[2]);
            pageCache.put(title, data);
        }

        return data;
    }

    private String getFileTextResponse(String file) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/java/resources/" +
                file.split("/")[1])));
    }

    private byte[] getFileByteData(String file) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/java/resources/" +
                file.split("/")[1]));
    }

    public List<String> getHeader(String file) {
        List<String> header = new ArrayList<>();
        header.add("HTTP/1.1 200 OK");
        String contentType = "Content-Type: ";
        if (file.endsWith(".html")) {
            contentType += "text/html";
        } else if (file.endsWith(".css")) {
            contentType += "text/css";
        } else if (file.endsWith(".js")) {
            contentType += "text/javascript";
        } else if (file.endsWith(".jpg")) {
            contentType += "image/jpeg";
        } else if (file.startsWith("/apps") && file.split("/").length > 2) {
                header = services.get(file.split("/")[2]).getHeader();
        } else {
            contentType += "text/plain";
        }
        header.add(contentType);


        return header;
    }

}
