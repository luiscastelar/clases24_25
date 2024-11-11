---
Title: Gestión de servidores y archivos
Keywords: Servidor, transferencias, despliegue, ftp, ssh, sftp, git BARE, hooks, CI/CD
Author: Luis Ferreira
Date:   7 de noviembre de 2024
---
#curso24_25 #deapweb [estado::Working]

# FTP
El `ftp` ha muerto 🥲. ¿Porqué? Porque los datos se transmiten en claro y tenemos `sftp` que es un “_wraper ftp_” sobre un tunel `ssh`.

Así que JAMAS debemos usar FTP ya que todos los servidores hoy soportan `sftp`.



# SSH: Cliente, servidor y bastionado


## Clientes
+ En Windows: normalmente con `puTTY`, pero si tienes `git` te instala `minTTY`, aunque con `PowerShell` viene integrado un cliente.

  >[!CAUTION]
  >Recuerda que la separación de rutas en windows es `\`, pero en entornos UN*X es `/`, y que las unidades están bajo el paraguas de la raíz (`/`).
  
+ En GNU/Linux: viene de "serie" `openssh`. Ejecución:
  - `ssh [USUARIO]@HOST [-p PUERTO]` -> Tunel SSH normal.
  - `ssh [USUARIO]@HOST [-ND PROXY_SOCKS]` -> Proxy SOCKS
  - `ssh [USUARIO]@HOST [-R PUERTO:SOCKET]` -> tunel inverso.
  - `ssh [USUARIO]@HOST [COMANDO_REMOTO]`-> Ejecuta el comando remoto y nos devuelve el resultado de salida `standard` remota en la salida `standard` local.

La configuración de usuario se guarda en `~/.ssh/` (config, host conocidos, llaves y host autorizados).
La configuración del cliente se guarda en `/etc/ssh/ssh_config`. Ejemplo:
```ini
Host website
        Hostname 275.128.172.46
        User alice
        Port 1500
Host forum-server
        Hostname 275.128.172.47
        User alice

Host main-server
        Hostname 275.128.172.49

Host common-test-server
        Hostname test-server

Host *
        User root
```

Luego podemos reescribir algunas opciones con `ssh -o "User=bob" website`.


## Servidores:
+ En Windows: Windows Server 2019 es instalable y puede controlarse remotamente gracias a ello.
+ En GNU/Linux: se instala `openssh-server`. En entornos `systemd` se controla con `sudo systemctl COMANDO sshd`.
  
  La configuración se almacena en `/etc/ssh/sshd_config`, con la 'd' final de `daemon` que es sinónimo de **servicio**.


### Bastionado:
Comencemos por lo [más básico](https://linuxhandbook.com/ssh-hardening-tips/).

Siendo fundamental la desactivación por contraseña simple. Dos opciones: pares de llaves o doble factor de autenticación.

A pesar de lo anterior, deberemos recurrir a Fail2ban para minimizar ataques por fuerza bruta.
#### Fail2ban
+ [Doc OFICIAL](https://www.fail2ban.org/wiki/index.php/MANUAL_0_8#Introduction)
+ [Guía completa](http://albertomagallon.es/fail2ban-bastionado-de-servicios-remotos-en-linux/)
+ [Guía](https://www.ionos.es/digitalguide/servidores/seguridad/fail2ban-la-herramienta-ideal-para-proteger-tu-servidor/)


### ~~Port-knoking~~
Otra de las técnicas puede ser el port-knoking, aunque sólo en aquellos sitios donde no sea posible métodos más seguros.
+ [Guía](https://www.tecmint.com/port-knocking-to-secure-ssh/)
+ [Guía esp](https://rm-rf.es/port-knocking-en-debian-con-knockd/)

## sftp
Secure File Transfer Program. es un ... Interactive program to copy files between hosts over SSH.For non-interactive file transfers, see scp or rsync. More information: https://manned.org/sftp.

+ Connect to a remote server and enter an interactive command mode: `sftp {{remote_user}}@{{remote_host}}`
+ Connect using an alternate port: `sftp -P {{remote_port}} {{remote_user}}@{{remote_host}}`
+ Connect using a predefined host (in ~/.ssh/config): `sftp {{host}}`
+ Transfer remote file to the local system: `get {{/path/remote_file}}`
+ Transfer local file to the remote system: `put {{/path/local_file}}`
+ Transfer remote directory to the local system recursively (works with put too): `get -R {{/path/remote_directory}}`
+ Get list of files on local machine: `lls`
+ Get list of files on remote machine: `ls`

## scp
Secure Copy:
```bash
scp -r /path/origen usr@fqdn:/path/destino
scp -r /path/origen usr@fqdn:~/destino
scp -r usr@fqdn:/path/origen /path/destino
scp -r usr@fqdn:~/origen /path/destino
```

Sin `-r` para copia de archivos no recursiva.

## rsync
Sincronización remota:
```bash
rsync -avzP /path/origen usr@fqdn:/path/destino
```

+ `-a` -> archive
+ `-v` -> verboso
+ `-z` -> comprimido
+ `-P` -> mostrar progreso

Permite excluir archivos o cargar una lista a excluir mediante archivo.txt


## ~~Práctica Fail2ban~~
Pondremos en marcha un fail2ban que inmunice nuestro servidor de ataques de fueraza bruta.

Para ello deberemos localizar los archivos de logs y configurar fail2ban para realizar baneos de atacantes.

Entrega en `ut4/fail2ban`

Gestión del servicio:
+  Ver estado: `systemclt status fail2ban`
+  Activar: `systemclt start fail2ban`
+  Habilitar (al inicio): `systemclt enable fail2ban`
+  Deshabilitar: `systemclt disable fail2ban`
+  Para: `systemclt stop fail2ban`
+  Recargar configuración: `systemclt reload fail2ban`
+  Reiniciar: `systemclt restart fail2ban`

Copiar el archivo `jail.conf` a `jail.local` y personalizarlo:
```ini
# Parte general
[DEFAULT]
bantime = 3h 
findtime = 30m
maxretry = 3

backend = auto

protocol = all

# Accion -> Reject:
#banaction = iptables-multiport
#banaction_allports = iptables-allports
# Drop:
banaction = iptables-multiport[blocktype=DROP]
banaction_allports = iptables-allports[blocktype=DROP]

# En cada jail
[sshd]
enabled = true
port = ssh
# port = ssh,2022 si el servicio funciona en este puerto

# Esto puede ir en el general o en los jail que deseemos:
bantime = 1h
bantime.increment = true
# default factor (causes increment - 1h -> 1d 2d 4d 8d 16d 32d ...):
bantime.factor = 24
# max banning time = 5 week:
bantime.maxtime = 16w
```

Cambiar a **`backend = systemd`** para systemas sin archivo `/var/log/auth.log`, que funcionan con `systemd` y por tanto con `journalctl`.

**REJECT vs DROP**: la primera rechaza las conexiones, la segunda las descarta. El “atacante” de la primera recibe el rechazo y en la segunda es ignorado.

Aporta menos información y además evita tener que procesar nuevas peticiones con lo que es más seguro a un ataque DDoS.

> [!TIP]
> Para la práctica poner el `bantime` a 2 minutos para probar rápido si banea-desbanea correctamente.

Luego tenemos modos más agresivos de filtrado para protecciones extra: ddos, extra y aggressive.


# Git BARE

## Práctica de despliegue con git
[Leer detenidamente](https://hardfloat.es//blog/2021/03/23/desplegar-aplicaciones-con-git.html) y seguir las instrucciones **adaptando** a vuestra situación.

Deberéis:
1. Crear en local un servidor web que sirva un archivo con vuestro nombre.
2. Conectar con un servidor web remoto siguiendo las instrucciones de git Bare + hook
3. Llamarme que os pediré realizar un cambio y que lo pongáis en producción.

_Evidentemente, el servidor remoto debe estar expuesto al mundo, y como estamos en la unidad 4, pues la dirección será `ut4.VUESTRO_SUBDOMINIO.duckdns.org`_.

**TODOS** los archivos implicados en esta práctica deberán estar subidos a REPO/`ut4/practica`, así como la memoria `README.md` con la explicación detallada del proceso. 

Como hablamos, duckdns ha estado dando algunos problemas de fiabilidad por lo que os recomendaría que buscarais un sustituto en _freeDNS_.
