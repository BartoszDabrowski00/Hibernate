package repositories;

import entities.BookShelf;
import entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;


public class BookRepository {
    private final EntityManagerFactory emf;
    private final Class<Book> cls;

    public BookRepository(EntityManagerFactory emf){
        this.emf = emf;
        this.cls = Book.class;
    }
    public List<Book> findAll(){
        EntityManager em = emf.createEntityManager();
        List<Book> list = em.createQuery("select Book from " + cls.getSimpleName()+" Book",cls).getResultList();
        em.close();
        return list;
    }

    public Book find(int id){
        EntityManager em = emf.createEntityManager();
        Book entity = em.find(cls, id);
        em.close();
        return entity;
    }

    public void delete(Book entity){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        BookShelf b = em.find(BookShelf.class,entity.getBookShelf().getId());
        b.removeBook(entity);
        em.merge(b);
        em.remove(em.merge(entity));

        transaction.commit();
        em.close();

    }

    public void add(Book entity){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        BookShelf bookShelfEntity = em.find(BookShelf.class, entity.getBookShelf().getId());
        bookShelfEntity.getBooks().add(entity);
        em.merge(bookShelfEntity);
        transaction.commit();
        em.close();
    }

    public int countAuthorWorksOnShelf(UUID id, String author) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select count(Book) from " + Book.class.getSimpleName()+
                " Book WHERE Book .author = :author and Book .bookShelf .id = :id");
        query.setParameter("id", id);
        query.setParameter("author", author);
        Long count = (Long)query.getSingleResult();
        em.close();
        return Math.toIntExact(count);
    }
}
