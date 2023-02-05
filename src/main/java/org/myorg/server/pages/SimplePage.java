package org.myorg.server.pages;

/**
 * Test Page
 */
public class SimplePage implements Page {
    @Override
    public String getContent() {
        return """
                HTTP/1.1 200 OK\r
                Content-Type: text/html\r
                \r
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                <title>Title of the document</title>
                </head>
                <body>My Web Site</body>
                </html>
                """
                ;
    }
}
