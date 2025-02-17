#!/usr/bin/java --source 21
import java.io.File;
import java.util.*;
import java.util.stream.Stream;

/** Verifica si has ubicado los archivos donde te pidió el profesor.
 *
 * Es válido para GNU/Linux ya que es case-sensitive, y por supuesto también
 * para Windows.
 *
 * Te pregunta:
 * - ruta al repositorio (relativa o absoluta)
 * - ruta en el repositorio (partiendo de la raíz de él)
 * - uno de los archivos buscados
 */
public class VerificadorDeRutas {
    // Valores del contrato:
    private static int SUCCESS = 0;
    private static int NOT_FOUND = 1;

    /** Gestión de arranque y salida */
    public static void main(String[] args) {
        int exitCode = new VerificadorDeRutas().start();
        if ( SUCCESS == exitCode) {
            //System.out.println("Hasta otro día.");
        } else {
            System.out.printf("%n%n%nERROR. Salida con código de error %d%n", exitCode );
        }

    }
    /** Programa principal (no estático).
     *
     * @return El exitCode vale 0 para correcto y 1 en caso de no encontrar el archivo o la ruta.
     */
    private int start(){
        String archivo = getAbsolutePathToFile();
        // En GNU/Linux:
        //String archivo = "/home/nombreAlumno/miRepo/lmsgi/ut3/examen/index.html";
        // En Windows:
        // String archivo = "/c/USERS/nombreAlumno/miRepo/lmsgi/ut3/examen/index.html";

        System.out.printf("%nLa ruta completa es: %s%n%n", archivo);

        File f = new File(archivo);
        if (f.exists()) {
            System.out.printf("%n%n%nLa ruta es correcta.%n");
            return SUCCESS;
        } else {
            String ruta = rutaMasParecida(archivo);
            System.out.printf("%n%nLa ruta no es correcta.%n" +
                    "La ruta más parecida es %s%n" +
                    "Los archivos en la ruta más parecida son:%n", ruta);

            // Captura todos los archivos y directorios en la ruta facilitada:
            List<String> archivos = Arrays.stream(new File(ruta).list()).toList();

            // Muestra el contenido de la ruta indicando si es un 'f'ile o un 'd'irectory
            archivos.forEach( file -> {
                File elemento = new File(ruta + "/"+ file);
                char tipo = (elemento.isDirectory())? 'd' : 'f';
                System.out.printf("[%c] -> %s/%s%n", tipo, ruta, file);
            });
            return NOT_FOUND;
        }
    }

    /** Gestión de entrada
     *
     * @return Retorna la ruta completa al archivo buscado
     *
     */
    private static String getAbsolutePathToFile() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Pega la ruta donde está tu repositorio:%n" +
                "Recuerda, puedes usar el comando pwd para saber cual es.%n" +
                "Para copiar en GNU/Linux utiliza Ctrl+Shift+c y para pegar Ctrl+Shift+v.%n" +
                "Para copiar en Windows utiliza Ctrl+Insert y para pegar Shift+Insert.%n");
        String ruta = scanner.nextLine();

        System.out.printf("%nPega la ruta porporcionada por el profesor (elimina {{RUTA}}:%n");
        ruta += scanner.nextLine();
        System.out.printf("%nPega el archivo que debe aparecer.%n" +
                "Recuerda que en lmsgi esparamos encontrar un index.html (en minúsculas) y,%n" +
                "en programación el nombre del archivo que contiene el método main() (P.e. ClasePrincipal.java)%n");
        String archivo = scanner.nextLine();
        archivo = ruta + "/" + archivo;
        return archivo;
    }

    /** Obtiene la ruta más parecida a la indicada.
     *
     * @param ruta -> Recibe la ruta completa al archivo buscado que no fue encontrado.
     * @return Ruta que contiene más partes iguales a las solicitadas.
     * Por ejemplo: se le pasó la ruta '/home/pedro/repositorio/lmsgi/index.html' y el alumno
     * tiene en su repositorio el directorio '.../Lmsgi' por lo que la ruta devuelta será
     * '/home/pedro/repositorio', que es el último tramo en el que lo solicitao y lo real 
     * coinciden.
     *
     */
    private String rutaMasParecida(String ruta){
        // Corrección de la ruta inicial
        final int SKIP = ( ruta.charAt(0) == '/' )? 1 : 0;

        String[] tokens = ruta.split("/");
        for(int i=tokens.length; i>0; i--){
            StringBuffer rutaMasParecida = new StringBuffer();
            for(int j=SKIP; j<i; j++){
                rutaMasParecida.append("/"+tokens[j]);
            }
            File f = new File(rutaMasParecida.toString());
            if (f.exists()) {
                return rutaMasParecida.toString();
            }
        }
        return "";
    }
}
