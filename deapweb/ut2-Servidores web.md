#curso24_25 #deapweb [estado:: Working] 

# Servidor Apache
Toda la unidad será desarrollada partiendo de las herramientas disponibles hoy donde lo habitual es trabajar con contenedores y pods de kubernetes.

Fuente: [Documentación Oficial `Apache`](https://httpd.apache.org/docs/)


## Configuración básica y host virtuales
+ [Doc imagen OFICIAL](https://hub.docker.com/_/httpd)
+ [Doc oficial Bitnami](https://github.com/bitnami/containers/tree/main/bitnami/apache#how-to-use-this-image)

_Salvo casos de uso particulares, la reducción de carga de los contenedores han desplazado el uso de host virtuales a entornos en contenedor independiente por cada host virtual debido a la seguridad y aislamiento ofrecidos._

#### Ejercicio:
1. Monta un servidor apache en una máquina virtual (desde archivo de provisión) que nos ofrezca un “hola mundo” soy el servidor de `Apache` en una MV sobre `Vagrant`.
2. Activa virtual host
3. Repite paso 1 en un contenedor.


## Configuración avanzada del servidor web
+ [Anonimizando cabeceras](https://techexpert.tips/es/apache-es/apache-cambiar-el-encabezado-de-identificacion-del-servidor/)

#### Ejercicio:
A partir del servidor anterior, modifica las cabeceras de forma que nuestro servidor responda sólo el nombre, sin especificar versión ni S.O.:
   + Extrae el archivo de configuración `httpd.conf`
   + Modifícalo para realizar el ejercicio


### Módulos: instalación, configuración y uso.
Comenzaremos repasando como instalar, configurar y habilitar un módulo en `Apache` [aquí](https://es.linux-console.net/?p=5208) para posteriormente realizar el traslado a nuestro entorno en [contenedor](https://stackoverflow.com/questions/55187078/how-to-install-apache-module-in-docker-container-at-the-correct-location).

#### Ejercicio:
Carga un módulo en nuestro entorno de contenedor.

  
## Autenticación y control de acceso
[Puntos 2 y 3](https://www.alvarovf.com/servicios/2020/11/01/control-acceso-apache.html)

En realidad, queda evidente que sólo el punto 3 será utilizable.

#### Ejercicio:
1. Configura una ruta controlada dentro del servidor mediante `auth basic`
2. Carga el módulo `auth_digest` y configura para que la web principal (`/`) sea accesible, pero se requiera autenticación para acceso a `/zona-controlada/`.

Los datos de acceso serán `ana:1234` y `alejandro:0987`


# Proxy inverso
El protocolo HTTPS o como obtener el candado para realizar una navegación “segura” se realiza mediante la utilización de certificados SSL... pero que nosotros gestionaremos mediante un proxy inverso.

Las ventajas de la gestión mediante proxy inverso son:
+ Él gestiona los certificados por nosotros
+ Él nos aisla del mundo

~~Certificados. Servidores de certificados.~~ => innecesaria la gestión si optamos por un Proxy Inverso

Como opciones recomendadas tenemos [Nginx Proxy Manager](https://nginxproxymanager.com/), [Traefik](https://hub.docker.com/_/traefik/), [Caddy](https://github.com/lucaslorentz/caddy-docker-proxy) o HAProxy.


# Puesta en producción
+ ~~Despliegue de aplicaciones sobre servidores web.~~
+ Despliegue de servidores web mediante tecnologías de virtualización en la nube y en contenedores.

Puesto que en local el sentido de tener un proxy es difuso, procederemos a montarlo en nuestro VPS como punto de entrada al mismo.

#### Ejercicio:
Deberéis elegir el proxy inverso que queráis, instalarlo en vuestro VPS y que sirva contenido diferente cuando accedamos a `ana.miservidor.duckdns.org` y `alejandro.miservidor.duckdns.org`.

Los contenedores web que sirven ana... y alejandro... no serán accesibles desde el mundo, salvo a través de nuestro proxy inverso en el puerto 443. La única superficie de ataque será dicho puerto.

_Nota: El dominio `duckdns.org` está filtrado desde la red educarex, no así desde la red de aula._


# Monitorización
1. Redes de monitorización y gestión
![separacion de redes](https://luiscastelar.duckdns.org/2024/assets/deapweb/separacion-de-redes.png)
2. Servicios de monitorización y gestión:
   + Uptime-kuma


# Examen
De cara al examen podéis probar los ejercicios en local, ya que el mismo se realizará sin acceso a internet y consistirá en realizar algunas de las tareas expuestas en el desarrollo de esta unidad.