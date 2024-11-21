#curso24_25 #prog [estado::Done] _Duración: 14h_

# Introducción a la Programación Orientada a Objetos -POO-
[**Presentación**](https://docs.google.com/presentation/d/1eZQizU8G9x8VFZFp5ja6H9hd6TJB91NZUxk0MNaVNYs/edit?usp=sharing)

## Recursos bibliográficos:
<details>

+ [W3S - Creación de clases e instanciación de objetos](https://www.w3schools.com/java/java_classes.asp)
+ [W3Schools](https://www.w3schools.com/java/java_oop.asp)
+ [JavaTPoint](https://www.javatpoint.com/java-oops-concepts)
+ [GeeksForGeeks](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/?ref=lbp)
+ [TutorialsPoint](https://www.tutorialspoint.com/java/java_object_classes.htm)
  
### Vídeos
+ Versión ligera (by TodoCode):
  + [1. ¿Qué es la POO?](https://www.youtube.com/watch?v=tcza2FEz4u4&list=PLQxX2eiEaqbwNP20GMMCjRslRq2lOLWlg&index=1&pp=iAQB)
  + [2. ¿Qué son las clases?](https://www.youtube.com/watch?v=q9gZ9fjKIC0&list=PLQxX2eiEaqbwNP20GMMCjRslRq2lOLWlg&index=2&pp=iAQB)
  + [3. Métodos](https://www.youtube.com/watch?v=pXX3c8BloY0&list=PLQxX2eiEaqbwNP20GMMCjRslRq2lOLWlg&index=3&pp=iAQB) (acciones disponibles en la clase u objeto).
  + [4. Constructores](https://www.youtube.com/watch?v=fdfXkiuVHp4&list=PLQxX2eiEaqbwNP20GMMCjRslRq2lOLWlg&index=4&pp=iAQB) (creadores de objetos).
  + [5. Getters & Setters](https://www.youtube.com/watch?v=ZHK0t5gocjA&list=PLQxX2eiEaqbwNP20GMMCjRslRq2lOLWlg&index=5&pp=iAQB) (consulta y modificación de estado o propiedades). 

+ Lista completa de vídeos: [POO Luisina](https://youtube.com/playlist?list=PLQxX2eiEaqbwNP20GMMCjRslRq2lOLWlg&si=Ua9od0yj-B8pmSvE)  
+ Versión completa (by Píldoras informáticas):
  + [Curso Java desde 0 - POO](https://www.youtube.com/watch?v=XmUz5WJmJVU&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=29)
  + [Curso Java desde 0 - POO 2](https://www.youtube.com/watch?v=ZY5pwm92cWQ&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=30)
  + [Curso Java desde 0 - POO 3](https://www.youtube.com/watch?v=ZY5pwm92cWQ&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=31)

</details>

## Construyendo la primera clase
Vamos a construir la clase coche y la instanciaremos desde el método `main`.

Veremos la referencia al objeto y comprobaremos que si 2 variables contienen una referencia al mismo objeto mostrarán el mismo `hash`:
```java
Coche cocheDeJuan = new Coche("Toyota");
Coche cocheDeAlicia = cocheDeJuan;

System.out.println("Coche de Juan es " + cocheDeJuan);
    // out: Juan - Coche@7ad041f3
System.out.println("Coche de Alicia, es " + cocheDeAlicia);
    // out: Alicia - Coche@7ad041f3
```

## Método `toString()`
Un método importante en _Java_ es el método `toString()` que utilizaremos para representar objetos como cadenas que lo describan.
```java
@Override
public String toString(){
  return "Objeto Coche\n"
        + "{\n"
        + "   Marca: " + marca + "\n"
        + "   Modelo: " + modelo + "\n"
        + "   Vel max: " + velocidadMaxima + " km/h\n"
        + "}";
} // toString()
```

Como podéis ver, cuando se mima un poco el formato la representación del objeto mejora sensiblemente.

Aparece algo nuevo en el código, una “@“ (arroba) y la palabra `Override`. Ésto es una _annotation_ (anotación), que el compilador utilizará de guía para realizar ciertas operaciones especiales con el código que le acompañe.

En concreto, la anotación `@Override` obliga a que el método siguiente sea sobreescrito o arroje un error de compilación. 

¿Qué quiere decir? Pues que si nosotros hemos cometido un error en el nombre o en los argumentos el compilador nos avisará. Veamos ésto.

Vamos a modificar la palabra `toString` por `tostring` y comprobemos los resultados.
<details>

```bash
./Coche.java:16: error: method does not override or implement a method from a supertype
        @Override
        ^
1 error
```

Efectivamente, el compilador nos avisa que en realidad no estamos sobreescribiendo nada y por tanto que tenemos un error en el método.
</details>

¿Y si elimninamos la anotación `@Override`? ¿Cuál será el resultado?

## Buenas prácticas en el nombrado de variables y métodos
### Variables y referencias
1. Uso de constantes nominales sobre números sin sentido / Evitar números mágicos.

   ¿Qué significa `if( duracion > 86 000 )`?
  <details>
  
  ```java
  final int SEGUNDOS_EN_UN_DIA = 86 000 // segundos
  ...
  if( duracion > SEGUNDOS_EN_UN_DIA )
    // Mas claro, ¿verdad?
  ```
  </details>
   
2. [**Buenas** prácticas](https://javascript.plainenglish.io/variable-naming-best-practices-in-javascript-94af115f42cd)
3. Uso del objeto mas genérico cuando sea posible (lo veremos en UT6)

# Teclado y pantalla

## Clase Scanner
+ [Vademecum]
+ [Como usarla _Scanner_](https://ifgeekthen.nttdata.com/s/post/que-es-y-como-usar-la-clase-scanner-en-java-MCGCZBXHLT3VDXRLUQLJ4O2X4XKM?language=es)
+ [API 21](https://docs.oracle.com/en/java/javase/21/docs//api/java.base/java/util/Scanner.html)

## Métodos:
+ `String next()` -> Captura un token (palabra)
+ `int nextInt()` -> Captura un entero
+ `double nextDouble()` -> Captura un double
+ `String nextLine()` -> Captura toda una línea (hasta `\n`)

Algunos métodos para hilar más fino:
+ `Scanner useDelimiter(String patron)` -> Modifica separador de tokens.
+ `Pattern delimiter()` -> Devuelve el separador de tokens actual (para salvarlo).


## Coloreando la salida
```java
public class ClasePrincipal{
	public static void main( String[] args ){
		final String NEGRO = "\u001B[30m";
		final String AZUL = "\u001B[34m";
		final String GREEN_BACKGROUND = "\u001B[42m";
		
		String texto = "Hola mundo";
		System.out.println( AZUL + texto + NEGRO + GREEN_BACKGROUND + " y más cosas");
	
	}
}
```

<details>

Tabla de códigos de colores ANSI:

| **Nombre del color** | **Código de colores** | **Color de fondo** | **Código de color de fondo** |
| --- | --- | --- | --- |
| NEGRO | \\u001B\[30m | FONDO NEGRO | \\u001B\[40m |
| ROJO | \\u001B\[31m | FONDO ROJO | \\u001B\[41m |
| VERDE | \\u001B\[32m | FONDO VERDE | \\u001B\[42m |
| AMARILLO | \\u001B\[33m | FONDO AMARILLO | \\u001B\[43m |
| AZUL | \\u001B\[34m | FONDO AZUL | \\u001B\[44m |
| PÚRPURA | \\u001B\[35m | FONDO PÚRPURA | \\u001B\[45m |
| CIAN | \\u001B\[36m | FONDO CIAN | \\u001B\[46m |
| BLANCO | \\u001B\[37m | FONDO BLANCO | \\u001B\[47m |

</details>


## Ejercicios
Debes establecer los criterios más restrictivos posibles de visibilidad.

<details>

1. Modifica la clase “HolaMundo” de forma que muestre por pantalla “hola {{nombre}}“, siendo {{nombre}} el primer argumento pasado por CLI.

2. Modifica la clase “HolaMundo” de forma que reclame un nombre por teclado.

3. Tenemos una clase `Coche` que tiene las propiedades `velocidad`, `direccion`, `color` y `ruedas`. \
   La clase tiene además una serie de métodos para ver su estado y modificarlo `acelerar(int cantidad) frenar(int cantidad) girar(int angulo) parar() repintar(String color) verVelocidad() verDireccion() verColor() verNumeroDeRuedas()`, siendo ésta última una característica intrínseca de todos los `Coches`. \
   Crea una clase que se encargue de crear un un objeto de la clase `Coche`. \
   Lo acelere 100 (km/h), luego reduzca 30 para girar 30 (grados a la izquierda), luego acelere 40 más, reduzca 70, gire 45 (grados a la derecha). \
   Nos muestre la velodidad, dirección actual, color y número de ruedas y se detenga completamente. \

4. Tenemos una clase `CuentaBanco` con las propiedades `saldo`, `limiteDescubierto`, `titular`, `rentabilidad`. *[Deberás establecer tú los valores por defecto]*\
   La clase tiene los métodos `ingresar(float euros), float sacar(float euros), avisarDescubierto(float saldo), avisarSaldoInsuficiente(float saldo, float seQuiereSacar), float calcularIntereses(float saldo, float rentabilidad)` y por supuesto `verSaldo()`. \
   El método `calcularIntereses`se ejecutará cada mes y llamará al método `ìngresar` con la cantidad calculada. \
   El método `sacar` utilizará el operador ternario para sacar si hay suficiente saldo o llamar al método `avisarSaldoInsuficiente` en caso contrario. \
   Crea una clase que se encargue de:
   + Crear un objeto de la clase `CuentaBanco` con 500 de saldo, un límite de descubierto de 30, a tu nombre y con una rentabilidad del 0'1%. \
   + Crear otra con 250 a nombre de un compañero.
   + Saca 300 de tu cuenta. Ingresa lo que sacaste en la de tu compañero.
   + Fin de mes *[toca debengar intereses]*.
   + Consulta el saldo de ambas cuentas.
   + Saca 300 de tu cuenta. Ingresa lo que sacaste en la de tu compañero.
   + Fin de mes *[toca debengar intereses]*.
   + Consulta el saldo de ambas cuentas.

5. Crea una clase llamada `Libro` que guarde la información de cada uno de los libros de una biblioteca. La clase debe guardar el título del libro, autor, número de ejemplares del libro y número de ejemplares prestados. La clase contendrá los siguientes métodos:
    - Constructor por defecto.
    - Constructor con parámetros.
    - Métodos `setters` y `getters`
    - Método `prestamo` que incremente el atributo correspondiente cada vez que se realice un préstamo del libro. No se podrán prestar libros de los que no queden ejemplares disponibles para prestar. Devuelve true si se ha podido realizar la operación y false en caso contrario.
    - Método `devolucion` que decremente el atributo correspondiente cuando se produzca la devolución de un libro. No se podrán devolver libros que no se hayan prestado. Devuelve true si se ha podido realizar la operación y false en caso contrario.
    - Método `toString` para mostrar los datos de los libros.
    - Escribe un programa para probar el funcionamiento de la clase Libro.
   <details>
   
   Tip:
   ```java
   public boolean prestamo(){
        // Verificamos si hay ejemplares
        //boolean isPrestable = CONDICIONAL
        // Actulizamos ejemplares
        //ejemplaresPrestados = CONDICIONAL
        // Retornamos situacion
        return isPrestable;
    }
   ```
    _CONDICIONAL debe sustituirse por el operador condicional con los argumentos adecuados_
   </details>
   
[Más ejercicios POO by Universidad Complutense de Madrid](https://github.com/luiscastelar/clases24_25/blob/main/prog/ut2/EjerciciosClasesYObjetos-UCM.pdf)

</details>


## Evitando errores con caracteres no americanos
```bash
javac -d /ruta/completa/target/classes -classpath /ruta/completa/target/classes src/main/java/ut6/HolaMundo.java 
java -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /ruta/completa/target/classes ut2.HolaMundo
```

Donde:
+ `-d` indica el destino de la clase compilada `.class`.
+ `-cp` o `-classpath` la ubicación de las clases necesarias para la compilación. Aquí podríamos haber añadido clases en `.jar` con algo así como `-cp /ruta/completa/target/clases:/ruta/donde/este/Archivo.jar`
+ `-Dfile.enconding=UTF-8`, `-Dsun.stdout.encoding=UTF-8` y `-Dsun.stderr.encoding=UTF-8` permiten configurar la codificación del archivo fuente, de la salida estandar y de error por separado.



---

# Especial Java
<details>

## `enum` - Tipos enumerados:
Es un tipo de clase especial que se utilizar como un subconjunto de datos (cerrados)

```java
private enum Meses {ENERO, FEBRERO, MARZO, ABRIL}

public static void main( String[] args ) {
  Meses mes = Meses.ENERO;
  System.out.println(“El año empieza por ” + mes);
}
```

Al ser una clase, podemos definir y sobreescribir métodos (ver [aquí](https://www.baeldung.com/a-guide-to-java-enums)).


## Versiones
+ Java SE, Java ME y Java EE
+ Versiones de Java SE:
  + [Desde Java 1.0 hasta 1.5](https://internetpasoapaso.com/versiones-java/)
  + Renombrado
  + [Desde J6SE hasta J8SE](https://internetpasoapaso.com/versiones-java/)
  + Cambio de ciclo de lanzamientos cada 6 meses:
    + 1 version LTS
    + 2 versiones “cortas”
  + [Desde Java 9 SE hasta 2024](https://internetpasoapaso.com/versiones-java/)
+ Kits de desarrollo:
  + OpenJDK -> la oficial
  + Temurin -> la universal
  + MS OpenJDK -> la ideal para azure
  + Amazon Corretto -> la ideal para AWS
  + RH OpenJDK -> la ideal para la nube de Red Hat


## `record` - Registros
Es un tipo de clase especial **inmutable**, esto es, que no se puede modificar sus valores después de crearlos.
```java
public record Alumno (String nombre, int edad){}
```
El compilador creará los getters, el constructor completo y el método `toString()` que nos permitirá de forma sencilla operar con ellos.

[Aquí](https://www.youtube.com/watch?v=TYtA8cJUzxA) te dejo un vídeo de refuerzo.

## Paso de argumentos por consola
```java
public class Main {
    public static void main(String[] args) {
        boolean isTieneArgumentos = ( args.length > 0 )? true : false;
        String texto = isTieneArgumentos ? args[0] : "No hay argumentos";
        System.out.println(texto);
    }
}
```

</details>    
---

# Prácticas
## Práctica “Hola Mundo”:
1. Crea una Clase denominada `MiPrimeraClase` que simplemente imprima un hola mundo por pantalla (CLI) cuando sea ejecutada.
2. Complilar
3. Ejecuta y muestra una captura de:
   + Terminal con el Promt String del tipo `nombre_alumno@programacion ~/PROGRAMACION/prog/ut2-holaMundo :/$`
   + Muestra el contenido con `cat {{ARCHIVO}}.java | tee salida.txt`
   + Línea de compilación.
   + Línea de ejecución.
   + Resultado.

_Para cambiar el Promt String: `PS1="{{Tu nombre completo}}@programacion \w :/$"`_ 

**Puntuación**:
+ El programa está bien (2 puntos).
+ Están los 4 archivos (4 puntos) en el directorio indicado (.java, .class, salida.txt y README.md).
+ La captura está bien (2 puntos).
+ La documentación y integra la captura (2 puntos).
+ Total: 10 puntos.
+ **Recuerda**: debes añadir un README.md explicando paso a paso lo realizado. Aquellos pasos no explicados conllevarán una puntuación de 0 puntos.



## Práctica “Biblioteca”
Basándonos en el ejercicio 5 donde nos pedían realizar una clase Libro para gestionar una biblioteca:
+ Añade un constructor que reciba el título y los ejemplares totales disponibles en la biblioteca.
+ Realiza una clase para probar todos los métodos desarrollados.

**Recuerda**:
+ Crea un directorio para ella `ut2-biblioteca`. Dentro irá tu práctica y el `README.md` con la documentación de la misma.
+ Añade los archivos fuente y las capturas que creas oportuno (si es texto, captura con `tee`).
+ Aquellos pasos no explicados en el `README.md` conllevarán una puntuación de **0 puntos**.

# Referencias
+ [Apuntes de Jose Luis Comesaña](https://github.com/rosepac/daw-temario/blob/main/PROG/PR03.pdf)