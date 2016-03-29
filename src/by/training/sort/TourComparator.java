package by.training.sort;


import by.training.entity.Tour;

import java.util.Comparator;

/**
 * The type Tour comparator.
 */
public class TourComparator {

    /**
     * The tourCostComparatorDescending.
     * <p>
     * Comparator for sorting the list by cost descending.
     */
    public static Comparator<Tour> tourCostComparatorDescending = (s1, s2) -> s2.getCost() - s1.getCost();

    /**
     * The tourCostComparatorAscending.
     * <p>
     * Comparator for sorting the list by cost ascending.
     */
    public static Comparator<Tour> tourCostComparatorAscending = (s1, s2) -> s1.getCost() - s2.getCost();

    /**
     * The tourDurationComparatorDescending.
     * <p>
     * Comparator for sorting the list by duration descending.
     */
    public static Comparator<Tour> tourDurationComparatorDescending = (s1, s2) -> s2.getDuration()- s1.getDuration();

    /**
     * The tourDurationComparatorAscending.
     * <p>
     * Comparator for sorting the list by duration ascending.
     */
    public static Comparator<Tour> tourDurationComparatorAscending = (s1, s2) -> s1.getDuration()- s2.getDuration();
}
