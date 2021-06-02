package views;
import entities.BookShelf;
import services.BookShelfService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookShelfList {
    private final BookShelfService bookShelfService;

    public void display(){
        for(BookShelf shelf : bookShelfService.findAll()){
            System.out.println(shelf);
            System.out.println(bookShelfService.findBooks(shelf.getId()));
        }
    }
}
