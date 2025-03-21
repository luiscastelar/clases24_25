#curso24_25 #lmsgi [estado::Done] Duración: _24 h => ~ 6 semanas_

# Herramientas de diseño web.
1. Bloc de notas (_Recomendado Notepad++_).
2. Navegador web (_Recomendado Firefox_).
   
Para aprender usaremos [codi.link](https://codi.link) o [codepen.io]

Para desarrollos más allá, podremos utilizar _vs code_ + plugin _live preview_.


# Estándares web. Versiones. Clasificación.
> **HTML, CSS y JavaScript**: Una aplicación web, es una aplicación creada usando como base el lenguaje HTML. Por lo tanto, se trata de una aplicación que se ejecuta en un navegador de Internet.
>
> Las aplicaciones web utilizan lenguajes que apoyan la labor de HTML y que son traducibles por parte de los navegadores. Esencialmente las aplicaciones web actuales utilizan:
>
> + **HTML**. Para dar significado a los contenidos de la aplicación web. Permite indicar qué textos son títulos, cuáles son párrafos normales, cuáles son celdas de una tabla, cuáles son imágenes, etc.
> + **CSS**. Lenguaje que permite dar formato y maquetación a los contenidos. Color, tamaño de letra, posición, etc.
> + **JavaScript**. Permite diseñar la interactividad de la página. Permite que las acciones del usuario se puedan capturar y que la página reaccione a ellas. Ejemplos de sus posibilidades que cuando el usuario arrime el ratón a una imagen esta se ilumine, o que cuando el usuario haga clic en un título se muestre el contenido relacionado si estaba oculto o que el usuario pueda aumentar el tamaño de la letra de la página haciendo clic en un icono.
>Fuente: [Jorge Sánchez](https://jorgesanchez.net/manuales/html/introduccion-html.html)


## Versiones
+ HTML: ha evolucionado desde la 1.2 (sí, 1.2) hasta la actual versión 5 donde el salto fundamental con respecto a la 4 ha sido la separación de la presentación de los datos. Aunque soportado, no deben utilizarse las marcas de formato/presentación, ya que de ello nos encargaremos con CSS.
+ CSS:
  + v1: primera separación. Representación muy simple.
  + v2: mejora de las capacidades de representación. Definido a veces como una revolución visual.
  + v3: grandes avances visuales, pero se centra en separación de módulos. Destacaría el manejo vectorial y las propiedades flexbox (fluído) y grid (rejilla).
+ JS:
  + ES1 (1997): primera versión. Aporta dinamismo a la web.
  + ES3 (1999): Algunos avances relevantes como `try/catch`.
  + ES5 (2009): Modo estricto y JSON sobresalen y cambian paradigmas.
  + ES6: Desde 2015 hasta hoy, con pequeñas revisiones cada año para una evolución más rápida. Destacando:
    + ES2015 -> Clases y módulos que cambian la forma de programar permitiendo realizar proyectos grandes de forma organizada.
    + ES2017 -> Async/await que modifican el tratamiento de tareas asíncronas.
    + ES2024 -> ultima versión.


# Primeros pasos con HTML.

## El mundo de las etiquetas
![Estructura de una etiqueta HTML](https://lenguajehtml.com/html/introduccion/estructura-etiqueta-html/estructura-etiqueta-html.png)
Fuente: [Manz.dev](https://lenguajehtml.com/html/)

### Atributos comunes
[Atributos](https://lenguajehtml.com/html/introduccion/atributos-comunes-html/)

+ `id`: es un identificador único de elemento. Viene a sustituir `name` ya _deprecated_ (-> “deprecado” -> obsoleto).
+ `class`: es un identificador de grupo utilizado para asignar estilos a todos los elementos de un grupo. Todo _tag_ (etiqueta) puede tener o no uno o varias clases asignadas (separadas por espacios). P.e.: `<button class="boton azul">` pertenecerá a las clases “boton” y “azul”.
+ `style`: permite asignar estilos css sobre el mismo elemento. Nosotros no lo utilizaremos ya que vamos a establecer la separación absoluta de contenido-presentación-acción con html-css-js respectivamente.

## Estructura:
![estructura](https://lenguajehtml.com/html/documento/estructura-documento-html/estructura-documento-html.png)
Fuente: [Manz](https://lenguajehtml.com/html/)

### Hola mundo:
```html
<html>
  <head>
    <!-- esto es un comentario -->
    <title>Mi primera web</title>
  </head>
  <body>
    Hola mundo. 
    
    ¡Que gran emoción tengo! 
    
    Saludos desde España.
  </body>
</html>
```

Algunos caracteres se ven mal... 

Seleccionemos un juego de caracteres que soporte los caracteres españoles. Para eso sólo tenemos que añadir en el `head` la etiqueta `<meta charset="UTF-8">`.


# Depuración / Validación
Para comenzar a depurar abriremos las herramientas para desarrolladores <kbd>F12</kbd> o <kbd>⌃ Control</kbd> + <kbd>⇧ Shift</kbd> + <kbd>I</kbd>

Podemos ver el aviso `Quirks Mode`, donde el navegador indica que se encuentra en un modo retrocompatible con web antiguas.

Para solucionarlo sólo tenemos que añadir al comienzo la [declaración de tipo](https://es.wikipedia.org/wiki/Declaraci%C3%B3n_de_tipo_de_documento) `<!DOCTYPE html>`.


## Validación
[w3c - World Wide Web Consortium](https://validator.w3.org/)

Como podréis comprobar, la validación de nuestra sencilla web nos arroja un _warning_ respecto al idioma, que si bien no es damático, si deberemos solucionar simplemente añadiendo el idioma a la etiqueta `<html>`, quedando tal que así `<html lang="es">`.


# Estructura de un documento HTML.
Veíamos en el ejemplo las 2 partes fundamentales de un documento html: cabeceras y cuerpo.

Dentro del cuerpo, **html5** nos ofrece una estructuración semántica según las _etiquetas_ semánticas encabezado `<header>`, navegación `<nav>`, lateral `<aside>`, pie `<footer>` y principal `<main>`,y dentro de éste elementos como `<article>`, `<section>` y los clásicos `<div>` (_bloques_).

Ver [mdn](https://developer.mozilla.org/es/docs/Learn/HTML/Introduction_to_HTML/Document_and_website_structure).

## Ejercicio:
Modifica la página básica para añadir dichos elementos y dar forma a nuestra web.

## HTML5 vs ...
- [HTML vs XHTML](https://desarrolloweb.com/articulos/diferencias-html-xhtml.html) ->  [etiquetas en XHTML](https://uniwebsidad.com/libros/xhtml/capitulo-2/sintaxis-de-las-etiquetas-xhtml)
- [HTML5 vs anteriores](https://htmldesdecero.es/blog/html5-diferencias-html/)



# Un mínimo visual
Estamos en html5 por lo que no vamos a utilizar etiquetas visuales y por tanto para dar algo de _style_ a nuestra web vamos a introducir un pié en el CSS (UT3).

Añadiremos al `<head>` la hoja de estilo `default.css` que tenéis disponible en el repositorio... y ¡magia! 
`<link rel="stylesheet" type="text/css" href="https://luiscastelar.duckdns.org/2024/assets/lmsgi/default.css" media="screen" />`


# Enlaces
Ver en [uniwebsidad](https://uniwebsidad.com/libros/xhtml/capitulo-4)

1. tag `<a></a>`
2. atributo obligatorio `href="marca.com"`
3. otros atributos:
   + `target="_blank"`
   + `download="archivo.txt"`
4. Enlaces internos `href="#idDelElemento"` 

## Rutas:
| Tipo | Formato | Significado |
|---|---|---|
| implícita | “foto.jpg” | se encuentra en el directorio actual[^1] |
| relativa | “./foto.jpg” | relativa al directorio actual |
| relativa | “../foto.jpg” | relativa al padre del directorio actual |
| absoluta | “https://marca.com/foto.jpg” | desde internet |

Respecto a las absolutas desde internet, debemos saber [más cosas](https://es.semrush.com/blog/que-es-una-url/).



# Elementos del HTML
Manual de Referencia de etiquetas en [w3schools](https://www.w3schools.com/tags/default.asp).

> Los elementos del HTML están definidos en la norma HTML living standard, del WHATWG. Esta norma se puede consultar en la web en su [versión paginada](https://html.spec.whatwg.org/multipage/) o en su [versión de una sola página](https://html.spec.whatwg.org/).
>
> A cada elemento corresponde una etiqueta (también llamadas marcas), por lo que estos tres términos (elementos, etiqueta y marca) son intercambiables.
>
> En la norma, las diferentes etiquetas están agrupadas en las siguientes categorías:
>
>##   **Elemento raíz**
>    
>    El elemento raíz de una página web es el elemento `<html>`, que abarca todo el documento excepto la declaración de tipo de documento inicial.
>    
>    El elemento raíz contiene dos elementos: `<head>` (la parte no visible de la página) y `<body>` (la parte visible).
>    
>    El elemento raíz `<html>` se comenta en la lección [Raíz y metadatos](https://www.mclibre.org/consultar/htmlcss/html/html-metadatos.html#etiqueta-html).
>
>##   **Secciones**
>    
>    Las secciones son las partes temáticas en las que se puede dividir el contenido de una página web.
>    
>    La sección más importante es `<body>` que abarca todo el contenido de la página web que se visualiza en el navegador. Los otros tipos de secciones son `<body>`, `<article>`, `<section>`, `<nav>`, `<aside>`, `<h1>` ...`<h6>`, `<hgroup>`, `<header>`, `<footer>` y `<address>`.
>    
>    Las secciones se comentan en la lección [Secciones](https://www.mclibre.org/consultar/htmlcss/html/html-secciones.html).
>    
>##   **Bloques de contenido**
>    
>    Las etiquetas de bloque permiten definir bloques de contenido coherente, formado por texto e imágenes. Visualmente, cada bloque se suele mostrar separado del resto de bloques.
>    
>    El bloque de contenido más simple es el párrafo (etiqueta `<p>`), pero existen otros tipos como `<hr>`, `<pre>`, `<blockquote>`, `<figure>`, `<figcaption>`, `<div>` y `<main>`, además de los diferentes tipos de lista `<ol>`, `<ul>` y `<dl>` (y sus componentes `<li>`, `<dt>` y `<dd>`).
>    
>    Los bloques de contenido se comentan en las lecciones [Bloques de contenido](https://www.mclibre.org/consultar/htmlcss/html/html-bloques.html) y [Listas](https://www.mclibre.org/consultar/htmlcss/html/html-listas.html).
>    
>##   **Texto en línea**
>    
>    Las etiquetas de texto en línea son las más numerosas y se emplean para identificar fragmentos de texto que tienen un significado especial. Normalmente, los elementos de texto en línea se encuentran dentro de elementos de bloque, modificaciones o tablas.
>    
>    Las etiquetas de texto en línea más habituales son `<br>`, `<span>`, `<em>` y `<strong>`, así como la etiqueta de enlace `<a>`.
>    
>    Otras etiquetas que se utilizan menos son `<small>`, `<s>`, `<cite>`, `<q>`, `<dfn>`, `<abbr>`, `<time>`, `<kbd>`, `<sub>`, `<sup>`, `<i>`, `<b>` y `<mark>`.
>    
>    Las etiquetas de texto en línea utilizadas más raramente son `<data>`, `<code>`, `<var>`, `<samp>`, `<u>`, `<ruby>`, `<rb>`, `<rt>`, `<rtc>`, `<rp>`, `<bdi>`, `<bdo>` y `<wbr>`.
>    
>    Los elementos de texto en línea se comentan en las lecciones [Texto en línea](https://www.mclibre.org/consultar/htmlcss/html/html-texto.html) y [Otros](https://www.mclibre.org/consultar/htmlcss/html/html-otros.html).
>>    
>##   **Metadatos**
>    
>    Los metadatos son información de carácter general que no se muestra en la ventana del navegador. Las etiquetas de metadatos son: `<head>`, `<title>`, `<base>`, `<link>`, `<meta>` y `<style>`.
>    
>    Los metadatos se encuentran dentro de la sección `<head>`.
>    
>    Los metadatos se comentan en la lección [Raíz y metadatos](https://www.mclibre.org/consultar/htmlcss/html/html-metadatos.html).
>    
>##   **Modificaciones**
>    
>    Esta categoría incluye únicamente dos etiquetas, `<del>` y `<ins>`, pensadas para identificar las modificaciones que se han realizado en un texto.
>    
>    Las modificaciones se comentan en la lección [Modificaciones](https://www.mclibre.org/consultar/htmlcss/html/html-modificaciones.html).
>    
>##   **Contenido incrustado**
>    
>    Una página web es un documento de texto, pero puede contener elementos "incrustados" como imágenes, vídeo, audio, etc.
>    
>    La principal etiqueta es la etiqueta `<img>`, que permite incluir imágenes, pero existen etiquetas para otros tipos de formatos: `<picture>`, `<source>`, `<iframe>`, `<embed>`, `<object>`, `<param>`, `<video>`, `<audio>`, `<track>`, `<map>` y `<area>`.
>    
>    Los contenidos incrustados se comentan en las lecciones [Imágenes](https://www.mclibre.org/consultar/htmlcss/html/html-imagenes.html) ([formatos](https://www.mclibre.org/consultar/htmlcss/html/html-imagenes-formatos.html)) y [Objetos](https://www.mclibre.org/consultar/htmlcss/html/html-objetos.html).
>    
>##   **Tablas**
>    
>    Una página web puede mostrar información en formato de tabla, con filas y columnas.
>    
>    Las etiquetas que permiten definir las tablas son: `<table>`, `<td>`, `<th>` `<tr>` `<thead>`, `<tbody>` `<tfoot>`, `<caption>`, `<col>` y `<colspan>`.
>    
>    Las tablas se comentan en la lección [Tablas](https://www.mclibre.org/consultar/htmlcss/html/html-tablas.html).
>    
> _Fuente: [MCLibre - Bartolomé Sintes](https://www.mclibre.org/consultar/htmlcss/index.html)_

### Tablas con `DIV`s
Lo trabajaremos en la ut3 sobre CSS - [enlace](https://estradawebgroup.com/Post/Como-crear-una-tabla-utilizando-DIVs-y-CSS/4152)
    
>##   **Formularios**
>    
>    Una página web puede contener formularios, que permiten al usuario proporcionar información. Normalmente dicha información se envía a un servidor para ser procesada por un programa, aunque también puede ser procesada en el navegador mediante un programa escrito en el lenguaje JavaScript.
>    
>    Las etiquetas relacionadas con formularios son: `<form>`, `<fieldset>`, `<label>`, `<input>`, `<button>`, `<textarea>` y `<select>`.
>    
>    Los formularios se comentan en la lección [Formularios](https://www.mclibre.org/consultar/htmlcss/html/html-formularios.html) y [formularios 2](https://www.mclibre.org/consultar/htmlcss/html/html-formularios-2.html)
>    
>##   **Elementos interactivos**
>    
>    Los elementos HTML son normalmente elementos fijos y su posible interactividad se consigue mediante JavaScript, pero existen un par de elementos que permiten cierta interactividad (muy limitada) sin necesidad de JavaScript: `<details>`, `<summary>` y `<dialog>`.
>    
>    Los elementos interactivos se comentan en la lección [Interactivos](https://www.mclibre.org/consultar/htmlcss/html/html-interactivos.html).
>    
>##   **Scripts**
>    
>    Los navegadores son capaces de ejecutar programas escritos en el lenguaje de programación JavaScript. Estos programas se suelen denominar _scripts_. Varias etiquetas permiten integrar estos programas en una página web: `<script>`, `<noscript>`, `<template>`, `<slot>` y `<canvas>`.
>    
> _Fuente: [MCLibre - Bartolomé Sintes](https://www.mclibre.org/consultar/htmlcss/index.html)_

### Tag `script`
En la web actual se refiere a _scripts_ de _JavaScript_, pero existen (o existían) otros lenguajes de script como VBSript (variante de Visual Basic).

_Veremos en profundidad los scprit en la UT5_.


### Tag `<noscript>`
Dentro de los scripts podemos incluir el tag `<noscript>` para compatibilidad con navegadores antiguos o por accesibilidad como lectores de pantalla, navegadores textuales, etc.


#### Tag `<canvas>`
El tag `<canvas>` permite dibujar gráficos y animaciones mediante la [canvas scripting API](https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API) o el [WebGL API](https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API).


### Modelo de Objetos de Documento - DOM
![DOM](http://www.elvisualista.com/wp-content/uploads/2018/07/g-20.1-grafico-pagina-dom.png)
Es la representación lógica de la estructura del documento. Es fundamental para la manipulación por parte de _scripts_.


#### Shadow DOM
![Shadow DOM](https://media.dev.to/dynamic/image/width=1000,height=420,fit=cover,gravity=auto,format=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2F6k5jghjo3029yyypg73s.jpg)
El “DOM en la Sombra” es un DOM que puede ser asociado a un elemento del DOM principal, pero que no es mostrado (en la sombra) hasta que no se manipula con _JavaScript_.


#### Tags `<template>` y `<slot>`
El tag `<template>` es un mecanismo para mantener fragmentos HTML en el _shadow DOM_ preparados para fusionar con en el _DOM_. La fusión se realiza mediante JavaScript.

El elemento HTML `<slot>`, parte del conjunto de tecnologías de componentes web, es un marcador de posición dentro de un componente web que puede rellenar con su propio marcado, lo que le permite crear árboles DOM separados y presentarlos juntos.



## Escapado de caracteres
En ocasiones se puede dar que queramos utilizar caracteres que utilizamos como marcas de html, p.e. `<`, `>`, un espacio ` `. 
| Result | Description            | Name    | Number  |
|--------|------------------------|---------|---------|
|        | non-breaking space     | `&nbsp;`  | `&#160;`  |
| <      | less than              | `&lt;`    | `&#60;`   |
| >      | greater than           | `&gt;`    | `&#62;`   |
| &      | ampersand              | `&amp;`   | `&#38;`   |
| "      | double quotation mark  | `&quot;`  | `&#34;`   |
| '      | single quotation mark  | `&apos;`  | `&#39;`   |
| ¢      | cent                   | `&cent;`  | `&#162;`  |
| £      | pound                  | `&pound;` | `&#163;`  |
| ¥      | yen                    | `&yen;`   | `&#165;`  |
| €      | euro                   | `&euro;`  | `&#8364;` |
| ©      | copyright              | `&copy;`  | `&#169;`  |
| ®      | trademark              | `&reg;`   | `&#174;`  |

Fuente: [w3schools](https://www.w3schools.com/html/html_entities.asp)

Podremos utilizar el código o el nombre para la sustitución que el navegador sustituirá por su carácter correspondiente.

Antiguamente, antes de la codificación utf-8 requeríamos escapar los caracteres típicos españoles como “ñ“ `&ntilde;`, “á“ `&aacute` o las olvidadas comillas españolas “«“ `&laquo;` y “»“ `&raquo;`. [Tabla completa](https://www.thoughtco.com/html-codes-spanish-characters-4062194).


## Accesibilidad
Existen algunas cosas que podemos realizar para mejorar la accesibilidad de nuestra web para personas con deficiencias visuales. 

La más sencilla y rápida es añadir el atributo `alt` en imágenes  lo cual garantiza que se mostrará una descripción en aquellos navegadores que no muestren la imagen, facilitanto la accesibilidad. P.e. `<img src="imagen_que_no_se_muestra.png" alt="Esta imagen aclara el concepto de mejora de la accesibilidad en html" />`:
<div>
  <p>Texto ambiguo que requiere una imagen aclaratoria <br />
    <img src="imagen_que_no_se_muestra.png" alt="Esta imagen aclara el concepto de mejora de la accesibilidad en html" />
  </p>
</div>

Por otro lado, también tenemos la etiqueta `title` que podremos utilizar en imágenes y enlaces para describir su función. P.e. `<img src="https://www.w3.org/html/logo/badge/html5-badge-h-css3-semantics.png" title="Esta imagen aclara el concepto de mejora de la accesibilidad en html" />` mostrará la descripción al pasar por encima... pero si tenemos un navegador adaptado será lo que nos muestre:
<div>
  <p>Texto ambiguo que requiere una imagen aclaratoria <br />
    <img src="https://www.w3.org/html/logo/badge/html5-badge-h-css3-semantics.png" title="Esta imagen aclara el concepto de mejora de la accesibilidad en html" />
  </p>
  <p><a href="#primeros-pasos-con-html" title="Volver a Primeros pasos">Ir</>
</div>


## Otros
*   SVG: [SVG (1)](https://www.mclibre.org/consultar/htmlcss/html/html-svg.html) - [SVG (2)](https://www.mclibre.org/consultar/htmlcss/html/html-svg-2.html)  
    [Formas básicas](https://www.mclibre.org/consultar/htmlcss/html/svg-formas-1.html) - [Formas avanzadas](https://www.mclibre.org/consultar/htmlcss/html/svg-formas-2.html)  
    [Texto](https://www.mclibre.org/consultar/htmlcss/html/svg-texto.html)
*   [MathML](https://www.mclibre.org/consultar/htmlcss/html/html-mathml.html)


## Obsoletas
[Puedes consultar](https://lenguajehtml.com/html/documento/etiquetas-html-obsoletas/) las etiquetas que no debemos utilizar y el reemplazo a realizar si te las encuentras.


# Práctica: Haz tu web-currículo.
¿Que no sabes cómo? Pues esta es la vida del desarrollador... algunos tips:
1. Busca algunos estilos de web-currículo que pudieran interesarte para tener claro que te gustaría mostrar.
2. Seamos prácticos, ahora no estás buscando trabajo. Pero sí lo harás cuando acabes el ciclo por lo que debes indicar las `skill`s y `soft-skill`s que tendrás cuando hayas acabado. Marca en cada una el nivel de logro actual por lo que sólo deberás actualizar el cv cuando hayas finalizado el ciclo[^2].
3. A trabajar.


## Formulario
Debes añadirle un formulario (de contacto o de compra o lo que creas más oportuno) en el que deberás incluir la dirección destino `https://lmsgi.luiscastelar.duckdns.org/recibe_formulario.php` y el campo nif/nie siguiente `<p>NIF o NIE: <input type="text" name="nif" maxlength="8"/></p>`. 

El uso del formulario con el destino facilitado y el campo añadido asegurará que tu formulario es recibido, procesado, registrado y valorado.

> [!NOTE]
> Sólo será valorado el último envío que realices. Asegúrate que es el correcto leyendo que he recibido y la puntuación otorgada a cada apartado.

> [!IMPORTANT]
> Según la tabla aportada, estima que necesitarás **30 puntos** para que el formulario sea considerado **suficiente**. De ahí para arriba podrás añadir lo que quieras.


## Forma de entrega
1. Se realizará a través del repositorio de Github compartido con el profesor a principio de curso.
2. Se ubicará en la siguiente ruta: `{{REPO}}/lmsgi/ut2/practica`, donde {{REPO}} es tu repositorio de Github.
3. Deberá contener únicamente archivos html e imágenes asociadas.
4. Deberá enlazar a css proporcionado por CDN `<link rel="stylesheet" type="text/css" href="https://luiscastelar.duckdns.org/2024/assets/lmsgi/default.css" media="screen" />`
5. El formulario deberá remitir los datos a `https://lmsgi.luiscastelar.duckdns.org/recibe_formulario.php`
6. El punto de entrada al mismo será un archivo denominado `index.html`
   

## Evaluación y calificación:
+ La dimensión y profundidad de esta práctica es libre y competitiva repartiendo la probabilidad de contratarte para la redacción de mi web entre todos los alumnos de 0 a 3 puntos (de décima en décima).
+ Utilización rica de etiquetas y atributos: 5 puntos.
+ Contenido: 2 puntos.
+ Respeto del estándar HTML5: **restará** 1 punto por `warning` y 3 por `error`.



# Referencias:
+ [Curso muy completo](https://www.mclibre.org/consultar/htmlcss/index.html)
+ [Otro](https://uniwebsidad.com/libros/xhtml)
+ [W3School](https://www.w3schools.com/html/default.asp)
+ [Curso Itef](http://www.ite.educacion.es/formacion/materiales/182/cd/indice.htm)

---
# Notas al pie
[^1]: en realidad la dirección queda calculada respecto a la dirección base si es especificada mediante el tag `<base href="https://url.es/lo_que_sea">`.

[^2]: inserta un campo con una clase específica para el indicador, p.e. rojo, naranja, amarillo, verde, que luego “maquillaremos” con css en la ut3.