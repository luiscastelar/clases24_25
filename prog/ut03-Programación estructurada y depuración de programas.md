#curso24_25 #prog [estado::Done]

# Herramientas
## Diagrama de actividades
Debéis conocer el lenguaje intermedio de programación, los [diagramas de actividades](https://ocw.unizar.es/ciencias-experimentales/modelos-matematicos-en-bases-de-datos/uml/02UML_DiagramaActividades.pdf).

No es objeto de este módulo formativo trabajarlos, pero si será una herramienta **imprescindible** para el desarrollo de esta y futuras unidades.


# Control de excepciones
En ocasiones se pueden recibir valores no esperados (p.e. solicitar un número y recibir una letra) o recursos no disponibles que no podremos detectar al compilar ya que se producen en tiempo de ejecución.

Para poder gestionarlos y no tener salidas prematuras y abruptas de la aplicación utilizaremos las palabras reservadas `try` y `catch` (intenta y atrapa).

Su funcionamiento es sencillo como podemos ver en el ejemplo siguiente:
```
...
int a = 7, b = 0, c;
try {
	c = a / b;
} catch (Exception e) {
	System.out.println(e.getMessage());
		// Imprime un mensaje descriptivo
	System.out.println(e.toString());
		// Imprime la clase que generó la excepción y un mensaje descriptivo
	System.out.println(e.printStackTrace());
		// Imprime el método y el mensaje... lo mismo que si no lo controláramos.
}
```
*Nota: Éstos mensajes son muy útiles en el `desarrollo`, pero deberemos ocultarlos en la puesta en `producción` para no dar pistas a usuarios maliciosos.*

El control de excepciones también dispone de la palabra `finally` que nos abrirá un sección de código que se ejecutará tanto si se ha producido una excepción como si no, y donde ubicaremos las instrucciones que lleven a un estado seguro limpiando.

Además, podemos tener un desarrollo más detallado con varios `catch` según el tipo de excepción que llamarán a objetos que heredan de la clase `Exception` por lo que disponen de los métodos anteriores. \
Ver referencia completa en  [control de errores - jorgesanchez.net](https://www.jorgesanchez.net/manuales/viejos/fpr/fpr0809.pdf) ).


## Estructura básica `try/catch`:

[Presentación](https://elvex.ugr.es/decsai/java/pdf/B2-excepciones.pdf) y [otro punto de vista](https://somoshackersdelaprogramacion.es/excepciones-en-java)

Modo sencillo:
```java
// ... 
try{

} catch (Exception e){

}
```

Con cierre seguro:
```java
try{

} catch (Exception e){

} finally {

}
```



_A partir de Java22 podemos usar una variable sin nombre “\_” si no necesitamos esa variable, evitando así los warnings del IDE o lint._
<details>

```java
try{

} catch (Exception _){
  System.out.println("Excepción ocurrida");
}

```
</details>

## Clase `Exception`
Mapa completo de situación:
<details>

![mapa](https://i0.wp.com/somoshackersdelaprogramacion.es/wp-content/uploads/2022/05/java-exceptions-hierarchy-example.png?w=977&ssl=1)
</details>

Fuentes:
 + [Reflexiones sobre excepciones](https://medium.com/javarevisited/all-about-exception-handling-f1a917bac254)


## `throw` y `throws`
A veces querremos lanzar de forma expresa una excepción. Para ello sólo tendremos que usar la palabra  `throw`:
```java
if (divisor != 0) {
  resultado = dividendo / divisor;
} else {
  throw new ArithmeticException("division por cero");
}
```
Con lo anterior hemos lanzado cuando hemos querido la excepción y además hemos personalizado el mensaje.

Además, podemos delegar la gestión en el método que lo invocó con `throws`:
```java
public division(float dividendo, float divisor) throws ArithmeticException {
  // Aquí el código de la división
}
```
Pero está claro que nuestro método `division` no puede saber porqué ha recibido un 0 como divisor, con lo que la gestión de la misma en su interior no puede ir más allá de lanzar un mensaje. 

Muy probablemente, desde el método que lo lanzamos podamos pedirle al usuario un nuevo divisor o algo similar, con lo que es más acertado delegar esa gestión en quien proporciona los datos “feos”.

## Excepciones controladas y no controladas
![errores y excepciones](https://1.bp.blogspot.com/-ScmTq0JbbYA/V6CXif8gsiI/AAAAAAAABeY/fBCJQaj6VQ8YcdUqV-yggEzGOon4XyPkACLcB/s640/ExcepcionesCheckedUnchecked.png)


 Fuentes:
 + [Excepciones controladas y no controladas](https://aprendiendoaprogramarbyem.blogspot.com/2016/08/excepciones-verificadas-y-no-verificadas.html) y [2](https://misapuntesdeprogramacion.wordpress.com/2013/02/07/excepciones/)

## [NO] - Excepciones personalizadas
[Eso](https://somoshackersdelaprogramacion.es/excepciones-en-java)

# assert - “Afirmación”
```java
public class Aserciones {
        public static void main( String[] args ){
                final int DESEADO = 0;
                int buscado = 0;
                assert DESEADO == buscado : "Afirmación falsa => buscado no vale DESEADO";
                assert DESEADO == buscado ; // Excepción no personalizada
                
                buscado = 1;
                assert DESEADO == buscado : "Afirmación falsa => buscado no vale DESEADO";
                assert DESEADO == buscado ; // Excepción no personalizada
        }
}
```

Compila y ejecuta... ¿que ocurre?

<details>Repite la ejecución con `-ea` (enable assertions)</details>


# Estructuras de control:

## De selección:
### `if`
+ IF Simple:
```
if (EXPRESION) {
	// Sentencias si verdadero
	...
}
```
+ IF-ELSE:
```
if (EXPRESION) {
	// Sentencias si verdadero
	...
} else {
	// Sentencias si falso
	...
}
```
+ Anidación de condicionales con IF-ELSE IF:
```
if (EXPRESION) {
	// Sentencias si verdadero
	...
} else if (EXPRESION_2) {
	// Sentencias si condicion 2
	...
} else {
	// Sentencias si falso
	...
}
```
_Nota: su uso estará sujeto a la más absoluta excepcionalidad._

### `switch`
Condicionales múltiples con SWITCH-CASE:
```
switch (EXPRESION) {
	case VALOR_1:
		// Sentencias si valor 1
		...
		break;
	case VALOR_2:
		// Sentencias si valor 2
		...
		break;
	[default:
		// Sentencias en otro caso
		...
		break;]
}
```
_Nota: si omitimos los `break` se ejecutarán las siguientes sentencias._
_Nota 2: los `[` y `]` indican que la parte `default` es opcional._

#### El infierno de los `switch`s:
La construcción `switch` es sin duda la que más ha ido evolucionando a lo largo del tiempo, con las siguientes mejoras en cada versión nueva del lenguaje:
+ Java SE 7: añade soporte para `String`s
+ Java SE 14: `switch` como expresión `lambda`:
<details>

```java
String result = switch (str) {
    case "A" -> 1;
    case "B" -> 2;
    case "C" -> 3;
    case "D" -> 4;
    default -> Integer.MIN_VALUE;
};

int result;
switch (str) {
    case "A" -> result = 1;
    case "B" -> result = 2;
    case "C" -> {
        result = 3;
        System.out.println("3!");
    }
    default -> {
        System.err.println("Valor no reconocido: " + str);
        result = -1;
    }
}

int result = switch (str) {
    case "A" -> 1;
    case "B" -> 2;
    case "C" -> {
        System.out.println("Es un 3!");
        yield 3; // return
    }
    default -> System.err.println("Valor no reconocido: " + str);
};

int result = switch (str) {
    case "A" -> 1;
    case "B" -> 2;
    case "C" -> 3;
    case "D", "E", "F" -> 4;
    default -> -1;
};
```
</details>


### Ejercicios
1.  Realiza un programa que reciba dos números por teclado e indique cuál es mayor o si son iguales.
2.  Realiza un programa que pida un número por teclado y nos indique si es par o impar.
3.  Crea un programa que pida al usuario dos números y muestre el resultado de su división. Si el segundo número es 0, debe mostrar un mensaje de error.
4.  Realiza un programa que lea una cadena por teclado y compruebe si es una letra mayúscula.
5.  Realiza un programa que calcule la potencia de un número, dado este y su exponente. Pueden ocurrir tres casos:
    + El exponente sea positivo: imprime resultado en pantalla.
    + El exponente sea 0, el resultado es 1.
    + El exponente sea negativo, el resultado es 1/potencia con el exponente positivo.
6. Realiza un programa que calcule la aceptación de una solicitud en base a los siguientes parámetros: edad, nota y sexo.
    + Mínimo: Nota (5), edad (18), sexo M -> POSIBLE
    + Mínimo: Nota (5), edad (18), sexo F -> ACEPTADA
    + Otros casos -> NO ACEPTADA
7. Realiza un programa que pida los puntos centrales de dos circunferencias (x1, y1), (x2, y2) y los radios de las mismas (r1, r2). El programa debe clasificar según corresponda como: exteriores, tangentes exteriores, secantes, tangentes interiores, interiores o concéntricas.
8. Realiza un programa que clasifique un triángulo tras recibir el tamaño de sus lados. Se debe clasificar como triángulo rectángulo, isósceles, equilátero o escaleno.
9. Escribe un programa que reciba un año y nos diga si es bisiesto o no.
10. La asociación de vinicultores tiene como política fijar un precio inicial al kilo de uva, la cual se clasifica en tipos (A y B), y además en tamaños (1 y 2). Cuando se realiza la venta del producto, ésta es de un sólo tipo y tamaño, se requiere determinar cuanto recibirá un productor por la uva que entrega en un embarque considerando lo siguiente:
    + Si es de tipo A, se le cargan 20 céntimos al precio inicial cuando es de tamaño 1 y 30 céntimos si es de tamaño 2.
    + Si es de tipo B, se rebajan 30 céntimos cuando es de tamaño 1, y 50 céntimos cuando es de tamaño 2.
11. El director de una escuela está organizando un viaje de estudios y requiere determinar cuánto debe cobrar a cada alumno y cuánto debe pagar a la compañía de viajes por el servicio. La forma de cobrar es la siguiente:
    + Si son 100 alumnos o más, el costo por cada alumno es de 65 euros.
    + De 50 a 99 alumnos, el costo es de 70 euros.
    + De 30 a 49 alumnos, el costo es de 95 euros.
    + Menos de 30 alumnos, el costo de la renta del autobús es de 4000 euros, sin importar el número de alumnos.
12. Realiza un algoritmo que permita determinar el pago a la compañía de autobuses y lo que debe pagar cada alumno por el viaje.
13. La política de cobro de una compañía telefónica es: \
    Cuando se realiza una llamada, el cobro es por el tiempo que esta dura, de tal forma que los primeros cinco minutos cuestan 1 euro, los siguientes tres, 80 céntimos, los siguientes dos minutos a 70 céntimos y a partir del décimo minuto, 50 céntimos. \
    Además, se carga un impuesto de 3% cuando es domingo, y si es otro día, en turno de mañana 15% y en turno de tarde 10%. \
    Realiza un algoritmo para determinar cuánto debe pagar por cada concepto una persona que realiza una llamada.
14. Realiza un programa que pida por teclado el resultado (dato entero) obtenido al lanzar un dado de seis caras y muestre por pantalla el número en letras (dato cadena) de la cara opuesta al resultado obtenido. \
    Nota 1: En las caras opuestas de un dado de seis caras están los números: 1-6, 2-5 y 3-4. \
    Nota 2: Si el número del dado introducido es menor que 1 o mayor que 6, se mostrará el mensaje: “ERROR: número incorrecto”. \
15. Realiza un programa que pida el día de la semana (del 1 al 7) y escriba el día correspondiente. Si introducimos otro número nos da un error.
16. Realiza un programa que pida un número entero entre uno y doce e imprima el número de días que tiene el mes correspondiente.


## De repetición:
### `while`
Bucles `while`: iteramos (repetimos) mientras la condición sea `true`:
```
while (*condicion*) {
	*sentencias a ejecutar mientras que se cumpla la condición*
	...
}
```


### `do-while`
Bucles `do-while`: la iteración se ejecutará al menos 1 vez, y si se cumple, seguimos iterando:
```
do {
	*sentencias a ejecutar mientras que se cumpla la condición*
	...
} while (*condicion*)
```

### `for`
Bucles `for`: heredado del lenguaje C y con la misma potencia:
```
for (*pre-ejecución*; *condición*; *post-ejecución*){
	*sentencias a ejecutar mientras que se cumpla la condición*
	...
}

for (int i=0; i < MAX; i++){
  System.out.println( "Mi primera lista ordenada " + i );
}

for (int i=MAX; i > 0; ){
  System.out.println( "Mi primera lista ordenada " + --i );
}
```
Uso _típico_:
1. Pre-ejecución: Inicializamos un contador. Típicamente se utilizan las variables `i`, `j` y `k`. Son la excepción a la norma del “naming”.
2. Verificamos condición y si se cumple ejecutamos el bloque contenido en entre `{` y `}`.
3. Post-ejecución: Incrementamos el contador y volvemos al punto 2.

_Nota: los bloques pre-ejecución y post-ejecución pueden utilizarse para lo que queramos._
_Nota 2: los bloques pre-ejecución y post-ejecución pueden NO utilizarse, pero los `;` deben aparecer._

El bucle `for` es tan potente que permite emular cualquiera de los otros bucles, e incluso a los `if`: `for( ; a < b ; ){ *Hago algo* }`


### Bucles anidados:
Los bucles pueden anidarse. 

Ejercicio: Imprime en pantalla las tablas de multiplicar (del 0 al 10).


## Saltos: `break` y `continue`
Cuando dadas las circunstancias queremos detener un bucle o anular el procesado de una iteración podemos utilizar:
	+ `break`: interrumpe completamente el bucle. Esto es, se finaliza su ejecución.
    + `continue`: interrumpe sólo la iteración actual, pasando a ejecutar la siguiente.


## Ejercicios
+ [Cuanta los minutos](https://www.aceptaelreto.com/problem/statement.php?id=148&cat=5)
+ [¿Qué lado de la calle?](https://www.aceptaelreto.com/problem/statement.php?id=217&cat=5)


# Pruebas
Dados los [tipos de pruebas](https://www.loadview-testing.com/es/blog/tipos-de-pruebas-de-software-diferencias-y-ejemplos/), en esta sección nos centraremos en las pruebas unitarias que nos permitiran de forma sencilla, flexible y potente seguir avanzando en el conocimiento de la POO y el lenguaje, sin perder el tiempo en testear los cambios.


## Entorno Integrado de Desarrollo -IDE-
+ [ ] Utilizar el entorno integrado de desarrollo en la creación y compilación de programas ~~simples~~.
+ [ ] Depuración
+ [ ] Test
  + [ ] unitarios - _JUnit_
     + Testeando la salida de consola con [JUnit](https://www.mastertheboss.com/various-stuff/testing-java/how-to-verify-the-console-output-in-junit-tests/)
      
  + [ ] Desarrollo Dirigido a Test -TDD- (rojo, verde, refactor)
  + [ ] _Records_

        
## Pruebas unitarias - Junit
1. [Introducción](https://rcasalla.gitbooks.io/libro-desarrollo-de-software/content/libro/temas/t_pruebas/prue_junit.html).
2. [Desarrollo](https://github.com/luiscastelar/clases24_25/blob/main/prog/ut03-pruebas_JUnit.md).


## TDD - Test-Driven Development
> Desarrollo guiado por pruebas de software, o Test-driven development es una práctica de ingeniería de software que involucra otras dos prácticas: Escribir las pruebas primero y Refactorización. Para escribir las pruebas generalmente se utilizan las pruebas unitarias. En primer lugar, se escribe una prueba y se verifica que la nueva prueba falla. A continuación, se implementa el código que hace que la prueba pase satisfactoriamente y seguidamente se refactoriza el código escrito. El propósito del *desarrollo guiado por pruebas* es lograr un **código limpio que funcione**. La idea es que los requisitos sean traducidos a pruebas, de este modo, cuando las pruebas pasen se garantizará que el software cumple con los requisitos que se han establecido.
>
> Fuente: [Wikipedia](https://es.wikipedia.org/wiki/Desarrollo_guiado_por_pruebas)

1.  **Fase ROJA**: Primero hacemos los test -> ergo falla ya que no tenemos la funcionalidad.
2.  **Fase VERDE**: Realizamos la implementación que permita que pase el test -> pasa el test?
3.  **Refactorización**: Ahora reescribimos el código de forma limpia -> [**CLEAN CODE**](https://www.ivoox.com/importancia-clean-code-script-time-audios-mp3_rf_123494197_1.html).


# javadoc - Documentación integrada
> Javadoc es una utilidad de Oracle para la generación de documentación de APIs en formato HTML a partir de código fuente Java. Javadoc es el estándar de la industria para documentar clases de Java.

Continuar en [wikipedia](https://es.wikipedia.org/wiki/Javadoc)

Uso típico `javadoc PAQUETES` o `javadoc FUENTES`, siendo éstas uno o varios archivos `.java`

_Nota: a menudo, windows no encuentra adecuadamente el programa `javadoc` pero fácilmente podemos instanciarlo indicando la ruta completa `c:\Program Files\Java\jdk-21\bin\javadoc `_


# Buenas prácticas
1. Los métodos **deben** especificar los parámetros y los retornos. **NO** usar variables globales.
2. Los métodos deben tener el mismo nivel de abstracción (ver fuente).
3. Los métodos deben ser pequeños para ser reusables.
4. Principio abierto cerrado -OCP- por sus siglas inglesas (ver en ut7)
5. _Evitar comentarios a toda costa_.[^1]
6. No usar números mágicos (visto en ut2)
7. No anidación profunda (ver fuente)
8. No “hardcodear” _paths_ y menos passwords (ver en ut8) [^2]
9. Las clases deberían ser pequeñas. Principio de simple responsabilidad SRP.
10. Los operadores ternarios deben ser sencillos. No anidarlos ni utilizar expresiones en sus “asignadores”.

Fuente:
+ [Para escribir mejor código10 tips](https://levelup.gitconnected.com/become-a-better-coder-10-tips-fa81f732a624)


# Juegos y retos:
+ [Acepta el reto](https://aceptaelreto.com/)
+ [**Programame**](https://programame.com/2025/reg/)
+ [CodinGame](https://www.codingame.com/training)
+ [CodeWars](https://www.codewars.com/)

## Ejercicios de algorítmia
+ [algorítmia](https://elhacker.info/manuales/Lenguajes%20de%20Programacion/Java/Ejercicios-de-Programacion-en-Java.pdf)


# PRÁCTICA
+ [Altura de un árbol general](https://www.aceptaelreto.com/problem/statement.php?id=310&cat=10)

Deberéis implementarlo mediante objetos, bucles y condicionales... vamos, lo que hemos visto en clase y sólo eso.

*Rúbrica*:
+ Descripción del problema [2p] (y documentación)
+ Implementación de objeto controlador:
	+ Captura de entrada [1p]
	+ Bucles [2p]
	+ Condicionales [2p]
+ Implementación de objeto [3p]

*Herramientas auxiliares*:
+ [String length](https://www.javatpoint.com/java-string-length)
+ [String to Char](https://www.javatpoint.com/java-string-to-char)
+ [Char to int](https://www.javatpoint.com/java-char-to-int)



---
# Notas

[^1]: Sólo cuando ya sepas programar y tu código hable por ti. Ahora que estamos aprendiendo, a veces, no codificamos lo que hemos programado mentalmente por lo que mejor si dejas claro al profesor lo que en realidad querías hacer.

[^2]: Pese a que la fuente avisa de que deben evitarse, nosotros lo tendremos prohibido, tanto rutas como otros elementos. Usar archivo de _properties_.