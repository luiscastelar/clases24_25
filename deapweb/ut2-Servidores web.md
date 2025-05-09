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



## Creación de instancia
Primero crearemos una instancia en Azuere, AWS, OC (Oracle Cloud) u otra máquina externa con acceso al mundo por vuestra parte (antiguo pc, raspberry pi, etc.)

## Creación de pares de llaves
Con `ssh-keygen -t ed25519 ` volcaremos un par de llaves público/privadas en `~/.ssh/` (tanto en Windows como en Linux). Pondremos contraseña de descifrar las llaves en equipos públicos (como el de clase).

Deberemos tomar la llave pública (la que lleva `.pub`) e insertarla en le archivo `.ssh/authorized_keys` del **servidor**. Para ello, en el servidor ejecutaremos `echo ‘contenido de la llave’ >> ~/.ssh/authorized_keys`.

A partir de este momento podremos acceder al servidor sin que nos solicite contraseña de acceso del servidor (sólo la de la llave si la creamos).

## Acceso al VPS
`ssh {{USUARIO}}@{{IP DEL SERVIDOR}}` o `ssh {{USUARIO}}@{{FQDN}}`

## DNS o Dinamic DNS
1. Deberemos darnos de alta en [duckdns](https://github.com/linuxserver/docker-duckdns) y obtener el token.
2. Obtener un subdominio del tipo “misubdominio.duckdns.org”.
3. Ahora para tener actualizada la IP a la que debe apuntar nuestro subdominio tenemos varias opciones:
   + [Contenedor docker](https://github.com/linuxserver/docker-duckdns)
   + Script de linux + CRON:
     + Script duck.sh:`echo url="https://www.duckdns.org/update?domains=exampledomain&token=a7c4d0ad-114e-40ef-ba1d-d217904a50f2&ip=" | curl -k -o ~/duckdns/duck.log -K -`
     + Cron -> `crontab -e` y añadir `*/5 * * * * ~/duckdns/duck.sh >/dev/null 2>&1` (vigilar la ruta)[^1]

   + [Script de powershell + `Task Scheduler`](https://github.com/ataylor32/duckdns-powershell)

### Otros servicios de DNS dinámica:
+ https://dnsexit.com
+ https://freedns.afraid.org/


## Firewall del VPS
Deberemos tener presente que lo habitual es tener seguridad por defecto, por lo que al iniciar sólo tendremos acceso al ssh por puerto 22 y por pares de llaves o esa es la situación que deberemos crear de inicio.

1. Verificar que no podemos entrar al VPS por contraseña. Sólo por pares de llaves. [En caso contrario](https://www.digitalocean.com/community/tutorials/how-to-configure-ssh-key-based-authentication-on-a-linux-server-es)
2. Abrir los puertos 80 y 443 y que apunten a la instancia. Tendremos que conocer la ip privada de la misma.

Si nuestro proveedor tiene abierto por defecto, o lo cerramos todo (excepto el puerto de ssh) o cerramos securizamos en la instancia.

Llegados a este punto.. `tail -f /var/log/auth.log` y en `midominio.duckdns.org` mostrar el fail2ban `sudo tail -f /var/log/fail2ban.log`.

Resumiendo, sólo hoy he recibido `sudo cat /var/log/auth.log | grep 'Oct 17' | wc -l`


## Acceso por túnel ssh
Para la gestión del proxy, como para acceder al equipo antes de ser público podremos conectarnos vía _tunnel ssh - proxy socks_. 

Para ello, desde consola abriremos un túnel proxy socks dinámico con `ssh -ND {{PUERTO_LOCAL_DEL_PROXY}} usr@servidor`, p.e. **`ssd -ND 9999 usr@sevidor.es`**

Después activaremos la conexión proxy del navegador con los datos `proxy shocks`, ip `localhost` y puerto `9999`.

Podremos acceder a los servicios de la máquina con su IP_PRIVADA y el puerto que corresponda. Con `localhost` no podemos ya que, salvo que se indique lo contrario, ésto apuntará al equipo desde el que hacemos la petición y no al que queremos acceder.


# Monitorización
1. Redes de monitorización y gestión
![separacion de redes](https://luiscastelar.duckdns.org/2024/assets/deapweb/separacion-de-redes.png)
2. Servicios de monitorización y gestión:
   + Uptime-kuma
   + Zabbix


## Sobre logs
Deberéis estudiar el punto donde se arrojan los logs de las aplicaciones desplegadas. A menudo las imágenes `docker` de servicios como `apache` y `nginx` enlazan los logs estándar con los dispositivos `/dev/stdout` y `/dev/stderr`, como se muestra en la captura:
```bash
usr@FQDN:~/ruta/completa/servidor_apache$ docker exec -it apache bash -c 'ls -la /var/log/apache2'
total 12
drwxrwxrwt 2 www-data www-data 4096 Oct 17 01:38 .
drwxr-xr-x 1 root     root     4096 Oct 17 01:38 ..
lrwxrwxrwx 1 www-data www-data   11 Oct 17 01:38 access.log -> /dev/stdout
lrwxrwxrwx 1 www-data www-data   11 Oct 17 01:38 error.log -> /dev/stderr
lrwxrwxrwx 1 www-data www-data   11 Oct 17 01:38 other_vhosts_access.log -> /dev/stdout

```

Como vemos, los logs `access.log` y `error.log` han sido redireccionados a la salidas estandar y de error. Para visualizarlos por tanto deberemos usar _docker_ con `docker logs apache`

Para la monitorización completa deberíamos modificar esta redirección ya que de otra forma perdemos la granularidad de aplicaciones externas o las mismas deben soportar la monitorización a través de contenedores.

Algún punto interesante que podemos ver en los logs `172.19.0.3 - - [22/Oct/2024:21:28:12 +0000] "GET /.env HTTP/1.1" 404 461 "-" "Mozilla/5.0 (Ubuntu; Linux x86_64; rv:123.0) Gecko/20100101 Firefox/123.0"
`. ¿Qué pensáis que ha pasado?


# Examen
~~De cara al examen podéis probar los ejercicios en local, ya que el mismo se realizará sin acceso a internet y consistirá en realizar algunas de las tareas expuestas en el desarrollo de esta unidad.~~


# Cross-Origin Resource Sharing - CORS
![cors](https://luiscastelar.duckdns.org/2024/assets/deapweb/cors.png)
Para protección del usuario, los navegadores bloquean las peticiones realizadas con origen cruzado, esto es, que un script ejecutado en un dominio B acceda a datos de peticiones realizadas por la web del usuario al dominio A.

Como demostración crearemos la siguiente _aplicación_ en local (navegador web + <kbd>F12</kbd> + console):
```javascript
let url='https://miDominio.duckdns.org/holaMundo.json';
const peticion = (url)=>{
  fetch(url)
    .then(res => res.json())
    .then(res => console.log(res));
}
peticion(url);
```

Y obtenemos una respuesta del tipo: `Solicitud desde otro origen bloqueada: la política de mismo origen impide leer el recurso remoto en https://miDominio.duckdns.org/ (razón: falta la cabecera CORS 'Access-Control-Allow-Origin'). Código de estado: 200.`.

Podemos investigar el motivo en <kbd>herramienta de desarrolladores</kbd> + <kbd>red</kbd> + <kbd>cabeceras</kbd> + <kbd>cabeceras de respuesta</kbd>.

Ahora añadimos cabeceras para GET dentro del `location` que deseemos:
```
if ($request_method = 'GET') {
            add_header 'Access-Control-Allow-Origin' '*' always;
            add_header 'Access-Control-Allow-Methods' 'GET, POST, OPTIONS' always;
            add_header 'Access-Control-Allow-Headers' 'DNT,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Range' always;
            add_header 'Access-Control-Expose-Headers' 'Content-Length,Content-Range' always;
}
```


Habilitar en [Nginx](https://enable-cors.org/server_nginx.html) y en [Apache](https://enable-cors.org/server_apache.html).



Fuente: [javascript.info](https://es.javascript.info/fetch-crossorigin#por-que-cors-es-necesario-una-breve-historia)

---
# Notas al pie
[^1]: Siempre es aconsejable poner la ruta absoluta ya que a veces podemos despistarnos de quien es el usuario que está ejecutando el script de cron, ya que la `~` hará referencia al `home` de dicho usuario.
