---
title: "Servicios en red"
keywords:
  - DNS
  - LDAP
author:
  - Luis Ferreira
---
#curso24_25 #deapweb [estado::ToDo]


# Servidor de Nombres de Dominio -DNS-

Duración: 5 horas.

## Teoría
1. Textos planos `/etc/hosts`
2. Sistema jerárquico

 ![TopLevelDomains](https://i.blogs.es/2bba3c/arboldns/1366_2000.webp)
	
 **Organización de servidores:**
  + partiendo de los servidores `root` que son los `.` (dot).

    _Puesto que TODAS las rutas SIEMPRE deben hacer referencia al dominio raiz, no es necesario ponerlo._
  + posteriormente tenemos los Top Level Domains -tld- que tenemos de 2 tipos: geográficos (`.es.`, `.fr.`, `.pt.`, ...) y específicos (`.com.`, `.org.`, `.tv.`, ...).
	+ después tenemos los de segundo nivel, los denominados dominios, p.e. `google.es.`, `duckdns.org.`
	+ los subdominios, p.e. `luiscastelar.duckdns.org.` o `mail.google.com.`.
	+ límites:
		* Cada nodo del árbol se llama nombre de dominio y tiene una etiqueta con una longitud máxima de 63 caracteres.
		* La profundidad máxima de una estructura arbórea es 127 niveles y la longitud máxima para un nombre es de 255 caracteres (incluído el punto final **obligatorio**).
	    * El nombre absoluto de un equipo -FQDN- está relacionado con todas las etiquetas de nodo y que termina con un punto final (`root`)
4. Mecanismo de funcionamiento:
	![DNS Iterativo](https://media.geeksforgeeks.org/wp-content/uploads/20220713172800/RecursiveDNS1.png)

*Nota: En la figura se combinan la solicitud recursiva del usuario y la iterativa del resolver.*

*Bibliografía*: [CIFP Rodolfo Ucha](https://wiki.cifprodolfoucha.es/index.php?title=Teor%C3%ADa_sobre_o_Servizo_de_nomes_de_dominio)

## Cliente DNS:
Jerarquía de resolución:
1. Archivo `/etc/hosts`:
  
  Fichero para la resolución estática de nombres (normalmente de la red local).
  
  Incluye nuevas líneas en este fichero para la resolución de nombres de la red local. Las líneas de /etc/hosts tienen el formato:
  ```yaml
  # dirección_IP nombre_largo nombre_corto
  127.0.0.1		localhost.localdomain localhost miPropioEquipo
  192.168.60.100	sauron.mordor.com sauron
  # bannear a youtuble
  127.0.0.2		youtube.com 
  ```
  
  Comprueba su funcionamiento haciendo ping a las máquinas que has incluido.
  
  *Nota*: en Windows el archivo es `C:\Windows\System32\drivers\etc\hosts`.
  
  *Nota 2: Firefox no respeta el uso de este archivo.*

2. Servicio DNS indicado en `/etc/resolv.conf`

  Fichero que especifica los servidores DNS y los dominios de búsqueda... salvo que en las nuevas versiones de S.O.s basados en Gnu/Linux ya no podemos editarlo directamente. El archivo es controlado por `systemd`.

  Ahora:
  1. Modificar archivo `/etc/system/resolved.conf`
  2. Enlazar el sistema *antiguo* `sudo ln -sf /run/systemd/resolve/resolv.conf /etc/resolv.conf`
  3. Reiniciar servicio:
     + `sudo systemctl stop systemd-resolved`
     + `sudo systemctl start systemd-resolved`
  
  >Nota: En cierta bibliografía aparecerá como `sudo systemctl stop systemd-resolved.service`. Deberéis saber que `systemd` toma por defecto *.service* si se omite el tipo de *demonio* (service, socket, ...)

## Servidor DNS

### DnsMasq:
Archivo de configuración:
```yaml
services:
  dns:
    ports:
      - 53:53/udp
      - 5380:8080
    volumes:
      - ./dnsmasq.conf:/etc/dnsmasq.conf
    logging:
      driver: "json-file"
      options:
        max-size: "10m"
        #max-file: "10"
    environment:
      - "HTTP_USER=foo"
      - "HTTP_PASS=bar"
    restart: always
    image: jpillora/dnsmasq
```

Ésto fallará ya que no tenemos el archivo `dnsmasq.conf` por lo que primero debemos levantarlo con el volumen desactivado y capturamos su contenido con `docker exec -it dnsmasq-dns-1 cat /etc/dnsmasq.conf > dnsmasq.conf`

Después podremos añadir nuestros equipos de zona o incluso capturar equipos que no queremos que sean accesibles:
```conf
...
address=/profesor.local/192.168.60.100
address=/youtube.com/127.0.0.1
address=/marca.com/127.0.0.1

address=/ut4.midominio.duckdns.org/10.0.0.100
```

> [!NOTE]
> Los dominios `.local` son dominios reservados para redes locales con lo que podemos utilizarlos sin peligro a ocultamientos.

### Probarlo
* En GNU/Linux con `dig [@servidor] FQDN` o sólo `dig FQDN`.
* En Windows con `nslookup [-opcion] [host] [servidor]`.


### Registros DNS
[Resumen de registros](https://www.ionos.es/digitalguide/hosting/cuestiones-tecnicas/registros-dns/)

### Servidores internos
Los servidores de DNS internos son de gran utilidad para llevar un inventario de equipos en la red local y poder acceder a los mismos a través de nombres sencillos y no de depender de IPs que puedan variar en el tiempo o colisionar.

Además, son de gran utilidad para solventar los problemas de `HairPin NAT`, `NAT reverso` o `NAT loopback`, esto es, cuando queremos acceder a servicios públicos que están en nuestra misma red.
![hairpin](https://supportportal.juniper.net/sfc/servlet.shepherd/version/renditionDownload?rendition=ORIGINAL_Png&versionId=0683c00000LUw1qAAD&operationContext=CHATTER)

## Referencias webgráficas
+ [ngi.es](https://www.ngi.es/configurar-servidor-dns-con-dnsmasq/)
+ [Jose Domingo Muñoz](https://www.josedomingo.org/pledin/2020/12/servidor-dns-dnsmasq/)
+ [DNS contra contenedores docker](https://dev.to/karlredman/dnsmasq--networkmanager--private-network-setup-258l)


## Prácticas
### P1 - Servidor DNS
Montar un servidor de DNS que resuelva las IPs de 1 compañero, la del profesor y un registro MX.  \
Pasos:
1. Tener una máquina `Vagrant` con IP pública y estática, y `docker`.
2. Instalar y configurar como microservicio el servidor `dnsmasq` de forma que resuelva lo solicitado.

*Nota: los ficheros de configuración de `dnsmasq` se encuentran en `/etc/dnsmasq.conf`*


### P2 - Balanceador de carga por DNS
Sigue las instrucciones para realizar un balanceo básico con un servidor DNS.
[Jose Domingo Muñoz](https://www.josedomingo.org/pledin/2022/02/dns-balanceo-carga/)

*Nota: Requieres 3 contenedores (2 nginx y un dnsmasq) y una red.*

# LDAP - Protocolo Ligero de Acceso a Directorios

1. [Teoría](https://www.redeszone.net/tutoriales/servidores/que-es-ldap-funcionamiento/)
2. Limitaciones:
   + Se requieren un mínimo de 2 servidores LDAP para establecer el servicio mínimamente confiable. Ten en cuenta que si uno falla la organización completa se queda sin acceso.
   + Los servidores deben implementarse sobre máquinas físicas SIEMPRE. Ten en cuenta que si no el servidor que soporta dichas máquinas virtuales no podría estar dentro de la organización.
  
_Nota: Active Directory de `Microsoft` es sólo una de las posibles implementaciones de LDAP._

_Nota 2: Las GPO’s que establecemos en `AD` (o cualquier otro LDAP) son sólo válidas para equipos cliente `Windows`._

## Autenticación de accesos Apache por LDAP
Tarea libre de validación [paso a paso](https://medium.com/@uri.tau/apache-and-ldap-cc7bff1f629d).


## Práctica
Partiendo de lo anterior, montad un servidor que autentique vía LDAP el acceso a un directorio dado.

La práctica se realizará por parejas compuestas por alumno/a que provenga del grado medio de SMR y alumno/a que provenga de bachillerato o universidad.

