#curso24_25 #lmsgi [estado::Done] _Duración: 3h_

# Introducción

> Un **lenguaje de marcado** o **lenguaje de marcas** es una forma de codificar un documento que, junto con el texto, incorpora etiquetas o marcas que contienen información adicional acerca de la estructura del texto o su presentación.
> 
> Fuente: [concepto de juangualberto](https://juangualberto.github.io/lmsgi/tema01/concepto.html)

![Imagen de chandlervid85 en Freepik](https://luiscastelar.duckdns.org/2024/assets/lmsgi/casa.jpg)
[Imagen de chandlervid85 en Freepik](https://www.freepik.es/foto-gratis/mujer-mostrando-mano-mini-casa-concepto-inmobiliario-ai-generativo_41954006.htm#fromView=search&page=1&position=5&uuid=d1ddeab1-f0d3-42e2-8df0-5d2da31431c8)

## Lenguajes vs codificaciones:
+ Esta es mi casa
+ This is my house
+ Das ist mein Haus
+ Αυτό είναι το σπίτι μου
+ Это мой дом
+ ここは私の家です
+ 这是我的房子
+ هذا هو منزلي

### Codificaciones:
Por motivos históricos: **ASCII**
![ASCII](https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/ASCII-Table-wide.svg/2000px-ASCII-Table-wide.svg.png)¿Qué problema le veis? ...




¿Dónde está la ñ, las tildes o ‘¿‘ ?


Hoy, **CP-1252 vs UTF-8**: [aquí](https://es.stackoverflow.com/questions/288782/diferencia-entre-cp-1252-y-utf-8). 

_Nota: la conversión actual entre ambas codificaciones “suele” funcionar. Pese a ésto, hay problemas de conversión por lo que se recomienda **no** utilizar en nombres de archivos caracteres no disponibles en la tabla ASCII._


**¿Diferencia entre Unicode y UTF-8?**

Respuesta corta: Unicode es el acuerdo de caracteres disponibles, p.e. 💘 `U+1F498` y los valores utilizados para almacenarlo en memoria en UTF-8 `0xF0 0x9F 0x92 0x98` (4 bytes), o la “A” como `U+0041` y en UTF-8 `0x41` (1 byte).


**Finales de línea**

Para el almacenado de textos en archivos se toma como convección partir los párrafos utilizando un carácter de salto de línea que:
+ en Windows `\r\n`
+ en Unix (Linux) `\n`
+ en MacOs `\r`


### En nuestro módulo formativo
Dado que el sistema operativo estándar en servidores utiliza UTF-8, nosotros utilizaremos dicha codificación y el final de línea tipo UNIX `\n`.

Para ello utilizaremos la aplicación _Notepad++_ y la configuraremos a tal efecto (UTF-8 y final tipo Linux).

Fuentes: 
+ [Introducción de Juangualberto](https://juangualberto.github.io/lmsgi/tema01/datos_y_formatos.html)
+ [Tabla de conversión Unicode](https://www.compart.com/en/unicode/)


## Tipos de lenguajes de marcas
> * **Orientados a la presentación**. En ellos los metadatos permiten indicar el formato en el que se debe presentar el texto. Es el caso de **RTF**, en el que sus etiquetas especifican tipos de letra, tamaños de página, colores, etc. Las primeras versiones de **HTML** también se consideran así, ya que incluían etiquetas como **font** mediante la cual se especificaba el formato de fuente.
> * **Orientados a la descripción**. En ellos las marcas especiales permiten dar significado al texto pero no indican cómo se debe presentar en pantalla el mismo. Sería el caso de **XML** (o de **SGML**), **JSON**, **Markdown** y de las versiones actuales de **HTML**. En estos lenguajes simplemente se indica el significado del contenido: si el texto es un título, un párrafo normal, un pie de ilustración, una dirección postal etc.
> * **Orientados a procedimientos**. Se trata de documentos en los que el texto marcado, se interpreta como órdenes a seguir, y así el archivo en realidad contiene instrucciones a realizar con el texto (girarle, convertirle en una fórmula, realizar una suma, etc.). Es el caso de **LaTeX** o **PostScript**.
>   
> Fuente: [Jorge Sánchez](https://jorgesanchez.net/manuales/html/introduccion-lenguajes-de-marcas.html)
 

# Control de versiones -> GIT
> Git es un software de control de versiones diseñado por Linus Torvalds, pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones cuando estas tienen un gran número de archivos de código fuente.

+ [Básico](https://github.com/luiscastelar/clases24_25/blob/main/comun/git.md)
+ [Medio](https://github.com/luiscastelar/clases24_25/blob/main/comun/git-ramas.md)


# Lenguaje de marcado ligero para representación -> Markdown
> Markdown es un lenguaje de marcado ligero que se puede utilizar para agregar elementos de formato a documentos de texto sin formato.

### Documentación
+ [Doc **OFICIAL**](https://www.markdownguide.org/basic-syntax)
+ [Doc español](https://markdown.es/sintaxis-markdown/)
+ [Resúmen en vídeo](https://www.youtube.com/watch?v=oxaH9CFpeEE)
+ [Cheat-sheet](https://www.markdownguide.org/cheat-sheet)

### Herramientas
+ [Editor online](https://stackedit.io/app#) sincronizable con drive y github.
+ [Tablas en md](https://www.tablesgenerator.com/markdown_tables)
+ [Keyboard generator](https://kbd.hsuan.xyz/)

### Ejemplos
Puedes ver ejemplos pasando al modo *Code* cualquier archivo de este repositorio.