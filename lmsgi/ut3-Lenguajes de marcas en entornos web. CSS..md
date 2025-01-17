#curso24_25 #lmsgi [estado::Working]

_38 h => ~ 10 semanas_


# Herramientas de diseño web.
1. Bloc de notas (_Recomendado Notepad++_).
2. Navegador web (_Recomendado Firefox_).
   
Para aprender usaremos [codi.link](https://codi.link) o [codepen.io](https://codepen.io/pen/)

Para desarrollos mas complejos utilizaremos _vs code_ + plugin _live preview_.


# Introducción
Continuando con los lenguajes de marca para entornos web y, habiendo visto en la unidad anterior todo lo relativo al contenido y la semántica del mismo, en esta unidad trabajaremos el estilo del mismo con el lenguaje CSS3.

Esta unidad la trabajaremos con la metodología de clase invertida por lo que es el alumno el que deberá mirarse los contenidos antes de la clase y utilizaremos la misma para discutir y trabajar las actividades propuestas. 

Para ello, en el archivo `seguimiento` verás marcadas las actividades a realzar con el prefijo [FC] **previa** a los días señalados.

Deberás realizar las clases del curso de [CSS - Códica](https://basicos.codica.la/languages/css).


## Estilos in-line, in-file y externos
Para comenzar dando estilo a la web debemos conocer que aunque se nos permite realizarlo desde 3 enfoques distintos:
+ como atributo de cada una de las etiquetas HTML: `<div style="width: 30px;">`.
+ como hoja de estilo interna:
  ```css
  <style>
  body {
    background-color: ligthblue;
  }
  </style>
  ```
+ como hojas de estilo externas, como ya lo hacíamos en la unidad anterior con la etiqueta `<link rel="stylesheet" type="text/css" href="https://luiscastelar.duckdns.org/2024/assets/lmsgi/default.css" media="screen" />`.

Esta última permite que un conjunto de páginas compartan una uniformidad y ejercer un _branding_ de marca sobre las mismas.

> [!NOTE]
> En el aula, siguiendo las buenas prácticas, sólo utilizaremos el de hojas externas.


## Cascada. Herencia de reglas
Al aplicar estilos a una etiqueta, éste no afecta únicamente a él, si no a todos los que tenga anidados.  P.e.: 
```HTML
<div style="font-weight: bold;">
  Texto negrita.
  <div style="text-decoration: underline;">Texto subrayado que hereda la negrita.</div>
  <div style="font-weight: normal;">Texto que sobreescribe la propiedad.</div>
</div>
<div style="text-decoration: underline;">Texto que no hereda por estar fuera.</div>
```

Mientras que ambas palabras aparecen en negrita, sólo aparece subrayada la palabra mundo.

<details>
  <summary>Ver resultado</summary>
  
  ![herencia](https://luiscastelar.duckdns.org/2024/lmsgi/snippets/herencia.png)
</details>


## Selectores
[Referencia w3schools](https://www.w3schools.com/cssref/css_selectors.php)

[**Juego de selectores**](https://flukeout.github.io/) #juego #obligatorio

### Hermanos
Los selectores `~` y `+` son utilizados para marcar a hermanos, siendo `~` cualquier elemento que haya tenido antes un hermano, y `+` para los que tengan un hermano INMEDIATAMENTE delante.

Un [buen tutorial](https://www.gyata.ai/es/css/css-sibling-selector) para entender las diferencias.

<details>
  <summary>Y un par de ejemplos</summary>

```html

<div>
  <h1>Hermanos iguales</h1>
  <p class="tipo-2">uno</p>
  <p class="tipo-2">dos</p>
  <p class="tipo-2">tres</p>
  <p class="tipo-2">cuatro</p>
  <div class="nota">
    <p>".tipo-2 ~ .tipo-2" -> Clase tipo-2 que haya tenido un hermano delante de tipo-2 y dentro de un div. Como todos son tipo-2, todos seleccionados, por tanto 2, 3 y 4 cumplen este requisito => aplicamos color, peso y fondo (blue).</p>
    <p>".tipo-2 + .tipo-2" -> Clase tipo-2 que le anteceda una clase tipo-2 y dentro de un div. Como todos son tipo-2, todos seleccionados, por tanto, 2, 3 y 4 cumplen el requisito => <b>cambiamos</b> fondo (azul claro).</p></div>
</div>
<hr />
<div class="tipo-1">
  <h1>Hermanos diferentes</h1>
  <p class="tipo-2">uno</p>
  <p class="tipo-2">dos</p>
  <p class="tipo-3">tres</p>
  <p class="tipo-2">cuatro</p>
  <div class="nota">
    <p>".tipo-2 ~ .tipo-2" -> Clase tipo-2 que haya tenido un hermano delante de tipo-2 y dentro de un div. Como hay de 2 tipos, 2 y 4 cumplen este requisito => aplicamos color, peso y fondo (azul).</p>
  <p>".tipo-2 + .tipo-2" -> Clase tipo-2 que le anteceda (justo delante) un hermano de tipo-2 y dentro de un div. Como hay de 2 tipos, esta condición <u>sólo la cumple 2</u> => <b>cambiamos</b> fondo (azul claro).</p>  
  </div>
</div>
<hr />
<hr />
<div>
  <h1>Hermanos iguales B</h1>
  <p class="tipo-2b">uno</p>
  <p class="tipo-2b">dos</p>
  <p class="tipo-2b">tres</p>
  <p class="tipo-2b">cuatro</p>
  <div class="nota"><p>".tipo-2b + .tipo-2b" -> Clase tipo-2b que le anteceda una clase tipo-2 y dentro de un div. Como todos son tipo-2b, todos seleccionados, por tanto, 2, 3 y 4 cumplen el requisito => aplicamos fondo (azul claro).</p>
     <p >".tipo-2b ~ .tipo-2b" -> Clase tipo-2b que le anteceda (justo delante) un hermano de tipo-2b y dentro de un div. Como todos son tipo-2b, todos seleccionados, por tanto, 2, 3 y 4 cumplen el requisito => aplicamos color y peso, y <b>cambiamos</b> fondo (azul).</p> 
  </div>
</div>
<hr />
<div class="tipo-1">
  <h1>Hermanos diferentes B</h1>
  <p class="tipo-2b">uno</p>
  <p class="tipo-2b">dos</p>
  <p class="tipo-3">tres</p>
  <p class="tipo-2b">cuatro</p>
  <div class="nota"><p>".tipo-2b + .tipo-2b" -> Clase tipo-2b que haya tenido un hermano delante de tipo-2b y dentro de un div. Como hay de 2 tipos, esta condición <u>sólo la cumple el 2</u> => aplicamos fondo (azul claro).</p>
  <p >".tipo-2b ~ .tipo-2b" -> Clase tipo-2b que le anteceda (justo delante) un hermano de tipo-2 y dentro de un div. Como hay de 2 tipos, 2 y 4 cumplen este requisito => aplicamos color y peso, y <b>cambiamos</b> fondo (azul).</p>  
</div>
</div>
<hr />
<h1>Aplicaciones</h1>
<div>
  <table>
    <thead>
      <tr>
        <th>E1</th><th colspan="2">E2 y 3</th>
      </tr>
    </thead>
    <tbody>
      <tr><td>f1c1</td><td>f1c2</td><td>f1c3</td></tr>
      <tr><td>f2c1</td><td>f2c2</td><td>f2c3</td></tr>
      <tr><td>f3c1</td><td>f3c2</td><td>f3c3</td></tr>
      <tr><td>f4c1</td><td>f4c2</td><td>f4c3</td></tr>
    </tbody>
    <tfoot>
      <td>f1</td><td>f2</td><td>f3</td>
    </tfoot>
  </table>
</div>

```

```css
<style>
  .tipo-2 ~ .tipo-2 {
  background-color: blue;
  color: grey;
  font-weight: bold;
  padding-left: 1em;
}

.tipo-2 + .tipo-2 {
  background-color: lightblue;
}


.tipo-2b + .tipo-2b {
  background-color: lightblue;
}

.tipo-2b ~ .tipo-2b {
  background-color: blue;
  color: grey;
  font-weight: bold;
  padding-left: 1em;
}

.nota {
  font-style: italic;
}

/* Impares */
tr, tr + tr + tr {
  background-color: lightgray;
}

/* Pares */
tr + tr, tr + tr + tr + tr {
  background-color: white;
}


table {
  border: 1px solid black;
}
td {
  border: 1px dotted lightgray;
}
thead tr {
  background-color: blue;
  color: white;
}
tfoot, tfoot tr {
  background-color: red;
  font-weight: bold;
}
</style>

```

Y, ¿porqué no hacerlo con `nth-child(2n+1)` y `nth-child(2n)`?

</details>


<details> 
  <summary>
  
  ### Ejercicio OBLIGATORIO
  </summary>

#obligatorio

  + Crea un conjunto de divs y span con párrafos _lorem ipsum_[^1] con fondo de color diferente aplicando los estilos:
    + Rojo: `div + span`
    + Verde: `div span`
    + Azul: `div > span`
    + Morado: `div ~ span` que respete que `div + span` siga rojo.
    
          Archivos: `selectores.html` y `css/selectores.css`
    
          Ubicación: `ut3/ejercicios/`
    
          Debes crear un `index.html` que enlace al archivo especificado dentro de un `<ol>`

</details>


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

#### Capas en cascada 
![layers](https://css-tricks.com/wp-content/uploads/2024/06/layers-tall-outlines3.svg)

Fuente: [css-triks](https://css-tricks.com/css-cascade-layers/).


### Modelo de Objetos CSS -CSSOM-
De forma análoga al DOM tenemos el CSSOM ([ver ejemplo](https://abhisaha.com/blog/exploring-browser-rendering-process/#cssom-tree-creation)).


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

<details> 
  <summary>
  
  ### Ejercicio OBLIGATORIO
  </summary>

#obligatorio

  + Crea unos párrafos _lorem ipsum_ con fondo de color diferente, utilizando para ello un tipo distinto de modelo de selección de color.

        Archivos: `color-sin-variables.html` y `css/color-sin-variables.css`
  
        Ubicación: `ut3/ejercicios/`
  
        Debes modificar el `index.html` para que enlace al archivo especificado.

  + Repite el ejercicio mediante variables.
    
        Archivos: `color-con-variables.html` y `css/color-con-variables.css`
  
        Ubicación: `ut3/ejercicios/`
  
        Debes modificar el `index.html` para que enlace al archivo especificado.

  
</details>

## Alineación de texto
`text-aling: valor`, siendo posibles `start`, `end`, `center` y `justify`.

_Nota: aunque `left`, `right` son válidos, la norma recomienda evitar su uso, ya que pueden ser confusos en textos `Right to Lelf`._

Puedes ampliar en el manual de `manz.dev`.


## Fuentes
### Tamaño de fuente
`font-size: 24px;` nos dará el tamaño a utilizar.

Unidades:
+ Absolutas: `24px` o `18pt`. Las primeras para pantallas, las segundas para medios impresos (folios).
+ Relativas:
  + Por nombre: `xx-small`, `x-small`, `small`, `medium`, `large`, `x-large`, `xx-large`, y también `smaller` y `larger`
  + Por porcentaje: `130%`
  + a una letra: `1.3rem` o `1.3em` (equivale a 130%)
 
A su vez, la propiedad `font-size` establecerá el tamaño base para las unidades `em`, `ex` y `cap`.

También afectará al tamaño `rem` (`em` del root).
  

### Intensidad de la fuente
`font-weight: bold` nos devolverá una **negrita**

Podemos poner valores numéricos entre 100 y 900, siendo 400 equivalente a `normal` y 700 a `bold`. El resto deben soportarlo la fuente elegida.


### Cursiva
`font-style: italic`, siendo posibles `italic`, `normal` y `oblique`.

La primera intenta tomar la tipografía italica de la fuente elegida, si no existe, simplemente curva la normal representando la obliqua.


### Interlineado
`line-height: 1.3` separará un 30% respecto a la fuente. También podemos hacerlo absoluto en `px`


### Familia de fuentes
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


### Regla general para fuentes
Cuando queramos modificar varias características de las fuentes podemos utilizar el siguiente formato: `font: italic bold 24px Arial;`


### Reglas básicas de tipografía
Utilizar fuentes estándar mejora la compatibilidad en todos los dispositivos.

Aunque podemos cargar fuentes como cualquier otro elemento, es un proceso lento y no carente de fallos.

No utilices demasiadas fuentes ya que distraerás el foco. La regla general indica que 2 es lo ideal: títulos y contenido.

Un tamaño adecuado mínimo es de 14 px. Menor será problemático en móviles.

El interlineado extra de un 50% da una mejor visualización en pantallas.

<details> 
  <summary>
  
  ### Ejercicio OBLIGATORIO
  </summary>

#obligatorio
+ Deberás crear una página que contenga varios _lorem ipsum_ en un `dl` con `dt` de la etiqueta utilizada y el `dd` de texto de ejemplo del resultado.

      Archivos: `textos.html` y `css/textos.css`

      Ubicación: `ut3/ejercicios/`

      Debes modificar el `index.html` para que enlace al archivo especificado.

 </details>

## Decoración
`text-decoration: underline`, subrayará el texto. 

Son posibles: `underline`, `line-through`, `overline`, `line-through double` y `underline overline`.


## Pseudoclases
Son clases con un significado especial:
+ `:link` -> contiene un enlace `<a>`.
+ `:visited` -> cuando ese enlace ya ha sido visitado.
+ `:hover` -> cuando pasamos por encima con el ratón.
+ `:active` -> al hacer _click_ en él.

Al igual que las variables, las _pseudoclases_ no son exclusivas de las fuentes, pudiendo ver la amplitud de las mismas [aquí](https://lenguajecss.com/css/pseudoclases/que-son/) y en la referencia [mdn web docs](https://developer.mozilla.org/en-US/docs/Web/CSS/Pseudo-classes). 

Algunos ya vistos en el juego de selectores: `:nth-child`, `:fist-child`, `:last-child` y `nth-of-type`.


<details> 
  <summary>
  
  ## Ejercicios OBLIGATORIOS
  </summary>
  
  #obligatorio
  
### Combina Selectores y Pseudo-clases
*   Crea una lista de elementos (usando `<ul>` o `<ol>`).
*   Usa `nth-child()` para aplicar diferentes estilos a los elementos pares e impares.
*   Combina esto con `:hover` para añadir un cambio visual al pasar el ratón.
*   Repite con el `nth-of-type()`.

        Archivos: `pseudoclases.html` y `css/pseudoclases.css`

        Ubicación: `ut3/ejercicios/`
    
        Debes modificar el `index.html` para que enlace al archivo especificado.

### Diseño de Tarjetas
Crea un diseño de tarjetas (cajas) utilizando:

*   Una fuente principal y una secundaria.
*   Define el tamaño y peso de los encabezados y párrafos siguiendo las reglas básicas de tipografía.
*   Aplica pseudo-clases `:hover` y `:active` para que las tarjetas cambien de color al interactuar.

        Archivos: `tarjetas.html` y `css/tarjetas.css`

        Ubicación: `ut3/ejercicios/`
    
        Debes modificar el `index.html` para que enlace al archivo especificado.

</details>


# Bloques
## Modelo de caja
![modelo de cajas clásico](http://juangualberto.github.io/lmsgi/tema02_html5/cajas.jpg)
Partiremos del [modelo de cajas clásico](https://lenguajecss.com/css/modelo-de-cajas/que-es/).

## Marcos
## Fondo
## Márgenes internos y externos
## Altura y ancho del bloque

<details> 
  <summary>
  
  ## Ejercicio OBLIGATORIO
  </summary>

#obligatorio
- Reproduce la imagen del modelo de cajas sólo con html y css.

        Archivos: `cajas.html` y `css/cajas.css`

        Ubicación: `ut3/ejercicios/`
        
        Debes modificar el `index.html` para que enlace al archivo especificado.

- Repite con variables.

        Archivos: `cajas-con-variables.html` y `css/cajas-con-variables.css`

        Ubicación: `ut3/ejercicios/`
        
        Debes modificar el `index.html` para que enlace al archivo especificado.

</details>


## Desbordamientos - Overflow
[Overflow](https://lenguajecss.com/css/modelo-de-cajas/overflow/)

<details> 
  <summary>
  
  ### Ejercicio OBLIGATORIO
  
  </summary>

#obligatorio
*   Diseña una caja con dimensiones fijas (400px por 300px) y un texto largo dentro (*lorem ipsum*).
*   Aplica las propiedades `overflow: hidden`, `scroll`, y `auto` para observar las diferencias.
*   Experimenta con `overflow-x` y `overflow-y`.
*   Muestra un poco de cada en una página única.

        Archivos: `overflow.html` y `css/overflow.css`

        Ubicación: `ut3/ejercicios/`
        
        Debes modificar el `index.html` para que enlace al archivo especificado.

</details>


## Box-sizing
[Eso](https://lenguajecss.com/css/modelo-de-cajas/box-sizing/)

<details> 
  <summary>
  
  ### Ejercicio OBLIGATORIO
  
  </summary>

#obligatorio

*   Crea dos cajas de 200px de ancho y 200px de alto.
*   Una debe usar `box-sizing: content-box` y otra `box-sizing: border-box`.
*   Aplica un borde de 10px y un padding de 20px a ambas. Observa cómo cambia el tamaño total de las cajas.

        Archivos: `box-sizing.html` y `css/box-sizing.css`

        Ubicación: `ut3/ejercicios/`
        
        Debes modificar el `index.html` para que enlace al archivo especificado.

</details>

## Propiedades lógicas
Un enfoque más moderno, flexible y global es utilizar propiedades lógicas frente a las físicas que serán siempre válidas en cualquier idioma del mundo en cualquier dirección.

[Ver información](https://lenguajecss.com/css/modelo-de-cajas/propiedades-logicas-css/#propiedades-de-dimensi%C3%B3n)


# Emmet
Emmet es un plugin diseñado para editores de texto que ayuda en gran manera tu flujo de trabajo y te ahorra tiempo.

+ [Introducción a emmet](https://javascriptes.com/publicaciones/tutorial-de-emmet-que-es-emmet-y-como-utilizarlo-en-html-y-css-xSOQpmqAj5E1pXT2KJuXP)
+ [Cheat Sheet](https://docs.emmet.io/cheatsheet-a5.pdf)


# Flex
[Introducción por ManzDev](https://www.youtube.com/watch?v=esjagdcozX0)

[Guía a seguir](https://css-tricks.com/snippets/css/a-guide-to-flexbox/)

## Herramientas:
+ [flex box generator](https://www.cssportal.com/css-flexbox-generator/)

## Juegos
+ [Flexbox Froggy](https://flexboxfroggy.com/#es) #juego
+ [Flexbox Defense](http://www.flexboxdefense.com/) #juego
+ [Flex Box Adventure](https://codingfantasy.com/games/flexboxadventure) #juego


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

  

# Grid Layout
[Introducción por ManzDev](https://www.youtube.com/watch?v=Q1CXWBtxKZU)

[Inicio](https://css-tricks.com/snippets/css/complete-guide-grid/) y [otro](https://gridbyexample.com/learn/)

[Playground](https://www.cssgridplayground.com/)


## Herramienta
[Grid generator](https://grid.layoutit.com/)


## Juegos
+ [Garden](https://cssgridgarden.com/#es) #juego
+ [Grid Attact](https://codingfantasy.com/games/css-grid-attack/play) #juego



## Cursos:
+ [FreeCodeCamp](https://www.freecodecamp.org/learn/2022/responsive-web-design/)
+ [codica.la](https://basicos.codica.la/languages/css/)
+ [Curso CSS - pildorasinformaticas](https://www.youtube.com/playlist?list=PLU8oAlHdN5BmpUDdnWSglIIHfIosElaVN) 
+ [Curso con muchos ejercicios](https://uniwebsidad.com/libros/css)

# Otras reglas
## Capas `@layer`
Nos permite redefinir y ordenar la aplicación de las reglas:
```css
/* Orden de aplicación:
   1. reset
   2. base
   3. tema
   Si no se define el orden, entonces se aplica de arriba a abajo.
*/
@layer reset, base, tema;

@layer base {
  body { background: pink; }
}

@layer tema {
  body { background: lightblue; }
}

@layer reset {
  body { background: white; }
}
```

¿Qué ocurre si añadimos `@layer { body { background: red; } }` al final del documento? ¿Y en medio? ¿Y después de la línea 1? ¿Y antes?

## 
## `@import`

> [!IMPORTANT]
> Los `@import` deben aparecer al principio del documento, si no, serán ignorados.

```css
@import 'custom.css';
@import "common.css" screen;
@import url("fineprint.css") print;
@import url('landscape.css') screen and (orientation:landscape);
```

Y combinado con `@layer`:
```css
@import "theme.css" layer(utilities);
@import "otro.css" layer(); /* capa anónima */
```

Fuente: [mdn](https://developer.mozilla.org/es/docs/Web/CSS/@import)

# PRÁCTICAS

## CSS + FLEX
Entrega 12 de enero de la práctica del CV maquetado en CSS con el módulo FLEX.

La práctica debe incluir:
+ Presentación
+ Secciones:
  + Front-end
  + Back-end
  + Sistemas
  + Soft-skills
  + Contacto (formulario)
+ Extras

_Cada parte aportará 1.5 puntos, excepto “Extras” que aportará 1 punto._


## CSS + GRID
Entrega 2 de febrero de la práctica del CV maquetado en CSS con el módulo GRID.

_Podéis y debéis anidar FLEX y GRID._

---
# Notas al pie:
[^1]: _lorem ipsum_ es el texto que se usa habitualmente en diseño gráfico en demostraciones de tipografías o de borradores de diseño para probar el diseño visual antes de insertar el texto final. Podemos utilizar el [generador](https://getlorem.com/es) cuando lo necesitmos.