package by.training.entity;


import java.util.ArrayList;

/**
 * The type Tour.
 */
public class Tour {
    private String name;
    private int duration;
    private ArrayList<String> countries = new ArrayList<String>();
    private ArrayList<String> transports = new ArrayList<String>();
    private String accommodation;
    private String mealPlan;
    private int cost;


    /**
     * Instantiates a new Tour.
     */
    public Tour() {
        super();
    }


    /**
     * Instantiates a new Tour.
     *
     * @param tour the tour
     */
    public Tour(Tour tour) {
        name = tour.name;
        countries = tour.countries;
        duration = tour.duration;
        transports = tour.transports;
        accommodation = tour.accommodation;
        mealPlan = tour.mealPlan;
        cost = tour.cost;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets countries.
     *
     * @return the countries
     */
    public ArrayList<String> getCountries() {
        return countries;
    }

    /**
     * Sets countries.
     *
     * @param countries the countries
     */
    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    /**
     * Gets transports.
     *
     * @return the transports
     */
    public ArrayList<String> getTransports() {
        return transports;
    }

    /**
     * Sets transports.
     *
     * @param transports the transports
     */
    public void setTransports(ArrayList<String> transports) {
        this.transports = transports;
    }

    /**
     * Gets accommodation.
     *
     * @return the accommodation
     */
    public String getAccommodation() {
        return accommodation;
    }

    /**
     * Sets accommodation.
     *
     * @param accommodation the accommodation
     */
    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    /**
     * Gets meal plan.
     *
     * @return the meal plan
     */
    public String getMealPlan() {
        return mealPlan;
    }

    /**
     * Sets meal plan.
     *
     * @param mealPlan the meal plan
     */
    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", duration=" + duration +
                ", countries=" + countries +
                ", transports=" + transports +
                ", accommodation='" + accommodation + '\'' +
                ", mealPlan='" + mealPlan + '\'' +
                ", cost=" + cost;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (Double.compare(tour.cost, cost) != 0) return false;
        if (duration != tour.duration) return false;
        if (!accommodation.equals(tour.accommodation)) return false;
        if (!countries.equals(tour.countries)) return false;
        if (!mealPlan.equals(tour.mealPlan)) return false;
        if (!name.equals(tour.name)) return false;
        if (!transports.equals(tour.transports)) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + duration;
        result = 31 * result + countries.hashCode();
        result = 31 * result + transports.hashCode();
        result = 31 * result + accommodation.hashCode();
        result = 31 * result + mealPlan.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
