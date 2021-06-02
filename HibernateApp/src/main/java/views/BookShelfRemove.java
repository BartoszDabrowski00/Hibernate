package views;

import entities.BookShelf;
import services.BookShelfService;
import lombok.AllArgsConstructor;

import java.util.Scanner;
import java.util.UUID;

@AllArgsConstructor
public class BookShelfRemove {
    private final BookShelfService bookShelfService;

    public void display(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Shelf id: ");
        UUID id = UUID.fromString(scanner.nextLine());
        BookShelf bookShelfEntity = bookShelfService.find(id);
        if (bookShelfEntity == null) {
            System.out.println("Wrong id");
        } else {
            bookShelfService.delete(bookShelfEntity);
        }
    }
}
