#curso24_25 #prog 

# Herramientas
1. Servidor: MariaDB sobre _Docker Desktop_, o xampp de forma subsidiaria.
2. `shell` o `dbGate`.

**Aviso:**
En esta unidad haremos uso de la base de datos MariaDB vía contenedor `docker` o `xampp`. 

Para la gestión de la misma utilizaremos indistintamente la `shell` o la aplicación `dbGate`.

Si el alumno conoce cualquier otra herramienta, `PhpMyAdmin` por ejemplo, es libre de utilizarla, pero puesto que la conoce no requiere soporte por parte del profesor.

# Primera conexión
Buscando los errores para reconocerlos y solucionarlos.

## Sin driver cargado:
Recibiremos el error `No suitable driver found for jdbc:mariadb://FQDN:PUERTO/db`

Deberemos cargar el driver mediante **maven** o **gradle**. Cualquier otro método implica un 0 en la calificación de esta unidad y los resultados de aprendizaje asociados por motivos de seguridad y mantenimiento en el tiempo.

Añadir al `pom.xml`:
```xml
<!-- https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client -->
<dependency>
    <groupId>org.mariadb.jdbc</groupId>
    <artifactId>mariadb-java-client</artifactId>
    <version>[3.5.2,)</version>
</dependency>
```

_Recuerda: el `[` indica que la versión mínima soportada es la indicada, y `,)` que la máxima está abierta. Si quisiéramos forzar a quedarse en la rama 3, por ejemplo, deberíamos indicar `[3.5.2,4.0)`._
   
## Sin conexión al servidor
Recibimos un error `Socket fail to connect to FQDN:PUERTO`

Deberemos comprobar que el socket es correcto y que no existe un firewall que impida el acceso. Nos ayudaremos del cliente gráfico `dbGate` o del `shell`.

### Depuración desde `shell`:
Dado que tenemos docker, con cada servidor nos instala además un cliente por lo que podemos utilizarlo para conectarnos a servidores de terceros. Para ello:
1. Nos metemos dentro del contenedor con el botón terminal del docker desktop o desde consola con `docker run --name maridb-shell --rm -it -e MARIADB_ROOT_PASSWORD=1111 mariadb /bin/bash`,
2. y una vez dentro `/bin/mariadb -h {{FQDN}} -P {{PUERTO}} -u {{USUARIO}} -p{{PASS}} -vvv {{db_uno}}`

## Acceso denegado
Ahora tenemos 2 opciones:
1. Usuario o pass mal: `Access denied for user 'usuario'@'123.123.123.123' (using password: YES)`
2. Sin premisos para la base de datos solicitada: `Access denied for user 'usuario'@'%' to database 'db_mia2'`

## Tabla no existe
Pues eso, que si no existe la tabla... `Table 'db_mia.persona' doesn't exist`, deberás crearla primero.

## Sentencias básicas SQL (mariaDB)
1. Ver bases de datos: `show databases;`
2. Conectar a una base de datos: `use database db_mia;`
3. Mostrar tablas: `show tables;`
4. Crear tablas:
   ```sql
   create table personas( 
      id SERIAL, 
      nombre VARCHAR(50) NOT NULL,
      fecha_nacimiento DATE NOT NULL,
      altura INT,
      sueldo DECIMAL(8,2) DEFAULT 1150
   );
   ```
   _Recuerda: SERIAL es un alias a BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE._
5. Mostrar estructura de la tabla `describe personas;`
6. Mostrar todos los registros de la tabla `select * from personas;`
7. Insertar registros ``INSERT INTO `personas` (`nombre`, `fecha_nacimiento`) VALUES ('Luis','2000/01/01');
INSERT INTO `personas` (`nombre`, `fecha_nacimiento`, `altura`) VALUES ('Pedro','2010/08/23','180');``

Con ésto tendríamos lo suficiente para comenzar a trabajar.

# Lanzando malas consultas
Sentencias + ejecución de consultas => Resultados: `Statemen` + `executeQuery( sql )` => `ResulSet`

1. Metadatos: cantidad de columnas, el nombre de las mismas, que tabla ofrece esa columna, ...
2. Datos: `rs.getX()`, ...



# Lanzando buenas consultas
Prepare + execute


# Fuentes
+ [BBDD - Pablo Alvarez Corredera](https://github.com/rosepac/daw-temario/blob/main/PROG/PR11.pdf)
+ Vídeos [Makigas](https://www.makigas.es/series/jdbc-moderno)