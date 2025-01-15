#curso24_25 #prog [estado::ToDo]

# Introducción a la Herencia

## Diagramas de clases y relaciones

[**TEORÍA**](https://diagramasuml.com/diagrama-de-clases/)

- [Diagrama de clases y relaciones](https://www.cybermedian.com/es/a-comprehensive-guide-to-uml-class-diagram/), especialmente importante:

![Diagrama](https://www.cybermedian.com/wp-content/uploads/2022/02/10-aggregation-example.png)

De forma que deberéis entregar (a mano) un esquema de la aplicación desarrollada, p.e.: ![diagrama](https://online.visual-paradigm.com/repository/images/7cacd2b6-df6f-40ae-ba75-eeab9a09aa54/class-diagram-design/class-diagram-gui-example.png) 

## Relaciones entre clases:

Se pueden distinguir diversos tipos de relaciones entre clases:
- **Clientela**. Cuando una clase utiliza objetos de otra clase (por ejemplo al pasarlos como parámetros a través de un método).
- **Composición**. Cuando alguno de los atributos de una clase es un objeto de otra clase.
- **Anidamiento**. Cuando se definen clases en el interior de otra clase.
- **Herencia**. Cuando una clase comparte determinadas características con otra (clase base), añadiéndole alguna funcionalidad específica (especialización).

### Pertenencia (Has-a)
[Clientela y composición](https://www.javatpoint.com/inheritance-in-java)

### Herencia (Is-a / Like-a)
+ [Herencia - `extends`](https://dit.upm.es//~pepe/libros/vademecum/index.html?n=305.html)
- Consideraciones:
   `public class 〈subclass-name 〉 extends 〈existing-class-name 〉`, esto es `class NombreClase extends ClasePadre { ... }`

1. Las clases `final` no pueden heredarse.
2. Se heredan todos los métodos y atributos **excepto** los `private`
3. Se ocultan (de la clase padre) todos los métodos y atributos sobreescritos. Se *recomienda* utilizar la anotación `@override` para que de error si sobrecargamos en lugar de sobreescribimos.
4. `super` para acceder a los métodos y atributos de la clase padre.
5. El constructor **DEBE** llamar al constructor de la clase padre con `super()`

#### super
Análogamente con `this` tenemos la palabra `super` que hace referencia a la clase padre, permitiéndonos acceder a sus atributos `super.variable`, a sus métodos `super.metodo()` o incluso a sus constructores con `super()`.


#### final
La palabra reservada `final` impide la modificación posterior de atributos, la sobreescritura de métodos o incluso la herencia de clases.

#### instanceof
El operador `instanceof` es usado para verificar el tipo de objeto instanciado

```java
// ...
if(objeto instanceof Coche) System.out.println("Es un coche");
else System.out.println("Es otro tipo de objeto");
// ...
```


## Ejercicio
Queremos crear una aplicación que maneje una colección de alumnos y profesores que gestionen los siguientes datos:
+ Alumnos: id, nombre, apellido1, apellido2, fechaNacimiento, modulosMatriculados, listaAmonestaciones.
  + Modulo: id, ciclo, nombre, notaFinal, listaAusencias, listaRetrasos.
    + Ausencia: Fecha[^1].
    + Retraso: Fecha
  + Amonestacion: Fecha, esGrave, causa, tieneExpulsion (en días).
+ Profesores: id, nombre, apellido1, apellido2, fechaNacimiento, modulosImpartidos.
  + Modulo: id, ciclo, nombre.
 
Crea el diagrama de clases para simplificar la aplicación y utilizar la filosofía D.R.Y. (Don’t Repeat Yourself - No te repitas).

## Otros ejercicios
1. [resuelto](https://puntocomnoesunlenguaje.blogspot.com/2016/04/ejercicio-resuelto-herencia-en-java.html)
2. [programacionpro.com](https://programacionpro.com/ejercicios-de-herencia-en-java-resueltos-desbloquea-las-puertas-de-la-programacion-orientada-a-objetos/)
3. [jarroba.com](https://jarroba.com/herencia-en-la-programacion-orientada-a-objetos-ejemplo-en-java/)
4. [**Con MANUAL**](https://github.com/OvejaBasualdo/Ejercicios-de-Java/blob/main/9-%20Herencia.pdf)
5. [Javaparanovatos](https://javaparajavatos.wordpress.com/category/ejercicios-de-herencia/)

## Clases abstractas (y métodos abstractos)
- Palabra clave [abstract](https://dit.upm.es/\~pepe/libros/vademecum/index.html?n=305.html)

Son aquellos métodos que no están implementados en la clase.

En las clases abstractas TODOS sus métodos lo son.


## `package`
La palabra reservada `package` nos permite crear nuestros propios paquetes de `Clases`.

Para su uso sólo deberemos incluir `package NOMBRE_PAQUETE` al comienzo de los archivos que queremos que pertenezcan a dicho paquete.

Para compilar el paquete deberemos hacer `javac -d . ClaseAMeterEnElPaquete.java`, sustituyendo `.` si deseamos compilarlo sobre otra ubucación.

Para la ejecución deberemos hacer `java ./NOMBRE_PAQUETE.ClaseAMeterEnElPaquete`


# Interface
![](https://dit.upm.es//~pepe/libros/vademecum/topics/doc_archivos/image010.png)

- [Clases e interfaces](https://ikastaroak.birt.eus/edu/argitalpen/backupa/20200331/1920k/es/DAMDAW/PROG/PROG08/es_DAMDAW_PROG08_Contenidos/PROG09_CONT_R46_InterfacesDepredadorPresa.png)
- [interface](https://dit.upm.es//~pepe/libros/vademecum/index.html?n=305.html)

![](https://sarreplec.caib.es/pluginfile.php/10288/mod_resource/content/2/PROG07/PROG09_CONT_R46_InterfacesDepredadorPresa.png)
Una interfaz es un contrato de desarrollo. Una vez redactado, todas las clases que lo implementen tienen la obligación de implementar TODO lo público.

`class NombreClase implements Interface{ ... }`

## Métodos `default`
+ [Creando métodos `default`](https://www.arquitecturajava.com/java-interface-default-method-y-reutilizacion/)


## Interfaces funcionales
Son un tipo especial de interfaces que tienen **un único método abstracto**.

Ese método (el abstracto) se podrá implementar mediante funciones lambdas:
```java
// Interfaces funcionales en java
// Requiere:
//    conocimiento de lambdas
//    base de programación funcional
//
// Clase principal
public class InterfazFuncional {

        // Anotacion para declara la interface
        @FunctionalInterface
        interface Operacion {
                // el metodo abstracto
                public double suma(double x, double y);
        }

        public static void main(String[] args) {
                // Expresion lambda
                Operacion l = (x, y) -> x + y;
                System.out.println(l.suma(8, 30));
        }
}
```


# Principios de diseño
+ [Principios de diseño](https://ichi.pro/es/principios-de-diseno-de-software-que-todo-desarrollador-deberia-conocer-39386044780942)

# Herencia vs Composición

> Puede que te preguntes, _¿cuando debería de utilizar la herencia?_
>
> Bueno, depende de tu problema del momento, pero esta sería una lista decente de cuando tiene más sentido utilizarla que la composición:
> 1.  Tu herencia representa una relación de "es-un" y no un "tener-un" (Humano->Animal vs Usuario->Detalles del Usuario)
> 2.  Puedes reutilizar tu código de las clases bases (Los humanos pueden moverse como todos los animales)
> 3.  Quieres hacer cambios globales a las clases derivadas con cambiar una clase base. (Cambiar el gasto calórico de todos los animales cuando se mueven)
>
> ## Principios SOLID
> ### El principio único de responsabilidad (SRP)
> Como se menciona en Clean Code, "Nunca debe existir más que una sola razón para cambiar una clase". Vale la pena decir que es normal querer llenar una 'clase' con muchas funciones, igual que cuando solo te permiten llevar una maleta en el vuelo. El problema existe en que tu 'clase' no estará cohesiva conceptualmente y existirá muchas razones para cambiarse. Minimizar la cantidad de veces que necesitas cambiar una clase es importante. Es importante ya que con demasiada funcionalidad viene dificultad de modificarlo y entender cómo afecta a otros módulos dependientes en tu programa.
>
> ### Principio de abierto/cerrado (OCP)
> Como dijo Bertrand Meyer, "las entidades de software (clases, módulos, funciones, etc.) deben abrirse para extensión, pero cerrarse para modificación. ¿Qué significa eso? Bueno, este principio básicamente nos dice que debes permitir que tus usuarios introduzcan nuevas funcionalidades sin cambiar el código existente.
>
> Fuente: [Clean Code Javascript](https://github.com/andersontr15/clean-code-javascript-es)

Revisa otros principios interesantes en la fuente.

## Métodos estáticos factory:
- [Static factory metodos](https://stackoverflow.com/questions/929021/what-are-static-factory-methods) -> no confundir con el patrón Factory Method
- [más factory metodos](https://www.baeldung.com/java-constructors-vs-static-factory-methods)


# Interfaces “famosas”
## `Comparable`
Sólo tiene el método `int compareTo(MismoTipo)` y se utiliza para tener un comparador natural de objetos, esto es, para ordenarlos decidiendo cual va antes.

Cada objeto decidirá como se va a ordenar, p.e. cuando tratamos con `Vehículos` podemos ordenarlos pero, ¿teniendo en cuenta la velocidad? ¿el consumo? ¿el coste? ¿los ocupantes? ¿la autonomía? ¿la capacidad de carga?...

Pues bien, `compareTo` nos devolverá un número positivo si el actual (this) es mayor que el proporcionado, negativo si es menor y 0 si son iguales.

La implementación de compareTo puede tener distintas referencias, esto es, que compare por velocidad máxima, pero si son iguales, que compare por consumo menor (mejor cuanto menor o más positivo cuanto menor sea).

### Ordenación
La forma más sencilla de ordenar una lista de elementos:
+ Colecciones: `void Collections.sort(lista)`
+ Arrays: `void Arrays.sort(array)`

Es void porque nos ordena la colección/array original, por lo que si queremos preservar su orden original deberemos tener la precaución de hacer una copia antes:
+ `List<Vehiculo> nuevaLista = new ArrayList<>( listaOriginal)`
+ `Vehiculo[] vehiculos = arrayOriginal.clone()`

### Referencia: 
[Comparable en arquitecturajava.com](https://www.arquitecturajava.com/java-comparable-interface-y-ordenaciones/)

## `Comparator`
Se trata de una interfaz con un único método a implementar `int compare(Tipo e1, Tipo e2)`

En esta ocasión lo que tendremos una clase que nos crea un `Comparador` que podemos utilizar en el método `sort` de colecciones y arrays.

Y lo mejor, que como `Comparator` es una **Interfaz funcional**, pues que podemos hacerlo “al vuelo” mediante expresiones _lambda_.

### Referencia:
[Comparator y lambdas](https://www.arquitecturajava.com/java-comparator-interface-y-lambdas/)


## `DAO` - Data Access Object
DAO y los `CRUD` (Create, Read, Update, Delete)

```java
public interface Dao<T> {
    
    T get(long id); // puede arrojar un null
    
    List<T> getAll(); // puede arrojar una lista vacía
    
    long save(T t); // devuelve el id
    
    void update(long id, String[] params);
    
    void delete(long id);
}
```

O de forma más elegante mediante el uso de [`Optional`](https://www.arquitecturajava.com/que-es-un-java-optional/):
```java
public interface Dao<T> {
    
    Optional<T> get(long id);
    
    List<T> getAll();
    
    long save(T t);
    
    void update(long id, String[] params);
    
    void delete(long id);
}
```


## `Serialize` (ut8)


## Otras:

### `DTO` - Data Transfer Objects

### `Iterable`

### `Iterator`


# Varios
## [^1] Fechas
Trabajar con fechas y horas en la informática es un auténtico dolor de muelas, pero en Java puede ser aún peor ya que históricamente, `java.util` ha sido bastante inútil, lo cual hizo durante un tiempo tener que reinventar la rueda varias veces.

A día de hoy, **NO** debemos utilizar la clase `java.util.Date`. 

Si buscamos, debemos tener cuidado, ya que nos aparecerá bastante información de la primera solución, la librería de fechas _Joda-Time_, que hoy está superado por el estándar JSR-310.

Después de Java 8 SE, deberemos hacer uso del paquete `java.time` y a veces de la clase `java.sql.Timestamp` (sobre trabajando con SQL).

### [Artículo de conversión](https://medium.com/@AlexanderObregon/beginners-guide-to-handling-date-and-time-in-java-cc2fcc5b13f1)
Each of these classes is immutable and thread-safe, addressing two major drawbacks of the old date-time classes. The immutability ensures that once an instance is created, it cannot be altered, making it safe to use in concurrent applications without the need for additional synchronization.

Java’s modern date and time API offers a comprehensive and intuitive approach for handling date and time, addressing the pain points of the old `java.util` classes. Whether you're working on a simple application that needs to display the current date or a complex system that handles time zones and daylight saving time changes, the `java.time` package has you covered.

### LocalDate

`LocalDate` represents a date without time of day or timezone information, such as `2024-04-11`. It is useful for representing dates like birthdays, anniversaries, or any other event that does not require time or timezone details. Here's how you can work with `LocalDate`:

```java
LocalDate today = LocalDate.now(); // Current date
LocalDate specificDate = LocalDate.of(2024, 4, 11); // A specific date
```

### LocalTime

`LocalTime`, on the other hand, represents time without a date or timezone. It can store times like `14:30:00` (2:30 PM). This class is ideal for scenarios where you need to represent or work with time alone, such as the opening hours of a business:

```java
LocalTime now = LocalTime.now(); // Current time
LocalTime specificTime = LocalTime.of(14, 30); // A specific time, say 2:30 PM
```

### LocalDateTime

`LocalDateTime` combines date and time but still without any timezone information, making it perfect for representing specific moments on a timeline, such as the exact moment an event starts or ends. It is particularly useful when the time zone is implied or not necessary for the context:

```java
LocalDateTime specificDateTime = LocalDateTime.of(2024, 4, 11, 14, 30); // Specific date and time
```

### ZonedDateTime

`ZonedDateTime` is a date-time with timezone information, such as `2024-04-11T14:30:00+01:00[Europe/Paris]`. It is important for applications that operate across multiple time zones and need to account for timezone differences and daylight saving time changes:

```java
ZonedDateTime zonedNow = ZonedDateTime.now(); // Current date and time with timezone
ZonedDateTime zonedSpecificDateTime = ZonedDateTime.of(specificDateTime, ZoneId.of("Europe/Paris")); // Specific date and time with timezone
```

### Instant

Apart from these, there’s also the `Instant` class, which represents a specific moment on the time-line. This class is intended for use with timestamps, and it's often used in logging and other time-stamped data:

```java
Instant now = Instant.now(); // Current timestamp
```


## Reflexión
La reflexión en Java en obtener información de [clases e instancias](https://www.arquitecturajava.com/el-concepto-java-reflection/)


## Clases anónimas

También **clases anónimas**
```java
...
NombreDeLaInterfaz referenciaAlObjeto = new NombreDeLaInterfaz() {
    ...
    /* Aquí la implementación de TODOS los métodos de la interfaz */
    ...
}
/* Aquí podemos usar cualquier método de la interfaz ya que lo tenemos implementado en el objeto */
referenciaAlObjeto.metodoDeLaClase();
...
```

# Referencias
Además de las habituales:
+ [Libro: Desarrollo de Proyectos Informáticos con Tecnología Java](http://www3.uji.es/~belfern/libroJava.pdf#%5B%7B%22num%22%3A98%2C%22gen%22%3A0%7D%2C%7B%22name%22%3A%22XYZ%22%7D%2C99.895%2C717.021%2Cnull%5D)