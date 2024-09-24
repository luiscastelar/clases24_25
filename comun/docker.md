*Tags: #curso24_25 #prog #lmsgi #deapweb #curso23_24 #sad #psp #ed #par #curso22_23 #bbdd* [estado::Done] 

# INSTALACIÓN

## LINUX

### AUTOMATIZADO
1.  Asegurarse que no hay nada instalado\
    `sudo apt-get remove docker docker-engine docker.io containerd runc`
2.  Descargar script\
    `curl -fsSL https://get.docker.com -o get-docker.sh`
3.  Ejecutar\
    `sudo sh get-docker.sh`
4.  Probar\
    `sudo docker run hello-world`

### PASO A PASO en Ubuntu/Debian (si falla lo anterior)

        sudo apt-get remove docker docker-engine docker.io containerd runc
        sudo apt-get update
        sudo apt-get install apt-transport-https ca-certificates curl gnupg lsb-release
        curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor \
    -o /usr/share/keyrings/docker-archive-keyring.gpg
        echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] \
     https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee \
     /etc/apt/sources.list.d/docker.list > /dev/null
        sudo apt-get update
        sudo apt-get install docker-ce docker-ce-cli containerd.io

> Aunque lo más recomendado es realizar los pasos anteriores, triviales
> por otra parte, podemos simplificar realizando la instalación desde
> repositorios oficiales de la distribución favorita. Ésto conlleva un
> desfase con la versión más actualizada del servicio DOCKER y por tanto
> un problema para la seguridad del host y los servicios. \
> **NO HACER EN PRODUCCIÓN**.


### CONFIGURACIÓN POST-INSTALACIÓN:
Pese a que no se requiere más configuración para su funcionamiento, el comando `docker` requiere a priori permisos de `root` con los consecuentes riesgos asociados.

Docker nos brinda la posibilidad de que un usuario sin privilegios pueda ejecutarlo. Para ello sólo tendremos que crear el grupo `docker`, asignarselo al usuario y cargarlo (para evitar reiniciar).

    sudo groupadd docker
    sudo usermod -aG docker $USER
    newgrp docker


### También DOCKER DESKTOP

DOCKER DESKTOP es una herramienta que añade una capa de virtualización y con ello una capa extra de aislamiento y OVERLOAD (sobrecarga).

Salvo que queramos probar IMÁGENES 💽 que dependan de KERNEL concretos, en GNU/Linux no nos aporta nada interesante.

> Referencias: [Doc oficial Docker Desktop](https://docs.docker.com/desktop/linux/install/)

## WINDOWS y MacOS
Aunque sin duda no es el entorno ideal para ejecutar contenedores, si puede serlo para el desarrollo por lo que a menudo tomaremos estos sistemas como HOST temporales. 

Tenemos varias opciones para ellos:
1. MV + Docker CLI (vagrant)
2. Docker Desktop: Capa de virtualización intermedia que no controlamos. Ideal si no necesitamos controlar la red por ser lo más sencillo, pero inviable si necesitamos controlarla.
3. Docker CLI sobre WSL (Windows subsystem for Linux): *no recomendado por Docker Inc.*
4. [Play with docker](https://labs.play-with-docker.com/): PAAS para aprender Docker sobre web.




[Docker desktop](https://www.docker.com/products/docker-desktop) ... instalar y listo.

> Para Windows y MacOS hay que poner una capa intermedia ya que los núcleos de éstos sistemas no están basados en GNU/Linux y por tanto la mayoría de las imágenes no funcionarán.
>
> En Windows será interesante la utilización de un hipervisor (p.e. VirtualBox) + una VM con GNU/Linux (p.e. Alpine) con red en modo puente + `Docker CLI` que nos aportará un mayor control sobre nuestras pruebas ya que de otra forma, Windows gestionará la red por nosotros y puede dar algunos problemas.
>
> Por otro lado, salvo casos excepcionales, el despliegue final se realizará en servidores linux, por lo que la solución anterior nos permite desarrollar sobre un “gemelo digital”.


## PREPARACIÓN para aula:
**Entorno de trabajo en el aula**: Instalar *Docker Desktop* en aquellos equipos que lo permitan.

Para los que **NO**, o para los que quieran control total de su sistema docker (incluida la red):
+ Vagrantfile:
```ruby
Vagrant.configure("2") do |config|
  config.vm.box = "generic/debian12"
   config.vm.network "public_network"
   config.vm.synced_folder "./", "/vagrant"
   config.vm.provision "shell", path: "provision.sh"
  # config.vm.network "forwarded_port", guest: 80, host: 8080
  # config.vm.network "forwarded_port", guest: 80, host: 8080, host_ip: "127.0.0.1"
  # config.vm.provider "virtualbox" do |vb|
  #   vb.memory = "1024"
  # end
end
```

+ provision.sh:
```bash
apt-get update && apt-get install -y curl

sudo -u vagrant docker --version
if [[ ! $? -eq 0 ]]; then
	sudo -u vagrant curl -fsSL https://get.docker.com -o install-docker.sh
	sh install-docker.sh

	groupadd docker
	usermod -aG docker vagrant
fi
sudo -u vagrant docker --version

ip a | grep "inet "
```

**En entorno de producción**: 
Daremos por hecho que el entorno es GNU/Linux e instalaremos docker cli utilizando el script obtenido en https://get.docker.com

*Si nuestro entorno de producción fuera NO Linux no podremos utilizar docker*.


# ¿FUNCIONA?

Para ver si el sistema de contenedores está funcionando sólo tendremos
que escribir `docker run hello-world` desde linea de comandos en Linux o
desde el CLI de Docker Desktop en Windows y MAC.


# PASO A PASO:

## LOGS

No es el primer comando que vamos a utilizar, pero seguramente sea el
que más utilicemos.

Docker implementa un sistema de logs donde cualquier salida por
`standard-output` de un `contenedor` será almacenada como log del mismo
y podremos acceder y consultarla con:

``` bash
docker logs CONTENEDOR
```

Donde CONTEDEDOR podrá ser el nombre del mismo o su ID (CONTAINER ID),
incluso los primeros números de su ID.


## CONTENEDORES CORRIENDO y CREADOS:

Para consultar el estado de los contenedores en funcionamiento
utilizaremos `docker ps`, y para ver el total de contenedores de la
máquina `docker ps -a`.

```bash
CONTAINER ID   IMAGE                              COMMAND            CREATED       STATUS                 PORTS                                                                                            NAMES
98dc0d69ddde   lscr.io/linuxserver/nginx:latest   "/init"            7 days ago    Up 2 hours             0.0.0.0:8080->80/tcp, :::8080->80/tcp, 443/tcp                                                   Dashboard
af88fc3300c7   portainer/portainer-ce:latest      "/portainer"       9 days ago    Up 2 hours             0.0.0.0:8000->8000/tcp, :::8000->8000/tcp, 0.0.0.0:9443->9443/tcp, :::9443->9443/tcp, 9000/tcp   portainer
8b2f6784af22   containrrr/watchtower:latest       "/watchtower"      2 weeks ago   Up 2 hours (healthy)   8080/tcp                                                                                         wtower
0591e9984b51   zerotier/zerotier:latest           "/entrypoint.sh"   3 weeks ago   Up 2 hours (healthy)                                                                                                    zerotier
```

Como vemos, ésto nos devuelve bastante información: ID, la IMAGEN
origen, el nombre del CONTENEDOR 🧰 y el mapeo de puertos. Los puertos
conectados que aparecen 0.0.0.0:8080 ➡️ 80 indican que el puerto 8080 de
cualquier interfaz del `HOST` conecta directamente con el puerto 80 del
CONTENEDOR (tanto en IPv4 como en IPv6).

Podría aparecer algo como "80/tcp" sin la flecha "➡️" lo que
indicaría que el CONTENEDOR tiene un puerto abierto, pero éste no está
expuesto al mundo. Ésto es muy habitual para dar un extra de seguridad
ya que los contenedores podrán estar conectados (o no) unos con otros
sin necesidad de exponer puertos.

## Sobre IMÁGENES y CONTENEDORES (run):

Para `programadores`: Las imágenes son equivalentes a las clases en
programación orientada a objetos, donde debemos instanciarlas para poder
utilizarlas.

Para **NO** programadores: Las imágenes docker son equivalentes a las
imágenes de instalación (iso) de `UBUNTU` o `WINDOWS`, donde tendremos
que instalarlas en el disco (virtual o real) 💽 para utilizar el sistema.

Además podremos instanciarla tantas veces como queramos con distintos
parámetros que harán cambiar su comportamiento y cualquier cambio que le
realicemos no afectará a la clase, sólo a la instancia.

Para los menos informáticos, también puede verse como los planos para
fabricar un coche (imagen). Nosotros al comprar decidiremos el color,
tapicería, motor, etc (contenedor), y podremos comprar tantos distintos
como queramos sin afectar al resto (o tantos como podamos permitirnos 😉).

**¿Cómo hacerlo? `docker run`**
```bash
docker run mysql
# creará una instancia de la imagen mysql ... pero no podremos acceder al contenedor al ser
# docker un entorno de aislamiento (tipo sandbox) y no le hemos abierto ninguna puerta.
# Control+C para detener el contenedor y salir.

docker run -p 13306:3306 mysql
# creará una instancia y conectará el puerto 13306 del host al puerto 3306 del contenedor...
# ahora sí podemos comunicarnos con él. Para ello utilizaremos nuestro cliente
# "mysql" favorito.
# Nota: Si la conexión la realizamos desde nuestro propio equipo deberemos indicar
# la IP 0.0.0.0 o 127.0.0.1, ya que "localhost" busca un socket local del host y no
# el socket del contenedor. Esto es "mysql -h 0.0.0.0 -p13306 -uroot -p" sería un
# ejemplo de conexión a través del CLI de GNU/Linux.

docker run -P mysql
# creará el remapeo de puertos de forma automática. Con `docker ps` veremos que puerto se le ha asignado.
```

Cada vez que lanzamos un `docker run` se genera un NUEVO contenedor y se
quedará dormido en nuestro sistema (no consume CPU, pero si HDD).

Para evitar ésto podemos hacer limpieza (más adelante lo veremos) o:

```bash
docker run -rm mysql
      # lanzar los contenedores con ~-rm~ donde el contenedor será destruido tras salir de él.

docker run --name mi_mysql mysql
docker start mi_mysql
      # lo arranca en segundo plano
docker stop mi_mysql
docker rm mi_mysql
      # lanzar los contenedores con nombre, reutilizaros y eliminarlos.
```

Ahora estamos preparados para algo un poco más completo y real...

```bash
# Creamos una instancia de mysql
    sudo docker run -d --name test-mysql -v ./datos_mysql:/var/lib/mysql -p 3306:3306 \
         -e MYSQL_ROOT_PASSWORD=pass1234 mysql

         # docker run -> crear instancia y a correr. Si no existe la imagen la descarga del último
         #   parámetro "mysql" que marca el nombre del repositorio dentro del docker hub.
         #     -d -> corre el contenedor en segundo plano y muestra su ID
         #     --name test-mysql -> nombre de la instancia. NO puede haber dos iguales. Si no se lo damos
         # genera uno aleatorio
         #     -v dir_host:dir_contendor -> conectar directorios
         #     -p XXX:YYY -> puerto_expuesto_del_host:puerto_interno_de_la_imagen
         #     -e ... -> variables de entorno (según contenedor).
```

## ESTADO de CONTENEDORES y LIMPIEZA

Para ver nuestro "almacen" de contenedores utilizaremos los comandos
`docker ps` y `docker ps -a`.

El primero nos devolverá los contenedores ACTIVOS ⬆️ y el mapa de puertos,
y el segundo nos devolverá todos los contenedores de nuestro
"almacén".

Podremos eliminar los contenedores que no necesitemos con
`docker container rm CONTENEDOR` si no está corriendo 🗑️, y con
`docker container rm -f CONTENEDOR` forzaremos a detenerse aunque estén
corriendo.

Finalmente, podremos usar con MUCHA **PRECAUCIÓN** el comando
`docker container prune` que eliminará automáticamente todos los
contenedores no activos.

## EJERCICIOS:

1.  Crear un `CONTENEDOR` con un NGINX (servidor web) que nos publique
    una pequeña web de muestra ubicada en el directorio "~/publico".

2.  Crear un segundo `CONTENEDOR` de NGINX que nos publique una pequeña
    web ubucada en "~/publico2".

3.  Parar ambos contenedores y lanzar `docker ps -a`,
    `docker container prune` y de nuevo `docker ps -a`.

    Para la realización buscaremos una `IMAGEN` de `CONTENEDOR` de NGINX
    en el public [registry DOCKER HUB](https://hub.docker.com).

    Deberemos fijarnos en varias cosas a la hora de seleccionar
    la IMAGEN ideal:
    -   Las arquitecturas soportadas.
    -   Si la imagen es "DOCKER OFFICIAL IMAGE".
    -   Si la imagen es de un "VERIFIED PUBLISHER".
    -   El número de descargas de la misma.

### Revisando las "instrucciones" del "fabricante"
Tomando como ejemplo la imagen oficial del servidor web [Nginx](https://hub.docker.com/_/nginx):
1.  **Supported tags**: versiones de la imagen. Si no indicamos nada
    cogerá la última ("latest").
    Para pruebas nos puede valer cualquiera, pero debemos asegurarnos
    elegir una concreta para producción ya que si dejamos "latest"
    podría romperse en una actualización de versión (más adelante
    hablamos de *actualizaciones de seguridad*).
2.  **How to use this image**, **Usage**, **TL;DR** o similar: nos da la
    forma correcta de realizar el `docker run ...` con los puertos,
    volúmenes y variables de entorno necesarias para hacer un `run`
    rápido.
3.  `docker` (docker-cli) vs `docker compose`: El primero nos permite
    testear de forma rápida el funcionamiento de la imagen, pero es
    difícil de recordar en el futuro por lo que para PRODUCCIÓN
    imprescindible `docker compose`.\
    Si el fabricante nos proporciona ambos cogeremos **SIEMPRE** el
    `docker compose`, si no, usaremos la magia de [COMPOSERIZE](https://www.composerize.com/).

## CONECTANDO CONTENEDORES
### Conexión con redes

```bash
docker network create NOMBRE_RED
    # crea una red en modo bridge
docker run -d --name CONTENEDOR1 --network NOMBRE_RED nombre_imagen1
docker run -d -p 80:5000 --name CONTENEDOR2 --network NOMBRE_RED nombre_imagen2
```

Con un ejemplo real. Vamos a montar un `PhpMyadmin` que conecte con un
servidor `MySql`.

```bash
docker network create mi_primera_red
docker run -d --name mysql_server_deapweb --net=mi_primera_red \
        -e MYSQL_ROOT_PASSWORD=pass-mysql  mysql
docker run -d --name myadmin --net=mi_primera_red \
       -e PMA_HOST=mysql_server_deapweb -p 8080:80 phpmyadmin
    # Variables de entorno:
    # - MYSQL_ROOT_PASSWORD el pass para el usuario root
    # - PMA_HOST es la dirección del servidor al que queremos conectar. Puede ser una IP,
    # una FQDN o, usando la "magia" de docker el nombre de un contenedor
```

Algunas referencias del tema:
- [Oficial](https://docs.docker.com/engine/reference/commandline/network_connect/)
- [Jose Domingo](https://www.josedomingo.org/pledin/2020/02/redes-en-docker/)
- [Atareao con Linux](https://www.atareao.es/tutorial/docker/redes-en-docker/)


### Redes macvlan:
Conectando contenedores a redes macvlan paso a paso -> [aquí](https://blog.oddbit.com/post/2018-03-12-using-docker-macvlan-networks/#host-access)

> *Opción poco elegante pero funcional (en GNU/Linux)*:
> Se puede crear un alias de interface, asignarle una IP y conectar los contenedores con esa IP en vez de con la inicial.
> *Para esta solución perdemos aislamiento del contenedor y tendremos que vigilar los servicios que levantamos en el host*.


### Modo legacy ➡️ NO USAR

## VERSIONES CONCRETAS de IMÁGENES (TAGs):
Uso de tag:

```bash
   # Creamos una instancia de mariadb
sudo docker run -d --name test-mysql -v $(pwd):/var/lib/mysql -p 3307:3306 \
     -e MYSQL_ROOT_PASSWORD=pass1234 mariadb:tag
   # Error tag -> nos permite elegir la imagen más adecuada a nuestras necesidades
   # (nº versión o similar)
   # Atentos -> ahora conecto el puerto 3307 del host al 3306 del contenedor
```

## VOLÚMENES (-v):
Si queremos compartir información de forma permanente entre el host y
los contenedores deberemos exponer directorios a través de volúmenes.

> **MUY IMPORTANTE**: si no montamos un volumen al instanciar perderemos
> (al destruir la instancia) todo lo que no copiemos.

```bash
docker run --name tienda-mysql -v $(pwd):/var/lib/mysql -e MYSQL_ROOT_PASSWORD=tienda.bbdd \
       -p 3307:3306 -d mysql

    # En este caso hemos añadido un volúmen con la opción -v.
    # El formato es -v directorio_host/directorio_contenedor.
    # Podemos compartir un mismo directorio del host con todos los contenedores que queramos
    # Sólo lectura: -v dir_host/dir_container:ro -> el contendero sólo puede leer
    # Las rutas deben darse de forma abasoluta.
    # Podemos utilizar $(pwd) para relativizar desde donde lo instanciamos
```

Existen otras opciones de persistencia. Ver documentación oficial.

## MODO INTERACTIVO

    sudo docker exec -it CONTENEDOR COMANDO
     # Donde el comando puede ser cualquier comando disponible en el contenedor,
     # incluidos /bin/bash o /bin/sh (este último siempre disponible).

## COPIAR DATOS ENTRE HOST y CONTENEDOR (cp):

Si se nos ha olvidado montar volúmenes o por segurida no lo hemos
montado podemos comunicarnos de la siguiente forma:

```bash
  SRC_PATH= ruta_de_origen_contenedor
  DEST_PATH= ruta_destino_host
  docker exec CONTAINER tar Ccf $(dirname $SRC_PATH) - $(basename $SRC_PATH) | tar Cvxf $DEST_PATH -
    # En el contenedor ejecutamos tar Ccf del directorio del contenedor y lo sacamos gracias
    # al pipe ~|~ al directorio destino del host


  SRC_PATH= ruta_de_origen_host
  DEST_PATH= ruta_destino_contenedor
  tar Ccf $(dirname $SRC_PATH) - $(basename $SRC_PATH) | docker exec -i CONTAINER tar Cvxf $DEST_PATH -
# Proceso inverso
```

### También con docker CP:

```bash
    # de host a contenedor:
docker cp -a host_source_path container:destination_path
    # de contededor a host:
docker cp -a container:source_path host_destination_path
    # podemos pasar archivos o directorios
    # -a: preserva los atributos de archivos y directorios
```

Referencia: [Doc oficial](https://docs.docker.com/engine/reference/commandline/cp/)


## POLÍTICAS de REINICIO

``` {.bash}
    # Cambiar política de reinicio { no |  on-failture | always | unless-stopped }
docker update --restart always nombre_contenedor
```

## INSPECCIONAR CONTENEDOR

Muy útil ante olvido claves, directorios de volúmenes, mapeo de puertos,
etc.

```bash
  # Inspeccionar contendor
docker inspect nombre_contenedor
  # buscar parámetro/s exacto:
  # Políticas de reinicio
docker inspect -f "{{ .HostConfig.RestartPolicy }}" zerotier-one
  # Nombre del contenedor y políticas de reinicio
docker inspect -f "{{ .Name }} -> {{ .HostConfig.RestartPolicy.Name }}" zerotier-one
  # Nombre, políticas de reinicio, puertos y volúmenes
docker inspect -f "{{ .Name }} -> -r {{ .HostConfig.RestartPolicy.Name }} \
  -p {{ .NetworkSettings.Ports }} -v {{ .Mounts }}" php-nginx
  # ID del contenedor
docker inspect -f "{{ .ID }}" practica1-mysql
```

## LIMPIEZA (PRUNE)

> **IMPORTANTE**: Elimina los CONTENEDORES que no estén corriendo ... y
> todos los datos que no estén en VOLÚMENES.

**Importante**: activar todo lo que no queramos borrar.

```bash
docker system prune -all
    # elimina todo lo que no esté en uso (imagenes, contenedores, redes, etc.)
```

## ACTUALIZACIONES (UPDATES)
Tenemos 3 opciones: a mano o con el contenedor de `watchtower` .


### A MANO:
**Importante**: Opción recomendada para contenedores en producción **críticos**. 3
pasos:
```bash
docker pull IMAGEN_NUEVA
docker stop CONTENEDOR_BASADO_EN_IMAGEN_ANTIGUA
docker run IMAGEN_NUEVA
```

Evidentemente, deberás haber puesto a salvo cualquier dato modificado en
el contenedor basado en la imagen antigua ya que de no ser así lo
**perderás TODO**.


### WATCHATOWER:
```bash
CONTENEDORES="contenedor1 contededor2 ... contenedorn"
docker run --name watchtower -v /var/run/docker.sock:/var/run/docker.sock \
       containrrr/watchtower $CONTENEDORES
    # actualiza imágenes que le pasamos como argumentos
```

Referencias: [oficial](https://containrrr.dev/watchtower/)
```bash
    -e TZ=America/New_York  # Change your time zone with the correct time
    zone from the TZ Database.
    -e WATCHTOWER_CLEANUP=true  # This option will delete the old images from your system when new images are downloaded. This prevents old images from building up and taking space on your system.
    -e WATCHTOWER_DEBUG=true  # This option will enable verbose logging in the Watchtower log.
    -e WATCHTOWER_INCLUDESTOPPED=true  # Adding this variable will allow Watchtower to monitor and upgrade stopped containers in addition to running containers.
    -e WATCHTOWER_REVIVESTOPPED=true  # This variable will take those stopped containers in the previous variable and start them once they are upgraded.
    -e WATCHTOWER_POLLINTERVAL=300  # This variable determines how often Watchtower will check for updates. Change 300 to your desired polling value in seconds.
    -e WATCHTOWER_LABELENABLE=true  # This variable configures Watchtower to only check containers that have the following label set to true: com.centurylinklabs.watchtower.enable\
    -e WATCHTOWER_MONITORONLY=true  # Use this to configure Watchtower to only monitor for updates. In the mode, Watchtower will not pull new images or update the containers.
```


### Docker-controller-bot
Gestión completa de contenedores (arrancar, parar, actualizar, programar...) -> [github](https://github.com/dgongut/docker-controller-bot)


## SECRETOS:
Muy utilizado en `docker compose` para evitar publicar credenciales por
error.

La documentación oficial también habla de:

-   docker secret create
-   docker secret inspect
-   docker secret ls
-   docker secret rm
-   --secret flag for docker service create
-   --secret-add and --secret-rm flags for docker service update


# Docker COMPOSE:
***AVISO***: La versión 1.0 de `docker-compose` está **sin mantenimiento** desde 
julio de 2023, por lo que deberá utilizarse únicamente la versión 2.0 
o superior.

En la práctica, para usar la versión 2 sólo tenemos que eliminar el 
“dash” o guión “-” y llamaremos a dicha versión. Podemos verificar
la versión mediante `docker compose -v`.


## COMANDOS BÁSICOS:
-   `docker compose up` levanta (crea) la composición. Con `-d` la deja
    corriendo en segundo plano.
-   `docker compose down` destruye la composición (no los volúmenes).
-   `docker compose ps` muestra las composiciones en funcionamiento con
    sus puertos.
-   `docker compose config` muestra y valida el archivo yml.
-   `docker compose rm` elimina uno o varios contenedores.
-   `docker compose -h` muestra ayuda.
-   ...

Por defecto, el programa toma el archivo `compose.yml` o `docker-compose.yml`.


## VARIABLES y SECRETOS
En archivos `.env` (del tipo clave:valor) podemos poner variables que
queramos pasar al compose del tipo "image: webapp:${TAG}".

También podemos pasarle variables de entorno con
`docker-compose run -e DEGUG=1 ...`


### SECRETOS:
La mejor forma de no exponer credenciales es mediante la utilización de
archivo ".env" y variables dentro del `docker-compose.yml`.

El archivo ".env" será del tipo clave=valor, y en el
`docker-compose.yml` utilizaremos los valores mediante la llamada con
"${clave}".

Por ejemplo: ".env": key1=16daz key2=d4

"compose.yml" version... ... environment:
-   usuario=${key1}
-   password${key2}


## YAML:
-   [Resumen {Wikipedia}](https://es.wikipedia.org/wiki/YAML)
-   [Oficial](https://yaml.org/)


## COMPOSERIZE:
Si ya controlamos `docker` cli podremos utilizar el servicio para 
convertir de docker cli a docker compose [composerize](https://www.composerize.com/).

---

# Dockerfile
[Desarrollo con contenedores (ED)](https://github.com/luiscastelar/clases23-24/blob/main/ed/ED-09-Desarrollo%20con%20contenedores.md)


---
# Preguntas de entrevistas sobre DOCKER:
Algunos tips sobre que debemos saber: [learning-zone](https://github.com/learning-zone/devops-interview-questions)


# Moviendo a un HD Externo
[Eso](https://geekland.eu/usar-y-ejecutar-docker-en-un-disco-duro-externo/)


# EXTRA de SEGURIDAD:

`docker`  se ejecuta en modo root por lo que pueden aparecer algunos 
problemas de seguridad, sobre todo en sistemas multi-usuario. 
Puedes saber más en los siguientes enlaces:
- [Vídeo del Pelao sobre el tema](https://www.youtube.com/watch?v=0xUwaz0MD_E)
- [Doc. Of. DOCKER sobre ejecución en espacio de nombres de usuario](https://docs.docker.com/engine/security/userns-remap/)
- [Doc. Of. DOCKER sobre ejecución en modo rootless](https://docs.docker.com/engine/security/rootless/)




# IMÁGENES ÚTILES:
*Este es un listado subjetivo y realizado en mayo de 2021. Tomarlo con precaución.*

## GUI - Gestión de IMAGENES/CONTENEDORES/VOLÚMENES

```bash
docker volume create portainer_data
docker run -d -p 8000:8000 -p 9000:9000 --name=portainer --restart=always \
       -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data portainer/portainer-ce

docker stop portainer
docker start portainer
```

## Servidor SSH:
Nos permite compartir una parte concreta de nuestro servidor.

```bash
# Servidor SSH
    docker run -d --name=ssh -p 7777:22 -v /nube:/nube  ugeek/ssh:amd64
    sudo docker run -d --name=ssh -p 7777:22 -v $INFORMATICA/ejercicios/docker/ssh:/nube \
         ugeek/ssh:amd64
        # -v -> volumen ... conexión de carpeta externa con carpeta interna
        # usuario: root
        # contraseña: EntraenlaMatrix
        # Fuente:
        # https://ugeek.github.io/blog/post/2021-02-06-docker-servidor-ssh-para-conectarte-por-sftp.html


# Accediendo desde bash
    ssh root@ip_host -p 7777

    # -p 7777 -> puerto donde está el servidor
    # root@ip_host -> usurio "root" en máquina "ip_host"
    # -X -> recomendable para novatos. Normalmente funciona con usuario root.

    # Una vez dentro...
        # fingerprint -> huella única. Importante que no nos muestre este mensaje
        # cambiar clave de acceso -> "#passwd" (sin la #)
        # "$passwd" = ejecución como usuario normal <-> "#passwd" = ejecución como root (superusuario)

    # También desde fuera:
        docker exec -it ssh passwd
```

## MySQL/Mariadb

``` {.bash}
# lanzamos consulta directamente
mysql -h 0.0.0.0 -uroot -p -D"mysql" -P 3307 -e "show tables; select * ...;"
    # -p: Nos pedirá el password
    # -D"bbdd" se conecta directamente a la ~bbdd~
    # -e: se le puede pasar las consultas que queramos en modo receta

# Modo interactivo (abre un shell MySQL):
mysql -h 0.0.0.0 -uroot -p"pass1234"
    ~mysql>SHOW VARIABLES WHERE Variable_name = 'port';~
```

## Firefox (VNC)

```bash
docker run -d --name=firefox -p 5800:5800 -p 5900:5900 \
       -v /home/hpserver/docker/appdata/firefox:/config:rw --shm-size 2g \
       -e VNC_PASSWORD=pass_elegida jlesage/firefox
```

## Kanboard:

```bash
# Kanboard
    sudo docker create --name=kanboard -p "80:80"
        -v $INFORMATICA/ejercicios/docker/kanboard/data:/var/www/app/data
        -v $INFORMATICA/ejercicios/docker/kanboard/plugins:/var/www/app/plugins
        -v $INFORMATICA/ejercicios/docker/kanboard/ssl:/etc/nginx/ssl kanboard/kanboard:latest
    # Username: admin Password: admin
    # toma la variable de sistema $INFORMATICA
```


## OTRAS IMÁGENES INTERESANTES

    # transmission
      docker run -d  --name=transmission  -e PUID=1000  -e PGID=1000  -e TZ=Europe/Madrid \
        -e TRANSMISSION_WEB_HOME=/combustion-release/  -e USER=torrent  -e PASS=torrent \
        -p 9091:9091  -p 51413:51413  -p 51413:51413/udp  -v $(pwd):/config  \
        -v $(pwd)/../media:/downloads  -v $(pwd):/watch  --restart unless-stopped \
        ghcr.io/linuxserver/transmission
        
    # ctop
      docker run -ti --name ctop --rm    -v /var/run/docker.sock:/var/run/docker.sock \
        wrfly/ctop:latest
        
    # filerun
      docker run -d --name=filerun -v $(pwd)/config:/config \
        -e TZ=Europe/Madrid -e PGID=1000 PUID=1000 -p 8081:80 afian/filerun:latest


# CAMBIAR PUERTOS ➡️ ****NO USAR****:

No usar ésto en producción **NUNCA**. Puede causar efectos imprevisibles.

```bash
CONTENEDOR="practica1-mysql"
    # Captura ID del contenedor
docker inspect -f "{{ .ID }}" $CONTENEDOR
    # Detener contenedor
docker container stop $CONTENEDOR
    # Detener servicio DOCKER
systemctl stop docker
    # editar el archivo de configuración hostconfig.json cambiando puerto
    # o añadiendolo ~,"443/tcp":[{"HostIp":"","HostPort":"443"}]~ justo delante de la llave de cierre
nano /var/lib/docker/containers/$(docker inspect -f "{{ .ID }}" practica1-mysql)/hostconfig.json
    # Iniciar servicio DOCKER
systemctl start docker
    # Iniciar contenedor
docker container start $CONTENEDOR
```
