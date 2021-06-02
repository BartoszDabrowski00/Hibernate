package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
@Getter
@Setter
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String title;

    private String author;

    @ManyToOne
    private BookShelf bookShelf;

    @Override
    public String toString(){
        return "\n BookID: " + id + " title: " + title + " author: " + author;
    }

}
