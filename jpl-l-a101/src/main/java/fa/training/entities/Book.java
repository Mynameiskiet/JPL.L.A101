package fa.training.entities;

import java.util.Set;

// Class representing a Book, inherits from Publication
public class Book extends Publication {
    private String isbn;
    // Set of authors (to avoid duplicates)
    private Set<String> author;
    private String publicationPlace;

    public Book() {
        // Default constructor
    }

    public Book(int publicationYear, String publisher, String publicationDate, String isbn, Set<String> author,
            String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.author = author;
        this.publicationPlace = publicationPlace;
    }

    public String getIsbn() {
        return isbn;
    }

    public Set<String> getAuthor() {
        return author;
    }

    public String getPublicationPlace() {
        return publicationPlace;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setAuthor(Set<String> author) {
        this.author = author;
    }

    public void setPublicationPlace(String publicationPlace) {
        this.publicationPlace = publicationPlace;
    }

    // Override display method to show book details
    @Override
    public void display() {
        System.out.printf("Book[ISBN=%s, Authors=%s, PublicationPlace=%s, Year=%d, Publisher=%s, Date=%s]%n",
                isbn, author, publicationPlace, getPublicationYear(), getPublisher(), getPublicationDate());
    }
}
