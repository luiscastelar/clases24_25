#curso24_25 #deapweb [estado:: TODO] 

# Bases del despliegue.
==Añadir==
## Arquitecturas web.
## Protocolos.
        *   [ ]  Http
        *   [ ]  Https
        *   [ ]  TCP/IP
            *   [ ]  IPv4
            *   [ ]  IPv6



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
## `docker compose`
## `Dockerfile`


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
Para el trabajo en clase utilizaremos un servidor vps basado en los siguientes proveedores:
+ AWS
+ Azure
+ Otros

Se reseñan los 2 primeros dado que nuestra organización `@iescastelar.com` tiene cuenta educativa con ellos y podéis generar instancias de máquinas virtuales de forma gratuíta (con algunas limitaciones) sin proporcionar tarjetas de crédito.

Algunos otros proveedores como Oracle o AWS también ofrecen instancias gratuítas (fuera de España) pero requieren proporcionar tarjetas de crédito/débito (no prepago). 

La ventaja de realizarlo sin cuenta educativa es que será permanente ya que no requiere que renovéis anualmente.