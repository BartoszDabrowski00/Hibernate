package views;

import entities.BookShelf;
import entities.Book;
import services.BookShelfService;
import services.BookService;
import lombok.AllArgsConstructor;

import java.util.Scanner;
import java.util.UUID;

@AllArgsConstructor
public class BookAdd {
    private final BookService bookService;
    private final BookShelfService bookShelfService;

    public void display(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        String title = scanner.nextLine();
        System.out.println("Author: ");
        String author = scanner.nextLine();
        System.out.println("Shelf UUID: ");
        UUID id = UUID.fromString(scanner.nextLine());
        BookShelf bookShelfEntity = bookShelfService.find(id);
        if (bookShelfEntity == null) {
            System.out.println("Wrong id");
        } else {
            bookService.create(Book.builder()
                    .title(title)
                    .author(author)
                    .bookShelf(bookShelfEntity)
                    .build());
        }
    }
}
