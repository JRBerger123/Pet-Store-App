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
    private String canFly;
    private String isMigratory;

    public String getCanFly() {
        return canFly;
    }

    public void setCanFly(String canFly) {
        this.canFly = canFly;
    }

    public String getIsMigratory() {
        return isMigratory;
    }

    public void setIsMigratory(String isMigratory) {
        this.isMigratory = isMigratory;
    }

    public Bird(String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, String canFly, String isMigratory) throws Exception {
        super(name, dateReceived, habitat, feedingSchedule);
        this.canFly = canFly;
        this.isMigratory = isMigratory;
        setName(name);
    }

    public Bird(int id, String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        super(id, name, dateReceived, habitat, feedingSchedule);
        setName(name);
        this.canFly = "Unknown";
        this.isMigratory = "Unknown";
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
