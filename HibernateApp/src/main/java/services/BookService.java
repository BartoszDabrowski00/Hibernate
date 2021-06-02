package services;

import entities.Book;
import repositories.BookRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public void delete(Book entity){
        repository.delete(entity);
    }

    public Book find(int id){
        return repository.find(id);
    }

    public void create(Book entity){
        repository.add(entity);
    }

    public int countAuthorWorksOnShelf(UUID id, String author){
        return repository.countAuthorWorksOnShelf(id, author);
    }
}
