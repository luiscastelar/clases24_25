#curso24_25 #lmsgi [estado::Working]

_28 h => ~7 semanas_


Curso temporal [edX](https://www.edx.org/learn/javascript/the-world-wide-web-consortium-w3c-javascript-introduction?index=product&queryId=95f33655bdfc0f00c7f2f6e02018233b&position=1) gratuito (hasta el 10 de abril)

# Mapa de unidad
![mapa](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*XsoPuMKmvHFIPiPzcPhPGQ.png)
# Introducción 
## Lenguajes de script de cliente. Características Estándares.

Hoy (2025) el estándar **ECMAScript** y su implementación en el lenguaje **JavaScript** dominan los scripts de lado de cliente. Eso no fue así siempre hubo otros pero ya no están.

Por su parte JavaScript, en adelante **JS**, además de ser de lado de cliente, también podemos implementarlo en el lado del servidor y para realizar aplicaciones de escritorio en Gnome.

## Características 
Es un lenguaje...
+ interpretado: no requiere compilarlo, pero recomendamos utilizar _linter_ que verifique su validez.
+ con tipado dinámico: las variables son del tipo del dato que contienen, pero pueden cambiar libremente.
+ tipado débil: variables de distinto tipo pueden interoperar sin cambios explícitos. Ésto requiere un conocimiento exhaustivo de las opciones.
+ imperativo.
+ funcional: donde las funciones son "ciudadanos de primera clase", esto es, podemos asignar funciones a variables, pasar funciones a funciones y retornar funciones de funciones.
+ orientado a objetos: basada en prototipos, aunque podemos crear definición de clases y objetos a partir de ellas.
+ mono-hilo en el lado del cliente y multi-hilo del lado del servidor.
+ Con APIs diferentes para el cliente (navegador web) y servidor (Node.js, Bun, ...).

## Sintaxis básica.
**Recorrido**:
1. Variables y constantes
2. Consola
3. Funciones
4. Tipos de datos
   + Primitivos (por valor)
   + Objetos y arrays (por referencia)
5. Programación estructurada
6. Arrays
   + Creación
   + Desestructuración
   + Loops: `forEach()`, `.map()` y `.filter()`
7. Concurrencia


## Variables y constantes 

#### Plantillas de texto (String Templates)
``let plantilla = `Texto con variables y ${valores}`; ``

## Consola
`console.log()`, `.info()`, `.warn()`, `.trace()` y `.error()`

## Funciones

## Tipos de datos

## Programación estructurada 

## Arrays
### Creación 
`let vector = Arrays.from(...);` cuando viene de otro tipo de elemento, por ejemplo un `HTMLCollection`, objetos habituales al consultar por nodos del `DOM`.

También podemos crear arrays con `let vector = [3, 4, 5];` o por desectructuración `let salida = [1, 2, ...vector];`

La desectructuración consiste en fragmentar un array en partes `let a, b, resto; [a, b, ...resto] = salida;`

### Loops
Tenemos que comenzar por introducir el concepto de función `callback`, que consiste en la función `callback` que le pasamos a otra función _A_ para que, la función _A_ realice con los datos de que disponga lo que indica la función `callback`. 

_No te precupes. Es algo confuso, pero se ve más claro en los ejemplos siguentes._

+ `.forEach()` consume un array: `vector.forEach( callback );`  
+ `.map()` modifica un array: `vector.map( callback );`
+ `.filter()` filtramos los elementos deseados del array: `vector.filter( callback );`
+ `.reduce()` pasa un array a un escalar siguiendo la función suministrada: `vector.reduce( callback [, inicial] );` (el valor inicial es opcional).
+ `.reduceRight()` igual, pero de derecha a izquierda
+ `.every()` verifica si TODOS los elementos cumplen una condición (boolean)
+ `.some()` verifica si existe un elemento que verifica la condición

Donde las funciones `callback` podrían ser respectivamente:
```js
const print = e => console.log(e);
const doble = e => 2*e;
const pares = e => (e%2)==0;
const suma = (acumulado, e) => { return acumulado + e; };
```

## Concurrencia:
Para la ejecución asíncrona de código tenemos la evolución:
1. `callback`s
2. Promesas
3. `await`/`async`

### `callback`s
Es la forma original de realizar la concurrencia. Un ejemplo clásico es:
```js
const myTimeout = setTimeout(myGreeting, 5_000);

function myGreeting() {
  alert("Happy Birthday!");
}
```

La función `myGreeting()` actúa de `callback` de la función `setTimeout(callback, time)`, esto es, `myGreeting()` será ejecutada cuando hayan pasado 5_000 ms.

Esa función `callback` a menudo se pasaba como una función anónima `const myTimeout = setTimeout(function(){alert("Happy Birthday!");}, 1_000);` si nadie más la va a necesitar, y en la actualidad _casi_ siempre como una función _lambda_ `const myTimeout = setTimeout(()=>{alert("Happy Birthday!");}, 1_000);`


### Promesas
Una forma más legible de hacer ejecutar código asíncrono es mediante las funciones que devuelven promesas.
lo anterior:
```js
const getUrl = (url) => {
  fetch(url)
    .then(response => response.json())
    .then(data => console.log(data))
    .catch( error => console.log("Hubo un problema con la petición Fetch:", error.message));  
}; 

getUrl('ejemplo.com');
```

_Nota: `fetch` devuelve un promesa y ésta es consumida con los métodos `.then()` y `.catch()`_

### `await` / `async`
No es más que azúcar sintáctico, por lo que lo dejaremos para el módulo de _Desarrollo Web en Entorno Cliente_.

## Código Ninja
[Buenas prácticas](https://es.javascript.info/ninja-code)

# Selección y acceso a elementos.

## DOM
![dom](https://upload.wikimedia.org/wikipedia/commons/5/5a/DOM-model.svg)
### Métodos clásicos
| Métodos de búsqueda | Descripción | Si no lo encuentra... |
| --- | --- | --- |
| `.getElementById(id)` | Busca el elemento HTML por su `id`. | Devuelve . |
| `.getElementsByClassName(class)` | Busca elementos con la clase `class`. | Devuelve `[]`. |
| `.getElementsByName(value)` | Busca elementos con el atributo `name` a `value`. | Devuelve `[]`. |
| `.getElementsByTagName(tag)` | Busca etiquetas HTML `tag`. | Devuelve `[]`. |

Fuente: [DOM - Manz.dev](https://lenguajejs.com/dom/)


## Métodos actuales
| Método de búsqueda | Descripción | Si no lo encuentra... |
| --- | --- | --- |
| `.querySelector(sel)` | Busca el primer elemento que coincide con el selector CSS `sel`. | Devuelve . |
| `.querySelectorAll(sel)` | Busca todos los elementos que coinciden con el selector CSS `sel`. | Devuelve `[]`. |

| Propiedades de elementos HTML | Descripción | Si está vacío... |
| --- | --- | --- |
| `.children` | Devuelve una lista de elementos HTML hijos. | `[]` |
| `.parentElement` | Devuelve el padre del elemento. |  |
| `.firstElementChild` | Devuelve el primer elemento hijo. |  |
| `.lastElementChild` | Devuelve el último elemento hijo. |  |
| `.previousElementSibling` | Devuelve el elemento hermano anterior. |  |
| `.nextElementSibling` | Devuelve el elemento hermano siguiente. |  |

Fuente: [DOM - Manz.dev](https://lenguajejs.com/dom/)

## Eventos

## Expresiones Regulares -RegEx-
1. [En crudo](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Regular_expressions)
2. [En español](https://www.freecodecamp.org/espanol/news/expresiones-regulares-regex-en-javascript-manual-para-principiantes/)

# Creación y modificación de elementos.


# Eliminación de elementos.




# Manipulación de estilos.


## Test unitarios:

<details>
  <summary>Test unitarios en css</summary>

* HTML:
```html
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <div id="uno" class="contenido">clásico</div>
  <div id="dos" class="border">ajustado</div>
  <div id="demo"></div>
</body>
</html>
```

* CSS:
```css
div{
  background-color: lightblue;
  border: 1px solid black;
  text-align: center;
  width: 100px;
  height: 100px;
  margin: var(--espacios);
  padding: var(--espacios);
}
.contenido {
}
.border{
  box-sizing: border-box;
}

:root{
  --espacios: 40px;
}
```

* JS:
```js
// Muestra TODAS las propiedades
function dumpCSSText(element){
  var s = '';
  var o = getComputedStyle(element);
  for(var i = 0; i < o.length; i++){
    s+=o[i] + ':' + o.getPropertyValue(o[i])+';';
  }
  return s;
}

// Selector tipo jQuery
function $(e){
  console.log(e);
  let r;
  if (e.substr(0,1) == "."){
    r = "clase";
  } else if (e.substr(0,1) == "#") {
    r = "id";
    let elemento = document.getElementById("demo");
    let prop = window.getComputedStyle(elemento, null).getPropertyValue("box-sizing");
    console.log( prop );
    //elemento.innerHTML = "hola";
    //r += elemento.textContent();
    //elemento.style.setProperty("background-color", "red");
  } else {
    r = "tag";
  }
  return r;
}
// Test Unitarios para estilos
// assertEquals(objetoPropiedades, elemento)
// Donde "objetoPropiedades" será un objeto con múltiples propiedad: valor y "elemento" el elemento que debe cumplir las propiedades.

function assertEquals(objetoPropiedades, elemento){
  let resultado = true;

  for (let key in objetoPropiedades){  
    let valorBuscado = objetoPropiedades[key];
    //console.log("Propiedad \"" + key + ": " + valorBuscado+"\"");
    let cssObj = window.getComputedStyle(elemento, null);
    let valorAlumno = cssObj.getPropertyValue(key);
    if(valorAlumno == valorBuscado){
      console.log("\"" + key + "\" iguales");
    } else {
      console.log("\"" + key + "\" diferente: El alumno tiene " + valorAlumno + " y era " + valorBuscado);
      resultado = false;
    }
  }
  return resultado;  
}
function dest(s){
  destino.innerHTML += s+"<br>";
}

let destino = document.getElementById("demo");
destino.innerHTML = "";
dest("Hola");

let objetoPropiedades = {
  "width": "100px",
  "box-sizing": "border-box"
}
let r = assertEquals(objetoPropiedades, destino);
console.log("Resultado " + r);


// Código basura para pruebas
let e = document.getElementById("demo");
e.style.setProperty("color", "yellow");

destino.innerHTML += $("#uno");
destino.innerHTML += $(".contenido");
destino.innerHTML += $("div");

//elementos = document.getElementsByTagName(div);
//elementos = document.getElementsByClassName(nombres)
//let element = document.getElementById("uno");

const element = document.getElementById("uno");
const cssObj = window.getComputedStyle(element, null);

let ancho = cssObj.getPropertyValue("box-sizing");
let correcto = (ancho == "border-box");
if(correcto){
  destino.innerHTML += correcto ;
} else {
  element.style.setProperty("width", "400px");
  element.style.setProperty("background-color", "red");
}

```

</details>

# Fuentes
+ Muy próximo a la línea que quiero llevar [repo de Brayan Diaz C](https://github.com/brayandiazc/aprendiendo-javaScript?tab=readme-ov-file)
+ [El Tutorial de JavaScript Moderno](https://es.javascript.info/)
+ De Manz.dev:
  1. [JS](https://lenguajejs.com/javascript/)
  2. [Http](https://lenguajejs.com/javascript/peticiones-http/url/)
  3. [DOM](https://lenguajejs.com/dom/)
  4. [Eventos](https://lenguajejs.com/eventos/)
  5. [CSS]
+ [MDN](https://developer.mozilla.org/es/docs/Learn_web_development) y más concretamente trabajamos [JavaScript](https://developer.mozilla.org/es/docs/conflicting/Learn_web_development/Core/Scripting_41cf930b8cfd2b83c76f8086a5e24792) (~70€) y más [básico](https://learnprogramming.online/app.html).
+ Otro [básico rapidito](https://edabit.com/tutorial/javascript).
+ [De Java a JavaScript](https://medium.com/@byrne.greg/transitioning-from-java-to-javascript-quick-guide-on-the-basics-you-need-to-immediately-know-ef95140a7d71)
+ [Controlando la visibilidad con módulos](https://coryrylan.com/blog/javascript-module-pattern-basics) y [export](https://developer.mozilla.org/es/docs/Web/JavaScript/Reference/Statements/export)
+ [The Ultimate Beginner’s Guide to Callbacks, Promises, and Async/Await in JavaScript](https://blog.devgenius.io/the-ultimate-beginners-guide-to-callbacks-promises-and-async-await-in-javascript-e319273a7f46)
+ [Buenas prácticas](https://medium.com/@onix_react/best-practices-for-writing-clean-javascript-code-a4e5755de69a)

**Libros:**
+ [Eloquent Js](https://eloquentjavascript.net/)
+ [Clean Code Js en Español](https://github.com/andersontr15/clean-code-javascript-es)


# Juegos
+ Algoritmia -> [Ascensor](http://play.elevatorsaga.com/)
+ [CodinGame](https://www.codingame.com/training)
+ [MMORPG](https://screeps.com/)
+ [CodeWars](https://www.codewars.com/)
+ Difícil -> [Adventure Game](https://alexnisnevich.github.io/untrusted/)

+ [Reto - islas (TypeScript)](https://checkio.org/)

**Reto final HTML + CSS + JS** [aquí](http://www.dungeonsanddevelopers.com/)


# Herramientas
+ [Codi.link](https://codi.link/)
+ [Node.js on-line](https://onecompiler.com/nodejs)

# Extras: 
## Consumo de API


### Protocolo http
![http](https://personales.unican.es/corcuerp/ingweb/notes/images/HTTP_Steps.png)
+ Es un protocolo de solicitud/respuesta.
+ Un cliente realiza la solicitud de un recurso y obtine una respuesta que se compone de un código y a veces un recurso.

#### Códigos:
  + 100: información.
  + 200: correcto.
  + 300: redirección.
  + 400: error en cliente. P.e. el 404 es no existe recurso
  + 500: error en servidor.

De forma más completa:
+ [Status Codes](https://httpstatuses.io/)
+ [en vídeo](https://www.youtube.com/watch?v=LYprAkna7Z4)
+ [Cats Codes](https://httpcats.com/) 🐈


#### Ejercicio:
Consultar cabezeras http con `curl -I` o [ReqBin](https://reqbin.com/ "REQ BIN")
Analizar las respuestas de:
```
curl -I mail.google.com
curl -I amazon.es
curl -I https://amazon.es
curl -I https://www.amazon.es
curl -I https://www.amazon.com
curl -I https://luiscastelar.duckdns.org/holaMundo.html
curl -I https://luiscastelar.duckdns.org/holaMundo.htm
curl -I https://luiscastelar.duckdns.org/holaMundo.json
curl https://luiscastelar.duckdns.org/holaMundo.json
curl luiscastelar.duckdns.org/holaMundo.json
curl -I luiscastelar.duckdns.org/holaMundo.json
curl -L luiscastelar.duckdns.org/holaMundo.json
```

#### Métodos
+ GET -> obtener
+ POST -> añadir
+ PUT -> modificar (todo el recurso)
+ PATCH -> modificar (parcialmente)
+ DELETE -> borrar
+ Otros... (no nos interesan para nuestro objeto de estudio).


## Test unitarios:
[Una guía sencilla](https://dev.to/dstrekelj/how-to-write-unit-tests-in-javascript-with-jest-2e83)

## Frameworks y librerías

### Un viaje al pasado -> jQuery `$`. 
Es una librería de JS que simplifica la manipulación del DOM.

+ [Aprendiendo jQuery](https://learn.jquery.com/)


### El popular de la clase -> React.js
“Es una librería de JS para crear interfaces de usuario”, con _enfoque modular_ donde es la librería la que manipula el DOM.

> [Características y ventajas de jQuery](https://www.webreactiva.com/blog/cambiando-jquery-a-react#caracteristicas-y-ventajas-de-jquery)
>
> jQuery, lanzado en 2006, es una biblioteca de JavaScript que simplifica la manipulación del DOM, el manejo de eventos y las animaciones en el navegador. Hemos querido locamente a “jotaquery” por su sintaxis sencilla y legible.
>
> Pero en la actualidad las interfaces de usuario interactivas demandan una solución más robusta.

> [Comparación directa: jQuery vs React.js](https://www.webreactiva.com/blog/cambiando-jquery-a-react#comparacion-directa-jquery-vs-reactjs)
>
> En comparación con jQuery, React.js tiene una curva de aprendizaje más pronunciada.
>
> Sin embargo, su enfoque modular y eficiente del desarrollo justifica el esfuerzo inicial.
>
> Mientras que jQuery manipula directamente el DOM y puede llevar a un código más difícil de seguir, React.js actualiza eficientemente el DOM y mantiene el código más organizado y manejable.

Fuentes:
+ [Aprendiendo React - midudev](https://github.com/midudev/aprendiendo-react)
+ [Curso](https://www.youtube.com/playlist?list=PLzA2VyZwsq_-dE3Jvunglxq8a6UcH6gnF)
+ [Wiki](https://www.reactjs.wiki/)



## TypeScript
[Una buena guía para emprezar](https://prismic.io/guides/typescript)

### Otros Frameworks
+ Angular, no confundir con AngularJS (en Typescript).
+ Derivadas de React como Next.js o React Native (para móviles)
+ Vue.js “The Progressive JavaScript Framework”
+ Svelte “Cybernetically enhanced web apps”

  