package views;

import services.BookService;
import lombok.AllArgsConstructor;

import java.util.Scanner;
import java.util.UUID;

@AllArgsConstructor
public class AuthorWorksNumById {
    private final BookService bookService;

    public void display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Shelf id: ");
        UUID id = UUID.fromString(scanner.nextLine());
        System.out.println("Author name: ");
        String author = scanner.nextLine();
        int size = bookService.countAuthorWorksOnShelf(id, author);
        System.out.println("Shelf id: " + id.toString() + " author: " + author + " works: "+size);
    }
}
