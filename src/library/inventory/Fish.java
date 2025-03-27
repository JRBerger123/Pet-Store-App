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
    private boolean isTropical;
    private boolean usesFreshwater;


    public boolean isTropical() {
        return isTropical;
    }

    public void setTropical(boolean isTropical) {
        this.isTropical = isTropical;
    }

    public boolean usesFreshwater() {
        return usesFreshwater;
    }

    public void setUsesFreshwater(boolean usesFreshwater) {
        this.usesFreshwater = usesFreshwater;
    }

    public Fish(String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule, boolean canFly, boolean isMigratory) throws Exception {
        super(name, dateReceived, habitat, feedingSchedule);
        this.isTropical = isTropical;
        this.usesFreshwater = usesFreshwater;
        setName(name);
    }

    public Fish(int id, String name, String dateReceived, HabitatType habitat, FeedingSchedule feedingSchedule) throws Exception {
        super(id, name, dateReceived, habitat, feedingSchedule);
        setName(name);
        this.isTropical = false;
        this.usesFreshwater = false;
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
        System.out.printf(" %-15s %-10s\n", type, schedule);
    }
}
