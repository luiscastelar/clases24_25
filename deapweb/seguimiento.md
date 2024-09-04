#curso24_25 #deapweb


# T0. Herramientas y repaso
10 h -> 16s a 29s

+ [ ] Control de versiones -> **GIT**
+ [ ] Lenguaje de marcado ligero para representación -> **Markdown**
+ [ ] Virtualización asistida -> **Vagrant**

*Git y Markdown asociados a RA6 y Vagrant asociado a RA1*.


# T1. Implantación de arquitecturas web
15 h -> 30s a 20o

+ [ ] Bases del despliegue (a, b, f):
  + [ ] Arquitecturas web
  + [ ] Protocolos:
    + [ ] Http
    + [ ] Https
    + [ ] TCP/IP
      + [ ] IPv4
      + [ ] IPv6
+ [ ] Contenedores (“virtualización” ligera) -> **Docker** (e, f, h, i)
  + [ ] `docker` CLI
  + [ ] `docker compose`
  + [ ] `Dockerfile`
+ [ ] Servidor web (c, f, h, i)
+ [ ] Servidor de aplicaciones (d, f, h, i)
+ [ ] Servidores en la nube (vps) (e, f, h, i)

## Tareas:
1. Documentar los procesos.
2. Implementar los procesos documentados por un compañero.

*Asociado al RA1*.


# T2. Servidores WEB
15h -> 21o a 10n

+ [ ] Servidor web Apache (a, b, c, d, g, i)
+ [ ] Servidor web Nginx (a, b, c, d, g, i)
+ [ ] Proxy (e, f, g, i)
+ [ ] Implantación aplicación Angular/React (h, i)
+ [ ] Monitorización (j)

*Asociado al RA2*.


# T3. Servidor de aplicaciones
10h -> 11n a 24n

+ [ ] Contenedor de aplicaciones Tomcat (a, b, c, d, e, h, i)
+ [ ] Despliege de aplicación web Servlet/Spring/Quarkus (f, g, h, i)

*Asociado al RA3*.


# T4. Gestión de servidores y archivos
10h -> 25n a 8d
+ [ ] FTP (a, b, c, d, g)
+ [ ] Acceso remoto seguro - SSH (e, g)
  + [ ] Bastionado SSH:
    + [ ] pares de llaves
    + [ ] fail2ban

+ [ ] Repositorios BARE (f, g, h)
  + [ ] CI/CD

*Asociado a los RA4 y RA6*.


# T5. Servicios de red
10h -> 9d a 20d
+ [ ] DNS (a, b, g, h)
+ [ ] LDAP (c, d, g, h)
+ [ ] nginx con LDAP (e, f, g, h)

*Asociado a RA5*.


# Proyecto integrador:
## Alumnos Dual (16h)
Despliegue de una aplicación web (front, back y persistencia) sobre nube pública o vps accesible públicamente desde internet.

## Alumnos NO Dual (40h)
Despliegue de aplicaciones web (front, back y persistencia) sobre nube pública o vps accesible públicamente desde internet:
+ Front:
  + Html5 + JS + Ajax
  + Laravel
  + Angular
  + React
  + Otra
+ Back:
  + Servlet
  + Spring
  + Quarkus
  + Node.js
  + Laravel
  + Otra
+ Persistencia:
  + Mysql
  + PostgreSQL
  + Firebase
  + Supabase
  + Otra

**Duración: 100 horas.**


# Contenidos:

## Contenidos mínimos:
+ Sitios web estáticos y dinámicos.
+ Aplicaciones web.
+ Servicios web.
+ Servidores de nombres. Tipos.
+ Registros DNS.
+ Zona directa e inversa.
+ Servidores web. Instalación.
+ Ficheros y parámetros de configuración de servidores.
+ Servidores virtuales.
+ Establecimiento de conexiones seguras HTTPS.
+ Configurando CORS.
+ Instalación y funcionamiento de FTP.
+ Git. Funcionamiento.
+ Git. Trabajo con ramas y en remoto.
+ Git BARE.
+ CI/CD con hooks de Git
+ Docker. Instalación y componentes.
+ Docker. Ciclo de vida de los contenedores.
+ DockerFile y DockerCompose.
+ JavaEE y JakartaEE.
+ Servidor/Contenedor de aplicaciones (Tomcat).
+ Despliegue de aplicaciones en un entorno de red en un servidor Linux.
+ Despliegue en la nube.
  

## **Contenidos básicos:**

Implantación de arquitecturas web:

− Arquitecturas web. Modelos.

− Servidores web y de aplicaciones. Instalación y configuración básica.

− Tecnologías de virtualización de servidores en la nube y en contenedores. Instalación y configuración básica.

− Estructura y recursos que componen una aplicación web.

− Documentación de los procesos realizados.

Administración de servidores web:

− Configuración avanzada del servidor web.

− Módulos: instalación, configuración y uso.

− Hosts virtuales. Creación, configuración y utilización.

− Autenticación y control de acceso.

− El protocolo HTTPS.

− Certificados. Servidores de certificados.

− Documentación.

− Despliegue de aplicaciones sobre servidores web.

− Despliegue de servidores web mediante tecnologías de virtualización en la nube y en contenedores.

− Conjuntos de herramientas de gestión de logs. Instalación, configuración y utilización, para la ayuda a la toma de decisiones: Big Data.

Administración de servidores de aplicaciones:

− Arquitectura y configuración básica del servidor de aplicaciones.

− Administrar aplicaciones web.

− Autenticación de usuarios. Dominios de seguridad para la autenticación.

− Administración de sesiones.

− Configurar el servidor de aplicaciones para cooperar con servidores web.

− Despliegue de aplicaciones en el servidor de aplicaciones.

− Seguridad en el servidor de aplicaciones.

− Documentación.

− Despliegue de servidores de aplicaciones mediante tecnologías de virtualización en la nube y en contenedores.

Instalación y administración de servidores de transferencia de archivos:

− Configuración del servicio de transferencia de archivos. Permisos y cuotas.

− Tipos de usuarios y accesos al servicio.

− Modos de conexión del cliente.

− Protocolo seguro de transferencia de archivos.

− Utilización de comandos y de herramientas gráficas.

− Utilización del servicio de transferencia de archivos en el proceso de despliegue de la aplicación web.

− Documentación.

− Despliegue de servidores de transferencia de archivos mediante tecnologías de virtualización en la nube y en contenedores.

Servicios de red implicados en el despliegue de una aplicación web:

− Resolutores de nombres. Proceso de resolución de un nombre de dominio.

− Parámetros de configuración y registros del servidor de nombres afectados en el despliegue.

− Servicio de directorios: características y funcionalidad.

− Archivos básicos de configuración.

− Autenticación de usuarios en el servicio de directorios.

− Adaptación de la configuración del servidor de directorios para el despliegue de la aplicación.

− Documentación.

− Despliegue de servidores de directorios mediante tecnologías de virtualización en la nube y en contenedores.

Documentación, sistemas de control de versiones y de integración continua:

− Herramientas colaborativas para la generación de documentación. Instalación, configuración y USO.

− Creación y utilización de plantillas.

− Instalación, configuración y uso de sistemas de control de versiones.

− Operaciones avanzadas.

− Seguridad de los sistemas de control de versiones.

− Instalación, configuración y uso de sistemas de integración continua del código. Monitorización continua de las métricas de calidad de la aplicación.

