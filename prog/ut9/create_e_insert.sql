USE XX_db_Alumno;
CREATE TABLE coches (
  id SERIAL PRIMARY KEY,
  matricula CHAR(7) NOT NULL,
  revisado BOOLEAN DEFAULT 0,
  kilometros INT NOT NULL,
  precio DECIMAL(8,2) NOT NULL
);

INSERT INTO coches (matricula, kilometros, precio) VALUES
  ('1234ABC', 100000, 20300.25),
  ('2345BCD', 123456, 23123.12),
  ('3456CDE', 654321, 10001.99);
