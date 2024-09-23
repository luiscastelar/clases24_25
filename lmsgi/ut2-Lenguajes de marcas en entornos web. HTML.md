#curso24_25 #lmsgi [estado::Done] Duración: _24 h => ~ 6 semanas_

# Herramientas de diseño web.
1. Bloc de notas (_Recomendado Notepad++_).
2. Navegador web (_Recomendado Firefox_).
   
Para aprender usaremos [codi.link](https://codi.link).

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
Fuente: [Manz.dev](https://lenguajehtml.com/html/introduccion/estructura-etiqueta-html/)

### Atributos comunes
[atributos](https://lenguajehtml.com/html/introduccion/atributos-comunes-html/)

## Hola mundo:
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
Para comenzar a depurar abriremos las herramientas para desarrolladores `F12`

Podemos ver el aviso `Quirks Mode`, donde el navegador indica que se encuentra en un modo retrocompatible con web antiguas.

Para solucionarlo sólo tenemos que añadir al comienzo la [declaración de tipo](https://es.wikipedia.org/wiki/Declaraci%C3%B3n_de_tipo_de_documento) `<!DOCTYPE html>`.


## Validación
[w3c - World Wide Web Consortium](https://validator.w3.org/)


# Estructura de un documento HTML.
Veíamos en el ejemplo las 2 partes fundamentales de un documento html: cabeceras y cuerpo.

Dentro del cuerpo, **html5** nos ofrece una estructuración semántica según las _etiquetas_ semánticas encabezado `<header>`, navegación `<nav>`, lateral `<aside>`, pie `<footer>` y principal `<main>`,y dentro de éste elementos como `<article>`, `<section>` y los clásicos `<div>` (_bloques_).

Ver [mdn](https://developer.mozilla.org/es/docs/Learn/HTML/Introduction_to_HTML/Document_and_website_structure).

## Ejercicio:
Modifica la página básica para añadir dichos elementos y dar forma a nuestra web.

## HTML5 vs ...
- [HTML vs XHTML](https://desarrolloweb.com/articulos/diferencias-html-xhtml.html)
- [HTML5 vs anteriores](https://htmldesdecero.es/blog/html5-diferencias-html/)


# Identificación de etiquetas y atributos de HTML.
Ver [uniwebsidad](https://uniwebsidad.com/libros/xhtml/capitulo-2/etiquetas-y-atributos)

Referencia de etiquetas en [w3schools](https://www.w3schools.com/html/).


# Enlaces
Ver en [uniwebsidad](https://uniwebsidad.com/libros/xhtml/capitulo-4)


# Un mínimo visual
Estamos en html5 por lo que no vamos a utilizar etiquetas visuales y por tanto para dar algo de _style_ a nuestra web vamos a introducir un pié en el CSS (UT3).

Añadiremos al `<head>` la hoja de estilo `default.css` que tenéis disponible en el repositorio... y ¡magia! 
`<link rel="stylesheet" type="text/css" href="./css/default.css" media="screen" />`


# Elementos del HTML
_Fuente: [MCLibre - Bartolomé Sintes](https://www.mclibre.org/consultar/htmlcss/index.html)_

Los elementos del HTML están definidos en la norma HTML living standard, del WHATWG. Esta norma se puede consultar en la web en su [versión paginada](https://html.spec.whatwg.org/multipage/) o en su [versión de una sola página](https://html.spec.whatwg.org/).

A cada elemento corresponde una etiqueta (también llamadas marcas), por lo que estos tres términos (elementos, etiqueta y marca) son intercambiables.

En la norma, las diferentes etiquetas están agrupadas en las siguientes categorías:

+   **Elemento raíz**
    
    El elemento raíz de una página web es el elemento <html>, que abarca todo el documento excepto la declaración de tipo de documento inicial.
    
    El elemento raíz contiene dos elementos: <head> (la parte no visible de la página) y <body> (la parte visible).
    
    El elemento raíz <html> se comenta en la lección [Raíz y metadatos](https://www.mclibre.org/consultar/htmlcss/html/html-metadatos.html#etiqueta-html).
    
+   **Metadatos**
    
    Los metadatos son información de carácter general que no se muestra en la ventana del navegador. Las etiquetas de metadatos son: <head>, <title>, <base>, <link>, <meta> y <style>.
    
    Los metadatos se encuentran dentro de la sección <head>.
    
    Los metadatos se comentan en la lección [Raíz y metadatos](https://www.mclibre.org/consultar/htmlcss/html/html-metadatos.html).
    
+   **Secciones**
    
    Las secciones son las partes temáticas en las que se puede dividir el contenido de una página web.
    
    La sección más importante es <body> que abarca todo el contenido de la página web que se visualiza en el navegador. Los otros tipos de secciones son <body>, <article>, <section>, <nav>, <aside>, <h1> ...<h6>, <hgroup>, <header>, <footer> y <address>.
    
    Las secciones se comentan en la lección [Secciones](https://www.mclibre.org/consultar/htmlcss/html/html-secciones.html).
    
+   **Bloques de contenido**
    
    Las etiquetas de bloque permiten definir bloques de contenido coherente, formado por texto e imágenes. Visualmente, cada bloque se suele mostrar separado del resto de bloques.
    
    El bloque de contenido más simple es el párrafo (etiqueta <p>), pero existen otros tipos como <hr>, <pre>, <blockquote>, <figure>, <figcaption>, <div> y <main>, además de los diferentes tipos de lista <ol>, <ul> y <dl> (y sus componentes <li>, <dt> y <dd>).
    
    Los bloques de contenido se comentan en las lecciones [Bloques de contenido](https://www.mclibre.org/consultar/htmlcss/html/html-bloques.html) y [Listas](https://www.mclibre.org/consultar/htmlcss/html/html-listas.html).
    
+   **Texto en línea**
    
    Las etiquetas de texto en línea son las más numerosas y se emplean para identificar fragmentos de texto que tienen un significado especial. Normalmente, los elementos de texto en línea se encuentran dentro de elementos de bloque, modificaciones o tablas.
    
    Las etiquetas de texto en línea más habituales son <br>, <span>, <em> y <strong>, así como la etiqueta de enlace <a>.
    
    Otras etiquetas que se utilizan menos son <small>, <s>, <cite>, <q>, <dfn>, <abbr>, <time>, <kbd>, <sub>, <sup>, <i>, <b> y <mark>.
    
    Las etiquetas de texto en línea utilizadas más raramente son <data>, <code>, <var>, <samp>, <u>, <ruby>, <rb>, <rt>, <rtc>, <rp>, <bdi>, <bdo> y <wbr>.
    
    Los elementos de texto en línea se comentan en las lecciones [Texto en línea](https://www.mclibre.org/consultar/htmlcss/html/html-texto.html) y [Otros](https://www.mclibre.org/consultar/htmlcss/html/html-otros.html).
    
+   **Modificaciones**
    
    Esta categoría incluye únicamente dos etiquetas, <del> y <ins>, pensadas para identificar las modificaciones que se han realizado en un texto.
    
    Las modificaciones se comentan en la lección [Modificaciones](https://www.mclibre.org/consultar/htmlcss/html/html-modificaciones.html).
    
+   **Contenido incrustado**
    
    Una página web es un documento de texto, pero puede contener elementos "incrustados" como imágenes, vídeo, audio, etc.
    
    La principal etiqueta es la etiqueta <img>, que permite incluir imágenes, pero existen etiquetas para otros tipos de formatos: <picture>, <source>, <iframe>, <embed>, <object>, <param>, <video>, <audio>, <track>, <map> y <area>.
    
    Los contenidos incrustados se comentan en las lecciones [Imágenes](https://www.mclibre.org/consultar/htmlcss/html/html-imagenes.html) ([formatos](https://www.mclibre.org/consultar/htmlcss/html/html-imagenes-formatos.html)) y [Objetos](https://www.mclibre.org/consultar/htmlcss/html/html-objetos.html).
    
+   **Tablas**
    
    Una página web puede mostrar información en formato de tabla, con filas y columnas.
    
    Las etiquetas que permiten definir las tablas son: <table>, <td>, <th> <tr> <thead>, <tbody> <tfoot>, <caption>, <col> y <colspan>.
    
    Las tablas se comentan en la lección [Tablas](https://www.mclibre.org/consultar/htmlcss/html/html-tablas.html).
    
+   **Formularios**
    
    Una página web puede contener formularios, que permiten al usuario proporcionar información. Normalmente dicha información se envía a un servidor para ser procesada por un programa, aunque también puede ser procesada en el navegador mediante un programa escrito en el lenguaje JavaScript.
    
    Las etiquetas relacionadas con formularios son: <form>, <fieldset>, <label>, <input>, <button>, <textarea> y <select>.
    
    Los formularios se comentan en la lección [Formularios](https://www.mclibre.org/consultar/htmlcss/html/html-formularios.html) y [formularios 2](https://www.mclibre.org/consultar/htmlcss/html/html-formularios-2.html)
    
+   **Elementos interactivos**
    
    Los elementos HTML son normalmente elementos fijos y su posible interactividad se consigue mediante JavaScript, pero existen un par de elementos que permiten cierta interactividad (muy limitada) sin necesidad de JavaScript: <details>, <summary> y <dialog>.
    
    Los elementos interactivos se comentan en la lección [Interactivos](https://www.mclibre.org/consultar/htmlcss/html/html-interactivos.html).
    
+   **Scripts**
    
    Los navegadores son capaces de ejecutar programas escritos en el lenguaje de programación JavaScript. Estos programas se suelen denominar _scripts_. Varias etiquetas permiten integrar estos programas en una página web: <script>, <noscript>, <template>, <slot> y <canvas>.
    
    _Veremos en profundidad los scprit en la UT5_.

## Otros
*   SVG: [SVG (1)](https://www.mclibre.org/consultar/htmlcss/html/html-svg.html) - [SVG (2)](https://www.mclibre.org/consultar/htmlcss/html/html-svg-2.html)  
    [Formas básicas](https://www.mclibre.org/consultar/htmlcss/html/svg-formas-1.html) - [Formas avanzadas](https://www.mclibre.org/consultar/htmlcss/html/svg-formas-2.html)  
    [Texto](https://www.mclibre.org/consultar/htmlcss/html/svg-texto.html)
*   [MathML](https://www.mclibre.org/consultar/htmlcss/html/html-mathml.html)


# Referencias:
+ [Curso muy completo](https://www.mclibre.org/consultar/htmlcss/index.html)
+ [Otro](https://uniwebsidad.com/libros/xhtml)
+ [W3School](https://www.w3schools.com/html/default.asp)
+ [Curso Itef](http://www.ite.educacion.es/formacion/materiales/182/cd/indice.htm)