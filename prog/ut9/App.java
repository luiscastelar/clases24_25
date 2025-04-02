/** Examen de la UT9 sobre bases de datos y manejo de bases de datos a través de objetos (DAO).
 *
 * Esta prueba valora:
 *  + Que sabes gestionar, acceder y actualizar los datos de una base de datos ya existente
 *  + Que sabes realizarlo mediante una interfaz conocida
 *  + Que sabes que es la programación por contrato y la utilizar para dejar un código limpio y estándar.
 *
 *  Debes utilizar la base de datos aportada por el profesor según las credenciales proporcionadas.
 *  Sigues el DAO y el contrato proporcionado y rellenas esta estructura con el código necesario para que funcione.
 *  Para que tu examen sea avaluado deberá compilar y ser verificará que realizas los puntos que se te solicitan (se
 *  aporta rúbrica en cada uno).
 *
 *  Debes subir tu aplicación exactamente a REPO/prog/examenes/ut9, por lo que tu App.java se ubicará en
 *  .../ut9/src/main/java/App.java, junto con el resto de archivos necesarios para probarlo, incluído el archivo de
 *  credenciales.
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }
    private void start() {
        // El garaje (gestor de coches) debe ser de tipo DAO
        // 0. Capturar todo el garaje (pista)

        // 1. [2p] Nos dicen que el vehículo de matrícula "2345BCD" ha sido revisado.

        // 3. [1p] Ha llegado un nuevo coche no revisado, con matrícula "9999AAA" con 100 kms y con un precio de 30.000 €

        // 4. [2p] Abandonan (elimanar) el garaje todos los vehículos de más de 500_000 kms

        // 5. [1p] Obtén el coche con id 1

        // 6. [1p] Obtén el número de vehículos en el garaje

        // 7. [1p] Mostrar todo el garaje de nuevo

        // 8. [2p] Obtén solo el coche con matrícula 1234ABC ( extiende la implementación del DAO con el método getByMatricula(String)  )
    }
}
