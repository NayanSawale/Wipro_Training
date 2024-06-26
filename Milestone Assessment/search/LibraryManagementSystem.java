package com.search;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("Java Programming", "James Gosling", "1234567890"));
        library.addBook(new Book("Python Programming", "Guido van Rossum", "0987654321"));
        library.addBook(new Book("C++ Programming", "Bjarne Stroustrup", "1122334455"));
        library.addBook(new Book("JavaScript Programming", "Brendan Eich", "6677889900"));

        // Display all books
        System.out.println("All books in the library:");
        library.displayAllBooks();

        // Linear Search
        String searchTitle = "Python Programming";
        long startTime = System.nanoTime();
        Book foundBook = library.linearSearch(searchTitle);
        long endTime = System.nanoTime();
        if (foundBook != null) {
            System.out.println("Linear Search - Book found: " + foundBook);
        } else {
            System.out.println("Linear Search - Book not found: " + searchTitle);
        }
        System.out.println("Linear Search Time: " + (endTime - startTime) + " ns");

        // Binary Search
        startTime = System.nanoTime();
        foundBook = library.binarySearch(searchTitle);
        endTime = System.nanoTime();
        if (foundBook != null) {
            System.out.println("Binary Search - Book found: " + foundBook);
        } else {
            System.out.println("Binary Search - Book not found: " + searchTitle);
        }
        System.out.println("Binary Search Time: " + (endTime - startTime) + " ns");

        // Remove a book
        library.removeBook("JavaScript Programming");

        // Display all books after removal
        System.out.println("All books in the library after removal:");
        library.displayAllBooks();
    }
}
