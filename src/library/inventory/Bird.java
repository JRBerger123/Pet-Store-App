package library.inventory;

/**
 * The {@code Bird} class represents a bird object. <p>
 * The {@code Bird} class extends the {@code Pet} class and adds the following properties:
 * <ul>
 *      <li>canFly - whether the bird can fly</li>
 *      <li>isMigratory - whether the bird is migratory</li>
 * </ul>
 * Methods available:
 * <ul>
 *      <li>{@link #canFly()} - Retrieves whether the bird can fly.</li>
 *      <li>{@link #setCanFly(boolean)} - Sets whether the bird can fly.</li>
 *      <li>{@link #isMigratory()} - Retrieves whether the bird is migratory.</li>
 *      <li>{@link #setMigratory(boolean)} - Sets whether the bird is migratory.</li>
 *      <li>{@link #displayItem()} - Displays the bird's information.</li>
 * </ul>
 * 
 * @author Brandon Berger, Ricardo Pretorius
 * @version 1.0
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
     * @param name the name of the bird
     * @param dateReceived the date the bird was received
     * @param habitat the habitat type of the bird
     * @param feedingSchedule the feeding schedule of the bird
     * @param canFly whether the bird can fly
     * @param isMigratory whether the bird is migratory
     * @throws Exception if any error occurs
     */
    public Bird(String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, boolean canFly, boolean isMigratory) throws Exception {
        super(name, dateReceived, habitat, feedingSchedule);
        this.canFly = canFly;
        this.isMigratory = isMigratory;
        setName(name);
    }

    /**
     * Creates a new bird object with the specified parameters.
     * @param id the i++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++d of the bird
     * @param name the name of the bird
     * @param dateReceived the date the bird was received
     * @param habitat the habitat type of the bird
     * @param feedingSchedule the feeding schedule of the bird
     * @param canFly whether the bird can fly
     * @param isMigratory whether the bird is migratory
     * @throws Exception if any error occurs
     */
    public Bird(int id, String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, boolean canFly, boolean isMigratory) throws Exception {
        super(id, name, dateReceived, habitat, feedingSchedule);
        this.canFly = canFly;
        this.isMigratory = isMigratory;
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
        System.out.printf(" %-8s %-13s\n", canFly(), isMigratory());
    }
}
