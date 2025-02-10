package xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;

public class JugandoConXPath1 {
    private static final String PATH_TO_RECURSOS = "./src/main/resources/";
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(PATH_TO_RECURSOS + "libros.xml");

            printListXpath(doc, "//title/text()", "Todos los libros");
            printNumberXpath(doc, "count(//title)", "Número de libros");

            // 1. Imprime el título de los libros escritos después del 2001
            // 2. Imprime el título de los libros escritos antes del 2001
            // 3. Imprime el título de los libros más baratos de 8 dólares
            // 4. Imprime el título de los libros más caros de 8 dólares
            // 5. Imprime el título del primer libro
            // 6. Imprime el título del último libro
            // 7. Imprime los escritores de todos los libros
            //      ¿Cómo harías para "imprimir todos los escritores"?
            //      ¿Qué diferencia hay?
            // 8. Imprime el número de libros por xpath absoluto
            // 9. Imprime el título de los libros escritos por alquien que empiece por Neal
            // 10. Imprime el título de los libros escritos por alguien que contenga Niven
            // 11. Imprime el título de los libros escritos por Neal Stephenson
            // 12. Imprime el número de libros escritos por Neal Stephenson
            // 13. Imprime los nodos de comentarios
            // 14. Imprime el título de los libros escritos por Neal Stephenson que cuesten más de 8 dólares.

        } catch (ParserConfigurationException pce){
            System.out.println("No pudo configurar XPath");
        } catch (SAXException saxe) {
            System.out.println("Error genérico de XML");
            saxe.printStackTrace();
        } catch (XPathExpressionException xpee) {
            System.out.println("Error en expresión XPath suministrada");
            xpee.printStackTrace();
        } catch (NullPointerException npe){
            System.out.println("Has pasado una expresión nula (NULL)");
        } catch (IOException ioe){
            System.out.println("No se pudo abrir el archivo fuente XML");
        }
    }

    private static void printNumberXpath(Document doc, String expresionXpath, String titulo) throws XPathExpressionException {
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        System.out.printf("%s => %1.0f%n%n%n", titulo, xpath.compile(expresionXpath).evaluate(doc, XPathConstants.NUMBER) );
    }

    private static void printListXpath(Document doc, String expresionXpath, String titulo) throws XPathExpressionException {
        System.out.printf("%s -> Xpath['%s']:%n", titulo, expresionXpath);
        NodeList nodes = getNodeList(doc, expresionXpath);
        printNodes(nodes);
    }

    private static void printNodes(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.printf("     - %s%n", nodes.item(i).getNodeValue());
        }
        System.out.println("\n");
    }

    private static NodeList getNodeList(Document doc, String expresionXpath) throws XPathExpressionException {
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        XPathExpression expr = xpath.compile( expresionXpath );
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        NodeList nodes = (NodeList) result;
        return nodes;
    }
}
