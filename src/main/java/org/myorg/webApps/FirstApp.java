package org.myorg.webApps;

import org.myorg.server.http.HttpServer;
import org.myorg.server.services.RESTService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstApp {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        server.addService("message",
                new RESTService() {
                    @Override
                    public List<String> getHeader() {
                        List<String> header = new ArrayList<>();
                        header.add("HTTP/1.1 200 OK");
                        header.add("Content-Type: application/json");
                        return header;
                    }

                    @Override
                    public String getResponse() {
                        return """
                                {"Message" : "Hello"}
                                """;
                    }
                });
        server.addService("hello", new HelloService());
        server.run();
    }
}
