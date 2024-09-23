#curso24_25 #deapweb [estado:: Working] 

# Bases del despliegue.

## Arquitecturas web:
Modelos de capas:
![capas](https://luiscastelar.duckdns.org/2024/assets/deapweb/modelo-de-capas.png)
+ Modelo 2 capas: cliente - datos -> P.e.: Angular + Firebase
+ Modelo 3 capas: cliente - servidor - datos -> P.e.: React + Node.js + MySQL
+ Modelo 4 capas: cliente - contenedor web - lógica de negocio - datos -> P.e.: Vue + Spring(API) + Microservicios + PostgreSQL

### Escalabilidad de sistemas:
+ **Escalabilidad vertical**: Habitualmente, la separación lógica en capas se implementa de tal forma que se permita una separación física de las mismas. Interponiendo elementos conectores que actúen de middlewares es posible distribuir la aplicación de forma vertical (una máquina por cada capa del sistema), e incluso si esto no fuera suficiente, distribuyendo los elementos de una misma capa entre distintas máquinas servidoras.
+ **Escalabilidad horizontal**: Se trata de clonar el sistema en otra máquina de características similares y balancear la carga de trabajo mediante un dispositivo externo.

## Protocolos.

### Http
+ Es un protocolo de solicitud/respuesta.
+ Un cliente realiza una solicitud similar a MIME (MUltipurpose Internet Mail Extensions), a menudo GET
+ El servidor devuelve el código de estado (éxito-200 o error-otro código) y un mensaje similar a MIME si procede.
+ Versiones 1 2: conexiones http y https sobre TCP, puertos 80 y 443 respectivamente.
  + [http1.1 - RFC2616](https://www.rfc-editor.org/rfc/rfc2616) - Probablemente, aún el más utilizado.
  + [http2.0 - RFC7540](https://www.rfc-editor.org/rfc/rfc7540) - Mejoras se enfocan en como se empaquetan los datos y en el transporte.

+ Versión 3 [http3](https://quicwg.org/base-drafts/draft-ietf-quic-http.html). **SIEMPRE** https pero sobre **UDP** (puerto 443) - Mejoras en la conexión rápida ya que solo la primera conexión requiere el intercambio de mensajes previos para el cifrado.
  
#### Ejercicios
Consultar cabezeras http con `curl -I`
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
[curl - ampliado](https://techexpert.tips/ubuntu/curl-get-headers-only/)

<!-- comentado
#### Tabajo (UT2)
Montar servidor con soporte HTTPv3
Fuentes:
+ [nginx http3](https://github.com/macbre/docker-nginx-http3)
+ [Montar servidor con soporte HTTPv3](https://blog.cloudflare.com/experiment-with-http-3-using-nginx-and-quiche/).
-->

### Prototolo HTTPs
+ SSL
+ TLS
+ Certificados -> Let's encrypt
[Criptografía asimétrica](https://www.youtube.com/watch?v=hRW_9Ck36Xc)

### Métodos
+ GET -> obtener
+ POST -> añadir
+ PUT -> modificar (todo el recurso)
+ PATCH -> modificar (parcialmente)
+ DELETE -> borrar
+ Otros... (no nos interesan para nuestro objeto de estudio).

Fuentes:
+ [Métodos MDN](https://developer.mozilla.org/es/docs/Web/HTTP/Methods) 
+ [API REST](https://www.oscarblancarteblog.com/2018/12/03/metodos-http-rest/) 
+ [Qué es una API REST](https://rockcontent.com/es/blog/api-rest/)

#### Juego:
Juega con la API REST de muestra ofrecida por [GoREST](https://gorest.co.in/)
+ GET:
  - Todos: curl https://gorest.co.in/public/v2/users
  - Uno: curl https://gorest.co.in/public/v2/users/2936
+ Para POST, PUT, PATCH y DELETE requerimos autenticarnos y pasarle los datos a cambiar... \
*El uso de curl con datos:*
```
curl --header "Content-Type: application/json" \
     --request POST \
     --data '{"username":"xyz","password":"xyz"}' \
     http://gorest.co.in/api/login
```

*También podéis usar [ReqBin](https://reqbin.com/ "REQ BIN")*


### Códigos de respuesta
+ [Status Codes](https://httpstatuses.io/)
+ [en vídeo](https://www.youtube.com/watch?v=LYprAkna7Z4)
+ [Cats Codes](https://httpcats.com/) 🐈


## Pila TCP/IP
+ Modelo de capas
+ Direccionamiento IP
  - Clases (obsoleto).
  - CIDR (Enrutamiento [interdominio] sin clases).
  - VLSM (Máscara de red de longitud variable).
  - IPs de relevancia:
```
   | IPv4               | IPv6            | Nombre / Significado                          |
   |--------------------+-----------------+-----------------------------------------------|
   | 0.0.0.0/0          | ::/0            | wildcard (comodín)                            |
   |                    | ::/128          | sin especificar                               |
   | 127.X.X.X/8        | ::1/128         | loopback (el propio host)                     |
   | 10.X.X.X/8         | fc00::/7        | Redes priv (con *hasta* 2^24 - 2 host IPv4)   |
   | 172.16.X.X/12      |                 | Redes priv (con *hasta* 2^20 - 2 host IPv4)   |
   | 192.168.X.X/16     |                 | Redes priv (con *hasta* 2^16 - 2 host IPv4)   |
   | 255.255.255.255/32 | -No existe-     | Difusión                                      |
   |                    | ::/96           | IPv4 compatible **NO usar**.                  |
   |                    | ::ffff:0:0/96   | IPv4 mapeada                                  |
   |                    | ::ffff:0:0:0/96 | IPv4 traducida                                |
   |--------------------+-----------------+-----------------------------------------------|
   | Enlace local       |                 | No enrutable (sin salida a internet)          |
   |--------------------+-----------------+-----------------------------------------------|
   | 169.254.X.X/16     | fe80::/10       | link-local -> no hay DHCP y hay conf dinámica |
   |--------------------+-----------------+-----------------------------------------------|
   | De interés         |                 |                                               |
   |--------------------+-----------------+-----------------------------------------------|
   | 224.0.0.1          | ff02::1/128     | All nodes (de la red)                         |
   | 224.0.0.2          | ff02::2/128     | All routers (de la red)                       |
   |                    | ff0e::1/128     | All nodes (de todas las redes)                |
   |                    | 2001::/32       | Túnel Teredo (conexión 6to4)                  |
   |                    | 64:ff9b::/96    | prefijo Well-know (IPv4 traducida automática) |
   | 192.168.56.X/24    |                 | Red NAT de Virtual Box                        |
   |--------------------+-----------------+-----------------------------------------------|
```
> (*) Lista no exhaustiva de ips de relevancia.

Si bien las direcciones link-local no son utilizadas habitualmente en IPv4, todas las interfaces **deben** disponer **OBLIGATORIAMENTE** de dirección **fe80::/10**.

_[Cheatsheet IPv6](http://wiki.webperfect.ch/images/4/49/IPv6_Cheatsheet.pdf)_

### Concepto de socket:
`IP:Puerto` => identificación de un servicio de manera única.

#### Ejerccios:
Ver sockets activos en el servidor (en equipo Linux):
   + Equipo propio:
```
$ ss -tapon
# ss -tapon
$ netstat -tapon
# netstat -tapon
$ lsof -i -P -n
```
> $ para usuario sin privilegios y # para root. Éste segundo nos dará información más detallada, como el nombre de los procesos entre otros.
   + Otro equipo:
```
$ nc -vc IP PUERTO
$ nmap IP
$ nmap IP/CIDR
```

> Para Windows (poco habitual en servidores): \
> Información de puestos y conexiones:
>> CMD:	netstat -ano \
>>		    netstat -abno \
>> PS:	Test-NetConnection IP -Port PUERTO \
>
> Información de rutas:
>> CMD:	route print
>
> Extra: Información sobre los procesos
>> CMD:	tasklist /FI "pid eq NUM_PID_DEL_PROCESO" /V /FO List
>
>> **Localizar y matar procesos**
>> PS: Get-NetTCPConnection -LocalPort PUERTO
>> PS o CMD: taskkill /F /PID PID_PROCESO

# Tareas:
1. Dado el mapa de red, asigna direcciones de forma coherente y razonada a TODOS los dispositivos en sus interfaces de capa 3.
![capas](https://luiscastelar.duckdns.org/2024/assets/deapweb/T1-mapa_de_red.png)
2. Obtén las cabeceras de una petición GET a *amazon.es* pero disfrazando el *user-agent* para parecer un Firefox versión 105.0.1.
3. Sobre un entorno linux (virtualizado o no), investiga todas los procesos con referencias a los puertos 67 y 68 y cómo interactúan. \
   Info: si la máquina está virtualizada, deberá estar conectada directamente a la red lan sin NAT. \
   P.D.: Un par de párrafos por puerto serán suficientes para demostar que sabes sus funciones.

> Forma de entrega: Subir como `README.md` a repositorio privado en una carpeta `T1-Bases` y compartir con @luiscastelar.


# Contenedores:
## Introducción a los Contenedores o ~~Virtualización LIGERA~~:

### LXC y LXD:

*Linux Containers* y *Linux Conteiner Daemon* son una herramienta de creación de contenedores Linux bajo entornos Linux y una Herramienta de gestión de LXC respectivamente. Esto es, LXD es una abstracción de LXC.

¿Pero que són los LXC?

![portada](https://luiscastelar.duckdns.org/2023/assets/vm-vs-lxc.png)
[Algo de info](https://www.josedomingo.org/pledin/2022/11/introduccion-lxd/)


### Docker
![otra](https://luiscastelar.duckdns.org/2023/assets/hypervisor1-vs-lxc-vs-docker.png)

LXC virtualiza sistemas completos (mismo núcleo que el host) y Docker aplicaciones. 

En ocasiones Docker cede el control a aplicaciones sin sistema operativo (a menudo en Rust).



### Podman
Es otro motor de contenedores similar a docker pero con interesantes características, por ejemplo:
+ **No requiere permisos de root**. No hay *demonio* en segundo plano. Ésto es bueno en torno a seguridad pero requiere que nosotros gestionemos el encendido de los contenedores, por ejemplo con *systemd*.
+ **Pod**: En podman tenemos un elemento intermedio llamado Pod que contiene uno o varios contenedores. Todos ellos comparten una misma IP.
+ Nos permite generar un manifiesto de Kubernetes a partir de un Pod creado con sólo `podman generate kube {{nombre del pod}} > {{nombre del manifiesto}}.yaml`, e incluso correr manifiestos de Kubernetes en un pod.

Fuente:
+ [Pelao Nerd](https://www.youtube.com/watch?v=l6Bgd7Y8pgE)


### Kubernetes (K8s, K3s, miniKube)
Es un orquestador de contenedores.
> Kubernetes es una plataforma portable y extensible de código abierto para administrar cargas de trabajo y servicios. Kubernetes facilita la automatización y la configuración declarativa. Tiene un ecosistema grande y en rápido crecimiento. El soporte, las herramientas y los servicios para Kubernetes están ampliamente disponibles.

> Puedes pensar en Kubernetes como:
>*   una plataforma de contenedores
>*   una plataforma de microservicios
>*   una plataforma portable de nube
>...y mucho más.

> Kubernetes ofrece un entorno de administración **centrado en contenedores**. Kubernetes orquesta la infraestructura de cómputo, redes y almacenamiento para que las cargas de trabajo de los usuarios no tengan que hacerlo. Esto ofrece la simplicidad de las Plataformas como Servicio (PaaS) con la flexibilidad de la Infraestructura como Servicio (IaaS) y permite la portabilidad entre proveedores de infraestructura.

![otra](https://luiscastelar.duckdns.org/2023/assets/SAD/Mono2kub.png)
![otra](https://luiscastelar.duckdns.org/2023/assets/SAD/Docker-Kubernetes-togethert-min.png)

## `docker` CLI
[Introducción a `docker cli`](https://github.com/luiscastelar/clases24_25/blob/main/comun/docker.md)

### Práctica
Deberéis crear un conjunto de microservicios (con docker) compuesto por 3 contenedores:
+ Red interna para la comunicación entre contenedores
+ Microservicio `mariaDB` no accesible desde el mundo, sólo desde la red interna. Éste debe inicializarse con la creación del usuario `pepe` y el pass `despliegue`.
+ Microservicio `php-apache` que pueda acceder a la bbdd y desde el exterior en el puerto 80. Debe contener un `phpinfo()` en el archivo `info.php` de la raíz púbilica.
+ Microservicio `phpMyAdmin` que pueda accedar a la bbdd y sea accesible desde el exterior en el puerto 8080 o 443 si lo realizas desde un VPS. \
*Nota: para simplificar esta última conexión deberéis pasarle la variable de entorno `PMA_HOST=nombre_contenedor_mariaDB`.


*Nota: El sistema debe ser accesible por cualquiera desde internet (VPS) o ser facilitado en un entorno reproducible (vagrant) con instrucciones claras para su ejecución.*

> Forma de entrega: Subir como README.md a repositorio privado en una carpeta `ut1-Docker`.


## `docker compose`
[Introducción a `docker compose`](https://github.com/luiscastelar/clases24_25/blob/main/comun/docker.md#docker-compose)

### Práctica
Transformar la práctica anterior (`mariaDB+php-apache+phpMyAdmin`) en un compose funcional. 

Para aumentar la seguridad le pasaremos toda la información sensible como parámentros a  través del archivo de secretos `.env`.

Recuerda:
> Deberéis crear un conjunto de microservicios (con docker) compuesto por 3 contenedores:
> + Red interna para la comunicación entre contenedores
> + Microservicio `mariaDB` no accesible desde el mundo, sólo desde la red interna. Éste debe inicializarse con la creación del usuario `pepe`y el pass `despliegue`.
> + Microservicio `php-apache` que pueda acceder a la bbdd y desde el exterior en el puerto 80. Debe contener un `phpinfo()` en el archivo `info.php` de la raíz púbilica.
> + Microservicio `phpMyAdmin`que pueda accedar a la bbdd y sea accesible desde el exterior en el puerto 8080 o 443 si lo realizas desde un VPS.
>   
> *Nota: para simplificar esta última conexión deberéis pasarle la variable de entorno `PMA_HOST=nombre_contenedor_mariaDB`.*
> 
> *Nota: El sistema debe ser accesible por cualquiera desde internet (VPS) o ser facilitado en un entorno reproducible (vagrant) con instrucciones claras para su ejecución.*

> Forma de entrega: Subir la documentación como README.md a repositorio privado en una carpeta `ut1-Compose` y añadir el `docker-compose.yml`.


## `Dockerfile`
[Introducción a `Dockerfile`](https://github.com/luiscastelar/clases24_25/blob/main/comun/Dockerfile.md)


# Servidor web:
> En términos sencillos, un servidor web es un ordenador que almacena, procesa y entrega archivos de sitios web a los usuarios desde un navegador.
> 
> Los servidores web están formados por hardware y software que utilizan el Protocolo de Transferencia de Hipertexto (HTTP) para responder a las peticiones de los usuarios de la web realizadas a través de la World Wide Web.
>
> > Fuente: [Hostinger](https://www.hostinger.mx/tutoriales/que-es-un-servidor-web)

De forma general un servidor web recibe en interpreta las peticiones `http` o `https` de una URL, tomando éstas la siguiente forma:
![partes de url](https://luiscastelar.duckdns.org/2024/assets/deapweb/partes-url-ejemplos.png)
Fuente: [edytapukocz.com](https://edytapukocz.com/url-partes-ejemplos-facil/)

Y más genérico aún:
![manz](https://lenguajejs.com/javascript/peticiones-http/url/url-parts.png)


Lo veremos ampliamente **en UT2**.

# Servidor de aplicaciones (UT3).
> En informática, se denomina servidor de aplicaciones a un servidor en una red de computadores que ejecuta ciertas aplicaciones.
> 
> Usualmente se trata de un dispositivo de software que proporciona servicios de aplicación a las computadoras cliente. Un servidor de aplicaciones generalmente gestiona la mayor parte (o la totalidad) de las funciones de lógica de negociación y de acceso a los datos de las aplicaciones. Los principales beneficios de la aplicación de la tecnología de servidores de aplicación son la centralización y la disminución de la complejidad en el desarrollo de aplicaciones.
>
> > Fuente: [Wikipedia](https://es.wikipedia.org/wiki/Servidor_de_aplicaciones)

Nosotros nos centraremos en el contenedor de aplicaciones *Tomcat* que ejecuta aplicaciones Jakarta EE (antes Java EE) con base en el lenguaje *Java*.

Lo veremos ampliamente **en UT3**.

# Servidores en la nube (vps).
![vps profesor Raul](https://raul-profesor.github.io/DEAW/img/vps.gif)Fuente: [profesor Raúl](https://raul-profesor.github.io/DEAW/debian_teoria/)

Para el trabajo en clase utilizaremos un servidor vps basado en los siguientes proveedores:
+ AWS
+ [Azure](https://portal.azure.com/#home)
+ Otros

Se reseñan los 2 primeros dado que nuestra organización `@iescastelar.com` tiene cuenta educativa con ellos y podéis generar instancias de máquinas virtuales de forma gratuíta (con algunas limitaciones) sin proporcionar tarjetas de crédito.

Algunos otros proveedores como [**Oracle**](https://www.oracle.com/es/cloud/free/) o AWS también ofrecen instancias gratuítas (**fuera** de España) pero requieren proporcionar tarjetas de crédito/débito (no prepago). 

La ventaja de realizarlo sin cuenta educativa es que será permanente ya que no requiere que renovéis anualmente.

## Otros servidores de despliegue:
**Con opciones gratis:**
+ [Render](https://render.com/)
  + backend: python, nodeJs
  + frontend: ¿todos?
  + db: PostgreSQL, Redis, MySQL
  + docker
  + ¿sin VPS?
+ [Google Cloud](https://cloud.google.com/free/?hl=es_419) (VPS e2-micro + otros + $300/90d)

**Low-cost**
+ [PiensaSOLUTIONS](https://www.piensasolutions.com/vps) (VPS desde 1€/mes)

**Con crédito gratis:**
+ [DigitalOcean](https://www.digitalocean.com/pricing) ($200/60d)
+ [IBM Cloud](https://www.ibm.com/cloud/free) (VPS 30 días + otros Always Free)


**[Referencias Free-Hosting](https://github.com/cloudcommunity/Free-Hosting)**