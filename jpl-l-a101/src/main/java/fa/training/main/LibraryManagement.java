package fa.training.main;

import fa.training.entities.Book;
import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.services.BookService;
import fa.training.services.MagazineService;
import fa.training.utils.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Main class to manage library publications using instance methods
public class LibraryManagement {
    // Instance variables
    private final List<Publication> publications;
    private final BookService bookService;
    private final MagazineService magazineService;
    private final Scanner scanner;
    private final Validator validator;

    // Constructor
    public LibraryManagement() {
        this.publications = new ArrayList<>();
        this.bookService = new BookService(publications);
        this.magazineService = new MagazineService(publications);
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    // Run the main menu
    public void run() {
        while (true) {
            System.out.println("\n=== Library Management Menu ===");
            System.out.println("1. Add a book");
            System.out.println("2. Add a magazine");
            System.out.println("3. Display books and magazines");
            System.out.println("4. Add author to book");
            System.out.println("5. Display top 10 magazines by volume");
            System.out.println("6. Search book by (isbn, author, publisher)");
            System.out.println("7. Exit");
            System.out.print("Please choose function (1-7): ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMagazine();
                    break;
                case 3:
                    displayPublications();
                    break;
                case 4:
                    addAuthorToBook();
                    break;
                case 5:
                    displayTop10Magazines();
                    break;
                case 6:
                    searchBooks();
                    break;
                case 7:
                    System.out.println("Exit program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-7.");
            }

            if (choice == 7) {
                break; // Exit the loop
            }
        }
        scanner.close();
    }

    // Method to add a book
    private void addBook() {
        System.out.println("\n=== Add Book ===");
        String isbn = null;
        while (true) {
            System.out.print("Enter ISBN (10-17 digits and hyphens): ");
            isbn = scanner.nextLine();
            if (validator.isValidIsbn(isbn)) {
                break;
            }
            System.out.println("Invalid ISBN format! Must be 10-17 digits and hyphens.");
        }

        // Input authors
        Set<String> authors = new HashSet<>();
        int numAuthors = 0;
        while (true) {
            System.out.print("Enter number of authors (positive number): ");
            try {
                numAuthors = Integer.parseInt(scanner.nextLine());
                if (numAuthors > 0) {
                    break;
                }
                System.out.println("Number of authors must be positive!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }
        for (int i = 0; i < numAuthors; i++) {
            String author = null;
            while (true) {
                System.out.print("Enter author " + (i + 1) + ": ");
                author = scanner.nextLine();
                if (validator.isValidString(author)) {
                    break;
                }
                System.out.println("Invalid author name! Please enter a valid name.");
            }
            authors.add(author);
        }
        if (authors.isEmpty()) {
            System.out.println("No valid authors provided!");
            return;
        }

        // Input publication place
        String publicationPlace = null;
        while (true) {
            System.out.print("Enter publication place: ");
            publicationPlace = scanner.nextLine();
            if (validator.isValidString(publicationPlace)) {
                break;
            }
            System.out.println("Publication place cannot be empty!");
        }

        // Input publication year
        int year = 0;
        while (true) {
            System.out.print("Enter publication year: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (validator.isValidPublicationYear(year)) {
                    break;
                }
                System.out.println("Invalid year! Must be between 1800 and current year.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        // Input publisher
        String publisher = null;
        while (true) {
            System.out.print("Enter publisher: ");
            publisher = scanner.nextLine();
            if (validator.isValidString(publisher)) {
                break;
            }
            System.out.println("Publisher cannot be empty!");
        }

        // Input publication date
        String date = null;
        while (true) {
            System.out.print("Enter publication date (dd/MM/yyyy): ");
            date = scanner.nextLine();
            if (validator.isValidPublicationDate(date)) {
                break;
            }
            System.out.println("Invalid date format! Use dd/MM/yyyy.");
        }

        // Create and add book
        Book book = new Book(year, publisher, date, isbn, authors, publicationPlace);
        bookService.addBook(book);
    }

    // Method to add a magazine
    private void addMagazine() {
        System.out.println("\n=== Add Magazine ===");
        String author = null;
        while (true) {
            System.out.print("Enter author: ");
            author = scanner.nextLine();
            if (validator.isValidString(author)) {
                break;
            }
            System.out.println("Author cannot be empty!");
        }

        // Input volume
        int volume = 0;
        while (true) {
            System.out.print("Enter volume (positive number): ");
            try {
                volume = Integer.parseInt(scanner.nextLine());
                if (volume > 0) {
                    break;
                }
                System.out.println("Volume must be positive!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        // Input edition
        int edition = 0;
        while (true) {
            System.out.print("Enter edition (positive number): ");
            try {
                edition = Integer.parseInt(scanner.nextLine());
                if (edition > 0) {
                    break;
                }
                System.out.println("Edition must be positive!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        // Input publication year
        int year = 0;
        while (true) {
            System.out.print("Enter publication year: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (validator.isValidPublicationYear(year)) {
                    break;
                }
                System.out.println("Invalid year! Must be between 1800 and current year.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        // Input publisher
        String publisher = null;
        while (true) {
            System.out.print("Enter publisher: ");
            publisher = scanner.nextLine();
            if (validator.isValidString(publisher)) {
                break;
            }
            System.out.println("Publisher cannot be empty!");
        }

        // Input publication date
        String date = null;
        while (true) {
            System.out.print("Enter publication date (dd/MM/yyyy): ");
            date = scanner.nextLine();
            if (validator.isValidPublicationDate(date)) {
                break;
            }
            System.out.println("Invalid date format! Use dd/MM/yyyy.");
        }

        // Create and add magazine
        Magazine magazine = new Magazine(year, publisher, date, author, volume, edition);
        magazineService.addMagazine(magazine);
    }

    // Method to display publications by year and publisher
    private void displayPublications() {
        System.out.println("\n=== Display Publications ===");
        int year = 0;
        while (true) {
            System.out.print("Enter publication year: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (validator.isValidPublicationYear(year)) {
                    break;
                }
                System.out.println("Invalid year! Must be between 1800 and current year.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
        }

        // Input publisher
        String publisher = null;
        while (true) {
            System.out.print("Enter publisher: ");
            publisher = scanner.nextLine();
            if (validator.isValidString(publisher)) {
                break;
            }
            System.out.println("Publisher cannot be empty!");
        }

        // Display matching publications
        System.out.println("\nPublications with Year=" + year + " and Publisher=" + publisher + ":");
        boolean found = false;
        for (Publication pub : publications) {
            if (pub.getPublicationYear() == year && pub.getPublisher().equalsIgnoreCase(publisher)) {
                pub.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No publications found with the specified year and publisher.");
        }
    }

    // Method to add author to book
    private void addAuthorToBook() {
        System.out.println("\n=== Add Author to Book ===");
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        String author = null;
        while (true) {
            System.out.print("Enter author name: ");
            author = scanner.nextLine();
            if (validator.isValidString(author)) {
                break;
            }
            System.out.println("Invalid author name! Please enter a valid name.");
        }
        bookService.addAuthor(isbn, author);
    }

    // Method to display top 10 magazines
    private void displayTop10Magazines() {
        System.out.println("\n=== Top 10 Magazines by Volume ===");
        List<Magazine> topMagazines = magazineService.getTop10ByVolume();
        if (topMagazines.isEmpty()) {
            System.out.println("No magazines found.");
        } else {
            topMagazines.forEach(Magazine::display);
        }
    }

    // Method to search books
    private void searchBooks() {
        System.out.println("\n=== Search Books ===");
        System.out.println("1. By ISBN");
        System.out.println("2. By Author");
        System.out.println("3. By Publisher");
        System.out.print("Enter choice (1-3): ");
        String choice = scanner.nextLine();
        List<Book> results;

        switch (choice) {
            case "1":
                String isbn = null;
                while (true) {
                    System.out.print("Enter ISBN: ");
                    isbn = scanner.nextLine();
                    if (validator.isValidIsbn(isbn)) {
                        break;
                    }
                    System.out.println("Invalid ISBN format! Must be 10-17 digits and hyphens.");
                }
                results = bookService.findByIsbn(isbn);
                break;
            case "2":
                String author = null;
                while (true) {
                    System.out.print("Enter author: ");
                    author = scanner.nextLine();
                    if (validator.isValidString(author)) {
                        break;
                    }
                    System.out.println("Invalid author name! Please enter a valid name.");
                }
                results = bookService.findByAuthor(author);
                break;
            case "3":
                String publisher = null;
                while (true) {
                    System.out.print("Enter publisher: ");
                    publisher = scanner.nextLine();
                    if (validator.isValidString(publisher)) {
                        break;
                    }
                    System.out.println("Publisher cannot be empty!");
                }
                results = bookService.findByPublisher(publisher);
                break;
            default:
                System.out.println("Invalid choice! Please select 1-3.");
                return;
        }

        // Display search results
        if (results.isEmpty()) {
            System.out.println("No books found with the specified criteria.");
        } else {
            System.out.println("\nSearch results:");
            results.forEach(Book::display);
        }
    }

    public static void main(String[] args) {
        LibraryManagement lm = new LibraryManagement();
        lm.run();
    }
}