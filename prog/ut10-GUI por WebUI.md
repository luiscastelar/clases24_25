---
Title: Interfaces gráficas de usuario - WebUI
Author: Luis Ferreira Gordillo
Publish: 4 de abril de 2025
Update: 4 de abril de 2025
---
#curso24_25 #curso22_23 #prog [estado::Working]


# JAKARTA EE

## Introducción
La Fundación Eclipse asumió en 2017 el proceso de desarrollo y estandarización de Java EE. A partir de ese momento y por motivos de derechos de nombres, Java EE pasa a denominarse Jakarta EE.

Jakarta EE se asienta sobre Java SE y lo desarrolla hacia la web, el ámbito empresarial y el acceso a datos (bases de datos).

## Referencias:

+   [Jakarta EE Tutorial OFICIAL](https://eclipse-ee4j.github.io/jakartaee-tutorial/)
+   [Jakarta EE 10 - Presentación OFICIAL](https://docs.google.com/presentation/d/1LBjjJg64j0HjmFu6m3EApN--mkavemyPFMUobIbGZds/edit#slide=id.g14a74e03a56_1_512)

## Overview (sumario)
+   Modelo 2 capas: cliente - datos
+   Modelo 3 capas: cliente - servidor - datos
+   Modelo 4 capas: cliente - contenedor web - lógica de negocio - datos.  


**Capa cliente**: 
+ Java SE
+ Java FX
+ **Web Browser HTML+CSS+JS (AJAX)**[^1]

**Capa servidor**: Contenedor web
    +   `JSP` para la _capa vista_ y accesos básicos[^2].
    +   `Servlet` para la _capa controlador_.
+   Capa de lógica de negocio:
    +   Utilizaremos las Entreprise Bean `EJB` para la _capa de modelo_, esto es el acceso a los datos.

# Herramientas
Dado que el número de tecnologías que requiere Jakarta es elevado y el IDE utilizado hasta este momento `IntelliJ Comunity Edition` no da soporte a las mismas, deberemos optar por una de las 2 siguientes soluciones:
+ Instalar `IntelliJ Ultimate` y activar la licencia de uso educativo.
+ Continuar el desarrollo con `NetBeans`

El alumnado que selecciones la primera opción, por otra parte recomendada, deberá NO asociar archivos `.java` ni `pom.xml` a dicho IDE, para no interferir con las actividades a realizar de otras unidades. 

Además, el alumno deberá debabilitar todos los plugins de Inteligencia Artificial. 

La utilización de cualquier asistente de inteligencia artificial supondrá la calificación de 0 puntos en la unidad, independiente del motivo de uso. Sois los únicos responsables de desactivar todo asistente.

## Test servlet:

1. Con el front (la página JSP o HTML+JS)
2. Con el navegador web (sólo para los get)
3. Con Postman o el plugin para VS Thunder Client (sólo para API REST)
4. En Bash:
   + GET usuario 1234: `curl http://example.com/users?uruario=1234`
   + POST json: `curl --data '{"name":"bob"}' --header 'Content-Type: application/json' http://example.com/users/1234` o `curl -d "@archivo.json -H 'Content-Type: application/json' http://example.com/users/1234`
   + Subir archivo: `curl -X POST -F 'field=@"/path/to/file.txt";filename="nuevoNombre.txt' https://postman-echo.com/post`  o podemos subir varios añadiendo mas campos `-F`
5. Con PS: 
``` html
	PS C:\Users\iescastelar>$URI="https://tc.luiscastelar.duckdns.org/jsp/holaAjax2"
	PS C:\Users\iescastelar> $ARGUMENTOS="texto=hola%20mundo"
	PS C:\Users\iescastelar> $PET=$URI+"?"+$ARGUMENTOS
	PS C:\Users\iescastelar> Write-Host $PET
	PS C:\Users\iescastelar> $Response = Invoke-WebRequest -URI $PET
	PS C:\Users\iescastelar> $Response.StatusCode
	200
	PS C:\Users\iescastelar> $Response.Content
	<h2>hola mundo</h2>
	PS C:\Users\iescastelar> $Response.RawContent
	HTTP/1.1 200 OK
	Alt-Svc: h3=":443"; ma=2592000
	Content-Length: 20
	Content-Type: text/plain; charset=utf-8
	Date: Fri, 19 May 2023 05:57:15 GMT
	Server: Caddy
	
	<h2>hola mundo</h2>
```

# Servlet
![servlets](https://www.tutorialspoint.com/servlets/images/servlet-arch.jpg)

1. `/helloworld`
2. `/echo`
3. `/echo-json`
4. `/json-json`
5. Acceso a librerías
6. Un “simple chat”


## Almacenamiento en el cliente
+ Session 
+ [cookie - local storage](https://netmind.net/es/cookies-vs-localstorage-cual-es-la-mejor-opcion/)
+ [cookie - session - local storage](https://es.stackoverflow.com/questions/198482/cual-es-la-diferencia-entre-las-cookies-y-sessionstorage-localstorage)


## Websockets
[Ejemplo](https://studentofjava.blog/building-real-time-applications-with-java-servlets-and-websockets/)


# JSP
1. Directivas `<%@ ... ; %>`
2. Declaraciones `<%! ... ; %>`
3. Expresiones `<%=  ... %>` -> Sin punto y coma al final. Lo transforma en ` out.print( Obj.toString() ) `
4. Scriptlets `<% ... ; %>`


# Referencias
+ [Java EE 5 - Tutorial OFICIAL](https://docs.oracle.com/javaee/5/tutorial/doc/bnaay.html)
+ [Servlet y jsp](http://static1.1.sqspcdn.com/static/f/923743/14770633/1416082087870/JavaEE.pdf)


---
# Notas:
[^1] Ajax puede utilizar `XMLRequest`, `jQuery` o `fecth`.


[^2] La tecnología JSP está marcada como obsoleta y se desaconseja su uso para nuevas aplicaciones frente a `JSF`. Pese a ésto, el número de aplicaciones en funcionamiento y su simplicidad se hace ideal para introducirnos en el mundo de Jakarta EE.