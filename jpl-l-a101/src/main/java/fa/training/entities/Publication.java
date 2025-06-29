package fa.training.entities;

/**
 * Abstract class representing a publication.
 * This class serves as a base for specific types of publications like books,
 * magazines, etc.
 */
public abstract class Publication {
    private int publicationYear;
    private String publisher;
    private String publicationDate;

    public Publication() {
        // Default constructor
    }

    /**
     * Constructor full initialization of a publication.
     *
     * @param publicationYear the year of publication
     * @param publisher       the publisher of the publication
     * @param publicationDate the date of publication
     */
    public Publication(int publicationYear, String publisher, String publicationDate) {
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    // Abstract method to display publication
    public abstract void display();
    
}