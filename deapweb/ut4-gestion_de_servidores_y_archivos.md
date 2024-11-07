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


# Git BARE

## Práctica de despliegue con git
