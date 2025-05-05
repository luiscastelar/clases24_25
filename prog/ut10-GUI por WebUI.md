---
Title: Interfaces gráficas de usuario - WebUI
Author: Luis Ferreira Gordillo
Publish: 4 de abril de 2025
Update: 3 de mayo de 2025
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
+ **Web Browser HTML+CSS+JS (AJAX)**

**Capa servidor**: Contenedor web
    +   `JSP` para la _capa vista_ y accesos básicos[^1].
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
## Ciclo de vida:
1. Inicio `public void init()` (la primera vez que es llamado el servlet).
2. Servicio:
   + método `doGet()`
   + método `doPost()`
   + método `doPut()`,
   + método `doDelete()`,
3. `public void destroy()` para cierre de conexiones y similar.
4. Recoletor de basura

## Captura de parámetros
    getParameter() − Llama al método request.getParameter() para obtener el valor de un parámetro de formulario.

    getParameterValues() − Llame a este método si el parámetro aparece más de una vez y devuelve múltiples valores, por ejemplo, casilla de verificación.

    getParameterNames() − Llame a este método si desea una lista completa de todos los parámetros en la solicitud actual.


# Web-Interfaces de Usuario - WebUI
Este proyecto realiza un acercamiento a las GUI mediante la creación de Web-UI mediante las tecnologías ya conocidas por el alumnado de primer curso de DAW/DAM en el último trimestre de curso.

Concretamente, emplearemos la pila tecnológica:
+ HTML (vista en LMSGI)
+ JS (vista en LMSGI)
+ Servlets

Por su puesto, también CSS, pero no es objeto de este proyecto.

Para la creación de servlet debemos pasar de Java SE a Jakarta EE (antes conocido como Java EE), para lo que vamos a realizar un proceso evolutivo desde el servicio más básico "hola mundo", hasta aplicación completa con sesiones y cookies.

## HelloServlet
1. Creación de servlets extendiendo la clase `HttpServlet`.
2. Publicando el servlet con la anotación `@WebServlet('/holaMundo')`
3. Ciclo de vida de un servlet: `init()`, vida, `destroy()`.
4. Métodos `doGet` y `dPost` para procesado de peticiones.
5. Creando la respuesta con `response.setContentType("text/html");` y `PrintWriter out = response.getWriter();`
6. Pruebas de servlets:
   + Navegador web:
     - GET con la ruta.
     - POST con formularios de html.
   + CURL:
     - GET con la ruta.
     - POST con `curl --data '{ "arg": "valor", ... }' --header 'Content-type: application-json' http://localhost:8080/miPrimerServlet_war_exploded/holaMundo`
   + Plug-in VSC `Thunder Client`
   + Plug-in IntelliJ `Restful Api Tool`
   
## Echo
Obteniendo argumentos GET con `String nombre = request.getParameter("nombre");` y evitando errores con la función `private String nullish(String texto) { return texto == null ? "" : texto; }`

## EchoArray
En ocasiones recibimos parámetros que son arrays de valores `String[] nombres = request.getParameterValues("nombre");`. 

En nuestro caso, utilizaremos una función que realiza la función de unirlo en un solo String:
```java
private String reverseSplit(String ...vector){
        if(vector == null) return "";
        StringBuffer sb = new StringBuffer();
        for(String v : vector){
            sb.append(v+" ");
        }
        return sb.toString().substring(0, sb.length()-1);
}
```

Aunque en realidad, sería tan sencillo como convertirlo en un `stream` y utilizar el colector `Collector.joining(" ")`, esto es `String nombreCompuesto = Arrays.stream(nombres).collect(java.util.stream.Collectors.joining(" ")) ;`

## EchoJson
La realidad es que hoy en día, las comunicaciones se realizan normalmente en json, pues vamos a capturar los argumentos recibidos en un GET y devolverlo como archivo json.

```java
response.setContentType("application/json");
//...
Persona persona = new Persona(nombre, apellido);
Gson gson = new GsonBuilder().setPrettyPrinting().create();
String json = gson.toJson(persona);

PrintWriter out = response.getWriter();
out.println(json);
```

## JsonJson
La cosa se complica si también recibimos un json... aunque no demasiado:
```java
BufferedReader reader = request.getReader(); //Se toma la fuente de datos de la solicitud
Operacion operacion = gson.fromJson(reader, Operacion.class); //Se instancia la clase Operacion como un objeto JSON que apunta a la fuente de datos
//...
// Lo visto en el ejercicio anterior
```
La clase o el `record` `Operacion` debe contemplar el objeto recibido, si no fallará.

## Chat
Algo de memoria, aunque se volátil.

En el `init()` inicializaremos una `List` o un `Map` que nos permita tener una persistencia, cargando datos desde disco o base de datos.

Al finalizar la ejecución, en `destroy()` volcaremos la memoria a disco o bbdd.

Durante la ejecución, `mensajes.add()` o `mensajes.put()` nos permitirá gestionar dicha memoria.

## Login (sesiones y cookies)
### Cookies
Las `cookies` son elementos de persistencia en el lado del cliente. Cada servidor sólo puede acceder a la suya, por seguridad y mandar una al cliente es trivial desde Java:
```java
final int PERMANENCIA = 2 * 60 * 60; // Para una caducidad de 2 horas
//...
// Creamos la cookie, le asignamos caducidad (no obligatorio), le damos visibilidad y la asociamos a la respuesta
Cookie cookieUsuario = new Cookie("usuario", user);
cookieUsuario.setMaxAge( PERMANENCIA );
cookieUsuario.setPath("/");
response.addCookie( cookieUsuario );
```

### Sesiones
=== Por desarrollar ===

## Acceso a Base de Datos
Cuando tratamos con bbdd lo más complejo es determinar donde se encuentra el archivo de `porperties` con las credenciales de acceso, ya que puede ser complejo encontrarlo si no tenemos cuidado. 

La recomendación oficial, tomar el contexto relativo al servlet con `String file = getServletContext().getRealPath("/WEB-INF/resources/archivo.properties");`

Luego, podremos utilizar tranquilamente nuestros `Contratos` o `Dao`, por ejemplo:
```java
// en init()
// Open a connection
conn = ContratoCoches.getConnection(file);

// en doGet o dPost
// uso de la implementación DAO que tengamos ya disponible.
```

## Acceso a archivos
### Subida
=== Por desarrollar ===

### Descarga
=== Por desarrollar ===


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
[^2] La tecnología JSP está marcada como obsoleta y se desaconseja su uso para nuevas aplicaciones frente a `JSF`. Pese a ésto, el número de aplicaciones en funcionamiento y su simplicidad se hace ideal para introducirnos en el mundo de Jakarta EE.