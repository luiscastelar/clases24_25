package ut9.examen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public abstract class ContratoCoches {

    /** Captura las properties
     *
     * @param file El archivo que las contiene (incluído el path completo o relativo)
     * @return El objeto Properties con las properties cargadas
     */
    protected static Properties getProperties(String file){
        Properties prop = new Properties();
        try (
                FileInputStream fis = new FileInputStream(file)
        ) {
            prop.load(fis);
            return prop;
        } catch (FileNotFoundException fnfe) {
            System.out.printf("Archivo %s no encontrado", file);
        } catch (SecurityException se){
            System.out.printf("No tienes permisos para acceder al archivo %s.", file);
        } catch (IOException ioe){
            System.out.printf("Error al acceder al archivo %s.", file);
        }
        return null;
    }

    /** Pausa n segundos
     *
     * @param segundos Los segundos a parar
     */
    protected static void sleep(int segundos){
        try{
            Thread.sleep(1 * 1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
