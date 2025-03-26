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
public class Bird extends Pet {
    private String name;
    private HabitatType habitat;

    public Bird(String title, String dateReceived, String name, HabitatType habitat) throws Exception {
        super(title, dateReceived);
        setName(name);
        setHabitatType(habitat);
    }

    public Bird(int id, String title, String dateReceived, String name, HabitatType habitat) throws Exception {
        super(id, title, dateReceived);
        setName(name);
        setHabitatType(habitat);
    }

    public String getName() { return name; }

    public void setName(String name) throws Exception {
        name = name.trim();

        if (name.isBlank())
            throw new Exception("Invalid data! Name can not be empty.");

        this.name = name;
    }

    public HabitatType getHabitatType() { return habitat; }

    public void setHabitatType(HabitatType habitat) { this.habitat = habitat; }

    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf(" %-15s %-10s\n", name, habitat);
    }
}
