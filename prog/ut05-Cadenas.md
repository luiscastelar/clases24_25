---
Title:    Cadena de caracteres  
Author:   Luis Ferreira  
Date:     25 de octubre de 2024  
Comment:  Precedido de las unidades  
          1. Introducción a la programación  
          2. Introducción a la POO  
          3. Programación estructurada  
          4. Matrices  
---

#curso24_25 #prog [estado::Done]


# Clase String
Construcción:
```java
String texto1 = "¡Prueba de texto!";
String texto2 = "Este es un texto que ocupa " +
    "varias líneas, no obstante se puede "+
    "perfectamente encadenar";
String texto3 ="""
    Este texto también
    se puede hacer y 
    es mucho más legible""";

// Construcciones especiales
char[] palabra = {'P','a','l','b','r','a'}; //Array de char
String cadena = new String(palabra);

byte[] datos = {97,98,99};
String codificada = new String (datos, "8859_1");
/* En el último ejemplo la cadena codificada se crea desde un array de tipo byte que
contiene números que serán interpretados como códigos Unicode. Al asignar, el valor
8859_1 indica la tabla de códigos a utilizar. */
```


## Métodos NO estáticos
| Método.                     | Descripción                                                |
|-----------------------------|------------------------------------------------------------|
| cat1.length()               | Devuelve la longitud de la cadena.                         |
| cat1.charAt(3)              | Devuelve el carácter de la posición 4                      |
| cad1.concat(cat2)           | Concatena 2 cadenas.                                       |
| cad1.substring(3,6)         | Devuelve 6 caracteres desde el 4º.                         |
| cad1.compareTo(cad2)        | Permite comparar dos cadenas entre sí                      |
|                             | lexicográficamente. Retornará 0 si son iguales,            |
|                             | un número menor que cero si la cadena (cad1) es            |
|                             | anterior en orden alfabético a la que se pasa              |
|                             | por argumento (cad2), y un número mayor que cero           |
|                             | si la cadena es posterior en orden alfabético.             |
| **cad1.equals(cad2)**           | Cuando se comparan si dos cadenas son iguales, no          |
|                             | se debe usar el operador de comparación "==", sino         |
|                             | el método equals. Retornará true si son iguales, y         |
|                             | false si no lo son.                                        |
| cad1.trim()                 | Genera una copia de la cadena eliminando los espacios      |
|                             | en blanco anteriores y posteriores de la cadena.           |
| cad1.toLowerCase()          | Genera una copia con los caracteres a minúscula.           |
| cad1.toUpperCase()          | Genera una copia con los caracteres a mayúsculas.          |
| cad1.indexOf(cad2)          | Si la cadena o carácter pasado por argumento está          |
|                             | contenida en la cadena invocante, retorna su posición,     |
|                             | en caso contrario retornará -1.                            |
| cad1.indexOf(cad2,num)      | Opcionalmente se le puede indicar la posición a partir     |
|                             | de la cual buscar, es útil para buscar varias apariciones. |
| cad1.contains(cad2)         | Retornará true si la cadena pasada por argumento está      |
|                             | contenida dentro de la cadena. En caso contrario           |
|                             | retornará false.                                           |
| cad1.startsWith(cad2)       | Retornará true si la cadena comienza por la cadena pasada  |
|                             | como argumento. En caso contrario retornará false.         |
| cad1.endsWith(cad2)         | Retornará true si la cadena acaba por la cadena pasada     |
|                             | como argumento. En caso contrario retornará false.         |
| cad1.replace(cad2,cad3)     | Devuelve un string copia de la cadena cad1, en la que se   |
|                             | reemplazarán todas las apariciones de cad2 por cad3.       |
|                             | El reemplazo se hará de izquierda a derecha, por           |
|                             | ejemplo: reemplazar "zzz" por "xx" en la cadena "zzzzz"    |
|                             | generará "xxzz" y no "zzxx".                               |
| cad1.replaceAll(regex, cad) | Reemplaza según la expresión regular                       |

Algunos métodos más interesantes:
| Método.                        | Descripción                                           |
|--------------------------------|-------------------------------------------------------|
| cad1.compareToIgnoreCase(cad2) | El método compareToIgnoreCase funciona igual que      |
|                                | el método compareTo, pero ignora las mayúsculas y     |
|                                | las minúsculas a la hora de hacer la comparación.     |
|                                | Las mayúsculas van antes en orden alfabético que      |
|                                | las minúsculas, por lo que hay que tenerlo en cuenta. |
| cad1.equalsIgnoreCase(cad2)    | El método equalsIgnoresCase es igual que el método    |
|                                | equals pero sin tener en cuenta las minúsculas.       |

## Método ESTÁTICO
El método `String.valueOf( x )` nos devolverá el string que representa el dato primitivo suministrado o incluso el objeto suministrado. P.e.:
```java
String texto;
texto = String.valueOf( 10 ) ) // texto: "10"
texto += " - ";
texto += String.valueOf( 10.7 ) ) // texto: "10 - 10.7"
texto += " - " 
texto += String.valueOf( alumnoMario ) ) // texto: " 10 - 10.7 - Ese es el alumno Mario de la clase DAW 1"
```


## Ejercicios
Crea una clase que nos trabaje cadenas:
-   Invierte un texto introducido por teclado (clase LeerEntrada)
-   Elimina los espacios en blanco:
    -   De antes del texto (denominada `lTrim()`)
    -   De después del texto (denominada `rTrim()`)
    -   De dentro del texto, dobles espacios (denominada `innerTrim()`)


## Pool de `String`s
![pool](https://www.javastring.net/wp-content/uploads/java-string-pool-1024x564.png)
Fuente: [JavaString.net](https://www.javastring.net/java/string/pool)

Explicación en español -> [ArquitecturaJava.com](https://www.arquitecturajava.com/java-string-pool-un-concepto-importante/)


# Comparadores

[Comparator](https://www.youtube.com/watch?v=lgZ0qvHl7a0)


# Clase StringBuilder
En Java, String es un objeto **inmutable**, lo cual significa, entre otras cosas, que cada vez que creamos un String, o un literal de String, se crea un nuevo objeto que no es modificable. Java proporciona la clase StringBuilder, la cual es un mutable, y permite una mayor optimización de la memoria. 

`Java` también nos proporciona la clase **StringBuffer** que es `thread-safe`[^1], por lo que tiene un consumo mayor de recursos y es más lenta.
| Método                  | Descripsión                                                         |
|-------------------------|---------------------------------------------------------------------|
| strb.delete(6,8)        | Elimina los caracteres desde el 7º al 9º carácter.                  |
| strb.append(".")        | Añade '.' al final.                                                 |
| strb.insert (0,"¡")     | Insertamos en la posición 0, el símbolo de apertura de exclamación. |
| strb.replace (3,5,"la") | Reemplazamos los caracteres 'al' situados entre la posición         |
|                         | inicial 3 y la posición final 4, por la cadena 'la'. En este método |
|                         | ocurre igual que en los métodos delete y substring, en vez de       |
|                         | indicar como posición final la posición 4, se debe indicar justo la |
|                         | posición contigua, es decir 5.                                      |
|                         |                                                                     |

StringBuilder contiene muchos métodos de la clase String (charAt, indexOf, lenght, substring, replace, etc.), pero no todos. Habrá que estar atentos a la **documentación** y los errores.

-   Referencia [Doc **OFICIAL**](https://docs.oracle.com/javase/tutorial/java/data/buffers.html)

## Ejercicios
1. Busca dos métodos de `String` que no estén en `Stringbuilder`.
2. Escribe un programa java que pida al usuario que introduzca un texto y una letra. Después el programa tiene que calcular y presentar por pantalla, cuantas veces aparece la letra en el texto.
3. Invierte una cadena introducida por teclado
4. Elimina los espacios en blanco de:
  + Antes
  + Después
  + Dentro (dobles espacios)

5. Suma los elementos de un array que esté introducido en una sola línea de texto.
7. Comprueba si una palabra es palíndromo, esto es, se lee igual de derecha a izquierda que de izquierda a derecha. P.e. asa, ojo, radar, ...
8. Comprueba si un número es capicúa. P.e. son capicúas el 131, 3443, 42624, ...
9. Contador de palabras. Simula un <u>array asociativo</u> mediante 2 <u>arrays paralelos</u> que dada una frase nos cuente cuantas veces aparece cada palabra 

   
# Práctica
Realiza un programa que dados los archivos `carta.txt` y `destinatarios.csv` implemente el controlador Main que:
1. Declaración de variables
2. Cargamos el archivo CSV y lo parseamos dentro de una instancia de la clase Parametros
3. Cargamos la carta a memoria
4. Cargamos los datos CSV
5. Cargamos los datos a parsear según usuario
6. Ahora realizamos las sustituciones
7. Escribimos las cartas y mostramos el resultado

Para la implementación disponemos de la clase `TrabajarArchivo` cuya `interface` podéis verla en `Github` y la implementación de la clase `Parametros`, también en `Github`.

Tienes disponible en `Github` la interfaz de `TrabajarArchivo`, la implementación de `Parametro`, la carta y el archivo CSV con los datos a procesar.

_Nota: el carácter `$` se debe sustituir por su varlor literal `\u0024` y debe ir escapado `\\`_

**Entrega**: 9 enero


## Para la corrección:
Deberéis subir todos los archivos fuente (.java ) y objeto ( .class)

Las cartas serán corregidas vía `diff` de manera sistemática automatizado que introducirá un `destinatarios.csv` y `carta.txt` **diferente** al proporcionado al alumno por lo que no se admitirá
errores en nombres de archivo o redactado de las cartas combinadas.


# Programación competitiva
+ [Mejorando los resultados de Scanner](https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/)


---
# Notas al pie
[^1]: El concepto `thread-safe` indica que la clase ha sido diseñada para ejecutarse de forma segura y sincronizada en múltiples hilos de ejecución paralela. Por lo general, las clases `thread-safe` tienen todos sus métodos `synchronized`[^2].
[^2]: Un método y/o bloque de código `synchronized` (sincronizado) sólo podrá ser ejecutado por un hilo en cada momento, por lo que el resto de hilos que lo requieran deberán esperar a que el hilo actual en ejecución termine para poder ejecutarlo.