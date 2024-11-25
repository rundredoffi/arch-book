import service.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.*;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Lorem","Lorem", 11);// Création d'un livre
        Path path = Paths.get("book.json");
      
        book.setTitle("Harry Potter");
        book.setAuthor("J.K. Rowling");

        // Création du service de bibliothèque
        LibraryService libraryService = new LibraryService();

        // Ajout du livre à la bibliothèque
        libraryService.addBook(book);

        // Récupération du livre ajouté
        Book addedBook = libraryService.getAddedBook();

        // Affichage des détails du livre ajouté
        System.out.println("Livre ajouté à la bibliothèque :");
        System.out.println("Titre : " + addedBook.getTitle());
        System.out.println("Auteur : " + addedBook.getAuthor());

        // Sérialisation du livre en JSON et écriture dans un fichier
        try {
            // Création de l'objet ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            // Sérialisation du livre en JSON
            String json = objectMapper.writeValueAsString(addedBook);

            // Écriture du JSON dans un fichier
            byte[] bs = json.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            

            // Affichage du message de confirmation
            System.out.println("Fichier JSON généré avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
