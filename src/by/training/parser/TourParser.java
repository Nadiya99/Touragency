package by.training.parser;

import by.training.constant.FilePathConstant;
import by.training.exception.XmlDataFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Tour parser.
 */
public class TourParser {
    /**
     * The Log.
     */
    private static Logger log = (Logger) LogManager.getLogger(TourParser.class.getName());

    /**
     * Parse tours node list.
     *
     * @return the node list
     * @throws XmlDataFileException the xml data file exception
     */
    public NodeList parseTours() {
        File inputFile = new File(FilePathConstant.TOURS_FILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.fatal("Tours parsing error. Check the xml file. The end of the execution of the application. ", e);
            throw new RuntimeException(e);
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
        } catch (SAXException e) {
            log.fatal("Tours parsing error. Check the xml file. The end of the execution of the application. ", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.fatal("Tours parsing error. Check the xml file. The end of the execution of the application. ", e);
            throw new RuntimeException(e);
        }
        doc.getDocumentElement().normalize();
        NodeList tourList = doc.getChildNodes().item(0).getChildNodes();
        log.info("Successful xml parsing");
        return tourList;
    }

    /**
     * Parse node.
     *
     * @param list    the list
     * @param element the element
     * @param tagName the tag name
     */
    public static void parseNode(ArrayList<String> list, Element element, String tagName) {
        Node node = element.getElementsByTagName(tagName).item(0).getFirstChild();
        do {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                list.add(node.getTextContent());
            }
            node = node.getNextSibling();
        } while (node != null);
    }
}


