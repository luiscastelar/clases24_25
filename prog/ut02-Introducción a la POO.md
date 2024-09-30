#curso24_25 #prog [estado::ToDo] _Duración: 14h_

# Introducción a la Programación Orientada a Objetos -POO-
[**Presentación**](https://docs.google.com/presentation/d/1eZQizU8G9x8VFZFp5ja6H9hd6TJB91NZUxk0MNaVNYs/edit?usp=sharing)

## Recursos bibliográficos:
+ [W3S - Creación de clases e instanciación de objetos](https://www.w3schools.com/java/java_classes.asp)
+ [W3Schools](https://www.w3schools.com/java/java_oop.asp)
+ [JavaTPoint](https://www.javatpoint.com/java-oops-concepts)
+ [GeeksForGeeks](https://www.geeksforgeeks.org/object-oriented-programming-oops-concept-in-java/?ref=lbp)
+ [TutorialsPoint](https://www.tutorialspoint.com/java/java_object_classes.htm)
  
### Vídeos
+ [Porqué de POO](https://youtu.be/XmUz5WJmJVU?t=142)
+ [Porqué modular](https://youtu.be/RZOSJ2zuxIs?t=528)

+ [Pildoras informaticas - Curso Java desde 0 - POO](https://www.youtube.com/watch?v=XmUz5WJmJVU&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=29)
+ [Pildoras informaticas - Curso Java desde 0 - POO 2](https://www.youtube.com/watch?v=ZY5pwm92cWQ&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=30)
+ [Pildoras informaticas - Curso Java desde 0 - POO 3](https://www.youtube.com/watch?v=ZY5pwm92cWQ&list=PLU8oAlHdN5BktAXdEVCLUYzvDyqRQJ2lk&index=31)


## Buenas prácticas en el nombrado de variables y métodos
### Variables y referencias
1. Uso de constantes nominales sobre números sin sentido / Evitar números mágicos.

   ¿Qué significa `if( duracion > 86 000 )`?
  <details>
  
  ```java
  final int DIA = 86 000 // segundos
  ...
  if( duracion > DIA )
    // Mas claro, ¿verdad?
  ```
  </details>
   
2. [**Buenas** prácticas](https://javascript.plainenglish.io/variable-naming-best-practices-in-javascript-94af115f42cd)
3. Uso del objeto mas genérico cuando sea posible (lo veremos en UT6)

# Teclado y pantalla

## Clase Scanner
+ [Como usarla _Scanner_](https://ifgeekthen.nttdata.com/s/post/que-es-y-como-usar-la-clase-scanner-en-java-MCGCZBXHLT3VDXRLUQLJ4O2X4XKM?language=es)
+ [API 21](https://docs.oracle.com/en/java/javase/21/docs//api/java.base/java/util/Scanner.html)

## Métodos:
+ String next() -> Captura un token (palabra)
+ int nextInt() -> Captura un entero
+ double nextDouble() -> Captura un double
+ String nextLine() -> Captura toda una línea (hasta `\n`)

+ Scanner useDelimiter(String patron) -> Modifica separador de tokens.
+ Pattern delimiter() -> Devuelve el separador de tokens actual (para salvarlo).




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
    - Método `toString` para mostrar los datos de los libros. Este método se heredada de Object y lo debemos modificar (override) para adaptarlo a la clase Libro. \
      Escribe un programa para probar el funcionamiento de la clase Libro. \
      *Nota: uso de `@Override`. Devuelve una representación textual del objeto.*
      ```
      ...
      @Override
      public String toString() {
          return "El texto que queramos " + atr_objeto ;
      }
      ```

[Más ejercicios POO by Universidad Complutense de Madrid](https://github.com/luiscastelar/clases24_25/blob/main/prog/ut2/EjerciciosClasesYObjetos-UCM.pdf)

</details>

---

# Especial Java
## Tipos enumerados:
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

_Para cambiar el Promt String: `PS1={{Tu nombre completo}}@programacion \w :/$`_ 

**Puntuación**:
+ El programa está bien (2 puntos).
+ Están los 4 archivos (4 puntos) en el directorio indicado (.java, .class, salida.txt y README.md).
+ La captura está bien (2 puntos).
+ La documentación y integra la captura (2 puntos).
+ Total: 10 puntos.
+ **Recuerda**: debes añadir un README.md explicando paso a paso lo realizado. Aquellos pasos no explicados conllevarán una puntuación de 0 puntos.



## Práctica “Biblioteca”
Basándonos en el ejercicio 3 donde nos pedían realizar una clase Libro para gestionar una biblioteca:
+ Añade un constructor que reciba el título y los ejemplares totales disponibles en la biblioteca.
+ Realiza una clase para probar todos los métodos desarrollados.

**Recuerda**:
+ Crea un directorio para ella `ut2-biblioteca`. Dentro irá tu práctica y el README.md con la documentación de la misma.
+ Añade los archivos fuente y las capturas que creas oportuno (si es texto, captura con `tee`).
+ **Recuerda**: debes añadir un README.md explicando paso a paso lo realizado. Aquellos pasos no explicados conllevarán una puntuación de 0 puntos.

