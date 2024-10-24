#curso24_25 #lmsgi [estado::Working]

_38 h => ~ 10 semanas_


# Herramientas de diseño web.
1. Bloc de notas (_Recomendado Notepad++_).
2. Navegador web (_Recomendado Firefox_).
   
Para aprender usaremos [codi.link](https://codi.link) o [codepen.io](https://codepen.io/pen/)

Para desarrollos mas complejos utilizaremos _vs code_ + plugin _live preview_.


# Introducción
Continuando con los lenguajes de marca para entornos web y, habiendo visto en la unidad anterior todo lo relativo al contenido y la semántica del mismo, en esta unidad trabajaremos el estilo del mismo con el lenguaje CSS3.


## Estilos in-line, in-file y externos
Para comenzar dando estilo a la web debemos conocer que aunque se nos permite realizarlo desde 3 enfoques distintos:
+ como atributo de cada una de las etiquetas HTML: `<div style="width: 30px;">`.
+ como hoja de estilo interna:
  ```css
  <style>
  body {
    background-color: ligthblue;
  }
  ```
+ como hojas de estilo externas, como ya lo hacíamos en la unidad anterior con la etiqueta `<link rel="stylesheet" type="text/css" href="https://luiscastelar.duckdns.org/2024/assets/lmsgi/default.css" media="screen" />`.

Esta última permite que un conjunto de páginas compartan una uniformidad y ejercer un _branding_ de marca sobre las mismas.

> [!NOTE]
> En el aula, siguiendo las buenas prácticas, sólo utilizaremos el de hojas externas.


## Cascada. Herencia de reglas
Al aplicar estilos a una etiqueta, éste no afecta únicamente a él, si no a todos los que tenga anidados.  P.e.: 
```HTML
<div style="font-weight: bold>
  Hola
  <p style="text-decoration: underline;">mundo</p>
</div>
```

Mientras que ambas palabras aparecen en negrita, sólo aparece subrayada la palabra mundo.

<details>
  <summary>Ver resultado</summary>
  <div style="font-weight: bold>
    Hola
    <p style="text-decoration: underline;">mundo</p>
  </div>
</details>


## Selectores
[Referencia w3schools](https://www.w3schools.com/cssref/css_selectors.php)

[**Juego de selectores**](https://flukeout.github.io/)


## Prioridad de reglas
> Cuando tenemos varias reglas CSS en cascada que afectan a un mismo elemento, el orden de prioridad que determina como se mostrará el elemento es el siguiente:
>
> 1. !important: un estilo marcado como importante prevalecerá sobre el resto de estilos. En caso de tener varios estilos marcados con !important, prevalecerá el de mayor peso según las reglas que estamos explicando.
> 2. Origen de las reglas: las reglas del autor de la web prevalecerán sobre las reglas del lector de similar peso. Y tanto las reglas de autor como de lector prevalecerán sobre las del navegador.
> 3. Peso de la regla: una regla con mayor peso prevalecerá sobre otra de menor peso.
>
    Peso = ABC (número de 3 cifras, cada una de las cuales se calcula contando los selectores de cada tipo según se indica a continuación)[^1]:
>    + A = nº de selectores de ID (selectores que acceden al atributo «id» del elemento mediante «#»)
>    + B = nº de selectores de CLASE (selectores que acceden al atributo «class» del elemento mediante «.»)
>    + C = nº de selectores de HTML (selectores que acceden al tag html)
>
>   Ejemplos ordenados de más a menos peso:
```css
#id1 .clase1 a (A=1, B=1, C=1 –> peso = 111)
div#id1 a (A=1, B=0, C=2 –> peso = 102)
.clase1 li.clase2 a (A=0, B=2, C=2 –> peso = 22)
.clase1 (A=0, B=1, C=0 –> peso = 10)
div a (A=0, B=0, C=2 –> peso = 2)
```
>  4. Orden de especificación: cuando dos reglas tienen el mismo peso prevalecerá la última regla especificada.
>
> NOTA:
> Y por último un detalle a tener en cuenta a la hora de diseñar correos HTML. Los gestores de correo como GMail suelen desactivar los estilos CSS para que no interfieran con sus propios estilos, con lo que solo se respetan los estilos definidos en línea en el código HTML mediante el atributo style, como por ejemplo: `<span style="color:#ff0000;">texto</span>`.
> 
> Fuente: [integrasistemas.es](https://www.integrasistemas.es/blog/general/prioridad-reglas-css/)

Con respecto a la fuente de la regla:
1. In-line
2. In-file
3. Hoja externa


### Normalización de estilos
`Normalize.css` es un pequeño archivo _css_ que proporciona una mejor consistecia _cross-browser_ definiendo los estilos iniciales de todos los navegadores de forma que elimina diferencias entre ellos.

Para añadirlo, deberemos invocarlo antes de nuestros estilos, de forma que los nuestros sobreescriban posteriormente los valores necesarios.

Deberéis descargar e incorporar el archivo `https://necolas.github.io/normalize.css/8.0.1/normalize.css` a vuestro arbol de trabajo.
```html
<!-- en el head del documento -->
<link type="text/css" rel="stylesheet" href="css/normalize.css" />
<!-- Add additional stylesheets next -->
```

# Textos
## Colores
### Tipos
+ Por nombre: `green`
+ Hexadecimal: `#22ff22` o `#2f2`
+ Rojo-verde-azul: `rgb(34 255 25)` o con transparencia 30% `rgba(34 255 25 / 0.3)`
+ `currentcolor`
+ Modelos de color:
  + `hsl(h s l)` y `hsla(h s l / a)`
  + `hwb(h w b)` y `hwb(h w b / a)`
 
_Nota: existe una notación obsoleta de rgb separado con comas `,`. La veréis en webs “legacy” pero no las utilizaremos en nuestros proyectos nuevos._

### Variables
Una función interesante de CSS3 es que permite definir variables de color que nos facilitan el diseño semántico del estilo de nuestra web. P.e.:
```css
:root {
  --fondo: var(--white);
  --colorTexto: var(--dark);
}

body {
  background-color: var(--fondo);
  color: var(--colorTexto);
}
```

Esta técnica nos permitirá alterar de forma sencilla los colores de fondo y texto en todos los objetos que lo tengan asignado.


## Alineación de texto
`text-aling: valor`, siendo posibles `start`, `end`, `center` y `justify`.

_Nota: aunque `left`, `right` son válidos, la norma recomienda evitar su uso, ya que pueden ser confusos en textos `Right to Lelf`._

Puedes ampliar en el manual de `manz.dev`.


## Tamaño de fuente
`font-size: 24px;` nos dará el tamaño a utilizar.

Unidades:
+ Absolutas: `24px` o `18pt`. Las primeras para pantallas, las segundas para medios impresos (folios).
+ Relativas:
  + Por nombre: `xx-small`, `x-small`, `small`, `medium`, `large`, `x-large`, `xx-large`, y también `smaller` y `larger`
  + Por porcentaje: `130%`
  + a una letra: `1.3rem` o `1.3em` (equivale a 130%)
 
A su vez, la propiedad `font-size` establecerá el tamaño base para las unidades `em`, `ex` y `cap`.

También afectará al tamaño `rem` (`em` del root).
  

## Intensidad de la fuente
`font-weight: bold` nos devolverá una **negrita**

Podemos poner valores numéricos entre 100 y 900, siendo 400 equivalente a `normal` y 700 a `bold`. El resto deben soportarlo la fuente elegida.


## Cursiva
`font-style: italic`, siendo posibles `italic`, `normal` y `oblique`.

La primera intenta tomar la tipografía italica de la fuente elegida, si no existe, simplemente curva la normal representando la obliqua.


## Línea horizontal
`text-decoration: underline`, subrayará el texto. 

Son posibles: `underline`, `line-through`, `overline`, `line-through double` y `underline overline`.


## Interlineado
`line-height: 1.3` separará un 30% respecto a la fuente. También podemos hacerlo absoluto en `px`


## Familia de fuentes
Normalmente cada equipo tiene una fuentes instaladas según los programas y necesidades del usuario, por lo que las fuentes se definen por familias a lo que podemos sugerir una lista que, de estar disponibles, serán utilizadas.

> Actualmente hay 5 de estas familias:
> + serif - fuentes con remates (antiguas). Un ejemplo destacado de estas fuentes es Times New Roman
> + sans-serif - fuentes sin remates (grotesco). Las fuentes más conocidas de este tipo son Arial y Verdana
> + cursive - fuentes cursivas
> + fantasy - fuentes decorativas. Esta familia se utiliza con menos frecuencia. El motivo es que las fuentes decorativas son demasiado diferentes para ser intercambiables
> + monospace - fuentes de ancho fijo. Estas son fuentes en las que todos los caracteres tienen el mismo ancho. Los programadores las utilizan con mucha frecuencia en editores de texto
>
> Fuente: [códica](https://basicos.codica.la/languages/css/lessons/font-family)


`font-family: Arial, Futura, sans-serif`, donde el navegador intentará renderizar el texto con la fuente `Arial`. De no existir en el sistema, intentará con `Futura`, y si no, con la definida por defecto del tipo `sans-serif`.

> [!NOTE]
> Las fuentes `serif` facilitan la lectura general en medios impresos y las `sans-serif` en pantallas.

> [!NOTE]
> Para personas con problemas con la lectura, las fuentes continuas les mejoraran la accesibilidad (como las fuentes escritas a mano).

> [!NOTE]
> Existe una fuente específica para facilitar la lectura a personas con [dixlesia](https://www.dafont.com/es/open-dyslexic.font).

> [!NOTE]
> Recomendaciones extra para personas con dixlesia:
> + Usar tamaños de fuente grandes (desde 18 a 24 puntos).
> + Usar tipografías `sans-serif`, tales como Arial, Helvética y Verdana.
> + Evitar la cursiva, pues disminuyen el rendimiento lector de las personas con dislexia.
> + Usar un ancho de columna reducido (unos 44 caracteres por columna).
> + Usar una separación entre caracteres superior a la media (entre + 7% – + 14%).


## Regla general para fuentes
Cuando queramos modificar varias características de las fuentes podemos utilizar el siguiente formato: `font: italic bold 24px Arial;`


## Reglas básicas de tipografía
Utilizar fuentes estándar mejora la compatibilidad en todos los dispositivos.

Aunque podemos cargar fuentes como cualquier otro elemento, es un proceso lento y no carente de fallos.

No utilices demasiadas fuentes ya que distraerás el foco. La regla general indica que 2 es lo ideal: títulos y contenido.

Un tamaño adecuado mínimo es de 14 px. Menor será problemático en móviles.

El interlineado extra de un 50% da una mejor visualización en pantallas.


# Bloques
[Modelo de cajas](http://juangualberto.github.io/lmsgi/tema02_html5/el_modelo_de_cajas.html)

## Marcos
## Fondo
## Márgenes internos y externos
## Altura y ancho del bloque
## Modelo de caja


# Flex
## Contenedor
## Dirección 
## Mover elementos
## Alineación
## Tamaño

# Varios
## Unidades
+ [Relativas a viewport](https://www.campusmvp.es/recursos/post/css-lvh-svh-y-dvh-las-unidades-de-medida-para-pantallas-moviles.aspx)
## Prefijos
## Medios
## Animaciones
## Variables
## Posicionamiento
## Validación
+ [Verifica tu css](https://jigsaw.w3.org/css-validator/)
+ [Calidad css](https://www.projectwallace.com/css-code-quality)

  
# Flexbox Layout
[Inicio](https://css-tricks.com/snippets/css/a-guide-to-flexbox/)


## Herramientas:
+ [flex box generator](https://www.cssportal.com/css-flexbox-generator/)


# Grid Layout
[Inicio](https://css-tricks.com/snippets/css/complete-guide-grid/) y [otro](https://gridbyexample.com/learn/)

[Playground](https://www.cssgridplayground.com/)


## Cursos:
+ [FreeCodeCamp](https://www.freecodecamp.org/learn/2022/responsive-web-design/)
+ [codica.la](https://basicos.codica.la/languages/css/)
+ [Curso CSS - pildorasinformaticas](https://www.youtube.com/playlist?list=PLU8oAlHdN5BmpUDdnWSglIIHfIosElaVN) 
+ [Curso con muchos ejercicios](https://uniwebsidad.com/libros/css)


# Juegos CSS
## Selectores
+ [Juego de selectores](https://flukeout.github.io/)


## Flexbox
+ [Flexbox Froggy](https://flexboxfroggy.com/#es)
+ [Flexbox Defense](http://www.flexboxdefense.com/)
+ [Flex Box Adventure](https://codingfantasy.com/games/flexboxadventure)


## Grid
+ [Garden](https://cssgridgarden.com/#es)
+ [Grid Attact](https://codingfantasy.com/games/css-grid-attack/play)

