package library.inventory;

/**
 * ...
 *
 * @author Brandon Berger, Ricardo Pretorius
 * @version 0.1
 * @since 2025.03.24
 * @see <a href="https://github.com/JRBerger123/Pet-Store-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/RicardoPret">Ricardo Pretorius GitHub</a>
 */
public class Bird extends Pet {
    /**
     * Represents whether or not the bird can fly.
     */
    private boolean canFly;

    /**
     * Represents whether or not the bird is migratory.
     */
    private boolean isMigratory;

    /**
     * Creates a new bird object with the specified parameters.
     * @param name
     * @param dateReceived
     * @param habitat
     * @param feedingSchedule
     * @param canFly
     * @param isMigratory
     * @throws Exception
     */
    public Bird(String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, boolean canFly, boolean isMigratory) throws Exception {
        super(name, dateReceived, habitat, feedingSchedule);
        this.canFly = canFly;
        this.isMigratory = isMigratory;
        setName(name);
    }

    /**
     * Creates a new bird object with the specified parameters.
     * @param id
     * @param name
     * @param dateReceived
     * @param habitat
     * @param feedingSchedule
     * @param canFly
     * @param isMigratory
     * @throws Exception
     */
    public Bird(int id, String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, boolean canFly, boolean isMigratory) throws Exception {
        super(id, name, dateReceived, habitat, feedingSchedule);
        setName(name);
        this.canFly = false;
        this.isMigratory = false;
    }

    /**
     * Gets whether the bird can fly.
     * @return returns true if the bird can fly, false otherwise.
     */
    public boolean canFly() {
        return canFly;
    }

    /**
     * Sets whether the bird can fly.
     * @param canFly holds true if the bird can fly, false otherwise.
     */
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    /**
     * Gets whether the bird is migratory.
     * @return returns true if the bird is migratory, false otherwise.
     */
    public boolean isMigratory() {
        return isMigratory;
    }

    /**
     * Sets whether the bird is migratory.
     * @param isMigratory holds true if the bird is migratory, false otherwise.
     */
    public void setMigratory(boolean isMigratory) {
        this.isMigratory = isMigratory;
    }

    /**
     * Displays the bird's information.
     */
    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf(" %-15s %-10s\n", name, dateAdded, habitat, feedingSchedule);
    }
}
