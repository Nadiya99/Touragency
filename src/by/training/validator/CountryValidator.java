package by.training.validator;


import by.training.parser.CountriesParser;

/**
 * The type Country validator.
 */
public class CountryValidator {

    /**
     * Check country exists.
     *
     * @param name the name
     * @return the boolean
     */
    public static boolean checkCountry(String name) {

        if (!CountriesParser.getCountries().contains(name)) {
            return false;
        }
        return true;
    }
}
