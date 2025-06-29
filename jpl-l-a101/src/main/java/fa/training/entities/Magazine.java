package fa.training.entities;

// Class representing a Magazine, inherits from Publication
public class Magazine extends Publication {
    private String author;
    private int volume;
    private int edition;

    public Magazine() {
        // Default constructor
    }

    // Constructor for full initialization of a magazine
    public Magazine(int publicationYear, String publisher, String publicationDate,
            String author, int volume, int edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volume = volume;
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public int getVolume() {
        return volume;
    }

    public int getEdition() {
        return edition;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    // Override display method to show magazine details
    @Override
    public void display() {
        System.out.printf("Magazine[Author=%s, Volume=%d, Edition=%d, Year=%d, Publisher=%s, Date=%s]%n",
                author, volume, edition, getPublicationYear(), getPublisher(), getPublicationDate());
    }
}
