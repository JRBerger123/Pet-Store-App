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
    private String author;
    private HabitatType genre;

    public Bird(String title, String dateReceived, String author, HabitatType genre) throws Exception {
        super(title, dateReceived);
        setAuthor(author);
        setGenre(genre);
    }

    public Bird(int id, String title, String dateReceived, String author, HabitatType genre) throws Exception {
        super(id, title, dateReceived);
        setAuthor(author);
        setGenre(genre);
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) throws Exception {
        author = author.trim();

        if (author.isBlank())
            throw new Exception("Invalid data! Author can not be empty.");

        this.author = author;
    }

    public HabitatType getGenre() { return genre; }

    public void setGenre(HabitatType genre) { this.genre = genre; }

    @Override
    public void displayItem(){
        super.displayItem();
        System.out.printf(" %-15s %-10s\n", author, genre);
    }
}
