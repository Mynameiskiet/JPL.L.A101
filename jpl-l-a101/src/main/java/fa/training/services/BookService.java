package fa.training.services;

import fa.training.entities.Book;
import fa.training.entities.Publication;
import fa.training.utils.Validator;

import java.util.List;
import java.util.stream.Collectors;

// Service class for managing Book operations
public class BookService {
    // List to store all publications
    private List<Publication> publications;
    private final Validator validator;

    // Constructor
    public BookService(List<Publication> publications) {
        this.publications = publications;
        this.validator = new Validator();
    }

    // Add a new book to the list
    public boolean addBook(Book book) {
        // Validate book attributes
        if (book == null ||
                !validator.isValidIsbn(book.getIsbn()) ||
                !validator.isValidPublicationYear(book.getPublicationYear()) ||
                !validator.isValidPublicationDate(book.getPublicationDate()) ||
                !validator.isValidString(book.getPublisher()) ||
                !validator.isValidString(book.getPublicationPlace()) ||
                book.getAuthor() == null || book.getAuthor().isEmpty()) {
            System.out.println("Invalid book data!");
            return false;
        }
        publications.add(book);
        System.out.println("Book added successfully.");
        return true;
    }

    // Add an author to a book by ISBN
    public boolean addAuthor(String isbn, String author) {
        // Find book by ISBN
        for (Publication pub : publications) {
            if (pub instanceof Book && ((Book) pub).getIsbn().equalsIgnoreCase(isbn)) {
                Book book = (Book) pub;
                // Check if author already exists
                if (book.getAuthor().contains(author)) {
                    System.out.println("Author existed");
                    return false;
                }
                // Add new author
                book.getAuthor().add(author);
                System.out.println("Add successfully");
                return true;
            }
        }
        System.out.println("Book not found with ISBN: " + isbn);
        return false;
    }

    // Find books by ISBN
    public List<Book> findByIsbn(String isbn) {
        return publications.stream()
                .filter(pub -> pub instanceof Book && ((Book) pub).getIsbn().equalsIgnoreCase(isbn))
                .map(pub -> (Book) pub)
                .sorted((b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn()))
                .collect(Collectors.toList());
    }

    // Find books by author
    public List<Book> findByAuthor(String author) {
        return publications.stream()
                .filter(pub -> pub instanceof Book && ((Book) pub).getAuthor().contains(author))
                .map(pub -> (Book) pub)
                .sorted((b1, b2) -> {
                    int cmp = b1.getIsbn().compareTo(b2.getIsbn());
                    return cmp != 0 ? cmp : b1.getPublicationDate().compareTo(b2.getPublicationDate());
                })
                .collect(Collectors.toList());
    }

    // Find books by publisher
    public List<Book> findByPublisher(String publisher) {
        return publications.stream()
                .filter(pub -> pub instanceof Book && ((Book) pub).getPublisher().equalsIgnoreCase(publisher))
                .map(pub -> (Book) pub)
                .sorted((b1, b2) -> {
                    int cmp = b1.getIsbn().compareTo(b2.getIsbn());
                    return cmp != 0 ? cmp : b1.getPublicationDate().compareTo(b2.getPublicationDate());
                })
                .collect(Collectors.toList());
    }
}