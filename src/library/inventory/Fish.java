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
 * 
 */
public class Fish extends Pet {
    private String type;
    private FeedingSchedule schedule;

    public Fish(String title, String dateReceived, String type, FeedingSchedule schedule) throws Exception {
        super(title, dateReceived);
        setType(type);
        setFeedingSchedule(schedule);
    }

    public Fish(int id, String title, String dateReceived, String type, FeedingSchedule schedule) throws Exception {
        super(id, title, dateReceived);
        setType(type);
        setFeedingSchedule(schedule);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) throws Exception {
        type = type.trim();

        if (type.isBlank())
            throw new Exception("Invalid data! Fish type cannot be empty.");

        this.type = type;
    }

    public FeedingSchedule getFeedingSchedule() { return schedule; }

    public void setFeedingSchedule(FeedingSchedule category) {
        this.schedule = schedule;
    }

    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf(" %-15s %-10s\n", type, schedule);
    }
}
