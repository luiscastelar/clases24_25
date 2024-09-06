#curso24_25 #común #ed [estado:: Done]

## Revisión de la historia

+ Detallado: `git log`
+ Resumido en una línea: `git log --pretty=oneline`
  + Con más datos: `git log --pretty=format:"%h - %an, %ar : %s"`
+ En árbol: `git log --graph`

Y por supuesto combinados: `git log --pretty=oneline --graph`


## Creación y fusión de ramas

+ [Doc OFICIAL](https://git-scm.com/book/es/v2/Ramificaciones-en-Git-Procedimientos-B%C3%A1sicos-para-Ramificar-y-Fusionar)
+ [Ramas - YT:TodoCode](https://www.youtube.com/watch?v=gjKKtQVVCZU)


### Sincronización de ramas
En ocasiones aparecen nuevas ramas en remoto que debemos crear en local para poder descargar las actualizaciones. ¿Lo más sencillo? 
```bash
for remote in `git branch -r | grep -v /HEAD`; do git checkout --track $remote ; done`
git pull -a
```


## Gestión de ramas

+ [Doc OFICIAL](https://git-scm.com/book/es/v2/Ramificaciones-en-Git-Gesti%C3%B3n-de-Ramas)

## Traer commits a la rama `RAMA`

Cuando en la rama `dev` hemos realizado commits interesantes puede ser de gran relevancia poder traérnoslos a la rama `main`. 

Para ello sólo necesitamos conocer su `hash` (1) y, desde la rama `main`  (a la que lo queremos llevar) deberemos escribir `git cherry-pick HASH`.

(1) Para capturar su `hash`, nos ubicaremos en la rama `dev` con `git checkout dev` y veremos el historial de commits con `git log`. Ésto nos arrojará el `hash` de cada commit, además de la descripción, autor y marca temporal.

## Jugando con ramas
+ [learnGitBranching](https://learngitbranching.js.org/?locale=es_ES)

## Ejercicios
[Git ramas](https://raul-profesor.github.io/DEAW/P5.1/)

# Forks
+ [forks](https://aprendegit.com/fork-de-repositorios-para-que-sirve/)

# Pull request
+ [pull request](https://www.freecodecamp.org/espanol/news/como-hacer-tu-primer-pull-request-en-github/)

# Preguntas que todo programador debería conocer
[Eso](https://pub.aimind.so/git-commands-summaries-that-every-developer-should-know-6b8f8971ccc4)


# Hooks
Algo general: [Hooks - Jeremy Holcombe](https://kinsta.com/es/blog/git-hooks/)

## Pre-commit
Como estamos trabajando sobre Java, utilizaremos un pre-commit inicial para verificar el estilo de código.

Si estuviéramos en otros lenguajes, especialmente aquellos sin tipado fuerte, podríamos verificar algunas cosas sobre tipos y analizadores sintácticos en lenguajes no compilados.

1. [Instalación](https://bohutskyi.com/improving-code-quality-setting-up-a-pre-commit-hook-for-checkstyle-on-git-4cdb17250279)
2. Configuración de git para utilizar el analizador
3. Ajustes de estilos. Podemos querer adaptarlo a nuestra necesidades (de empresa).
4. Probarlo:
   ```bash
      git commit -m"style fix google"
      Comenzando auditoría...
      Auditoría concluida.
      [main e0eaeed] style fix google
       1 file changed, 128 insertions(+), 105 deletions(-)
       rewrite Palindromos.java (96%)
   ```

Podemos ver en las líneas 2 y 3 que realiza la auditoría de código y la pasa sin warnings.

En este punto, podría ser interesante plantearnos si deberá pasar los test antes de los commits, después o antes del push.


# VARIOS interesantes
## Mover ramas
Resulta que me he liado y he creado una rama *main* en remoto y en local no leí y deje por defecto la rama *master*. ¿Qué puedo hacer?

Tenemos varias opciones, pero voy a simplificarlas en 2:
1. Renombrar la rama remota de *main* a *master* y seguir las indicaciones que nos proporciona *github*:
    ```bash
    git branch -m main master
    git fetch origin
    git branch -u origin/master master
    git remote set-head origin -a
    ```
2. Clonar la rama *main* en un nuevo repositorio remoto, aplicar los cambios en local a mano (sugiero la aplicación *Meld*) y subir los cambios.