#curso24_25 #común #deapweb [estado:: Done]


> **Vagrant** es un software de código abierto que nos permite crear y mantener entornos de desarrollo portables, puede trabajar con VMware, VirtualBox, Hyper-V, KVM, AWS e incluso también con contenedores de Docker, por tanto, es ideal para simplificar la configuración de estos software de virtualización.

En otras palabras, nos permite gestionar máquinas virtuales desde código...

1. [Buscar y descargar la base](https://portal.cloud.hashicorp.com/vagrant/discover?query=generic)
2. Generar archivo base con `vagrant init generic/alpine318`
3. Arrancar la máquina virtual (y generarla si es necesario)`vagrant up`
4. Actualizar la configuración de la máquina `vagrant provision` o `vagrant up --provision`
5. Detener la máquina `vagrant halt`
6. Eliminar la máquina `vagrant destroy`


## ==Trabajo en casa== (FC)
Investigar en la web como generar el archivo `Vagrantfile` con las características que vamos a desarrollar en clase.


## En clase:
Hacer los archivos `Vagrantfile` (7 distintos) que resuelva los siguientes supuestos:
1. Añadir una segunda interfaz de red
2. Ponerla en modo `bridge`
3. Añadir 2 mv en un sólo fichero
4. Conectar esas 2 mv en una red interna
5. Limitar el uso de ram a 512MB
6. Limitar el uso de cores a 1
7. Instalar el paquete `git` en una de las mv

*Tip:* A veces desde el centro puede tardar en devolvernos la terminal, pero en muchas ocasiones estará disponible para el acceso aunque no al 100%.



#### UUID
  Uno de los problemas que podemos tener al generar varias máquinas partiendo desde el mismo box base es que las mismas pueden tener el mismo uuid (machine-id) por lo que al solicitar ip al servidor DHCP pudiera ser que obtengan la misma IP (no todos los dhcp tienen esta funcionalidad).

  Para solucionarlo podemos generar un nuevo uuid por una vez y ya tendríamos suficiente, aunque lo ideal será añadirlo al fichero de `provision` con lo que nos aseguraremos que será ejecutado cada vez que recreemos la `vm`.

```bash
# Generar nuevo uuid
     rm -f /etc/machine-id`
     dbus-uuidgen --ensure=/etc/machine-id

# Obtenemos nueva IP del DHCP
     dhclient -r eth1
     dhclient eth1
     ip link set eth1 down
     ip link set eth1 up

# Fuente: David G.S. - Alumno de ASIR2 curso 23/24
```



#### Referencias: 
+ [Manual completo - Friends of Vagrant](https://friendsofvagrant.github.io/v1/docs/boxes.html)
+ [Get Started - Vagrant](https://developer.hashicorp.com/vagrant/tutorials/getting-started)
+ [Vagrant Boxes](https://app.vagrantup.com/boxes/search?provider=virtualbox)
+ [Repositorio externo de BOXes](https://github.com/acntech/vagrant-repository)


