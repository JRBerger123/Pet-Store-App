package library.inventory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * ...
 *
 * @author Brandon Berger, Ricardo Pretorius
 * @version 0.1
 * @since 2025.03.24
 * @see <a href="https://github.com/JRBerger123/Pet-Store-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * @see <a href="https://github.com/RicardoPret">Ricardo Pretorius GitHub</a>
 * 
 */
public class Pet {
    private static int lastId = 0;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

    protected final int id;
    protected String name;
    protected LocalDate dateAdded;
    protected String description;
    protected HabitatType habitat;
    protected FeedingSchedule feedingSchedule;

    public Pet(String name, String dateAdded, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        this.id = ++Pet.lastId;
        setName(name);
        setDateAdded(dateAdded);
    }

    public Pet(int id, String name, String dateAdded, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        this.id = id;
        setName(name);
        setDateAdded(dateAdded);
    }

    public static void setLastId(int lastId){
        Pet.lastId = lastId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        name = name.trim();

        if (name.isBlank()){
            throw new Exception("Invalid! Name cannot be empty.");
        }

        this.name = name;
    }

    public String getDateAdded() {
        return dateAdded.format(Pet.formatter);
    }

    public void setDateAdded(String dateAdded) throws Exception {
        try {
            this.dateAdded = LocalDate.parse(dateAdded, Pet.formatter);
        } catch (Exception e){
            throw new Exception("Invalid date! Must be MM-DD-YYYY");
        }
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description.trim();
    }

    public FeedingSchedule getFeedingSchedule() { 
        return feedingSchedule; 
    }

    public void setFeedingSchedule(FeedingSchedule schedule) {
        this.feedingSchedule = schedule;
    }

    public HabitatType getHabitatType() { 
        return habitat;
    }

    public void setHabitatType(HabitatType habitat) {
         this.habitat = habitat;
    }

    public void displayItem(){
        System.out.printf("%3d %-15s %10s", id, name, getDateAdded());
    }

    @Override
    public String toString(){
        return id + " | " + name + " | " + getDateAdded();
    }

}
