package repositories;

import entities.BookShelf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;


public class BookShelfRepository {
    private final EntityManagerFactory emf;
    private final Class<BookShelf> cls;

    public BookShelfRepository(EntityManagerFactory emf){
        this.emf = emf;
        this.cls = BookShelf.class;
    }
    public List<BookShelf> findAll(){
        EntityManager em = emf.createEntityManager();
        List<BookShelf> list = em.createQuery("select BookShelf from " + cls.getSimpleName()+" BookShelf",cls).getResultList();
        em.close();
        return list;
    }

    public BookShelf find(UUID id){
        EntityManager em = emf.createEntityManager();
        BookShelf entity = em.find(cls, id);
        em.close();
        return entity;
    }

    public void delete(BookShelf entity){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.merge(entity));
        transaction.commit();
        em.close();
    }

    public void add(BookShelf entity){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
        em.close();
    }

    public List findBooks(UUID id) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select BookShelf.books from " + cls.getSimpleName()+" BookShelf WHERE BookShelf .id = :id");
        query.setParameter("id", id);
        List shelfContent = query.getResultList();
        em.close();
        return shelfContent;
    }
}
