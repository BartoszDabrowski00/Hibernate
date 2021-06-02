import services.DataInitializer;
import repositories.BookShelfRepository;
import repositories.BookRepository;
import services.BookShelfService;
import services.BookService;
import views.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class PT4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pt4PU");

        BookShelfService bookShelfService = new BookShelfService(new BookShelfRepository(emf));
        BookService bookService = new BookService(new BookRepository(emf));

        if(args.length>0 && Boolean.parseBoolean(args[0])){
            new DataInitializer(bookService, bookShelfService).initialize();
        }
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.println("add/remove/show/query");
            String command = scanner.next();
            switch (command) {
                case "add" -> {
                    System.out.println("book/shelf");
                    String addType = scanner.next();
                    switch (addType) {
                        case "book" -> new BookAdd(bookService, bookShelfService).display();
                        case "shelf" -> new BookShelfAdd(bookShelfService).display();
                    }
                }
                case "remove" -> {
                    System.out.println("book/shelf");
                    String removeType = scanner.next();
                    switch (removeType) {
                        case "book" -> new BookRemove(bookService).display();
                        case "shelf" -> new BookShelfRemove(bookShelfService).display();
                    }
                }
                case "show" -> {
                    System.out.println("books/shelves");
                    String type = scanner.next();
                    switch(type){
                        case "shelves" -> new BookShelfList(bookShelfService).display();
                        case "books" -> new BookList(bookService).display();
                    }
                }
                case "query" -> new AuthorWorksNumById(bookService).display();
                case "quit" -> quit = true;
            }
        }

    }
}
