package library.inventory;

/**
 * ...
 *
 * @author Brandon Berger, Ricardo Pretorius
 * @version 0.1
 * @since 2025.03.24
 * @see <a href="https://github.com/JRBerger123/Pet-Store-App">GitHub Repository</a>
 * @see <a href="https://github.com/JRBerger123">Brandon Berger's GitHub</a>
 * 
 */
public class Fish extends Pet {
    private String publisher;
    private FeedingSchedule category;

    public Fish(String title, String dateReceived, String publisher, FeedingSchedule category) throws Exception {
        super(title, dateReceived);
        setPublisher(publisher);
        setCategory(category);
    }

    public Fish(int id, String title, String dateReceived, String publisher, FeedingSchedule category) throws Exception {
        super(id, title, dateReceived);
        setPublisher(publisher);
        setCategory(category);
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) throws Exception {
        publisher = publisher.trim();

        if (publisher.isBlank())
            throw new Exception("Invalid data! Author can not be empty.");

        this.publisher = publisher;
    }

    public FeedingSchedule getCategory() { return category; }

    public void setCategory(FeedingSchedule category) {
        this.category = category;
    }

    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf(" %-15s %-10s\n", publisher, category);
    }
}
