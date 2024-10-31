---
Title: Servidores de aplicaciones
Keywords: Servidor, Aplicación, JakartaEE, Laravel, Node.js, Flask
Author: Luis Ferreira
Date:   29 de octubre de 2024
---
#curso24_25 #deapweb [estado::ToDo]


# ¿Que es?

En informática, se denomina servidor de aplicaciones a un servidor en una red de computadores que ejecuta ciertas aplicaciones.

Usualmente se trata de un dispositivo de software que proporciona servicios de aplicación a las computadoras cliente. Un servidor de aplicaciones generalmente gestiona la mayor parte (o la totalidad) de
las funciones de lógica de negociación y de acceso a los datos de las aplicaciones. Los principales beneficios de la aplicación de la tecnología de servidores de aplicación son la centralización y la
disminución de la complejidad en el desarrollo de aplicaciones.

En el modelo de 3 capas (cliente-servidor-datos), el servidor de aplicaciones desarrolla el modelo de negocio y el acceso a los datos.

En la actualidad tenemos 4 _stacks_ tecnológicos dominantes:
+ _JakartaEE_: en especial el framework _Spring_, aunque otros como _Quarkus_ también asoma.
+ _PHP_: en especial el framework _Laravel_.
+ _Javascript_: con el servidor _Node.js_ como estándar de la industria, aunque muy pujantes los motores _Bun_ y _Deno_.
+ _Python_: con muchos frameworks disponibles de diversa índole, aunque destacan _django_ y _flask_.

Nos centraremos en las 3 primeras que son las tecnologías desarrolladas ampliamente en los módulos de Desarrollo Web en Entrono de Cliente y Desarrollo Web en Entorno de Servidor.


# JakartaEE
Los componentes más básicos (en los que nos centraremos) son las JSP y los Servlets, ambos distribuidos a menudo empaquetados en archivos `.war` análogos a los `.jar` de apicaciones Java SE.

Tecnologías Java de servidor como JSP y JSF realizan funciones similares a las realizadas por PHP, donde se entremezcla código Java y etiquetas HTML. Éstas habitualmente realizaban la implementación de la _vista_ en el _modelo-vista-controlador_.

Con el auge de Javascript y los frameworks (REACT, ANGULAR, VUE, ...), la capa _vista_ ha sido desplazada casi en la totalidad a dicha tecnología base.


## Opciones
Existen muchos muchos servidores de aplicaciones (Tomcat, TomEE, TomEE JAXRS, TomEE+, TomEE PluME, OpenEJB, Blowfish, WildFly, Jetty,...) y cada uno implementa algunas de las tecnologías estandarizadas por JakartaEE.

![jakarta10](https://blogs.eclipse.org/sites/default/files/users/user180/JEE10Specs.png)
Nosotros nos centraremos en _**Tomcat**_, aunque TomEE es muy similar al estar
construido sobre la base Tomcat.


## Paquetes _war_
Para entender la estructura básica de los archivos `.war` partiremos del war suministrado y lo desempaqeutaremos `jar -xvf paqueteEmpaquetado.war`.

Realizaremos modificación del nombre y volveremos a empaquetarlo con `jar cf nuevoPaquete.war *`.


## Práctica
Deberemos:
1. Crear una aplicación echo en _JakartaEE_.
2. Levantar un servidor _Tomcat_ que despliegue nuestra aplicación.
3. Crear una aplicación en _Spring_ utilizando _Spring Boot_.
4. Desplegarla

Deberemos subir los resultados a `ut3/jakartaEE`.


## WebUI
_Tomcat_ dispone de una interfaz de administración gráfica que podemos activar mediante modificación del archivo `tomcat-users.xml`, habilitándole el rol `manager-gui` y asignándoselo a un usuario.

Una vez modificada podremos acceder al él en `http://localhost:8888/manager/html`.


# Laravel
1. [Ventajas de Sails](https://medium.com/@AFelipeTrujillo/crear-contenedores-laravel-y-mysql-con-sails-ventajas-y-desventajas-ca5f0b57208e)
2. [Uso de Sails](https://mrashish75.medium.com/laravel-docker-vs-sail-680f59b9b94e)
3. [Paso a paso](https://desarrolloweb.com/articulos/laravel-sail)

> [!TIP]
> Para los que como a mí no nos guste tener que instalar nada, podemos hacer uso de los siguientes alias:
> + PHP: `alias php='docker run -u $(id -u):$(id -g) --rm -it -v $(pwd):/usr/src/myapp -w /usr/src/myapp php:8.2-cli php'`
> + COMPOSER: `alias composer='docker run -u $(id -u):$(id -g) --rm -it -v $(pwd):/app composer composer'
`

Tener en cuenta que podemos sustituir la versión de php según las siguientes características:
+ php-cli: para herramientas de cli
+ php-apache: lista para usar. Basada en Debian por lo que de gran tamaño.
+ php-fpm: para servir de intérprete a servidores (como _ningx_).
+ php-alpine: para versión compacta basada en _Alpine_.


También podemos levantar una app _Laravel_ via la [imágen de Bitnami](https://hub.docker.com/r/bitnami/laravel/).


## Práctica
Crea la aplicación “hola mundo” de _Laravel_ y sube los resultados a `ut3/laravel`.


# Node.js
1. Crear `server.js`:
  ```javascript
  const express = require('express')
  const app = express()
  const port = 3000
  
  app.get('/', (req, res) => {
    res.send('Hello World!')
  })
  
  app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
  })
  ```

2. Crear proyecto `npm init`
3. Instalar dependencias `npm install express`. Si nuestra aplicación no se llamara `server.js` deberemos añadir el _script_ start `"start": "node app.js"` al `package.json` (donde `app.js` es el nombre de la aplicación desarrollada).
4. Crear `Dockerfile`:
  ```Dockerfile
  # Utiliza una imagen base de Node.js mínima
  FROM node:alpine
  
  # Establece el directorio de trabajo en el directorio raíz de la imagen
  WORKDIR /usr/src/app
  
  # Copia el package.json y el archivo lock (si lo tienes)
  COPY package*.json ./
  
  # Instala las dependencias
  RUN npm install
  
  # Copia el resto de los archivos de la aplicación
  COPY . .
  
  # Exponer el puerto 3000
  EXPOSE 3000
  
  # Comando para iniciar la aplicación
  CMD [ "npm", "start" ]
  #ENTRYPOINT [ "node", "server.js" ]
  ```
  
  Con `CMD` nos permite sobreescribir el arranque y utilizar el contenedor para correr el _script_ de test si lo hubiera.

5. Crear `compose.yml`:
  ```yml
  services:
    cors:
      build:
        dockerfile: Dockerfile
        context: .
      ports:
        - "3000:3000"
      entrypoint: ["node", "server.js", "argumento1", "argumento2"]
  ```


## Práctica
Reproduce lo anterior y muestra el resultado. Súbela a `ut3/node.js`.


# Flask
1. Crear `app.py`:
   ```python
   # Importar librería
   from flask import Flask

   # Crear instancia a clase Flask
   app = Flask(__name__)

   # Asociar ruta a función
   @app.route("/")
   def hello_world():
     return "<p>Hello, World!</p>"
   ```
   
2. Crear `Dockerfile`:
   ```yml
    # Establecemos la imagen base de Python
    FROM python:bookworm
    
    # Definimos el directorio de trabajo
    WORKDIR /app
    
    # Copiamos los archivos de requerimientos y la aplicación
    COPY requirements.txt ./
    COPY app.py ./
    
    # Instalamos las dependencias
    RUN pip install -r requirements.txt
    
    # Exponemos el puerto 5000 para comunicarnos con la aplicación
    EXPOSE 5000
    
    # Definimos el comando de arranque
    CMD ["python", "-m", "flask", "run"]
   ```

   Donde `requirements.txt` contiene `flask` únicamente.
3. Crear `compose.yml`:
  ```yml
  services:
    app:
        build: .
        ports:
            - "5000:5000"
        environment:
            - FLASK_ENV=production
            - FLASK_APP=app.py
        command: flask run --host=0.0.0.0
  ```

  Tras cada cambio de la aplicación `app.py` deberemos reconstruir con `docker compose build` o más flexible montando un volumen.


## Práctica
Reproduce lo anterior y muestra el resultado. Súbela a `ut3/flask`.