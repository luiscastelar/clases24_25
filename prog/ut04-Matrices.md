  #curso24_25 #prog [estado::Done]



# Introducción
<div align="center">

![array](https://i0.wp.com/somoshackersdelaprogramacion.es/wp-content/uploads/2022/05/arrays01.jpg?w=500&ssl=1)
</div>

Un _array_ es un objeto que almacena un tipo **uniforme** de datos, primitivos u objetos, pero **SIEMPRE** iguales.


## Declaración y asignación:

## Declaración
`Tipo[] nombre`, p.e.:
+ `String[] cadena`
+ `int[] numeros`
+ `char[] caracteres`
+ `Vehiculo[] vehiculos`

## Asignación
Podemos realizarla en la declaración `String[] cadena = {"esto", "es", "un", "array","de","Strings"}`, o posteriormente si la hemos inicializado:

```java
String[] cadena = new String[4]; // array de 4 strings
cadena[0]="esto";
cadena[3]="array";
// cadena = {"esto", null, null, "array"}
```

El tamaño del _array_ es inferido por el número de elementos suministrado, o si utilizamos el operador `new` deberemos pasarle el número de elementos para construirlo.

> [!NOTE]
> Las posiciones no asignados tomaran el tipo el valor por defecto del tipo de datos del array, esto es:
> + int -> 0
> + char -> `\u0000` (carácter null != null)
> + float -> 0.0
> + boolean -> false
> + cualquier objeto -> null


## Longitud
Podemos conocer la longitud de una cadena utilizando la “propiedad” `length`. P.e.: `cadena.length` nos devolvería 4;

> [!CAUTION]
> Pese a parecerlo por utilizar la “propiedad” `length`, los _array_ son construcciones internas del lenguaje y no colecciones de objetos por lo que **NO** tienen métodos, y en concreto, no tiene sentido utilizar `length()`.


## Recorrer un `array`
Podemos obtener la posición `i` de un _array_ mediante la sintaxis `caneda[i]`.

Conocida la longitud de un array podemos recorrerlo obteniendo los valores que almacena con los bucles que hemos visto en la unidad anterior.

```java
String[] cadena = {"esto", "es", "un", "array","de","Strings"};
for (int i=0; i<cadena.length(); i++) {
  System.out.println(cadena[i]);
}
```


## Bucle _ForEach_
Como en muchos lenguajes, recorer un array es algo bastante habitual por lo que se implementa una estructura específica para facilitarlo. Esta estructura es el bucle _ForEach_ cuya sintasis es:

```java
for (Type valor : nombreDelArray) {
  System.out.println( valor );
}
```

> [!CAUTION]
> Esta construcción genera una variable `valor` cuya existencia es sólo válida dentro de las `{}`, por lo que **NO** podemos modificar los valores del _array_ con un _ForEach_.
>
> Veamos el ejemplo:
```java
int[] algunosEnteros = {1, 2, 3};
for ( int valor : algunosEnteros){
  valor = valor * 2;
  System.out.print( valor + ", " ); // -> 2, 4, 6,
}
// Si ejecutamos de nuevo:
for ( int valor : algunosEnteros ){
  System.out.println( valor + ", " ); // -> 1, 2, 3,
}
```
> Cabría esperar que las salidas fueran idénticas, pero debemos ser conscientes que en realidad el ámbito de `valor` está restringido al bloque, por lo que al salir desaparece.

## Fuentes:
+ [Arrays estáticos](https://somoshackersdelaprogramacion.es/arrays-estaticos-en-java)

# Clase `Arrays`
Se trata de una clase preparada para trabajar con arrays y que TODOS sus métodos son “estáticos”.

¿Qué implica que todos sus métodos sean “estáticos”?
<details>

Que NO debemos instanciar dicha clase, si no operarla directamente. P.e.:
`String[] nuevaCadena = Arrays.copyOf( cadena )`
</details>

## Métodos útiles (java.util.Arrays)
|Nombre|Descripción|Parámetros|Dato devuelto|
|---|---|---|---|
|binarySearch|"Busca un valor que le pasamos por parámetro devuelve su posición. Debe estar ordenado."|"Un array y un valor. Los dos del mismo tipo. Estos pueden ser un byte, char, double, float, int, long, short , objecto."|int|
|copyOf|Copia un array y lo devuelve en un nuevo array.|"Un array y la longitud. Si se pasa del tamaño del array original rellena los con ceros las posiciones sobrantes. Estos pueden ser un byte, char, double, float, int, long, short , objecto."|array del mismo tipo que se introduce|
|copyOfRange|Copia un array y lo devuelve en un nuevo array. Le indicamos la posición de origen y de destino.|"Un array, posición origen y destino. Estos pueden ser un byte, char, double, float, int, long, short , objecto."|array del mismo tipo que se introduce.|
|equals|Indica si dos arrays son iguales.|Dos arrays del mismo tipo.|true o false|
|deepEquals|Indica si dos arrays de cualquier profundidad son iguales.|Dos arrays del mismo tipo.|true o false|
|fill|Rellena un array con un valor que le indiquemos como parámetro.|"Un array y el valor a rellenar. Estos pueden ser un byte, char, double, float, int, long, short u objecto."|No devuelve nada|
|sort|Ordena el array.|"Un array. Estos pueden ser un byte, char, double, float, int, long, short u objecto."|No devuelve nada|
|toString|Muestra el contenido del array pasado como parámetros|"Un array. Estos pueden ser un byte, char, double, float, int, long, short u objecto."|Devuelve una cadena con el contenido del array.|


## Arrays multidimensionales (Matrices)
<div align="center">

![matrices](https://maritzacondori.wordpress.com/wp-content/uploads/2015/11/arraymulti.jpg?w=214)
</div>

Las matrices o arrays multidimensionales son una construcción de 2 o más dimensiones, convirtiendo un vector en una matriz de 2 o más dimensiones.

```java
// Declaración (podría hacerse en una sola línea)
int[][] myNumbers = { 
      {1, 2, 3, 4}, 
      {5, 6, 7} 
};
for (int i = 0; i < myNumbers.length; ++i) {
  System.out.print("[");
  for(int j = 0; j < myNumbers[i].length; ++j) {
    System.out.print(myNumbers[i][j] + " ");
  }
  System.out.println("]");
}
```


# Ejercicios:
<details>

1. Suma los elementos de un array `harcodeado`[^1].
2. Suma los elementos de un array que esté introducido por teclado.
3. Obtén el valor medio de un array.
4. Obtén la moda de un array. _Nota: la moda es el elemento que más se repite._
5. Escribe un programa que pida 10 números por teclado, los almacene en un array y que luego muestre el máximo valor, el mínimo y las posiciones que ocupan en el array.
6. Escribe un programa que genere 20 números enteros aleatorios entre 0 y 99 y los almacene en un array. El programa debe crear un nuevo array con los números primos que haya entre esos 20 números. Luego debe mostrar los dos arrays.

   <details>
   <summary>Generar número aleatorio</summary>
   
   ```java
   // Generar semilla
   Random aleatorio = new Random(System.currentTimeMillis());
   // Producir nuevo int aleatorio entre 0 y 99
   int intAletorio = aleatorio.nextInt(100);
   ```

   </details>
7. Escribe un programa que pida al usuario que introduzca los datos de una factura y luego los presente por pantalla.
    
    +   La factura tendrá tres partes. La cabecera, el listado de productos con sus datos, y el pie de factura con el total de la misma. Cada una deberás implementarse con un objeto.
    +   La cabecera tendrá el siguiente texto: Producto, unidades, precio/unidad y total.
    +   Le pediremos al usuario que introduzca los datos anteriores para tres productos (utiliza LeerEntrada). Por lo que el cuerpo de la factura tendrá 3 líneas.
    > Un ejemplo de posible factura impresa sería:
    > 
    > Producto —Unidades —Precio/unidad —Total
    > 
    > Mesa — 7 — 101.0 — 707.0
    > 
    > Silla — 3 — 45.0 — 135.0
    > 
    > Lampara — 11 — 9.0 — 99.0
    > 
    > Total: 941.0
    
8. Escribe un programa que genere al azar 20 números enteros comprendidos entre 0 y 9. Estos números se deben introducir en un array de 4 filas por 5 columnas.

   El programa mostrará las sumas parciales de filas y columnas igual que si de una hoja de cálculo se tratara. La suma total debe aparecer en la esquina inferior derecha.
   
9. Escribe una clase que reciba un array de integers que busque un valor dentro del array y borre todas sus ocurrencias, reduciendo la dimensión del array. Es decir, no vale con poner cero en el lugar donde encontremos el valor.

   Crea una clase de prueba donde estará `hardcodeado` (en el código) el array.

   El valor a buscar y borrar debe ser introducido por el usuario.

   El programa debe mostrar por pantalla el valor borrado, el array inicial y el array final.

   Una posible salida sería:
   >Introduce el numero que quieres borrar: 5
   >
   >Elemento a borrar: 5
   >
   >Array inicial: 1 – 5 – 9 – 3 – 45 – 23 – 45 – 12 – 87 – 9 – 6 – 5 –
   >
   >Array final  : 1 – 9 – 3 – 45 – 23 – 45 – 12 – 87 – 9 –
    
10. Sobre el anterior, modifica la clase `LeerEntrada` donde le crearemos el método `boolean continuar(char default)` que pregunte al usuario si queremos continuar y reciba un ‘y’ para valor `yes` defecto o un ‘n’ para valor `no`.
    El método devolverá `true` si recibe por teclado `y|Y|yes|YES|Yes|Sí|Si|sí|si|SÍ|SI|S|s` o nada y el valor por defecto es ‘y’.

    El método devolverá `false` si recibe `n|N|no|No|NO` o nada y el valor por defecto es ‘n’.
    
    Mientras que este método devuelva `true` se continuará eliminando elementos del array.
    
12. Sobre el ejercicio anterior, realiza las modificaciones necesarias para crear e instanciar una clase que genere de forma aleatoria el array inicial según los parámetros valor mínimo, valor máximo y número de elementos.  
13. Crea un programa que muestre por pantalla la nota de un estudiante, de entre una lista de estudiantes con sus respectivas notas. Estos datos estarían hardcodeados.  
    El nombre del estudiante lo introduce el usuario por teclado (usa la clase LeerEntrada).

    Usa dos arrays, uno para guardar los nombres de los estudiantes, y el otro para guardar las notas de los mismos. Ambos tendrán 5 elementos. Puedes guardar la información relacionada en ambos arrays con el mismo valor del índice. Es decir, si por ejemplo el estudiante Pedro está en la posición 2 del array de estudiantes, su nota estaría en la posición 2 del array de notas.

    Para comparar el nombre del estudiante introducido por teclado con los nombres de los estudiantes en el array de estudiantes, puedes usar el método equals de la Clase String.
    
15.  Repite con un array multidimensional.
16.  Crea un programa que reciba por teclado un array de enteros y ordene sus elementos almacenando la posición origial en otro array.
17.  Desarrolla un programa java para ser usado por los camareros de un restaurante, que sirva para tomar nota de los menus que los clientes van a tomar.
18.  Primer dato a introducir por el camarero es el número de comensales que tendrá que estar en el rango de 1-5, ya que no hay mesas de más de cinco comensales. El valor introducido debe asegurarse de que se encuentra en el rango definido.
19.  Entonces el camarero tiene que introducir el menú seleccionado por cada cliente.
20.  Tenemos tres menus: #1,#2 y #3. Puedes identificar cada menú por el número: menú 1, menú 2 o menú 3.
21.  Una vez introducidos todos los datos, el programa imprimirá por pantalla los menús solicitados por cada comensal.
22. Tienes que emplear un array para registrar los menús que tomará cada comensal. Ten en cuenta que la dimensión de dicho array tendrá que definirse en ejecución, ya que no sabemos a priori cuantos comensales vamos a tener.
23. Un ejemplo de una posible salida sería:
    >Introduce el número de comensales (máximo 5): 3
    >
    >Introduce el menu pedido por el comensal 1 : 1
    >Introduce el menu pedido por el comensal 2 : 2
    >Introduce el menu pedido por el comensal 3 : 1
    >Comensal 1 va a tomar el menu 1
    >Comensal 2 va a tomar el menu 2
    >Comensal 3 va a tomar el menu 1  

24. Dada las siguientes [operaciones matemáticas con matrices](https://matesfacil.com/matrices/resueltos-matrices-suma.html), implementa una clase que realice la suma matricial, multiplicación escalar y transposición de una matriz.
25. Amplia la clase anterior con la [multiplicación matricial](https://www.matricesydeterminantes.com/matrices/multiplicacion-de-matrices-2x2-y-3x3-ejemplos-y-ejercicios-resueltos-paso-a-paso/).


</details>


## PRÁCTICAS:

## Evaluación de resultados.

Crear una aplicación `ResultadosDeClase` que nos evalúe los resultados obtenidos en la primera evaluación, esto es, deberéis crear una aplicación que, partiendo de una matriz de alumnos/modulos cumpla:

1. Almacene los nombres de los alumnos
2. Almacene el nombre de los módulos, que serán {“PROG”, “BBDD”, “LLMM”, “EED_”, “SSII”, “IPE1”, “ING_”}
3. Que guarde las calificaciones teniendo en cuenta:

   + Si la calificación es -1 significa que el alumno no se encuentra matriculado en el módulo. Dicha calificación no será tenida en cuenta para realiza la nota media, y no será representada.
   + Si la calificación es -2 significia que el alumno ya tiene aprobado el módulo. Dicha calificación no será tenida en cuenta para realiza la nota media, y será representada con un character `A`.
   + La nota será un entero entre 0 y 9 puntos, inclusive. 

4. Determinar la media de las notas del alumno (filas) y mostrarla como la figura (azul aprobado y rojo suspenso). 
5. Determinar la media de las notas del módulo (columnas) y mostrarla como en la figura (azul aprobado y rojo suspenso).
6. Determinar la media de las medias de módulos
7. Mostrar una tabla similar a la de la figura con los nombres de módulos, de alumnos las medias y las notas de cada alumno en cada módulo.

![resultados](https://luiscastelar.duckdns.org/2024/prog/ut4_practica.png)

**Entrega**: 20 de noviembre

**Avanzado:** modificar el programa anterior elimnando la restricción de 1 dígito, almacenando y mostrando `float` con un dígito decimal. 

_Puedes controlar el número de dígitos a mostrar con ``String.format(`"%.1f"`, variable)`` que nos devuelve un `String` con los decimales solicitados._


## Para la corrección:

Modificaremos la clase anterior para poder pasar test unitarios. Para ello deberemos asegurarnos que:

1.  La clase se denomina `ResultadosDeClaseTest`
2.  Creamos los métodos:
    +   `listarNotaAlumno(String alumno): int []` -> devuelve las notas del alumno
    +   `listarNotasModulos(String modulo): int []` -> devuelve la nota del modulo
    +   `mediaAlumno(String alumno): int` -> devuelve la media del alumno
    +   `mediaModulo(String modulo): int` -> devuelve la media del módulo
3.  Crearemos los test unitarios que nos permitan verificar los métodos anteriores.
  
**Entrega**: 9 enero

<!--
## Posicionamiento de brazos robóticos.

Dado [cinemática de robot (2D)](https://youtu.be/9zSRNXRuX0g), se pide generar una matriz de transformación precalculada de forma que podamos solicitarle a la apliación la ubicación de la punta en unas coordenadas cartesianas (x e y) y nos devuelva los ángulos de posicionamiento de los brazos robóticos.  
Se solicita que nos facilitéis la respuesta de ángulos para todos los valores enteros de un cubo de dimensiones 1x1, teniendo en cuenta que el origen de coordenadas está en un vértice y la longitud de los brazos son de 1 ambos.

Restricciones: implementar el método `float[] cinematicaInversa2D(int x, int y)` de la clase `MatricesDeTransformacion` que podamos utilizar sin instanciar objetos, donde `float[]` será un vector con los valores de los 2 ángulos.


### Para la corrección:

Modificaremos la clase anterior para poder pasar test unitarios. Para ello deberemos asegurarnos que:

1.  La clase se denomina `MatricesDeTransformacion`
2.  Implementaremos una batería de test unitarios para el método `cinematicaInversa2D(int x, int y): float[]` (testear 0,0; 0,10; 10,0; 10,10; 5,7;)
-->

# ... en Java
## varargs
Los argumentos de entrada variables en métodos son “sinónimos” de arrays de entradas, esto es:

`void metodo( String ... varargs )` es equivalente a `void metodo( String[] args)`, salvo que en el primer caso podremos llamar al método sin pasarle argumentos `metodo()`, mientras que en el segundo no.

Requisitos de uso:
+ El método debe tener un sólo `varargs`
+ Debe ser el último/s argumento del método.

### Fuentes:
+ [Ejemplo de uso](https://www.arquitecturajava.com/java-varargs-colecciones/)
+ [Más info](https://www.baeldung.com/java-varargs)

---
# Notas
[^1]: “Hardcodeado” es un término utilizado en el mundo de la programación para referirse a la práctica de incorporar directamente en el código fuente de un programa ciertos datos o valores específicos, en lugar de obtenerlos de manera dinámica o a través de una fuente externa. _Fuente: [udoe.es](https://udoe.es/hardcodeado-todo-lo-que-necesitas-saber-sobre-esta-practica/)_. Debe evitarse de forma general, y en especial con variables de entrono y password que estará completamente **prohibido**.