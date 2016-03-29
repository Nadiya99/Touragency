package by.training.search;


import by.training.entity.Tour;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The type Tours search.
 */
public class ToursSearch {

    /**
     * Search by transport array list.
     *
     * @param tours         the tours
     * @param transportName the transport name
     * @return the array list
     */
    public static ArrayList<Tour> searchByTransport(HashSet<Tour> tours, String transportName) {
        Iterator iterator = tours.iterator();
        ArrayList<Tour> searchTours = new ArrayList<Tour>();

        while (iterator.hasNext()) {
            Tour data = (Tour) iterator.next();
            for (String transport : data.getTransports()) {
                if (transport.equals(transportName)) {
                    searchTours.add(data);
                }
            }
        }
        return searchTours;
    }

    /**
     * Search by duration array list.
     *
     * @param tours    the tours
     * @param duration the duration
     * @return the array list
     */
    public static ArrayList<Tour> searchByDuration(HashSet<Tour> tours, int duration) {
        Iterator iterator = tours.iterator();
        ArrayList<Tour> searchTours = new ArrayList<Tour>();

        while (iterator.hasNext()) {
            Tour data = (Tour) iterator.next();
            if (data.getDuration() == duration) {
                searchTours.add(data);
            }
        }
        return searchTours;
    }

    /**
     * Search by meal plan array list.
     *
     * @param tours    the tours
     * @param mealPlan the meal plan
     * @return the array list
     */
    public static ArrayList<Tour> searchByMealPlan(HashSet<Tour> tours, String mealPlan) {
        Iterator iterator = tours.iterator();
        ArrayList<Tour> searchTours = new ArrayList<Tour>();

        while (iterator.hasNext()) {
            Tour data = (Tour) iterator.next();
            if (data.getMealPlan().equals(mealPlan)) {
                searchTours.add(data);
            }
        }
        return searchTours;
    }
}
