package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "bookshelves")
public class BookShelf implements Serializable {
    @Id
    private UUID id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    @Override
    public String toString(){
        return "Shelf id: " + id + " books:";
    }

    public void removeBook(Book entity){
        for(Book book : books){
            if(book.getId() == entity.getId()){
                books.remove(book);
                break;
            }
        }
    }
}
