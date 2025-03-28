package library.inventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The {@code Pet} class represents a pet object. <p>
 * The {@code Pet} class is the parent class for all pet types and adds the following properties:
 * <ul>
 *      <li>id - the unique identifier for the pet</li>
 *      <li>name - the name of the pet</li>
 *      <li>dateAdded - the date the pet was added to the inventory</li>
 *      <li>description - the description of the pet</li>
 *      <li>habitat - the habitat type of the pet</li>
 *      <li>feedingSchedule - the feeding schedule of the pet</li>
 * </ul>
 * Methods available:
 * <ul>
 *      <li>{@link #getId()} - Retrieves the pet's unique identifier.</li>
 *      <li>{@link #setLastId(int)} - Sets the id of the pet based on the last id used.</li>
 *      <li>{@link #getName()} - Retrieves the pet's name.</li>
 *      <li>{@link #setName(String)} - Sets the pet's name.</li>
 *      <li>{@link #getDateAdded()} - Retrieves the date the pet was added.</li>
 *      <li>{@link #setDateAdded(String)} - Sets the date the pet was added.</li>
 *      <li>{@link #getDescription()} - Retrieves the pet's description.</li>
 *      <li>{@link #setDescription(String)} - Sets the pet's description.</li>
 *      <li>{@link #getFeedingSchedule()} - Retrieves the pet's feeding schedule.</li>
 *      <li>{@link #setFeedingSchedule(FeedingSchedule)} - Sets the pet's feeding schedule.</li>
 *      <li>{@link #getHabitatType()} - Retrieves the pet's habitat type.</li>
 *      <li>{@link #setHabitatType(HabitatType)} - Sets the pet's habitat type.</li>
 *      <li>{@link #displayItem()} - Displays the pet's information.</li>
 * </ul>
 *
 * @author Brandon Berger, Ricardo Pretorius
 * @version 1.0
 * @since 2025.03.24
 * @see <a href="https://github.com/JRBerger123/Pet-Store-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/RicardoPret">Ricardo Pretorius GitHub</a>
 * 
 */
public class Pet {
    /**
     * Represents the last id used when creating a pet.
     */
    private static int lastId = 0;

    /**
     * Represents the date formatter for the pet's date added.
     */
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    /**
     * Represents the unique identifier for the pet.
     */
    protected final int id;

    /**
     * Represents the name of the pet.
     */
    protected String name;

    /**
     * Represents the date the pet was added to the inventory.
     */
    protected LocalDate dateAdded;

    /**
     * Represents the description of the pet.
     */
    protected String description;

    /**
     * Represents the habitat type of the pet.
     */
    protected HabitatType habitat;

    /**
     * Represents the feeding schedule of the pet.
     */
    protected FeedingSchedule feedingSchedule;

    /**
     * Creates a new pet object with the specified parameters.
     * @param name the name of the pet
     * @param dateAdded the date the pet was added
     * @param habitat the habitat type of the pet
     * @param feedingSchedule the feeding schedule of the pet
     * @throws Exception if any error occurs
     */
    public Pet(String name, String dateAdded, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        this.id = ++Pet.lastId;
        setName(name);
        setDateAdded(dateAdded);
        setHabitatType(habitat);
        setFeedingSchedule(feedingSchedule);
    }

    /**
     * Creates a new pet object with the specified parameters.
     * @param id the id of the pet
     * @param name the name of the pet
     * @param dateAdded the date the pet was added
     * @param habitat the habitat type of the pet
     * @param feedingSchedule the feeding schedule of the pet
     * @throws Exception if any error occurs
     */
    public Pet(int id, String name, String dateAdded, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        this.id = id;
        setName(name);
        setDateAdded(dateAdded);
        setHabitatType(habitat);
        setFeedingSchedule(feedingSchedule);
    }

    /**
     * Retrieves the pet's unique identifier.
     * @return the id of the pet
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id of the pet based on the last id used.
     * @param lastId the last id used when creating a pet
     */
    public static void setLastId(int lastId){
        Pet.lastId = lastId;
    }

    /**
     * Retrieves the pet's name.
     * @return the name of the pet
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the pet's name.
     * @param name the name of the pet
     * @throws Exception if the name is empty
     */
    public void setName(String name) throws Exception {
        name = name.trim();

        if (name.isBlank()){
            throw new Exception("Invalid! Name cannot be empty.");
        }

        this.name = name;
    }

    /**
     * Retrieves the date the pet was added.
     * @return the date the pet was added
     */
    public String getDateAdded() {
        return dateAdded.format(Pet.formatter);
    }

    /**
     * Sets the date the pet was added.
     * @param dateAdded the date the pet was added in the MM-DD-YYYY format
     * @throws Exception if the date is invalid
     */
    public void setDateAdded(String dateAdded) throws Exception {
        try {
            this.dateAdded = LocalDate.parse(dateAdded, Pet.formatter);
        } catch (Exception e){
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }

    /**
     * Retrieves the pet's description.
     * @return the description of the pet
     */
    public String getDescription() { 
        return description;
    }

    /**
     * Sets the pet's description.
     * @param description the description of the pet
     */
    public void setDescription(String description) {
        this.description = description.trim();
    }

    /**
     * Retrieves the pet's feeding schedule.
     * @return the feeding schedule of the pet
     */
    public FeedingSchedule getFeedingSchedule() { 
        return feedingSchedule; 
    }

    /**
     * Sets the pet's feeding schedule.
     * @param schedule the feeding schedule of the pet
     */
    public void setFeedingSchedule(FeedingSchedule schedule) {
        this.feedingSchedule = schedule;
    }

    /**
     * Retrieves the pet's habitat type.
     * @return the habitat type of the pet
     */
    public HabitatType getHabitatType() { 
        return habitat;
    }

    /**
     * Sets the pet's habitat type.
     * @param habitat the habitat type of the pet
     */
    public void setHabitatType(HabitatType habitat) {
         this.habitat = habitat;
    }

    /**
     * Displays the pet's information.
     */
    public void displayItem() {
        System.out.printf("%3d %-15s %10s %-15s %-20s", getId(), getName(), getDateAdded(), getHabitatType(), getFeedingSchedule());
    }

    /**
     * Returns a string representation of the pet object.
     * @return the string representation of the pet object
     */
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s", getId(), getName(), getDateAdded(), getHabitatType(), getFeedingSchedule());
    }

}
