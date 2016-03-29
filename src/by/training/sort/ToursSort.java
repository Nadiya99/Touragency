package by.training.sort;


import by.training.entity.Tour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * The type Tours sort.
 */
public class ToursSort {

    /**
     * Sort by duration ascending array list.
     *
     * @param tours the tours
     * @return the array list
     */
    public static ArrayList<Tour> sortByDurationAscending(HashSet<Tour> tours) {
        ArrayList<Tour> sortedList = new ArrayList(tours);
        Collections.sort(sortedList, TourComparator.tourDurationComparatorAscending);
        return sortedList;
    }

    /**
     * Sort by duration descending array list.
     *
     * @param tours the tours
     * @return the array list
     */
    public static ArrayList<Tour> sortByDurationDescending(HashSet<Tour> tours) {
        ArrayList<Tour> sortedList = new ArrayList(tours);
        Collections.sort(sortedList, TourComparator.tourDurationComparatorDescending);
        return sortedList;
    }

    /**
     * Sort by cost descending array list.
     *
     * @param tours the tours
     * @return the array list
     */
    public static ArrayList<Tour> sortByCostDescending(HashSet<Tour> tours) {
        ArrayList<Tour> sortedList = new ArrayList(tours);
        Collections.sort(sortedList, TourComparator.tourCostComparatorDescending);
        return sortedList;
    }

    /**
     * Sort by cost ascending array list.
     *
     * @param tours the tours
     * @return the array list
     */
    public static ArrayList<Tour> sortByCostAscending(HashSet<Tour> tours) {
        ArrayList<Tour> sortedList = new ArrayList(tours);
        Collections.sort(sortedList, TourComparator.tourCostComparatorAscending);
        return sortedList;
    }
}
