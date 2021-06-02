package views;

import entities.Book;
import services.BookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookList {
    private final BookService bookService;

    public void display(){
        for(Book book : bookService.findAll()){
            System.out.println(book);
        }
    }
}
