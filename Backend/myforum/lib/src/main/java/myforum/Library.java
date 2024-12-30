package myforum;

public class Library {

    // A simple method to demonstrate functionality
    public String getGreeting() {
        return "Hello from the Library!";
    }

    // Method that checks if a book is available (just an example)
    public boolean isBookAvailable(String bookName) {
        // For simplicity, assume that only "Java Basics" is available
        return "Java Basics".equalsIgnoreCase(bookName);
    }
}
