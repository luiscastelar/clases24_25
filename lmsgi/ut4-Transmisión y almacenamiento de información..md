#curso24_25 #lmsgi [estado::Done]


# XML
![estructura](https://www.ticarte.com/sites/su/users/7/image/grafos_documento.png)

[Curso XML](https://www.eniun.com/curso-xml/)

## Ejercicio
Dado el esquema anterior, crea el XML que lo implemente.



## DTD
El Documento de Definición de Tipos o DTD (Document Type Defintion) por sus siglas inglesas:
![esquema](https://github.com/luiscastelar/clases24_25/blob/main/lmsgi/assets/agenda.png?raw=true)
[Creación de un DTD](https://www.youtube.com/watch?v=fPU1ex7bSgg) y su incorporación al [XML](https://www.youtube.com/watch?v=4NB89iXyxMU).

### Elementos
+ `EMPTY`: nada
+ `PCDATA`: texto en claro
+ `ANY`: cualquier tipo
+ nodos: elementos de otro tipo (complejos)

**Cantidades**:
+ Nada -> 1
+ ? -> 0 o 1
+ \+ -> 1 o más
+ \* -> 0 o más
+ | -> enumerado

[Vídeo](https://www.youtube.com/watch?v=ryoW-B_6cGs)



## Xpath
[Lenguaje de consultas Xpath](https://www.eniun.com/tutorial-xpath/)

[Introducción a Xpath](https://howtodoinjava.com/java/xml/convert-xml-to-properties/) para realizar consultas sobre diccionarios XML

### Funciones
+ Suma: `sum(//price)` (valor redondeado).
+ Cuenta: `count(//title)`

En Xpath v2:
+ Mínimo: `min(//book/price)`
+ Máximo: `max(//book/price)`
+ Media: `avg(//book/price)`


### Referencias
+ [Consultas](https://docs.mendix.com/refguide8/xpath-constraints/)
+ [Funciones](https://docs.mendix.com/refguide8/xpath-query-functions/)

## ~~XQuery~~
Lenguaje de consultas “similar” a SQL que se apoya en Xpath para operar sobre XML


## ~~Validación con XSD~~
Para validar XML utilizaremos [esquemas XSD](https://www.ticarte.com/contenido/que-son-los-esquemas-xsd)


## Herramientas
+ [Parser XML](https://codebeautify.org/xml-parser-online) y [otro parser](https://jsonformatter.org/xml-parser)
+ [gestión XML con Java](https://mkyong.com/java/jaxb-hello-world-example/), [con Python](https://www.geeksforgeeks.org/xml-parsing-python/), [con PHP](https://www.php.net/manual/es/simplexml.examples-basic.php) o [js](https://www.geeksforgeeks.org/how-to-parse-xml-in-javascript/).

## Referencias
+ [teoria XML](https://lm-xml-apuntes.readthedocs.io/apuntes/10_introduccion_xml.html)
+ [temario](https://www.ticarte.com/contenido/lenguajes-de-marcas-y-sistemas-de-gestion-de-informacion)
+ [breve](https://juangualberto.github.io/lmsgi/tema01/xml2.html)
+ [Ejemplos](https://github.com/lokeshgupta1981/Core-Java/tree/master/src/main/java/com/howtodoinjava/xml)
+ [Desde java](https://github.com/lokeshgupta1981/Core-Java/tree/master/src/main/java/com/howtodoinjava/xml)

## Feeds: RSS y Atom
+ [RSS](https://es.wikipedia.org/wiki/RSS)
+ [Atom](https://es.wikipedia.org/wiki/Atom_(formato_de_redifusi%C3%B3n))

# Json
[Introducción - Wikipedia](https://es.wikipedia.org/wiki/JSON)

## Referencias
+ [Validador](https://jsonlint.com/)
+ [Oficial](https://www.json.org/json-es.html)
+ [Brevísimo](https://juangualberto.github.io/lmsgi/tema01/json2.html)
+ [Visualizador en “tablas”](https://www.jointjs.com/demos/json-visualizer)
+ [Xml2Json](https://codebeautify.org/xmltojson/)


## MariaDB y Json
[trabajo con json en MariaDB](https://mariadb.com/resources/blog/using-json-in-mariadb/)

### Ejercicio
Vamos a jugar con Json en MariaDB gracias a [OneCompiler](https://onecompiler.com/mariadb)

Vamos a crear la tabla del ejemplo:
```sql
# -- Creación de tabla con atributo JSON
CREATE TABLE locations (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,  
    type CHAR(1) NOT NULL,
    latitude DECIMAL(9,6) NOT NULL,
    longitude DECIMAL(9,6) NOT NULL,
    attr JSON, 
    PRIMARY KEY (id)
);
# -- Consulta de descripción de la tabla
DESCRIBE locations;
# -- O el create (para copiar y pegar)
SHOW CREATE TABLE locations;


# -- Añadimos registros
INSERT INTO locations (type, name, latitude, longitude, attr) VALUES 
    ('R', 'Lou Malnatis', 42.0021628, -87.7255662,
      '{"details": {"foodType": "Pizza", "menu": 
    "our-menu"}, 
    "favorites": [{"description": "Pepperoni deep dish", "price": 18.75}, 
         {"description": "The Lou", "price": 24.75}]}');


INSERT INTO locations (type, name, latitude, longitude, attr) VALUES 
    ('A', 'Cloud Gate', 41.8826572, -87.6233039, 
          '{"category": "Landmark", "lastVisitDate": "11/10/2019"}');

          
```

Ahora a realizar las siguientes consultas:
1. Obtén todos los campos de todos los registros de la tabla
2. Obtén el nombre del restaurante y tipo de comida de todos los restaurantes
3. Obtén el nombre del restaurante y la lista de especialidades (favorites) de todos los restaurantes
4. Obtén el precio de la primera especialidad

### Funciones
[Funciones JSON en MariaDB]


## MongoDB y Bson
+ [Binary like Json => Bson](https://www.mongodb.com/resources/basics/json-and-bson)

### Búsqueda
`db.collection.find( <query>, <projection>, <options> )`

Donde:
+ query: filtramos filas
+ projection: filtramos columnas
+ options: límite, máximo, orden, ...

Fuente: [Búsquedas en MongoDB](https://www.mongodb.com/docs/manual/reference/method/db.collection.find/)

### Ejercicio:
Vamos a jugar con Json en MariaDB gracias a [OneCompiler](https://onecompiler.com/mongodb)

```mongodb
db.employees.insertMany([
  {empId: 1, name: 'Clark', dept: 'Sales', age: 23 },
  {empId: 2, name: 'Dave', dept: 'Accounting', age: 30 },
  {empId: 3, name: 'Ava', dept: 'Sales', age: 25 }
]);
```

1. Obtén la lista de todos los empleados
2. (query) Sólo del departamento ventas
3. (proyection) Sólo la lista de nombres
4. (proyection + filtros) Sólo los nombres y edades de los mayores de 23 años.
5. (funciones) Obtén el más jóven
6. y el más mayor.


## Json y APIs
+ [PokeAPI](https://pokeapi.co)

  
# Yaml
Sencillo, humano, ... sólo no uses tabuladores.

Es un formato que se crea inspirado en python para ser compatible con json y usable por humanos. Es completamente[^1] Json2yml y Yml2json.

Su utilización principal es ficheros de configuración, pero como json o xml podría ser empleado para serializar objetos.

+ [Aprende Yaml en Y minutos](https://learnxinyminutes.com/es/yaml/)
+ Validación de yaml con [Yaml Linter](https://www.yamllint.com/)

**Ventajas de YML**
+ Comentarios `#`: los comentarios no existen en otros archivos como json.
+ [Anclas `&` y alias `*`](https://tecnoyfoto.com/anclas-y-alias-en-yaml) (`<<: *alias`): ¿Algo se repite? Pues encapsulado con un ancla `&parte` e invocado por su alias `<<: *parte`
  
```yaml
# Documento
---
# Definimos el ancla
x-cosa: &prepe
  a: juan
  b: pedro
  c: manolo

# Lo usamos por su alias:
uno: 
  <<: *repe
dos: a=juan b=pedro
tres:
  <<: *repe
  j: lola
cuatro: 
  <<: *repe
  d: maria
```

Fuentes:
+ [restack.io - anchors y alias](https://www.restack.io/p/yaml-how-to-use-anchors-answer-cat-ai)
+ [medium.com - anchors y alias](https://medium.com/@kinghuang/docker-compose-anchors-aliases-extensions-a1e4105d70bd)


## Comparativa
+ [toml - json - yml](https://vergaracarmona.es/comparando-toml-json-y-yaml/)
+ [xml - json - toml - yaml](https://tennen.medium.com/xml-json-toml-yaml-which-one-is-the-secret-key-to-your-data-success-bc2895d609ae)

---
# Notas:
[^1] No tan completamente si usamos anclas, la única excepción.