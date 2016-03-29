package by.training.entity;


import java.util.ArrayList;

/**
 * The type Treatment tour.
 */
public class TreatmentTour extends Tour {
    private ArrayList<String> medicalProcedures;
    private String sanatoriumName;

    /**
     * Instantiates a new Treatment tour.
     *
     * @param tour the tour
     */
    public TreatmentTour(Tour tour) {
        super(tour);
        medicalProcedures = new ArrayList<String>();
    }

    /**
     * Gets medical procedures.
     *
     * @return the medical procedures
     */
    public ArrayList<String> getMedicalProcedures() {
        return medicalProcedures;
    }

    /**
     * Sets medical procedures.
     *
     * @param medicalProcedures the medical procedures
     */
    public void setMedicalProcedures(ArrayList<String> medicalProcedures) {
        this.medicalProcedures = medicalProcedures;
    }

    /**
     * Gets sanatorium name.
     *
     * @return the sanatorium name
     */
    public String getSanatoriumName() {
        return sanatoriumName;
    }

    /**
     * Sets sanatorium name.
     *
     * @param sanatoriumName the sanatorium name
     */
    public void setSanatoriumName(String sanatoriumName) {
        this.sanatoriumName = sanatoriumName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        TreatmentTour that = (TreatmentTour) o;

        if (!medicalProcedures.equals(that.medicalProcedures)) return false;
        if (!sanatoriumName.equals(that.sanatoriumName)) return false;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + medicalProcedures.hashCode();
        result = 31 * result + sanatoriumName.hashCode();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "\n TreatmentTour{" + super.toString() +
                ", medicalProcedures=" + medicalProcedures +
                ", sanatoriumName='" + sanatoriumName + '\'' +
                '}';
    }
}
