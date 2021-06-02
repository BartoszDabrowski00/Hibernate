package views;

import entities.BookShelf;
import services.BookShelfService;
import lombok.AllArgsConstructor;
import java.util.UUID;


@AllArgsConstructor
public class BookShelfAdd {
    private final BookShelfService bookShelfService;

    public void display(){
        UUID id = UUID.randomUUID();
        BookShelf bookShelf = BookShelf.builder()
                .id(id)
                .build();
        bookShelfService.create(bookShelf);
    }
}
