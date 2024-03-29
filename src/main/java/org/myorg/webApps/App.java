package org.myorg.webApps;

import org.myorg.server.http.HttpServer;
import org.myorg.server.services.RESTService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.getInstance();
        // Services : message: Json, hello: html, api: html-ccs-js -> json, pageTest: html-css-js
        server.addService("message",
                new RESTService() {
                    @Override
                    public List<String> getHeader() {
                        List<String> header = new ArrayList<>() ;
                        header.add("HTTP/1.1 200 OK") ;
                        header.add("Content-Type: application/json") ;
                        return header ;
                    }

                    @Override
                    public String getResponse() {
                        return """
                                {"Message" : "Hello"}
                                """ ;
                    }
                });
        server.addService("hello", new HelloService());
        server.addService("api", new ApiService());
        server.addService("pageTest", new RESTService() {
            @Override
            public List<String> getHeader() {
                List<String> header = new ArrayList<>() ;
                header.add("HTTP/1.1 200 OK") ;
                header.add("Content-Type: text/html") ;
                return header ;
            }

            @Override
            public String getResponse() {
                return """
                        <!DOCTYPE html>
                        <html lang="en">
                          <head>
                            <meta charset="UTF-8" />
                            <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
                            <style>
                              body {
                                font-family: Arial, sans-serif;
                                margin: 0;
                                padding: 0;
                              }
                                                
                              header {
                                background-color: lightgray;
                                padding: 20px;
                              }
                                                
                              nav ul {
                                display: flex;
                                list-style: none;
                                margin: 0;
                                padding: 0;
                              }
                                                
                              nav a {
                                color: black;
                                display: block;
                                padding: 10px 20px;
                                text-decoration: none;
                              }
                                                
                              main {
                                padding: 20px;
                                text-align: center;
                              }
                                                
                              footer {
                                background-color: lightgray;
                                bottom: 0;
                                padding: 10px;
                                position: absolute;
                                width: 100%;
                                text-align: center;
                              }
                            </style>
                            <script>
                              function mostrarMensaje() {
                                alert("¡Bienvenido a mi página web!");
                              }
                                                
                              function cambiarColorDeFondo() {
                                var color = document.getElementById("color").value;
                                document.body.style.backgroundColor = color;
                              }
                            </script>
                            <title>Page</title>
                          </head>
                          <body onload="mostrarMensaje()">
                            <header>
                              <nav>
                                <ul>
                                  <li><a href="#">Inicio</a></li>
                                  <li><a href="#">Acerca de</a></li>
                                  <li><a href="#">Contacto</a></li>
                                </ul>
                              </nav>
                            </header>
                            <main>
                              <h1>Bienvenidos a Mi Página Web</h1>
                              <input type="text" id="color" />
                              <button onclick="cambiarColorDeFondo()">Cambiar color de fondo</button>
                            </main>
                            <footer>
                              <p>Copyright &copy; 2021 Por Mi</p>
                            </footer>
                          </body>
                        </html>
                        """;
            }
        });
        server.run();
    }
}
