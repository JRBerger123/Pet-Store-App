package library.inventory;

/**
 * The {@code Fish} class represents a fish object. <p>
 * The {@code Fish} class extends the {@code Pet} class and adds the following properties:
 * <ul>
 *      <li>isTropical - whether the fish is tropical</li>
 *      <li>usesFreshwater - whether the fish uses fresh water</li>
 * </ul>
 * Methods available:
 * <ul>
 *      <li>{@link #isTropical()} - Retrieves whether the fish is tropical.</li>
 *      <li>{@link #setTropical(boolean)} - Sets whether the fish is tropical.</li>
 *      <li>{@link #usesFreshwater()} - Retrieves whether the fish uses fresh water.</li>
 *      <li>{@link #setUsesFreshwater(boolean)} - Sets whether the fish uses fresh water.</li>
 *      <li>{@link #displayItem()} - Displays the fish's information.</li>
 * </ul>
 *
 * @author Brandon Berger, Ricardo Pretorius
 * @version 1.0
 * @since 2025.03.24
 * @see <a href="https://github.com/JRBerger123/Pet-Store-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/RicardoPret">Ricardo Pretorius GitHub</a>
 */
public class Fish extends Pet {
    /**
     * Represents whether or not the fish needs to swim in warm water.
     */
    private boolean isTropical;

    /**
     * Represents whether or not the fish needs to swim in fresh water.
     */
    private boolean usesFreshwater;

    /**
     * Creates a new fish object with the specified parameters.
     * @param name the name of the fish
     * @param dateReceived the date the fish was received
     * @param habitat the habitat type of the fish
     * @param feedingSchedule the feeding schedule of the fish
     * @param isTropical whether the fish is tropical
     * @param usesFreshwater whether the fish uses fresh water
     * @throws Exception if any error occurs
     */
    public Fish(String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, boolean isTropical, boolean usesFreshwater) throws Exception {
        super(name, dateReceived, habitat, feedingSchedule);
        this.isTropical = isTropical;
        this.usesFreshwater = usesFreshwater;
    }

    /**
     * Creates a new fish object with the specified parameters.
     * @param id the id of the fish
     * @param name the name of the fish
     * @param dateReceived the date the fish was received
     * @param habitat the habitat type of the fish
     * @param feedingSchedule the feeding schedule of the fish
     * @param isTropical whether the fish is tropical
     * @param usesFreshwater whether the fish uses fresh water
     * @throws Exception if any error occurs
     */
    public Fish(int id, String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, boolean isTropical, boolean usesFreshwater) throws Exception {
        super(id, name, dateReceived, habitat, feedingSchedule);
        setName(name);
        this.isTropical = isTropical;
        this.usesFreshwater = usesFreshwater;
    }

    /**
     * Gets whether the fish is tropical.
     * @return returns true if the fish is tropical, false otherwise.
     */
    public boolean isTropical() {
        return isTropical;
    }

    /**
     * Sets whether the fish is tropical.
     * @param isTropical holds true if the fish is tropical, false otherwise.
     */
    public void setTropical(boolean isTropical) {
        this.isTropical = isTropical;
    }

    /**
     * Gets whether the fish uses fresh water.
     * @return returns true if the fish uses fresh water, false otherwise.
     */
    public boolean usesFreshwater() {
        return usesFreshwater;
    }

    /**
     * Sets whether the fish uses fresh water.
     * @param usesFreshwater holds true if the fish uses fresh water, false otherwise.
     */
    public void setUsesFreshwater(boolean usesFreshwater) {
        this.usesFreshwater = usesFreshwater;
    }

    /**
     * Displays the fish's information.
     */
    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf(" %-12s %-16s\n", isTropical(), usesFreshwater());
    }
}
