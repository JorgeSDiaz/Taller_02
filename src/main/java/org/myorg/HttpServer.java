package org.myorg;

import org.myorg.factories.PageFactory;
import org.myorg.http.HttpConnection;
import org.myorg.pages.Page;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Http server making resolves connection with fronted
 */
public class HttpServer {

    public static void main(String[] args) throws IOException {
        HttpConnection httpConnection = new HttpConnection("https://www.omdbapi.com/", "&apikey=2701988f");
        HashMap<String, String> pageCache = new HashMap<String, String>();
        PageFactory pageFactory = new PageFactory();
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

            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean firstLine = true;
            String path = "/Simple";
            while ((inputLine = input.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (firstLine) {
                    path = inputLine.split(" ")[1].equals("/") ? path : inputLine.split(" ")[1];
                    firstLine = false;
                }
                if (!input.ready()) {
                    break;
                }
            }

            String file =  path.split("/")[1];
            Page page;
            String data = "";
            String query = "";
            if (file.equals("json")) {
                if (pageCache.containsKey(file)) {
                    data = pageCache.get(file);
                } else {
                    query = path.split("/")[2];
                    data = httpConnection.getData(query);
                    pageCache.put(path.split("=")[1], data);
                }
                output.println(httpConnection.getData(query));
            } else {
                page = pageFactory.Page(file);
                output.println(page.getContent());
            }

            output.close();
            input.close();
            clientSocket.close();
        }
        serverSocket.close();
    }
}
