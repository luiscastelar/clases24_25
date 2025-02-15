package xpath;

import org.w3c.dom.Document;

import javax.xml.xpath.XPathExpressionException;

public class ExamenXpath {
    public static void main(String[] args) {
        // Definimos el archivo y ruta con el que trabajar y lo cargamos
        String path = "./src/main/resources/";
        String xml = path +"libros.xml";
        Document doc = JugandoConXPath1.config( xml );

        // Si no existe el archivo o se produjo error
        if (doc == null) {
            System.out.println("No se encontro el archivo");
            System.exit(1);
        }

        try {
            // Consultas de ejemplo de uso
            JugandoConXPath1.printListXpath(doc, "//title/text()", "Todos los libros");
            JugandoConXPath1.printNumberXpath(doc, "count(//book)", "Número de libros");
            JugandoConXPath1.printNumberXpath(doc, "sum(//price)", "Coste (redondeado) de todos los libros");

        } catch (XPathExpressionException xpee) {
            System.out.println("Error en expresión XPath suministrada");
            xpee.printStackTrace();
        }
    }
}
