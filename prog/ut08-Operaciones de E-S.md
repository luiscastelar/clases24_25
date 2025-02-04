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
### Clase `Scanner`
### Clase `FileReader`
Fuente: [Lectura y escritura](https://campusvirtual.ull.es/ocw/pluginfile.php/15444/mod_resource/content/1/Tema%205.%20Manejo%20de%20ficheros%20en%20Java.pdf)

## _`try` with resources_
```java
//...
try( recursos ){

} catch (Exception e){}
//...
```

Fuentes: [MitoCode](https://www.youtube.com/watch?v=tjSzhUGB1LE) y [OpenWebinars](https://www.youtube.com/watch?v=_5Pokz2sVUw)


## Clase `java.NIO`
[Uso de `java.NIO`](https://www.delftstack.com/es/howto/java/java-nio-package/) para leer de forma NO bloqueante.

## Escritura de archivos

## Datos sensibles
![hash vs crypt](https://miro.medium.com/v2/resize:fit:720/format:webp/0*fL1xaUrKT2cDFhZF)
Los datos sensibles como _passwords_ no se almacenarán **NUNCA**. 

¿Entonces, cómo podríamos luego comprobar si el usuario introdujo la contraseña bien si no almacenamos la misma?

Pues porque lo que almacenaremos será el _hash_ de la misma y lo verificaremos contra el _hash_ introducido por el usuario.

¿Ventaja? Aunque alguien se hiciera con el archivo no podría acceder al sistema al no conocer la contraseña almacenada ya que la función F(x) que genera el _hash_ no tiene función inversa **conocida**.

Un sistema sencillo sería mediante [bcrypt](https://dzone.com/articles/hashing-passwords-in-java-with-bcrypt).

_Nota: Si vuestro banco (o cualquier otra entidad) os envía la contraseña al pulsar en no la recuerdo, ¡¡TENÉIS QUE CAMBIAR DE BANCO!!_


# [i18n y l10n] Internacionalización y localizacion
1. Aproximación del problema.
2. Solución “casera” con `properties` + “nullish”
3. Soluciones más [complejas](https://picodotdev.github.io/blog-bitix/2020/12/internacionalizar-localizar-y-dar-formato-a-cadenas-numeros-importes-y-fechas-en-java/).

# Ficheros de bytes



# Ficheros de objetos (Serialize)


# Fuentes
1. [Lectura y escritura | Universidad de La Laguna](https://campusvirtual.ull.es/ocw/pluginfile.php/15444/mod_resource/content/1/Tema%205.%20Manejo%20de%20ficheros%20en%20Java.pdf)
2. [Java-io | Makigas](https://www.makigas.es/series/java-io)
3. [Lectura y escritura | Universidad de Alicante](https://www.dlsi.ua.es/asignaturas/prog3/java_io.html)
4. [Mis apuntes de programacion](https://misapuntesdeprogramacion.wordpress.com/2013/02/14/paquete-java-io/)