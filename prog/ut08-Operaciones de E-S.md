#curso24_25 #curso22_23 #prog [estado::ToDo]

# Ficheros de texto

## Archivos _properties_
La clase _Properties_ en java es una wrapper sencillo para poder evitar datos harcodeados en nuestros programas.

Ejemplo:
```java
//...
// Ubicación del archivo (desde la raíz del proyecto - junto al pom.xml)
String path = "./src/main/resources/";
String archivo = path + "config.properties";
try {
    // Stream del archivo
    FileInputStream streamDeEntradaDeArchivo = new FileInputStream(archivo);

    // Generamos objeto Propoerties y cargamos el stream
    Properties propiedades = new Properties();
    propiedades.load( streamDeEntradaDeArchivo );

    // Cargamos propiedades (valores)
    VALOR_MINIMO = Integer.valueOf( (String)propiedades.get("VALOR_MINIMO") );
    VALOR_MAXIMO = Integer.valueOf(  propiedades.getProperty("VALOR_MAXIMO") );

    // Recorremos TODOS mostrando valores
    propiedades.forEach((clave, valor) -> System.out.println("Clave: " + clave + " - valor= " + valor)  );

    // Y añadir propiedades (valores)
    propiedades.setProperty("nueva", "valorNuevo");

} catch (FileNotFoundException fnfe){
    System.out.println("El archivo " + archivo + " no existe.");
} catch (IOException ioe){
    System.out.println("No se puede leer archivo.");
}
//...
```

Podemos estudiar su uso [aquí](https://www.arquitecturajava.com/java-properties-files-y-como-usarlos/).

_**Nota**: a partir de este punto, está completamente **prohibido harcodear** ningún dato y/o ruta en nuestros programas. Todos los programas harán uso del archivo `config.properties` del que tomarán las variables y rutas que se os indique en cada ejercicio/práctica/examen._

[Vídeo refuerzo](https://www.youtube.com/watch?v=v8ToJLBBfq8&list=PLTd5ehIj0goOxCwlYFWTKCYH1KeUx1qB1)

## Lectura de archivos

### Clase `File`
✅ visto

### Clase `Scanner`
✅ visto

### Clase `FileReader`
✅ visto

Fuente: [Lectura y escritura](https://campusvirtual.ull.es/ocw/pluginfile.php/15444/mod_resource/content/1/Tema%205.%20Manejo%20de%20ficheros%20en%20Java.pdf)

## _`try` with resources_
```java
//...
try( recursos ){

} catch (Exception e){}
//...
```

Fuentes: [MitoCode](https://www.youtube.com/watch?v=tjSzhUGB1LE) y [OpenWebinars](https://www.youtube.com/watch?v=_5Pokz2sVUw)


## Ejercicio:
**Enunciado:**
Nos facilitan un archivo CSV (archivo separado por “comas”) y nos piden que lo capturemos y carguemos en una lista de `Persona`s. 

Como no están muy seguros de en el futuro podamos tener variaciones, por ejemplo para `Alumno`s nos dicen que dejemos todo preparado para una variación “sencilla”

| num | nombre | edad | altura |
|-----|--------|------|--------|
|   1 | Juan   | 25   | 1,85   |
|   2 | Alicia | 22   | 1,75   |

**Desarrollo:**
1. Crear un archivo de `Proporties` con el nombre de la columna, posición y tipo de dato (num=0,int - nombre=1,String - ...).
2. Crear un objeto del tipo Persona que pueda recoger los campos anteriores.
3. Leer el archivo + analizarlo (“parsearlo”) + guardarlo en la lista.
4. Mostrar todas las personas de más de 22 años.


## Escritura de archivos
Para escribir utilizaremos [`FileWriter`](https://es.linux-console.net/?p=6338) + [`PrintWriter`](https://www.delftstack.com/es/howto/java/java-printwriter/).


## Clases de `java.NIO`
[Uso de `java.NIO`](https://www.delftstack.com/es/howto/java/java-nio-package/) para leer de forma NO bloqueante y escribir de forma sencilla gracias a la clase `Files`.


## Datos sensibles
![hash vs crypt](https://miro.medium.com/v2/resize:fit:720/format:webp/0*fL1xaUrKT2cDFhZF)
Los datos sensibles como _passwords_ no se almacenarán **NUNCA**. 

¿Entonces, cómo podríamos luego comprobar si el usuario introdujo la contraseña bien si no almacenamos la misma?

Pues porque lo que almacenaremos será el _hash_ de la misma y lo verificaremos contra el _hash_ introducido por el usuario.

¿Ventaja? Aunque alguien se hiciera con el archivo no podría acceder al sistema al no conocer la contraseña almacenada ya que la función F(x) que genera el _hash_ no tiene función inversa **conocida**.

Un sistema sencillo sería mediante [bcrypt](https://dzone.com/articles/hashing-passwords-in-java-with-bcrypt).

_Nota: Si vuestro banco (o cualquier otra entidad) os envía la contraseña al pulsar en no la recuerdo, ¡¡TENÉIS QUE CAMBIAR DE BANCO!!_


### Referencias:
+ [Arquitectura Java](https://www.arquitecturajava.com/el-concepto-de-hashing-algorithm/)

# Ficheros de objetos (bytes)
Aunque no es la única forma, emplearemos la interfaz `Serializable` para exportar/importar instancias de clases, o más concretamente, estado de objetos.

[Vídeo introductorio - Makigas](https://www.makigas.es/series/java-io/serializando-clases)
  

## `InputObjectStream` y `OutputObjectStream` 


### Ejercicio
Crear un ejercicio completo donde:
1. Crearemos una estructura Modelo-Vista-Controlador
2. Crearemos un menú interactivo con las opciones:
   - Leer objetos de archivo
   - Escribir objetos en archivo
   - Crear un nuevo objeto
   - Eliminar un objeto
   - Mostrar datos cargados
   - Salir


### Serializando el mundo - base64
[Cualquier cosa to string](https://howtodoinjava.com/java/serialization/object-to-string/)

[Herramienta base64 converter](https://base64.guru/converter/encode/image/jpg)



## Json

Serialización / Deserialización pero a formato estandar Json.

**Ejercicio**:
Vamos a serializar a una de las personas que venimos trabajando en la unidad 8. Utilizaremos la librería Gson (Json de Google) que nos da “mascadito” el trabajo.

```pom.xml
<!--  Gson: Java to JSON conversion -->
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.12.1</version>
  <scope>compile</scope>
</dependency>
```

Y ahora:
```java
//...
// Serializar
Persona juan = new Persona(3, "Juan", 34, 160f);
Gson gson = new Gson();

String serializado = gson.toJson(juan);
// Y ésto podemos trasmitirlo como queramos (red, disco, respuesta http, ...)

// Deserializar
Persona nueva = gson.formJson(persona, Persona.class)

```

### El formato

* Tipos: https://es.wikipedia.org/wiki/JSON
* Gráfico: https://www.json.org/json-es.html
* Más simple: https://i.stack.imgur.com/rq9Th.png

### Librerías y utilidades

Dos librerías de amplia difusión por la simplicidad: GSon y Jackson.

* [Herrramienta visual](https://jsonviewer.stack.hu/)
* [Json esquema Pojo](https://www.jsonschema2pojo.org/)
* [API Gob](https://datos.gob.es/es/apidata#/) y [ejemplo](https://datos.gob.es/es/apidata#/), e incluso con CURL `curl -X GET --header 'Accept: application/json' 'https://datos.gob.es/apidata/nti/territory/Province?_sort=label&_pageSize=10&_page=0'`
* [API calles](https://apiv1.geoapi.es/calles?CPRO=06&CMUM=015&CUN=0004302&CPOS=06001&type=JSON&key=&sandbox=1)
* [POKEMON API](https://pokeapi.co/)

### GSon

Más sencillo de crear y algo menos flexible en la lectura.

* [doc](https://github.com/google/gson)

Facilitando la depuración con pretty print:
```java
```

### Jackson

* [doc](https://github.com/FasterXML/jackson)

### JsonPath

* [doc](https://github.com/json-path/JsonPath)
* [parser online](https://jsonpath.com/)
* [finder](https://jsonpathfinder.com/)


# Modificar DAO de la unidad 7

Comenzamos con nuestro CRUD de personas sobre _disco_:

![caso](https://luiscastelar.duckdns.org/2024/assets/prog/DAO.drawio-1.png)

Una mejora sustancial es aislar el CRUD de la tecnología con un DAO:


![caso](https://luiscastelar.duckdns.org/2024/assets/prog/DAO.drawio-2.png)
**¿Por qué?**
<details>
Porque con sólo cambiar una línea en la clase Main sería suficiente. 

Con sólo cambiar `DAOPersona gestionDePersistencia = new DAOPersonaDiscoImpl()` por `DAOPersona gestionDePersistencia = new DAOPersonaBBDDImpl()` estaríamos realizando la persistencia en una tecnología completamente diferente, y de forma transparente.

![caso](https://luiscastelar.duckdns.org/2024/assets/prog/DAO.drawio-3.png)</details>




# [i18n y l10n] Internacionalización y localizacion
1. Aproximación del problema.
2. Solución “casera” con `properties` + “nullish”
3. Soluciones más [complejas](https://picodotdev.github.io/blog-bitix/2020/12/internacionalizar-localizar-y-dar-formato-a-cadenas-numeros-importes-y-fechas-en-java/).



# Fuentes
1. [Lectura y escritura | Universidad de La Laguna](https://campusvirtual.ull.es/ocw/pluginfile.php/15444/mod_resource/content/1/Tema%205.%20Manejo%20de%20ficheros%20en%20Java.pdf)
2. [Java-io | Makigas](https://www.makigas.es/series/java-io)
3. [Lectura y escritura | Universidad de Alicante](https://www.dlsi.ua.es/asignaturas/prog3/java_io.html)
4. [Mis apuntes de programacion](https://misapuntesdeprogramacion.wordpress.com/2013/02/14/paquete-java-io/)




# [Ampliación] 
## Sockets de red
Si has llegado hasta aquí y has entendido la mecánica, el salto al intercambio de datos entre dos equipos puede ser un juego de niños. 

Aquí tienen un [tutorial sencillo](https://aprenderjava.net/base/guia-completa-como-enviar-mensajes-con-sockets-en-java/) de como podrías realizarlo.


## Interactuando con el sistema
Como verás en el módulo **Sistemas Informáticos**, los informáticos queremos automatizar las operaciones más habituales de un sistema operativo. Para ello recurrimos a los scripts de `shell` en GNU/Linux, o de `PowerShell` en Windows.

Pues resulta que estamos aprendiendo POO y con ello Java y que es un lenguaje muy potente y sencillo..., ¿sería posible hacer scripts con él?

Pues podemos de forma sencilla:
```java
//...
p = Runtime.getRuntime().exec("notepad.exe");
System.out.println("PID:" + p.pid() );
p.waitFor();
p.destroy();
//...      
```
El programa anterior crea un proceso, captura su pid (identificador de proceso), esperamos[^1] a que se acabe y liberamos recursos.

Capturar la salida requiere algo más de esfuerzo. Puedes ver un ejemplo:
<details>

```java
try {
    // 2º proceso: Sumar dos números y devolverlos
    Process proceso2 = new ProcessBuilder("java", "SumarNumeros", "1", "2").start();
    
    // Esperar a que el proceso termine
    proceso2.waitFor();

    // Leer la salida del proceso2
    InputStream is = proceso2.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    
    // Capturamos e imprimimos salida
    while ((line = br.readLine()) != null) {
      System.out.print(line);
    }
} catch (IOException | InterruptedException e) {
    e.printStackTrace();
}
```
</details>


---
# Notas
[^1]: Podríamos ejecutar el programa en paralelo con el nuevo proceso lanzado con _Runtime.getRuntime().exec()_, pero en nuestro caso de uso querremos esperar la respuesta del comando.

