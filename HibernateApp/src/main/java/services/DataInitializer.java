package services;

import entities.Book;
import entities.BookShelf;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class DataInitializer {
    private final BookService bookService;
    private final BookShelfService bookShelfService;

    public void initialize(){
        createShelves();
    }
    private void createBooks(UUID firstID, UUID secondID, UUID thirdID){
        Book book1 = Book.builder()
                .title("Title 1")
                .author("Author 1")
                .bookShelf(bookShelfService.find(firstID))
                .build();
        Book book2 = Book.builder()
                .title("Title 2")
                .author("Author 1")
                .bookShelf(bookShelfService.find(firstID))
                .build();
        Book book3 = Book.builder()
                .title("Title 3")
                .author("Author 1")
                .bookShelf(bookShelfService.find(firstID))
                .build();
        Book book4 = Book.builder()
                .title("Title 4")
                .author("Author 1")
                .bookShelf(bookShelfService.find(secondID))
                .build();
        Book book5 = Book.builder()
                .title("Title 5")
                .author("Author 1")
                .bookShelf(bookShelfService.find(secondID))
                .build();
        Book book6 = Book.builder()
                .title("Title 6")
                .author("Author 1")
                .bookShelf(bookShelfService.find(thirdID))
                .build();
        bookService.create(book1);
        bookService.create(book2);
        bookService.create(book3);
        bookService.create(book4);
        bookService.create(book5);
        bookService.create(book6);
        Book book7 = Book.builder()
                .title("Title 1")
                .author("Author 2")
                .bookShelf(bookShelfService.find(firstID))
                .build();
        Book book8 = Book.builder()
                .title("Title 2")
                .author("Author 2")
                .bookShelf(bookShelfService.find(secondID))
                .build();
        Book book9 = Book.builder()
                .title("Title 3")
                .author("Author 2")
                .bookShelf(bookShelfService.find(secondID))
                .build();
        Book book10 = Book.builder()
                .title("Title 4")
                .author("Author 2")
                .bookShelf(bookShelfService.find(secondID))
                .build();
        Book book11 = Book.builder()
                .title("Title 5")
                .author("Author 2")
                .bookShelf(bookShelfService.find(thirdID))
                .build();
        Book book12 = Book.builder()
                .title("Title 6")
                .author("Author 2")
                .bookShelf(bookShelfService.find(thirdID))
                .build();
        bookService.create(book7);
        bookService.create(book8);
        bookService.create(book9);
        bookService.create(book10);
        bookService.create(book11);
        bookService.create(book12);
    }
    private void createShelves(){
        UUID firstID = UUID.randomUUID();
        UUID secondID = UUID.randomUUID();
        UUID thirdID = UUID.randomUUID();

        BookShelf first = BookShelf.builder()
                .id(firstID)
                .build();
        BookShelf second = BookShelf.builder()
                .id(secondID)
                .build();
        BookShelf third = BookShelf.builder()
                .id(thirdID)
                .build();
        bookShelfService.create(first);
        bookShelfService.create(second);
        bookShelfService.create(third);
        createBooks(firstID, secondID, thirdID);
    }
}
