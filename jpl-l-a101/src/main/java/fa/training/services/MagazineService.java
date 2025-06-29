package fa.training.services;

import fa.training.entities.Magazine;
import fa.training.entities.Publication;
import fa.training.utils.Validator;

import java.util.List;
import java.util.stream.Collectors;

// Service class for managing Magazine
public class MagazineService {
    // List to store all publications
    private List<Publication> publications;
    private final Validator validator;

    // Constructor
    public MagazineService(List<Publication> publications) {
        this.publications = publications;
        this.validator = new Validator();
    }

    // Add a new magazine 
    public boolean addMagazine(Magazine magazine) {
        // Validate magazine 
        if (magazine == null ||
                !validator.isValidPublicationYear(magazine.getPublicationYear()) ||
                !validator.isValidPublicationDate(magazine.getPublicationDate()) ||
                !validator.isValidString(magazine.getPublisher()) ||
                !validator.isValidString(magazine.getAuthor()) ||
                magazine.getVolume() <= 0 ||
                magazine.getEdition() <= 0) {
            System.out.println("Invalid magazine data!");
            return false;
        }
        publications.add(magazine);
        System.out.println("Magazine added successfully.");
        return true;
    }

    // Get top 10 magazines
    public List<Magazine> getTop10ByVolume() {
        return publications.stream()
                .filter(pub -> pub instanceof Magazine)
                .map(pub -> (Magazine) pub)
                .sorted((m1, m2) -> Integer.compare(m2.getVolume(), m1.getVolume()))
                .limit(10)
                .collect(Collectors.toList());
    }
}