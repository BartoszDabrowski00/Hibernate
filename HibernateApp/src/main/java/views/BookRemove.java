package views;

import entities.Book;
import services.BookService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class BookRemove {
    private final BookService bookService;

    public void display(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type id");
        int id = scanner.nextInt();
        Book entity = bookService.find(id);
        if(entity==null){
            System.out.println("Wrong name");
        } else{
            bookService.delete(entity);
        }
    }
}
