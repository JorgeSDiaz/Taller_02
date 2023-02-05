package org.myorg.webApps;

import org.myorg.server.services.RESTService;

import java.util.ArrayList;
import java.util.List;

public class HelloService implements RESTService {
    @Override
    public List<String> getHeader() {
        List<String> header = new ArrayList<>();
        header.add("HTTP/1.1 200 OK");
        header.add("Content-Type: text/html");
        return header;
    }

    @Override
    public String getResponse() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                <title>HS</title>
                </head>
                <body>Hello Service</body>
                </html>
                """;
    }
}
