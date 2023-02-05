package org.myorg.server.pages;

/**
 * Page with form to make a query to an api
 */
public class FormPage implements Page {
    @Override
    public String getContent() {
        return """
                HTTP/1.1 200 OK\r
                Content-Type: text/html\r
                \r
                <!DOCTYPE html>
                <html>
                  <head>
                    <title>Movies</title>
                    <meta charset="UTF-8" />
                    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                    <style>
                      label {
                        color: red;
                        font-size: 25px;
                      }
                      input[type="text"]{
                       width: 150px;
                       height: 30px;
                       font-size: 15px;
                       color: darkgray;
                      }
                      input[type="text"]:focus {
                        color: black;
                      }
                      input[type="button"] {
                        width: 100px;
                        height: 25px;
                      }
                    </style>
                  </head>
                  <body>
                    <h1>GET Movie by Title</h1>
                    <form action="/json">
                      <label for="name">Title  </label>
                      <input type="text" id="title" value="  indiana" /><br /><br />
                      <input type="button" value="Submit" onclick="loadGetMsg()" />
                    </form>
                    <br>
                    <div id="getrespmsg"></div>
                    <script type="text/javascript">
                      function loadGetMsg() {
                        let title = document.getElementById("title");
                        let url = "json/?t=" + name.title;
                        fetch(url, { method: "GET", mode:"no-cors"})
                          .then((x) => x.text())
                          .then((y) => (document.getElementById("getrespmsg").innerHTML = y));
                      }
                    </script>
                  </body>
                </html>
                                 """
                ;
    }
}
