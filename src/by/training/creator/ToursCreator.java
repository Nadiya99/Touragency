package by.training.creator;


import by.training.entity.ShopTour;
import by.training.entity.Tour;
import by.training.entity.TreatmentTour;
import by.training.exception.ParseNumberException;
import by.training.parser.CountriesParser;
import by.training.parser.TourParser;
import by.training.entity.SightseeingTour;
import by.training.exception.CountryNotExistException;
import by.training.validator.CountryValidator;
import by.training.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * The type Tours creator.
 */
public class ToursCreator {
    /**
     * The Log.
     */
    private static Logger log = (Logger) LogManager.getLogger(ToursCreator.class.getName());

    /**
     * Fill tour list.
     *
     * @param tours the tours
     * @return the boolean
     */
    public boolean fillTourList(HashSet<Tour> tours) {
        log.info("Start create tour list");

        TourParser tourParser = new TourParser();
        NodeList tourList = tourParser.parseTours();

        CountriesParser countriesParser = new CountriesParser();
        countriesParser.parseCountries();

        for (int temp = 0; temp < tourList.getLength(); temp++) {
            Node tourNode = tourList.item(temp);

            if (tourNode.getNodeType() == Node.ELEMENT_NODE) {
                Element tourElement = (Element) tourNode;
                String tagName = tourElement.getTagName();

                switch (tagName) {
                    case "treatmentTour":
                        try {
                            tours.add(createTreatmentTour(tourElement));
                        } catch (ParseNumberException e) {
                            log.warn("Incorrect data. Object is not created. ", e);
                            continue;
                        } catch (CountryNotExistException e) {
                            log.warn("Incorrect country. Object is not created. ", e);
                            continue;
                        }
                        break;
                    case "shopTour":
                        try {
                            tours.add(createShopTour(tourElement));
                        } catch (ParseNumberException e) {
                            log.warn("Incorrect data. Object is not created. ", e);
                            continue;
                        } catch (CountryNotExistException e) {
                            log.warn("Incorrect country. Object is not created. ", e);
                            continue;
                        }
                        break;
                    case "sightseeingTour":
                        try {
                            tours.add(createSightseeingTour(tourElement));
                        } catch (ParseNumberException e) {
                            log.warn("Incorrect data. Object is not created. ", e);
                            continue;
                        } catch (CountryNotExistException e) {
                            log.warn("Incorrect country. Object is not created. ", e);
                            continue;
                        }
                        break;
                    default:
                        log.warn("Tags don't found. ");
                        continue;
                }
            }
        }

        return true;
    }

    private Tour createTour(Element element) throws ParseNumberException, CountryNotExistException {
        Tour tour = new Tour();
        tour.setName(element.getElementsByTagName("name").item(0).getTextContent());
        tour.setAccommodation(element.getElementsByTagName("accommodation").item(0).getTextContent());
        tour.setMealPlan(element.getElementsByTagName("mealPlan").item(0).getTextContent());
        String cost = element.getElementsByTagName("cost").item(0).getTextContent();
        if (DataValidator.checkInteger(cost)) {
            tour.setCost(Integer.parseInt(cost));
        } else {
            throw new ParseNumberException();
        }
        String duration = element.getElementsByTagName("duration").item(0).getTextContent();
        if (DataValidator.checkInteger(duration)) {
            tour.setDuration(Integer.parseInt(duration));
        } else {
            throw new ParseNumberException();
        }

        ArrayList<String> countries = new ArrayList<String>();
        TourParser.parseNode(countries, element, "countries");
        boolean presenceCountry = true;
        for (String country : countries) {
            if (!CountryValidator.checkCountry(country)) {
                presenceCountry = false;
                break;
            }
        }

        if (presenceCountry) {
            tour.setCountries(countries);
        } else {
            throw new CountryNotExistException();
        }

        ArrayList<String> transports = new ArrayList<String>();
        TourParser.parseNode(transports, element, "transports");
        tour.setTransports(transports);

        return tour;
    }

    private TreatmentTour createTreatmentTour(Element tourElement) throws ParseNumberException, CountryNotExistException {
        TreatmentTour tour = null;
        try {
            tour = new TreatmentTour(createTour(tourElement));
        } catch (ParseNumberException e) {
            throw new ParseNumberException(e);
        } catch (CountryNotExistException e) {
            throw new CountryNotExistException(e);
        }

        tour.setSanatoriumName(tourElement.getElementsByTagName("sanatoriumName").item(0).getTextContent());
        ArrayList<String> medicalProcedures = new ArrayList<String>();
        TourParser.parseNode(medicalProcedures, tourElement, "medicalProcedures");
        tour.setMedicalProcedures(medicalProcedures);
        return tour;
    }

    private ShopTour createShopTour(Element tourElement) throws ParseNumberException, CountryNotExistException {
        ShopTour tour = null;
        try {
            tour = new ShopTour(createTour(tourElement));
        } catch (ParseNumberException e) {
            throw new ParseNumberException(e);
        } catch (CountryNotExistException e) {
            throw new CountryNotExistException(e);
        }

        String groupAmount = tourElement.getElementsByTagName("groupAmount").item(0).getTextContent();
        if (DataValidator.checkInteger(groupAmount)) {
            tour.setGroupAmount(Integer.parseInt(groupAmount));
        } else {
            throw new ParseNumberException();
        }
        ArrayList<String> shops = new ArrayList<String>();
        TourParser.parseNode(shops, tourElement, "shops");
        tour.setShops(shops);
        return tour;
    }

    private SightseeingTour createSightseeingTour(Element tourElement) throws ParseNumberException, CountryNotExistException {
        SightseeingTour tour = null;
        try {
            tour = new SightseeingTour(createTour(tourElement));
        } catch (ParseNumberException e) {
            throw new ParseNumberException(e);
        } catch (CountryNotExistException e) {
            throw new CountryNotExistException(e);
        }
        String presenceGuide = tourElement.getElementsByTagName("presenceGuide").item(0).getTextContent();
        if (DataValidator.checkBoolean(presenceGuide)) {
            tour.setPresenceGuide(Boolean.parseBoolean(presenceGuide));
        } else {
            throw new ParseNumberException();
        }

        ArrayList<String> attractions = new ArrayList<String>();
        TourParser.parseNode(attractions, tourElement, "attractions");
        tour.setAttractions(attractions);
        return tour;
    }
}
