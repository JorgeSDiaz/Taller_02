package org.myorg.server.pages;

/**
 * Test Page
 */
public class SimplePage implements Page {
    @Override
    public String getContent() {
        return """
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
