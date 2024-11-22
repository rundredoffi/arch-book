package service;

import java.lang.System.Logger;
import java.util.*;
import java.util.logging.LogManager;
import test.SimpleArch.model.*;

public class LibraryService {
    private static final Logger logger = LogManager.getLogger(LibraryService.class);
    private Book addedBook;
    
    private Collection<Book> books = ImmutableList.of(
            new Book("The Great Gatsby", "F. Scott Fitzgerald",2007),
            new Book("To Kill a Mockingbird", "Harper Lee",2008)
    );

    public void addBook(Book book) {
        // Log de l'ajout du livre
        logger.info("Adding book: " + book.getTitle());

        // Validation des données du livre
        if (StringUtils.isBlank(book.getTitle()) || StringUtils.isBlank(book.getAuthor())) {
            throw new IllegalArgumentException("Title and author cannot be empty");
        }

        // Log de la validation réussie
        logger.debug("Book data validated successfully");
        
        // Log de l'ajout du livre
        logger.info("Book added successfully");

        // Sauvegarde du livre ajouté
        this.addedBook = book;
    }
    
    
    public Collection<Book> getBooksPublishedAfter(int year) {
        Predicate<Book> publishedAfterPredicate = new Predicate<Book>() {
            @Override
            public boolean apply(Book input) {
                // Assume that the publication year is stored in the Book class
                return input.getPublicationYear() > year;
            }
        };

        return Collections2.filter(books, publishedAfterPredicate);
    }

    public Book getAddedBook() {
        return addedBook;
    }


	public Collection<Book> getBooks() {
		return books;
	}

}
