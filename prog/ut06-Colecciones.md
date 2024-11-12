#curso24_25 #prog [estado::ToDo]


# Introducción
Una colección es un conjunto variable de objetos del mimo tipo.
Podríamos verla como un `array` de tamaño variable.

[Vídeo explicativo](https://youtu.be/oQ0WkIdr73E?feature=shared)

En realidad, en Java `Collection` es un *framework* que proporciona una
arquitectura para el almacenamiento y manipulación de objetos.

La funcionalidad `collection` viene dada por el paquete `java.util` por
lo que deberemos importar todo el paquete con `import java.util.*;`

Podemos ver la magnitud del *framework* en la siguiente imágen:

![colecciones mapa](https://luiscastelar.duckdns.org/2024/prog/java-collection-hierarchy-y-maps.png)

## Interfaces de la Java Collection Framework:

-   `Collection`: define métodos para tratar una colección genérica de
    elementos
-   `List`: admite elementos repetidos y mantiene un orden inicial
-   `Set`: colección que no admite elementos repetidos
-   `SortedSet`: set cuyos elementos se mantienen ordenados según el
    criterio establecido
-   `Map`: conjunto de pares clave/valor, sin repetición de claves
-   `SortedMap`: map cuyos elementos se mantienen ordenados según el
    criterio establecido

# Interface `Collection` extends `Itarable`

### Parte pública (interfaz)
Veamos el `interface` de la clase:

```java
profe@servidor ~ :/$ javap java.util.Collection
Compiled from "Collection.java"
public interface java.util.Collection<E> extends java.lang.Iterable<E> {
  public abstract int size();
  public abstract boolean isEmpty();
  public abstract boolean contains(java.lang.Object);
  public abstract java.util.Iterator<E> iterator();
    public abstract java.lang.Object[] toArray();
  public abstract <T> T[] toArray(T[]);
  public default <T> T[] toArray(java.util.function.IntFunction<T[]>);
  public abstract boolean add(E);
  public abstract boolean remove(java.lang.Object);
  public abstract boolean containsAll(java.util.Collection<?>);
  public abstract boolean addAll(java.util.Collection<? extends E>);
  public abstract boolean removeAll(java.util.Collection<?>);
  public default boolean removeIf(java.util.function.Predicate<? super E>);
  public abstract boolean retainAll(java.util.Collection<?>);
  public abstract void clear();
  public abstract boolean equals(java.lang.Object);
  public abstract int hashCode();
  public default java.util.Spliterator<E> spliterator();
  public default java.util.stream.Stream<E> stream();
  public default java.util.stream.Stream<E> parallelStream();
```

**Nota:** aquí aparece la semántica de los *genéricos*. Si quieres saber
más sobre ellos, [aquí](https://picodotdev.github.io/blog-bitix/2016/04/tutorial-sobre-los-tipos-genericos-de-java/) tienes una referencia.

Tenemos métodos que hablan por si solos, pero también tenemos otros algo
especiales:
-   los `iterator()` que nos devolverá un elemento `Iterator` que
    podremos:
    -   obtener un elemento con `next()`,
    -   comprobar si hay más elementos `hasNext()` o,
    -   borrar un elemento `remove()`.
-   los `toArray()` que nos convertirán la colección dinámica en un
    array estático.
-   [public interface Collection<E> extends Iterable<E>](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collection.html)


Pero empecemos por el principio...

### Métodos:

| método | uso |
| --- | --- |
| boolean add(Object o) | Añade el objeto a la colección. Devuelve true si se pudo completar la operación. Si no cambió la colección como resultado de la operación devuelve false |
| boolean remove(Object o) | Elimina al objeto indicado de la colección. |
| int size() | Devuelve el número de objetos almacenados en la colección |
| boolean isEmpty() | Indica si la colección está vacía |
| boolean contains(Object o) | Devuelve true si la colección contiene a o |
| void clear() | Elimina todos los elementos de la colección |
| boolean addAll( Collection otra) | Añade todos los elementos de la colección otra a la colección actual |
| boolean removeAll(Collection otra) | Elimina todos los objetos de la colección actual que estén en la colección otra |
| boolean retainAll(Collection otra) | Elimina todos los elementos de la colección que no estén en la otra |
| boolean containsAll(Collection otra) | Indica si la colección contiene todos los elementos de otra |
| Object\[\] toArray() | Convierte la colección en un array de objetos. |
| Iterator iterator() | Obtiene el objeto iterador de la colección |

Pero como decíamos en el título, este `interface` extiende el `interface Iterable`, y por tanto, heredará de él todos sus métodos.


# Interface `Iterable`
## Uso básico
Es el mismo `Iterator` que implementa la clase `Scanner` por lo que su uso ya lo tenemos interiorizado o al menos lo conocemos.

Recordemos que tiene los métodos `hasNext(), next(), remove()` y `forEachRemaining()`

```java
Iterator it=coleccionString.iterator();
while(it.hasNext()){
        String s=(String)it.next();
        System.out.println(s);
}

//También podremos recorrer la colección con el ~for each~ (for mejorado)
for( String valor : it ){
        System.out.println(valor);
}
```

Mas información de [diferencias entre `Iterator` y forEach](https://www.arquitecturajava.com/java-iterator-vs-foreach/?pdf=6034)


## Nuevas sintaxis para iterar
Además del `for( Tipo v : elementoAIterar)` tenemos dos nuevas forma de
representarlo:
-   Operador `Lambda`: `elementoAIterar.foreach( (s) -> System.out.println(s) )`
-   Operador `::` (referencia a método): `elementoAIterar.foreach( System.out::println )`

Aquí de momento no vamos a ir más allá. Cuando veamos el tema de
`POO II` entraremos en estas construcciones.

Mas información en [expresiones Lambda y ::](https://javadesdecero.es/avanzado/expresiones-lambda-java/)


# Clase `Collections`
Sí, si no fuera poco el interface, además tenemos una clase que **NO** implementa la interface, si no que es una clase con métodos estáticos al estilo de la clase `Arrays`, esto es, que nos ayuda a manipular las colecciones, pero no a crearlas.

Mas información en [Class Collections extends Object](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collection.html)


# `List` (listas)
Explicación del funcionamiento/creación de listas:
1. [Listas enlazadas - teoría](https://www.youtube.com/watch?v=0NzAFk1CwaQ&list=PLTd5ehIj0goMTSK7RRAPBF4wP-Nj5DRvT&index=2&pp=iAQB)
2. [Listas enlazadas en Java](https://www.youtube.com/watch?v=TjlPQPRfWFk&list=PLTd5ehIj0goMTSK7RRAPBF4wP-Nj5DRvT&index=4&pp=iAQB)


## `public interface List<E> extends Collection<E>`
Esta **inferfaz** la implementan los `ArrayList`, los `LinkedList`, los `Vector` y derivado de éste último las `Stack` (pilas).

Podemos construir una lista a partir de un array con `List<String>  lista = Arrays.asList(unArray);` o incluso `List<String>  lista = Arrays.asList("Larry", "Moe", "Curly");`

**`List.of`** (Java 9):
Con él aparece una nueva forma de construir `List.of`, p.e. `List<String> lista=List.of("Esto","es","una","lista");`. La lista creada es **INMUTABLE**, por lo que no podemos modificar sus valores.

```java
profe@servidor ~ :/$ javap java.util.List
Compiled from "List.java"
public interface java.util.List<E> extends java.util.Collection<E> {
  public abstract int size();
  public abstract boolean isEmpty();
  public abstract boolean contains(java.lang.Object);
  public abstract java.util.Iterator<E> iterator();
  public abstract java.lang.Object[] toArray();
  public abstract <T> T[] toArray(T[]);
  public abstract boolean add(E);
  public abstract boolean remove(java.lang.Object);
  public abstract boolean containsAll(java.util.Collection<?>);
  public abstract boolean addAll(java.util.Collection<? extends E>);
  public abstract boolean addAll(int, java.util.Collection<? extends E>);
  public abstract boolean removeAll(java.util.Collection<?>);
  public abstract boolean retainAll(java.util.Collection<?>);
  public default void replaceAll(java.util.function.UnaryOperator<E>);
  public default void sort(java.util.Comparator<? super E>);
  public abstract void clear();
  public abstract boolean equals(java.lang.Object);
  public abstract int hashCode();
  public abstract E get(int);
  public abstract E set(int, E);
  public abstract void add(int, E);
  public abstract E remove(int);
  public abstract int indexOf(java.lang.Object);
  public abstract int lastIndexOf(java.lang.Object);
  public abstract java.util.ListIterator<E> listIterator();
  public abstract java.util.ListIterator<E> listIterator(int);
  public abstract java.util.List<E> subList(int, int);
  public default java.util.Spliterator<E> spliterator();
  public static <E> java.util.List<E> of();
  public static <E> java.util.List<E> of(E);
  public static <E> java.util.List<E> of(E, E);
  public static <E> java.util.List<E> of(E, E, E);
  public static <E> java.util.List<E> of(E, E, E, E);
  public static <E> java.util.List<E> of(E, E, E, E, E);
  public static <E> java.util.List<E> of(E, E, E, E, E, E);
  public static <E> java.util.List<E> of(E, E, E, E, E, E, E);
  public static <E> java.util.List<E> of(E, E, E, E, E, E, E, E);
  public static <E> java.util.List<E> of(E, E, E, E, E, E, E, E, E);
  public static <E> java.util.List<E> of(E, E, E, E, E, E, E, E, E, E);
  public static <E> java.util.List<E> of(E...);
  public static <E> java.util.List<E> copyOf(java.util.Collection<? extends E>);
}
```


## Ejercicio:
1.  Crea un programa que cree una `List` que esté *hardcoded* y luego recorrelo con el iterador mostrándo su contenido completo.
2.  Repite el programa recorriendo la lista con el bucle for
3.  Repite el programa recorriendo la lista con el operador Lambda `->`
4.  Repite el programa recorriendo la lista con el operador método-referencia `::`


## `ArrayList` implementa `List`
![ArrayList](https://prepbytes-misc-images.s3.ap-south-1.amazonaws.com/assets/1673848211453-Difference%20between%20ArrayList%20and%20LinkedList3.png)
La clase `ArrayList` implementa la interfaz `List`. Utiliza una matriz dinámica para almacenar los elementos duplicados de distintos tipos de datos. La clase `ArrayList` mantiene el orden de inserción y no está sincronizada[^1]. Se puede acceder aleatoriamente a los elementos almacenados en la clase `ArrayList`.

Lista dinámica de elementos de que mantienen el **orden** de inserción y cuyos elementos **pueden** estar duplicados.

Pese a que tienen orden, los elementos pueden ser accedidos de forma aleatoria mediante `miLista.get(indice)`.

Para su construcción lo invocaremos mediante la estructura `List<Tipo> referencia = new ArrayList <Tipo>()` [^2].

Se debe decir un para de cosas sobre estra construcción:
- Los `ArrayList` son una clase derivada de `List` por lo que podemos crear las referencias del tipo `List` o `ArrayList` indistintamente.
- Los Tipos son obligatoriamente **OBJETOS** por lo que no podremos crear ArrayList de tipo `int`, pero si de tipo `Integer`.
- Hemos usado el constructor general, pero tendremos 2 constructores más:
  - Con capacidad inicial `List<Tipo> referencia = new ArrayList<Tipo>(4)`.
  - A partir de un objeto `Collection` o `List`


### Métodos:
+ `boolean add(E)` -> Añade un objeto al final.
+ `void add(N, E)` -> Añade E en la posición N.
+ `int size()` -> Retorna el tamaño.
+ `int indexOf(E)` -> Retorna el indice del elemento E o -1.
+ `boolean contains(E)` -> Retorna true si existe el elemento E.
+ `oldE set(i, E)` -> Modifica el elemento que esta en la posición i, por el nuevo elemento E.
+ `E remove(N)` -> Saca el elemento N del `ArrayList` X.
+ `boolean remove(E)` -> Elimina la primera ocurrencia del elemento E de la lista si lo hubiera.
+ `E get(i)` -> Obtiene el elemento en la posición i.


### Referencias:
- [JavaDoc OFICIAL](https://docs.oracle.com/en/java/javase/17/docs/api/index.html)


### Ejercicio:
Crea una clase que:
-   lea números por teclado y almacene en una lista dinámica hasta
    recibir el comando `:q`.
-   elimine el comando si se almacenó en la lista.
-   imprima la lista.
-   recorra la lista sumando todos sus elementos.
-   obtenga la media usando el método para obtener el tamaño de la
    lista.
-   modifica los valores pares de la lista a por su posición, esto es,
    el segundo valor pase a valer 2 (recuerda que el primer valor es la
    pos 0).
-   imprime la lista.


## `LinkedList` implementa `List`
![LinkedList](https://media.licdn.com/dms/image/v2/C4D12AQGPIQSgwCgcEw/article-inline_image-shrink_1000_1488/article-inline_image-shrink_1000_1488/0/1647321614396?e=2147483647&v=beta&t=BqYHW6CiKWmVzUzmR2mxpdBpUW1T5_ZYPHNjUyO7vJ0)
Son similares al anterior pero su implementación interna los hace más eficientes en manipulación de sus datos.

Por contra, los ArrayList son mejores insertar y consultar los datos.

Ver [documentación OFICIAL LinkedList](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/LinkedList.html)


# `Set` (conjuntos)
Esta **interfaz** la implementan los `HashSet`, los `LinkedHashSet` y los `TreeSet` entre otros.

Crea conjuntos de datos **SIN duplicados**.

Al igual que `List` dispone del método `Set.of` para la creación rápida de conjuntos **INMUTABLES**.


## `HashSet` implementa `Set`

Es usado para crear una colección que implementa el interfaz ``Set``. Es por tanto un conjunto desordenado(*)  de elementos (objetos o datos primitivos) y por ende no dispone de índice, pero al heredar de `Iterator` podremos recorrerlo con él.

_Aunque a priori podría parecer ordenado, no está asegurado dicho comportamiento._


### Contructor
Tenemos 4 opciones:
| Constructor | Descripción |
|---|---|
| `HashSet()` | Constructor por defecto. |
| `HashSet(int capacidad)` | Con un capacidad definida. |
|`HashSet(int capacity, float factorDeCarga)` | Con una capacidad y un factor de carga. |
| `HashSet(Collection<? extends E> c)` |          Inicializado desde una colección. |
  ---------------------------------------------- ----------------------------------------

### Métodos
Tiene los métodos típicos para la gestión: add(e), remove(Obj), toArray(), size() y isEmpty().

Podéis consultar la [documentación OFICIAL de HashSet](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashSet.html).


### Iteraradores:
Dado un `HashSet` denominado `set`, podemos recorrerlo:
-   `set.forEach(System.out::println);`
-   `set.forEach( (s) -> System.out.println(s+" ");`


### Ejercicio
Crea un conjunto de tipo `HashSet` con elementos repetidos e impríme el resultado mediante expresiones `Lambda` o operador referencia.


## `TreeSet`
Esta clase implementa la interface `SortSet` que a su vez deriva de `Set`.

Se trata de un conjunto ORDENADO de elememntos ÚNICOS.

### Métodos
Además de los implementados de la interface `List` tenemos los implementados de la interface `Set`:
|  método |                                         uso
|  ---------------------------------------------- |---------------------------------------------------------------------------------------------------------------------------------------|
|  Object first()       |                          Obtiene el primer elemento del árbol (el más pequeño)|
|  Object last()      |                            Obtiene el último elemento del árbol (el más grande)|
|  SortedSet headSet(Object o)    |                Obtiene un SortedSet que contendrá todos los elementos menores que el objeto o. |
|  SortedSet tailSet(Object o)    |                Obtiene un SortedSet que contendrá todos los elementos mayores que el objeto o.
|  SortedSet subSet(Object menor, Object mayor) |  Obtiene un SortedSet que contendrá todos los elementos del árbol cuyos valores ordenados estén entre el menor y mayor objeto indicado|
  Comparator comparator()  |                      Obtiene el objeto comparador de la lista |


### Ejercicio
Crea un conjunto de tipo `TreeSet` con 10 números aleatorios e impríme el resultado mediante expresiones `Lambda` o operador referencia.


# `Map` (mapas)
Es una interfaz que genera objetos con pares `clave-valor`. P.e.: el mapa ciudad-temperatura:
-   Badajoz: 36
-   Cáceres: 34
-   Sevilla: 36
-   Madrid: 32
-   Barcelona: 26

En otros lenguajes se denominan también arrays asociativos.

## `HashMap` 
Pero `Map` es sólo la interface, nosotros utilizaremos `HashMap` que nos dice la DOC OFICIAL que
`public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable`


### Métodos
Aquí varian los nombres de los métodos con respecto a ``ArrayList`` y ``HashSet`` dado que tenemos 2 propiedades en cada elemento de la colección, su índice y el valor.
| Método | Descripción |
|---|---|
| V get(K indice) | Obtine el objeto `V` del índice `K`. |
| set(K indice, V valor) | Inserta o sobreescribe valor en indice. |
| remove(K indice) | Elimina elemento del índice. |
| isEmpty() | ¿Está vacío? |
| size() | Retorna el tamaño. |
| keySet() | Retorna un `Set` de los índices. |
| values() | Retorna un `Collection` de los valores. | 

Ver la [documentación OFICIAL de HashMap](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HashMap.html)


### Ejercicio:
1.  Crea el mapa del ejemplo e imprímelo
2.  Intenta duplicar alguna ciudad (imprime).
3.  Elimina todas las ciudades con 36 grados (imprime).
4.  Elimina Barcelona (imprime).
5.  Modifica la temperatura de Cáceres a 37 (imprime).


# Otras construcciones interesantes
## `Queue` (colas)
*Normalmente* primero en entrar - primero en salir (FIFO por su siglas inglesas). 

[DOC OFICIAL `public interface Queue<E> extends Collection<E>`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Queue.html)

## `Stack` (pilas)
Primero en entrar - último en salir (LIFO por sus siglas inglesas). [DOC OFICIAL
`public class Stack<E> extends Vector<E>`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Stack.html)

Refuerzo visual:
1.[Teoría](https://www.youtube.com/watch?v=JDlhpEuLUrQ&list=PLTd5ehIj0goMTSK7RRAPBF4wP-Nj5DRvT&index=8&pp=iAQB)
2.[En Java](https://www.youtube.com/watch?v=3q_2NKCqRmA&list=PLTd5ehIj0goMTSK7RRAPBF4wP-Nj5DRvT&index=10&pp=iAQB)

# Práctica
## Evaluación de resultados
Repite la práctica de evaluación de resultados de los alumnos en los módulos con un mapa donde los índices serán el nombre de los módulos.

Para ello el programa nos solicitará al comienzo los módulos, para posteriormente solicitarnos uno a uno las notas de cada uno (nos debe indicar cuál nos está solicitando).

En esta ocasión, si recibe un "-1" NO debe almacenar nada ahorrando espacio y tiempo.

Asegúrate de que utilizas los nombre adecuados de forma que tu nueva implementación debe pasar los test de tu implementación anterior.


## Transmisor de datos
En esta ocasión vamos a implementar una aplicación que envíe archivos a través de tramas ethernet.

*Puesto que nosotros no vamos a trasmitir realmente por la interfaz de red lo que haremos será los bytes leídos de un archivo los imprimiremos en pantalla a ritmo constante y por supuesto teniendo algunas
cosideraciones para dar veracidad a la transmisión.*

Como en todas las transmisiones deberemos tomar las siguientes consideraciones:
- Antes de comenzar determinaremos la tasa de transmisión.

  *En la vida real se realizaría según la velocidad de nuestra tarjeta y conexión, pero nosotros la leeremos por teclado en formato `0.2` (en segundos)*

+ Además leeremos el nombre del archivo a cargar en memoria
- Si el archivo lo trocearemos en trozos de 60 (caracteres)
- Cada trozo lo deberemos empaquetar en una [trama ethernet 802.3](https://es.wikipedia.org/wiki/IEEE_802.3):
  1.  Preámbilo: 7 veces el carácter `\u00AA` (`ª`)
  2.  SFD (comienzo de trama) `\u00AB` (`«`)
  3.  Dirección destino (broadcast) `\u00FF:\u00FF:\u00FF:\u00FF:\u00FF:\u00FF`
  4.  Dirección origen (el de vuestra mac /ipconfig *all*)
  5.  Longitud: 60 caracteres o los que queden en el último envío (con 3 dígitos).
  6.  Datos
  7.  Nº de trama (número de 3 dígitos correlativo comenzando por un número aleatorio)
- Entre trama y trama introduciremos un final de línea.
- Vamos a dejar bonita la pantalla. Vamos a encapsular las tramas de forma que tras leer el nombre del archivo borraremos y comenzaremos imprimiendo la cabecera de la tabla de envíos y debajo cada uno de     los paquetes separando sus campos con ``|``, de forma que nos quede algo tal que así:

![colecciones mapa](https://luiscastelar.duckdns.org/2024/prog/tablaTransmision.png)
Los [bordes de la tabla aquí](https://en.wikipedia.org/wiki/Box_Drawing)

Nota: Nos hemos tomado algunas licencias artísticas, pero el envío puede ser similar a esto.

Debe entregarse tanto la clase `TransmisionDeArchivos` como la salida por pantalla que llamaremos `transmision.log`

Para capturar la salida por pantalla deberemos invocar el programa desde PowerShell con el comando Tee-Object de la siguiente forma: `java TransmisionDeArchivos | Tee-Object -FilePath "transmision.log"`, o desde ``bash`` con ``java TransmisionDeArchivos | tee "transmision.log"``.


## Calculadora de pila (RPN)
En esta práctica vamos a crear una pequeña calculadora de pila que sólo suma, multiplica y totaliza.

Las calculadoras de pila operan algo diferente de las calculadoras normales. Introducimos los operandos en la pila y cuando recibimos un operador realizamos la operación pertinente y devolvemos el resultado a la pila.

Por ejemplo: si queremos obtener ``(2+3)*5`` le introduciremos los datos de la siguiente forma: ``2 3 + 5 * =``.

El programa deberá:
+ Si recibe un operando: deberá introducirlo en la pila.
+ Si recibe una operación:
   + `+` -> deberá realizar la suma invocando al método `void sumar(Pila mem)` que tomará 2 operandos de memoria y devolverá el resultado.
   + `*` -> deberá realizar la multiplicación invocando al método `void multiplicar(Pila mem)` que tomará 2 operandos de memoria y devolverá el resultado.
   + `!` -> deberá obtener el factorial invocando al método `void factorial(Pila mem)` que tomará 1 operandos de memoria y devolverá el resultado. Deberéis resolverlo de forma **recursiva**.
   + `=` -> deberá imprimir el resultado en formato ``"El total es: "+ total`` y finalizar.

Deberéis realizar test unitarios con al menos los siguiente casos de prueba:
1.  3 2 * 2 + 4 *
2.  3 2 * 2 + 4 * 3 * 2 + 4 * 3 + 2 * 2 + 4 *
3.  3 2 * 2 + 4 * 3 * 2 + 4 * 3 + 2 * 2 + 0 *

Debe entregarse tanto la clase `CalculadoraRPN` como `TestCalculadoraRPN`.

---

# Genericos
[Genericos](https://oregoom.com/java/generics/)

**NO** -> [Ampliación - Wildcards](https://www.youtube.com/watch?v=becfU6P5o1c).


# Nuevas expresiones

## Lambda
¿Qué es una `lambda`?, o ¿cómo se forma una `lambda`?

### Construcción paso a paso
1. Dada una función:
  ```java
  public void miFuncion(String s){
    // hacer cosas, p.e.:
    System.out.println(s);
  }
  ```
2. La podemos asignar a una variable (del tipo `lambda`) a partir de Java 8:
  ```java
  miLambda = public void miFuncion(String s){
    // hacer cosas, p.e.:
    System.out.println(s);
  }
  ```
3. `public` es redundante...:
  ```java
  miLambda = void miFuncion(String s){
    System.out.println(s);
  }
  ```
4. ¿Para qué asignarle nombre a la función?
  ```java
  miLambda = void (String s){
    System.out.println(s);
  }
  ```
5. El compilador puede inferir el tipo de retorno...
  ```java
  miLambda = (String s){
    System.out.println(s);
  }
  ```
6. El compilador puede inferir el tipo de entrada...
  ```java
  miLambda = (s){
    System.out.println(s);
  }
  ```
7. Si le añadimos el operador flecha podemos prescindir de las llaves cuando sólo tenemos una línea:
  ```java
  miLambda = (s) -> System.out.println(s);
  ```
8. Y podemos ir más allá... cuando queramos podemos no usar la asignación, si no simplemente insertarlo:
  ```java
  (s) -> System.out.println(s);
  ```

Construcción paso a paso[^3].

#### Uso
Esto último se ve mejor aquí:
```java
// Tenemos una implementación de la interfaz `Comparator`
Comparator<Player> comparator = (p1, p2) -> p1.getRanking() - p2.getRanking();
//...
// y la usamos en 
Player player1 = new Player(59, "John", Integer.MAX_VALUE);
Player player2 = new Player(67, "Roger", -1);

List<Player> players = Arrays.asList(player1, player2);
players.sort(comparator);
```

En realidad podemos simplificarlo con:
```java
Player player1 = new Player(59, "John", Integer.MAX_VALUE);
Player player2 = new Player(67, "Roger", -1);

List<Player> players = Arrays.asList(player1, player2);
players.sort(
  (p1, p2) -> p1.getRanking() - p2.getRanking()
);
```

Y yendo un paso más allá:
```java
//..
players.sort( Player::getRanking() );
```

### Fuentes
+ Lambda expresion `->` https://www.geeksforgeeks.org/lambda-expressions-java-8/?ref=gcse
+ [Construcción](https://www.youtube.com/watch?v=xnq3SXX70JM)

## Referencia a método
Operador double `::` https://www.geeksforgeeks.org/double-colon-operator-in-java/

[Aquí](https://www.youtube.com/watch?v=_0wn9wi0wcI) tienes un vídeo de usos.

# Streams
En doc aparte

+ [Introducción](https://www.youtube.com/watch?v=G4-43xfY8_0)
+ [Operaciones terminales](https://www.youtube.com/watch?v=BRshULYMGs8)

---
# Notas al pie
[^1]: en Java, se dice que un método está `synchronized` cuando lleva dicha palabra en su declaración o en su interior. El bloque de código afectado por `synchronized` será ejecutado por los hilos de forma exclusiva, por lo que mientras haya un hilo ejecutando dicho código, el resto deberán esperar a que se libere.

[^2]: Como podemos ver, siempre que podamos almacenaremos en referencias de la interfaz los objetos del tipo implementación de la misma. Ésto se realiza por motivos de flexibilidad de modificación en el futuro.

[^3]: Ejemplificación paso a paso ficcionada. No podemos realizar estos pasos en la realidad.