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
    private boolean canFly;
    private boolean isMigratory;

    public Bird(String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        super(name, dateReceived, habitat, feedingSchedule);
        setName(name);
    }

    public Bird(int id, String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        super(id, name, dateReceived, habitat, feedingSchedule);
        setName(name);
    }

    public String getName() { return name; }

    public void setName(String name) throws Exception {
        name = name.trim();

        if (name.isBlank())
            throw new Exception("Invalid data! Name can not be empty.");

        this.name = name;
    }

    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf(" %-15s %-10s\n", name, habitat);
    }
}
