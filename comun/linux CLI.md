#curso24_25 #común #deapweb #sad [estado:: Working]

# Pipes:
Investiga:
```bash
echo “hola” > uno.txt
cat uno.txt | tee dos.txt
echo “adios” >> uno.txt
cat uno.txt dos.txt
cat <<-EOF > tres.txt
hola mundo
EOF
cat tres.txt
cat uno.txt <(cat tres.txt)
cat tres.txt | cat - uno.txt
```

Errores:
```bash
ls no_existe
ls no_existe 2> error.txt
cat error.txt
ls no_existe 2> /dev/null
```
Nota:
+ 1> es equivalente a > y es la salida. Si no se indica se utiliza la _standard_ (monitor).
+ 2> es la salida de error. Si no se indica se utiliza la _standad_.
+ 2>&1 conecta ambas salidas al descriptor indicado.


# Archivos y directorios:
| Coman. | Descripción |
|--------|-------------|
| ls | listar |
| cd | change directory |
| pwd | print working directory |
| rm | remove file o directory **No pregunta** | 
| cp | copy |
| mv | move/rename |
| cat | “vuelca” contenido archivo |
| tail | muestra últimas líneas |

# Permisos:
| Coman. | Descripción |
|--------|-------------|
| chmod | change permisos `chmod u+x {{archivo}}` |
| chown | change ownership (propietario) |
| sudo | switch user do -> ejecuta como otro usuario |

# Process
| Coman. | Descripción |
|--------|-------------|
| ps | mostrar processos `ps aux` (ojo sin `-`) |
| top | monitor de sistema |
| kill | mata (con katana) `kill -9 {{proc}}` |



# System Info
| Coman. | Descripción |
|--------|-------------|
| free | muestra uso de memoria `free -h` |


# Network
| Coman. | Descripción |
|--------|-------------|
| ping | ping - pong |
| ss | network socket `ss -putlan` |
| ss | network socket `ss -eltapon` |


# Remoto
| Coman. | Descripción |
|--------|-------------|
| ssh | secure shell |
| scp | secure cp |
| rsync | sincroniza directorios |
| curl | lanza peticiones http y ftp |

**Especial SSH:**
1. [Vídeo básico ssh](https://www.youtube.com/watch?v=RMS5zBYQIqA&pp=ygUOcGVsYW8gbmVyZCBzc2g%3D)
2. [Parte 2](https://www.youtube.com/watch?v=IDDmqlN-hF0&pp=ygUOcGVsYW8gbmVyZCBzc2g%3D)
3. [Parte 3](https://www.youtube.com/watch?v=ZHSGGG_WwUs&pp=ygUOcGVsYW8gbmVyZCBzc2g%3D)


---
# Ampliación:
| Coman. | Descripción |
|--------|-------------|
| ln | create link to file |
| touch | crea archivo vacio |
| head | muestra primeras líneas |
| find | buscar archivos y dir |
| | |
| kill | apaga proceso `kill {{proceso}}` |
| kill | interrumpe proceso `kill -2 {{proc}}` |
| kill | solicita parar proceso `kill -15 {{proc}}` |
| kill | solicita congelar proceso `kill -19 {{proc}}` |
| kill | solicita restaurar proceso `kill -18 {{proc}}` |
| | |
| grep | buscar EN archivos |
| | |
| du | muestra uso disco |

+ [**Ampliación**](https://www.geeksforgeeks.org/linux-commands-cheat-sheet/)
+ [Hoja resúmen](https://phoenixnap.com/kb/wp-content/uploads/2023/11/linux-commands-cheat-sheet-pdf.pdf)
+ [Pelao Nerd](https://youtu.be/0BA4k3jweaE?si=EivnGioae7QBAz1v)
  