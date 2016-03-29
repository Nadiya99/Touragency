package by.training.entity;


import java.util.ArrayList;

/**
 * The type Sightseeing tour.
 */
public class SightseeingTour extends Tour {
    private ArrayList<String> attractions;
    private boolean presenceGuide;

    /**
     * Instantiates a new Sightseeing tour.
     *
     * @param tour the tour
     */
    public SightseeingTour(Tour tour) {
        super(tour);
        attractions = new ArrayList<String>();
    }

    /**
     * Gets attractions.
     *
     * @return the attractions
     */
    public ArrayList<String> getAttractions() {
        return attractions;
    }

    /**
     * Sets attractions.
     *
     * @param attractions the attractions
     */
    public void setAttractions(ArrayList<String> attractions) {
        this.attractions = attractions;
    }

    /**
     * Is presence guide boolean.
     *
     * @return the boolean
     */
    public boolean isPresenceGuide() {
        return presenceGuide;
    }

    /**
     * Sets presence guide.
     *
     * @param presenceGuide the presence guide
     */
    public void setPresenceGuide(boolean presenceGuide) {
        this.presenceGuide = presenceGuide;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "\n SightseeingTour{" + super.toString() +
                ", attractions=" + attractions +
                ", presenceGuide=" + presenceGuide +
                '}';
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SightseeingTour that = (SightseeingTour) o;

        if (presenceGuide != that.presenceGuide) return false;
        if (attractions != null ? !attractions.equals(that.attractions) : that.attractions != null) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (attractions != null ? attractions.hashCode() : 0);
        result = 31 * result + (presenceGuide ? 1 : 0);
        return result;
    }
}
