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
    public static void main(String[] args) {
        String path = "./src/main/resources/";
        String xml = path +"libros.xml";
        Document doc = config( xml );

        if (doc == null) {
            System.out.println("No se encontro el archivo");
            System.exit(1);
        }

        try {
            printListXpath(doc, "//title/text()", "Todos los libros");

            printNumberXpath(doc, "count(//book)", "Número de libros");
            printNumberXpath(doc, "sum(//price)", "Coste (redondeado) de todos los libros");


            String titulo = "1) Get book titles written after 2001";
            String expresionXpath = "//book[@year>2001]/title/text()";
            printListXpath(doc, expresionXpath, titulo);

            printListXpath(doc,
                    "//book[@year<2001]/title/text()",
                    "2) Get book titles written before 2001");
            // también con "/inventory/book[..."

            printListXpath(doc,
                    "//book[price<8]/title/text()",
                    "3) Get book titles cheaper than 8 dollars");

            printListXpath(doc,
                    "//book[price>8]/title/text()",
                    "4) Get book titles costlier than 8 dollars");
            printListXpath(doc,
                    "//book[1]/title/text()",
                    "5) Get book titles added in first node");
            printListXpath(doc,
                    "//book[last()]/title/text()",
                    "6) Get book title added in last node");
            printListXpath(doc,
                    "//book[*]/author/text()",
                    "7) Get all writers");

            // --------------
            // Sólo un número
            // --------------
            printNumberXpath(doc, "count(//book/title)", "8) Count all books titles");

            printListXpath(doc,
                    "//book[starts-with(author,'Neal')]/title/text()",
                    "9) Get book titles with writer name start with Neal");

            printListXpath(doc,
                    "//book[contains(author,'Niven')]/title/text()",
                    "10) Get book titles with writer name containing Niven");

            printListXpath(doc,
                    "//book[author='Neal Stephenson']/title/text()",
                    "11) Get book titles written by Neal Stephenson");
            // También con "//book[contains(author,'Neal Stephenson')]/title/text()"

            printNumberXpath(doc, "count(//book[author='Neal Stephenson'])", "12) Get count of book titles written by Neal Stephenson");

            printListXpath(doc,
                    "//comment()",
                    "13) Reading comment node");

            printListXpath(doc,
                    "//book[author='Neal Stephenson' and price>8]/title/text()",
                    "14) Get book titles written by Neal Stephenson and price greater than 8 USD");

        } catch (XPathExpressionException xpee) {
            System.out.println("Error en expresión XPath suministrada");
            xpee.printStackTrace();
        }
    }

    /** Nos genera un documento xml para analizarlo (parsearlo)
     *
      * @param xml La ruta completa al archivo
     * @return el documento
     */
    public static Document config(String xml){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);
            return doc;
        } catch (ParserConfigurationException pce){
            System.out.println("No pudo configurar XPath");
        } catch (SAXException saxe) {
            System.out.println("Error genérico de XML");
            saxe.printStackTrace();
        } catch (NullPointerException npe){
            System.out.println("Has pasado una expresión nula (NULL)");
        } catch (IOException ioe){
            System.out.println("No se pudo abrir el archivo fuente XML");
        }
        return null;
    }


    /** Imprime el número que devuelve la expresión solicitada.
     *
     * @param doc El documento xml generado con JugandoConXPath1.config( xml )
     * @param expresionXpath La expresión Xpath
     * @param titulo El texto que representa
     * @throws XPathExpressionException En caso de error de expresión
     */
    public static void printNumberXpath(Document doc, String expresionXpath, String titulo) throws XPathExpressionException {
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        System.out.printf("%s => %1.0f%n%n%n", titulo, xpath.compile(expresionXpath).evaluate(doc, XPathConstants.NUMBER) );
    }

    /** Imprime la lista de nodos seleccionados por la expresión Xpath.
     *
     * @param doc El documento xml generado con JugandoConXPath1.config( xml )
     * @param expresionXpath La expresión Xpath
     * @param titulo El texto que representa
     * @throws XPathExpressionException En caso de error de expresión
     */
    public static void printListXpath(Document doc, String expresionXpath, String titulo) throws XPathExpressionException {
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
