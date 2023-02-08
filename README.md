# TALLER 2: Diseño y estructuración de aplicaciones distribuidas en internet
Se construye un servidor Web que nos permite obtener archivos (.jpg, .html, .css, .js) de un servidor (En este caso nuestra maquina en la carpeta resources, que se ubica dentro del proyecto) así como acceder a RESTServices que se alojan en la ruta "/apps/..."

---
### Prerrequisitos
Para elaborar este proyecto requerimos de las siguientes tecnologias:

 - **[Maven](https://openwebinars.net/blog/que-es-apache-maven/)**: Apache Maven es una herramienta que estandariza la configuración de un proyecto en todo su ciclo de vida.
 - **[Git](https://learn.microsoft.com/es-es/devops/develop/git/what-is-git)**: Es un sistema de control de versiones distribuido (VCS).

---
###  Instalación
Primero clonamos el repositorio

     git clone https://github.com/jorge-stack/Taller_02.git
    
Se accede al repositorio que acabamos de clonar

	 cd Taller_02

Hacemos la construccion del proyecto

	 mvn clean package install
---
### Corriendo
Ahora corremos el servidor

**Windows**

	 mvn exec:java -"Dexec.mainClass"="org.myorg.webApps.App"

**Linux/MacOs**

	 mvn exec:java -Dexec.mainClass="org.myorg.webApps.App"

Por ultimo accedemos a Firefox con la siguiente URL

	 https://localhost:32000/

Aqui nos debera de cargar la siguiente pagina, con la cual podemos empezar a hacer las busquedas que necesitemos

![MainPage](https://i.imgur.com/OtEIWJo.png)
---
## Casos de Uso
### Trayendo Archivos

### index.html
	https://localhost:32000/index.html
![index.html](https://i.imgur.com/3yNEITf.png)
### style.css
	https://localhost:32000/style.css
![style.css](https://i.imgur.com/6aPyTaX.png)
### index.js
	https://localhost:32000/index.js
![index.js](https://i.imgur.com/4ljzKsS.png)
### image.jpg
	https://localhost:32000/image.jpg
![image.jpg](https://i.imgur.com/Sn04NL3.png)
### minions.jpg
	https://localhost:32000/minions.jpg
![minions.jpg](https://i.imgur.com/0uW2SmR.png)
* Si abre las opciones de desarrollo en su navegador, podrá apreciar como cada archivo viene con su correspondiente MIME

### RestService
	https://localhost:32000/apps/
![RestServices](https://i.imgur.com/xLwFZFs.png)
### hello (HTML)
	https://localhost:32000/apps/hello
![hello](https://i.imgur.com/wUcaCjH.png)
### message (Json)
	https://localhost:32000/apps/message
![message](https://i.imgur.com/vnjAqnT.png)
### api (HTML + CSS + JS  ->  JSON)
	https://localhost:32000/apps/api
![api](https://i.imgur.com/FJvrjdF.png)
### pageTest (HTML + CSS + JS)
	https://localhost:32000/apps/pageTest 
![pageTest ](https://i.imgur.com/7ESbTLP.png)

---
## Corriendo test

Ejecutamos el comando

	mvn Test
	
---
## Construido con

* [Maven](https://maven.apache.org/): Apache Maven es una herramienta que estandariza la configuración de un proyecto en todo su ciclo de vida.
* [Git](https://rometools.github.io/rome/):  Es un sistema de control de versiones distribuido (VCS).
* [IntelliJ](https://www.jetbrains.com/idea/): Es un entorno de desarrollo integrado para el desarrollo de programas informáticos.
* [Java 19](https://www.java.com/es/): Lenguaje de programación de propósito general, es decir, que sirve para muchas cosas, para web, servidores, aplicaciones móviles, entre otros. Java también es un lenguaje orientado a objetos, y con un fuerte tipado de variables.
* [Html](https://developer.mozilla.org/es/docs/Learn/Getting_started_with_the_web/HTML_basics): Es el código que se utiliza para estructurar y desplegar una página web y sus contenidos.
* [JavaScript](https://developer.mozilla.org/es/docs/Learn/JavaScript/First_steps/What_is_JavaScript): JavaScript es un lenguaje de programación o de secuencias de comandos que te permite implementar funciones complejas en páginas web
* [CSS](https://developer.mozilla.org/es/docs/Learn/CSS/First_steps/What_is_CSS):Las hojas de estilo en cascada permiten crear páginas web atractivas.

## Autor
* **[Jorge David Saenz Diaz](https://co.linkedin.com/in/jorgedsaenzd/en)**  - [Jorge-Stack](https://github.com/jorge-stack?tab=repositories)

## Licencia
**©** Jorge David Saenz Diaz, Estudiante de Ingeniería de Sistemas de la Escuela Colombiana de Ingeniería Julio Garavito.
