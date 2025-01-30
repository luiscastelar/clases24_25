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

# [i18n y l10n] Internacionalización y localizacion
1. Aproximación del problema.
2. Solución “casera” con `properties`.
3. Soluciones más [complejas](https://picodotdev.github.io/blog-bitix/2020/12/internacionalizar-localizar-y-dar-formato-a-cadenas-numeros-importes-y-fechas-en-java/).

# Ficheros de bytes



# Ficheros de objetos (Serialize)


