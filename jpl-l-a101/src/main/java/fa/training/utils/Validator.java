package fa.training.utils;

import java.text.SimpleDateFormat;

// Utility class for input validation
public class Validator {
    // Validate ISBN: 10-17 characters, digits and hyphens
    public boolean isValidIsbn(String isbn) {
        if (isbn == null)
            return false;
        return isbn.matches("^[0-9-]{10,17}$");
    }

    // Validate publication year: between 1800 and current year
    public boolean isValidPublicationYear(int year) {
        int currentYear = java.time.Year.now().getValue();
        return year >= 1800 && year <= currentYear;
    }

    // Validate publication date format (dd/MM/yyyy)
    public boolean isValidPublicationDate(String date) {
        if (date == null)
            return false;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Validate non-empty string
    public boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }
}