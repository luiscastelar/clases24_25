#curso24_25 #común #deapweb #prog #lmsgi #bbdd #ed #psp #sad [estado:: Done]

# GIT básico
Lectura **OBLIGATORIA** => [blog de Diego Martín](https://www.diegocmartin.com/tutorial-git/).

Y en modo vídeo:
1. [Introducción a GIT por TodoCode](https://www.youtube.com/watch?v=mCVQgSyjCkI&list=PLQxX2eiEaqby-qh4raiKfYyb4T7WyHsfW)
2. [Curso completo - Makigas](https://www.youtube.com/watch?v=jSJ8xhKtfP4&list=PLTd5ehIj0goMCnj6V5NdzSIHBgrIXckGU)



## Resumen de zonas:

![resumen git](https://cfw.rabbitloader.xyz/eyJjIjp0cnVlLCJoIjoid3d3LmRpZWdvY21hcnRpbi5jb20iLCJ2IjoxMzQ2MTc0NzgzfQ/wp-content/uploads/2018/12/git-workflow1.png)

Para crear un README en texto plano, pero con un formato agradable y *convertible* recurriremos al formato Markdown ([Fazt Code - Markdown](https://www.youtube.com/watch?v=oxaH9CFpeEE) )


## Ejercicio: 
1. Crear un repo con README.md conectado con GitHub.
2. Añadir colaborador (profe `@luiscastelar`).
3. El `README.md` contendrá vuestro nombre y email coorporativo.
4. Clonar repositorio en otra ubicación y realizar una captura. Añadirla (integrada) al READMe.md.
5. Crear un archivo de credenciales (nombre de usuario y contraseña) denominado `.env`.
6. Crear archivo `.gitignore` con el contenido:
  ```
  *.env
  ```

*Aplicaciones auxiliares:* [GitFiend](https://gitfiend.com/) o [GitG](https://wiki.gnome.org/Apps/Gitg) como apoyo visual a *git bash*. También [Git Extensions](https://gitextensions.github.io/) como plug-in de VS.


## Conectando nuevos equipos
### Nuevo repositorio
Cuando queramos conectar nuevos equipos, p.e. el de casa, al repositorio `BARE` (central) deberemos:
1. Tener acceso al repositorio `BARE` mediante pares de llaves público/privadas, o por token[^1].
2. Obtener la dirección del repositorio `BARE` al que queremos conectar. Ésta debe ser del tipo `git@github.com:luiscastelar/pruebasDAW1.git`. Ésta dirección tiene 3 partes:
   + `git@github.com` -> el servidor al que nos estamos conectando [^2].
   + `luiscastelar` -> vuestro nombre de usuario en github (o el servidor al que os conectéis).
   + `pruebasDAW1.git` -> el repositorio al que os estáis conectando.
3. Clonar el repositorio sobre el directorio que deseemos con `git clone git@github.com:luiscastelar/pruebasDAW1.git {{NOMBRE DEL DIRECTORIO}}`.


### A repositorio ya existente
También podemos conectar un repositorio local ya creado anteriormente y con contenido con el comando `git remote add origin git@github.com:luiscastelar/pruebasDAW1.git`, y posteriormente sincronizar sus contenidos con:
```bash
git pull origin main
git push -u origin main
```
_Con el primer comando descargamos el contenido remoto y con el segundo subimos el contenido local y establecemos `origin` como `push` por defecto_.

A menudo se producirán conflictos en el `git pull` que deberemos resolver a mano.


## Revertir cambios
+ git reset --soft HEAD~1
+ git reset --hard HEAD~1

Fuente: [@midudev](https://youtube.com/shorts/IwatUhxAsdU?si=fDiKuvklhy_0N2_v)

## Merge y rebase
¿Qué ocurre cuando trabajamos con ramas o hemos realizado cambios desde 2 equipos distintos? \
![Ramas](https://miro.medium.com/max/720/1*wRBcfPnjdm8vY40j9iIl7g.png)

Pues que tenemos que unir los caminos. Tenemos 2 opciones: merge y rebase.
+ **git merge** crea un commit *MERGE* de unión de ambas ramas.
+ **git rebase** crea un commit *REBASE* que contiene los commits de la línea temporal alternativa y elimina la elimina. Como si nunca hubiera existido, pero con el mismo resultado qeu el `merge`.
+ 
  *Ventaja*: Visualmente más sencillo ya que el historial aparece lineal.
  
  *Inconveniente*: Los creadores de los commits que desaparecen pierden el seguimiento de sus cambios por los HASH. **=> SÓLO REALIZAR EN REPOSITORIOS UNIPERSONALES** o nunca.
  
![merge-rebase](https://miro.medium.com/max/720/1*UDKJF0BHO_USMuovMgdylQ.png)

## cherry-pick
+ [trayendo cambios](https://www.juannicolas.eu/dominando-git-cherry-pick-guia-basica/)


## Uniendo repositorios
[Unir 2 repositorios conservando el historial


## Nooooo: 
![](https://luiscastelar.duckdns.org/memes/lmsgi-git-push-force.jpg)


## PRÁCTICA (voluntaria)
Haz sólo lo que no tengas ya en el ejercicio anterior:
1. Crea una cuenta en github (con el email corporativo).
2. Crea un repositorio privado (vacío).
3. Sigue los pasos que te proporciona para crear un git local o subir uno existente.
4. Crea un README.md con:
   + Autor del repositorio
   + eMail de contacto (corporativo)
   + Crea un directorio para la UT1 con un README.md donde documentes esta práctica.
6. En otra carpeta, clona tu repositorio remoto.
   + Captura de pantalla.
   + Súbela a ./img
   + Enlázala al README de la práctica.
7. Crea un archivo “a.txt” con 3 líneas y sincroniza con el repositorio remoto.
8. Modifica la primera línea del archivo en la web y la tercera en local con contenidos distintos e intenta sincronizarlos. Captura el conflicto y añádelo a la documentación.
9. Busca la estrategia de solucionar el conflicto y realiza un merge.
10. Mediante gitfiend o gitg captura la línea de tiempo.
11. Regresa al punto 7 (en el tiempo) y muestra el contenido del archivo a.txt mediante una captura.
12. Vuelve al `HEAD` y documentalo todo.

## Referencias:
  + Documentación OFICIAL -> [Git reference manual](https://git-scm.com/docs) y en [español](https://git-scm.com/book/es/v2)
  + [David Poza](https://davidinformatico.com/apuntes-git)
  + [Manuel Cillero](https://manuel.cillero.es/doc/apuntes-tic/herramientas/git/)
  + Vídeos aclarativos -> [PildorasInformáticas 1-5, 10-11](https://www.youtube.com/watch?v=ANF1X42_ae4&list=PLU8oAlHdN5BlyaPFiNQcV0xDqy0eR35aU)
  + [Pelao Nerd - 1](https://youtu.be/kEPF-MWGq1w) y [Pelao - 2](https://youtu.be/7-JHoPyJy-Q)


# Notas al pie
[^1]: Es un sistema de acceso a nuestro repositorio que se genera un token con los permisos necesarios a el repositorio adecuado y con fecha de caducidad, lo cual otorga bastante seguridad. [Información sobre acceso por token].
[^2]: Puede haber otros servidores interesantes, p.e. gitlab, gitbucket, o el vuestro privado.