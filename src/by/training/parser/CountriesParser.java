package by.training.parser;


import by.training.constant.FilePathConstant;
import by.training.exception.XmlDataFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

/**
 * The type Countries parser.
 */
public class CountriesParser {
    /**
     * The Log.
     */
    private static Logger log = (Logger) LogManager.getLogger(TourParser.class.getName());

    private static HashSet<String> countries = new HashSet<>();

    /**
     * Parse countries xml file.
     *
     * @return the hash set
     * @throws XmlDataFileException the xml data file exception
     */
    public void parseCountries() {
        File inputFile = new File(FilePathConstant.COUNTRIES_FILE);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.fatal("Countries parsing error. Check the xml file. The end of the execution of the application. ", e);
            throw new RuntimeException(e);
        }
        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
        } catch (SAXException e) {
            log.fatal("Countries parsing error. Check the xml file. The end of the execution of the application. ", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.fatal("Countries parsing error. Check the xml file. The end of the execution of the application. ", e);
            throw new RuntimeException(e);
        }
        doc.getDocumentElement().normalize();

        NodeList countriesList = doc.getChildNodes().item(0).getChildNodes();
        for (int i = 0; i < countriesList.getLength(); i++) {
            if (countriesList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element countryElement = (Element) countriesList.item(i);
                String country = countryElement.getTextContent();
                countries.add(country);
            }
        }
    }

    public static HashSet<String> getCountries() {
        return countries;
    }
}
