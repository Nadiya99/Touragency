package by.training.validator;


/**
 * The type Data validator.
 */
public class DataValidator {
    private static final String NUMBER_REGEX = "[1-9]{1}([0-9]{1,20})*";


    /**
     * Check integer value format.
     *
     * @param number the number
     * @return the boolean
     */
    public static boolean checkInteger(String number) {
        if (number == null || !number.matches(NUMBER_REGEX)) {
            return false;
        }
        return true;
    }

    /**
     * Check boolean value format.
     *
     * @param stringBool the bool
     * @return the boolean
     */
    public static boolean checkBoolean(String stringBool) {
        Boolean bool = Boolean.parseBoolean(stringBool);
        if (!bool) {
            if (!stringBool.equals("false")) {
                return false;
            }
        }

        return true;
    }
}
