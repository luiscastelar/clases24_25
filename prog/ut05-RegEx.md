
#curso24_25 #prog #lmsgi #bbdd [estado::Done]

# Expresiones regulares -REGEX-

## Teoría sobre expresiones regulares
-   [Vídeo introducción](https://www.youtube.com/watch?v=M72lwALYRJU)
-   [Presentacion de expresiones regulares](https://www.slideshare.net/alkuy/expresiones-regulares-64990123)
-   [átomos](https://www.geeksforgeeks.org/write-regular-expressions/)
-   Tabla resúmen:

![Chuleta/resumen de expresiones
regulares](https://luiscastelar.duckdns.org/2024/assets/prog/ExpresionesRegulares.png)

-   Validadores on-line: <https://regexr.com/> o <https://regex101.com/>
-   [Crucigrama de RegEx](https://regexcrossword.com/)
-   Expresiones **CODICIOSAS** \"(.\*)\" y **PEREZOSAS** \"(.\*?)\": las
    codiciosas buscan la coincidencia más larga y las perezosas la más
    corta.
-   [Vídeo resúmen](https://www.youtube.com/watch?v=eiyFt2lHnAY) (52min)
-   [Un pedazo de manual sobre Expresiones Regulares](https://jarroba.com/busqueda-de-patrones-expresiones-regulares/)
-   [Man RegEx Microsoft](https://docs.microsoft.com/es-es/dotnet/standard/base-types/regular-expressions)

## RegEx en Java
```java
import java.util.regex.*;
public class RegexExample1{
  public static void main(String args[]){
    //1st way
    Pattern p = Pattern.compile(".s");//. represents single character
    Matcher m = p.matcher("as");
    boolean b = m.matches();
    
    //2nd way
    boolean b2=Pattern.compile(".s").matcher("as").matches();
    
    //3rd way
    boolean b3 = Pattern.matches(".s", "as");
    
    System.out.println(b+" "+b2+" "+b3);
  }
}
```

-   [Más info en javaTpoint.com](https://www.javatpoint.com/java-regex)
-   [RegEx w3schools](https://www.w3schools.com/java/java_regex.asp)


## Ejercicios:
-   Busca la cadena "pe" dentro de:
    > PERRO (NO COINCIDE)
    > perro (COINCIDE)
    > pepe (COINCIDE)
    > lep (NO COINCIDE)
-   Letra mayúscula entre la A y la C
    > A (COINCIDE)
    > Z (NO COINCIDE)
    > casa (NO COINCIDE)
    > CASA (NO COINCIDE)
-   "Parsea" los siguientes datos de entrada: ip, puerto, tlf,
    usuario.

## Juegos
+ [Crucigramas](https://regexcrossword.com/)
+ [Pruebas contra reloj](http://play.inginf.units.it/#/)
+ [ScapeRoom](https://www.therobinlord.com/projects/slash-escape)