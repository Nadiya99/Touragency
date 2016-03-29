package by.training.entity;


import java.util.ArrayList;

/**
 * The type Shop tour.
 */
public class ShopTour extends Tour {
    private ArrayList<String> shops = new ArrayList<String>();
    private int groupAmount;

    /**
     * Instantiates a new Shop tour.
     *
     * @param tour the tour
     */
    public ShopTour(Tour tour) {
        super(tour);
    }


    /**
     * Gets shops.
     *
     * @return the shops
     */
    public ArrayList<String> getShops() {
        return shops;
    }

    /**
     * Sets shops.
     *
     * @param shops the shops
     */
    public void setShops(ArrayList<String> shops) {
        this.shops = shops;
    }

    /**
     * Gets group amount.
     *
     * @return the group amount
     */
    public int getGroupAmount() {
        return groupAmount;
    }

    /**
     * Sets group amount.
     *
     * @param groupAmount the group amount
     */
    public void setGroupAmount(int groupAmount) {
        this.groupAmount = groupAmount;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "\n ShopTour{" + super.toString() +
                ", shops=" + shops +
                ", groupAmount=" + groupAmount +
                "}";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ShopTour shopTour = (ShopTour) o;

        if (groupAmount != shopTour.groupAmount) return false;
        if (!shops.equals(shopTour.shops)) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + shops.hashCode();
        result = 31 * result + groupAmount;
        return result;
    }
}
