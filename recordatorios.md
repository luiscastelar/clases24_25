#curso23_24 #deapweb #prog #lmsgi #par #sad #ed #psp #bbdd

Todos los recordatorios son válidos para todo el módulo formativo, salvo cuando se indique expresamente lo contrario. 

El incumplimiento podrá ser motivo de penalizaciones, dar por no entregada la actividad o el apercibimiento por canales oficiales.


**14 de septiembre**
+ Estructura del repositorio (_salvo para el módulo de PAR_):
  * Como sabes las correcciones se realizaran sobre el **primer** repositorio del que recibí invitación a colaborar. El resto de repositorios serán completamente ignorados.
  * Dentro del repositorio deberás tener un README.md con tu nombre, email y el nombre del módulo formativo que estamos trabajando (deapweb, prog, lmsgi, ed, sad, psp, bbdd, ...).
  * Además crearás una carpeta por cada Unidad de Trabajo y se llamarán ut1, ut2, ... (Si ya las tienes, pero con otros nombres, puedes renombrarlas con p.e. `git mv tema1_tal ut1`).
  * Si compartimos más de un módulo formativo, tendrás una estructura del tipo `REPO/prog/ut1`, si no, del tipo `REPO/ut1`.
  * Dentro de cada carpeta de unidad colocarás una carpeta por trabajo solicitado (`practica1`, `practica2`, ...) o exámen (`examen`), y otra para `ejercicios`. \
    *No utilices tildes ni `ñ` en los nombres de archivos o directorios, git desde windows la lía parda con ellas (tema de conversión de charsets)*. 
  * Dentro de cada carpeta irá un `README.md` con la documentación del trabajo/práctica/examen, o simplemente informando del contenido de la carpeta.
  * Sólo se corregirá aquellos trabajos donde haya una copia **ZIP** del directorio subida al MOODLE en tiempo y forma. Si además la acompañas con el README correspondiente podremos ambos (tú y yo) saber que contiene el zip sin descargarlo y abrirlo.
+ Todos los días se abre espacio para preguntar dudas y solicitar orientación sobre teoría, ejercicios y prácticas. Si está trabajado, y la pregunta cumple con los [requisitos mínimos de trabajo previo](https://sindominio.net/ayuda/preguntas-inteligentes.html) hazla, o se dará por hecho que lo has trabajado y entendido.

  ![preguntas inteligentes](https://pilas.guru/wp-content/uploads/2013/11/7302968194_77d54b1160_b.jpg)
  Comprendo que estás aprendiendo RTFM puede llegar a ser duro, utiliza los trucos (tldr, cheet.sh, ...) vistos en el aula.
+ Las capturas de pantalla se realizarán **siempre** con fondo blanco y letras en negro. De otra manera no se visualizarán correctamente en proyecciones ni impresiones en papel. *Cualquier captura sobre fondo negro será ignorada, esto es, no será dada por válida*.
+ Los documentos de texto serán subidos **siempre** en formato de texto plano (markdown, orgmode o txt), salvo que se indique otra cosa (pdf, odt, ...). *Recuerda que GIT sólo puede rastrear archivos de texto plano*.
+ Sobre las versiones de software a utilizar, **siempre** utilizaremos:
  + Por defecto, la versión actual y estable -> P.e: Ubuntu 24.04 LTS o JDK21 LTS.
  + Si estamos probando nuevas _features_ nuevas, la versión en desarrollo -> P.e.: Ubuntu 24.10 (saldrá en breve). 
  + Para entornos _legacy_, si la versión montada si tiene soporte (p.e: Ubuntu 22.04 LTS o JDK17 LTS) la utilizamos, si llegó a _end_of_life_ deberéis establecer un proyecto de migración o consultar con el jefe de proyectos.
  + **NUNCA** versiones obsoletas (*deprecated*) -> P.e: Ubuntu 23.10 o JDK 20.
+ Cuando entregas una práctica que “rompe” (errores críticos), es que no te has molestado ni en comprobar “tus fuentes”.
+ No se debe utilizar **root** salvo cuando necesitamos a root. El uso innecesario de root será penalizado con 2 puntos en cada práctica.
+ RAR es un formato propietario. No se admiten entregas en dicho formato. Utiliza `tar` o `zip` en su lugar.
* Recuerda que el git de clase así como cualquier documento de entrega obligatorio son documentos **OFICIALES** que serán incluidos a tu expediente académico, usa por tanto lenguaje formal, adecuado y técnico. *No estás en el parque con los amigos*.
![lenguaje no formal](https://luiscastelar.duckdns.org/2023/assets/ED/formas_inadecuadas.png)
+ Todos los emails deben llevar un asunto. De otra forma serán automáticamente eliminados (mi gestor de correo lo hace así).
+ No se admitirán [variables ninja](https://es.javascript.info/ninja-code) bajo ninguna circunstancia. Del nombre de las mismas deberá poder inferirse su contenido u utilidad.
+ Las capturas de salida estándar se realizarán con `tee` o `Tee-Object` **siempre**.

  _Si el programa no capturara la salida, consultar con el profesor. Por ejemplo, a `git` hay que añadirle el argumento `--progress` y redireccionar ambas salidas `2>1&` para realizarlo correctamente, quedando algo como `git clone --progress ruta/repo.git 2>1& | tee archivo.log`_
  
+ Únicamente cuando no sea posible se realizarán con el método de realizar captura y subir (siempre con GIT) y asegurándoos de que funcionan mediante ruta relativa al README y no a rutas absolutas respecto a github.
+ Respecto a las correcciones encuentro que debemos recordar algunos términos que a algunos se les olvida:
  1. Si no existe documentación no continúa la corrección ya que “el cliente” no sabe como comenzar.
  2. Si la documentación no refleja algún requisito se entenderá que no ha sido realizado (o no de forma *original)
  3. Si la práctica/examen/tarea arroja errores no gestionados y rompe, el corrector (automático o humano) para ya que no puede evaluar más.
  4. La práctica/examen/tarea debe cumplir con TODAS los requisitos de “el cliente”. Excepcionalmente, “el cliente” puede quedar temporalmente satisfecho si algunos requisitos auxiliares no se cumplen. Ante la duda, consultar a “el cliente”.
+ Sobre la documentación de las prácticas: cuando en una práctica se os solicita una enumeración de funcionalidades, deberás crear un apartado específico en la documentación para cada una de ellas. Cualquier ausencia de dicho apartado se tomará como no documentado, y por tanto no podrá ser corregido.
+ Sobre la documentación de las prácticas (parte II): La documentación de vuestras prácticas debe permitir que otro técnico reproduzca **exactamente** lo configurado/implementado/desarrollado. Esto es, tan exactamente que debería tener los mismos “aciertos” y errores con el fin de que este otro técnico pueda investigar/mejorar el sistema “fuera de línea” (entorno de laboratorio).

  _Puedes comprobar si está bien documentado con el feedback de un compañero o de chatGPT_.
+ Para lograr el objetivo, deberá adjuntarse todos los archivos necesarios (con comentarios si procede), así como un pequeño documento que explique todo lo necesario para utilizar dichos archivos.
+ Aquel alumnado que por motivos justificados, o no, no pueda asistir a clase total o parcialmente, será responsable de informarse sobre lo tratado en el aula y acogerse a cualquier decisión o elección tratada en su ausencia.