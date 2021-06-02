package services;

import entities.Book;
import entities.BookShelf;
import repositories.BookShelfRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class BookShelfService {
    private final BookShelfRepository repository;

    public List<BookShelf> findAll(){
        return repository.findAll();
    }

    public void delete(BookShelf entity){
        repository.delete(entity);
    }

    public BookShelf find(UUID id){
        return repository.find(id);
    }

    public List<Book> findBooks(UUID id){
        return repository.findBooks(id);
    }
    public void create(BookShelf entity){
        repository.add(entity);
    }
}
