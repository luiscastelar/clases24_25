#curso24_25 #deapweb [estado:: Done] 

# Control de versiones -> GIT
> Git es un software de control de versiones diseñado por Linus Torvalds, pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones cuando estas tienen un gran número de archivos de código fuente.

+ [Básico](https://github.com/luiscastelar/clases24_25/blob/main/comun/GIT.md)
+ [Medio](https://github.com/luiscastelar/clases24_25/blob/main/comun/GIT-ramas.md)

# Lenguaje de marcado ligero para representación -> Markdown
+ [Doc **OFICIAL**](https://www.markdownguide.org/basic-syntax)
+ [Doc español](https://markdown.es/sintaxis-markdown/)
+ [Cheat-sheet](https://www.markdownguide.org/cheat-sheet)
+ [Tablas en md](https://www.tablesgenerator.com/markdown_tables)
+ [Resúmen en vídeo](https://www.youtube.com/watch?v=oxaH9CFpeEE)

Puedes ver ejemplos pasando al modo *Code* cualquier archivo de este repositorio.

# Virtualización asistida -> Vagrant
> **Vagrant** es un software de código abierto que nos permite crear y mantener entornos de desarrollo portables, puede trabajar con VMware, VirtualBox, Hyper-V, KVM, AWS e incluso también con contenedores de Docker, por tanto, es ideal para simplificar la configuración de estos software de virtualización.

[Básico](https://github.com/luiscastelar/clases24_25/blob/main/comun/Vagrant.md)


# Introducción a los Contenedores o ~~Virtualización LIGERA~~:

### LXC y LXD:

*Linux Containers* y *Linux Conteiner Daemon* son una herramienta de creación de contenedores Linux bajo entornos Linux y una Herramienta de gestión de LXC respectivamente. Esto es, LXD es una abstracción de LXC.

¿Pero que són los LXC?

![portada](https://luiscastelar.duckdns.org/2023/assets/vm-vs-lxc.png)
[Algo de info](https://www.josedomingo.org/pledin/2022/11/introduccion-lxd/)


### Docker
![otra](https://luiscastelar.duckdns.org/2023/assets/hypervisor1-vs-lxc-vs-docker.png)

LXC virtualiza sistemas completos (mismo núcleo que el host) y Docker aplicaciones. 

En ocasiones Docker cede el control a aplicaciones sin sistema operativo (a menudo en Rust).



#### Podman
Es otro motor de contenedores similar a docker pero con interesantes características, por ejemplo:
+ **No requiere permisos de root**. No hay *demonio* en segundo plano. Ésto es bueno en torno a seguridad pero requiere que nosotros gestionemos el encendido de los contenedores, por ejemplo con *systemd*.
+ **Pod**: En podman tenemos un elemento intermedio llamado Pod que contiene uno o varios contenedores. Todos ellos comparten una misma IP.


#### Kubernetes (K8s, K3s, miniKube)
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