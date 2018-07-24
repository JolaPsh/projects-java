package service;

import entity.Book;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joanna Pakosh on 06, 2018
 */

public class ServiceImpl {

    private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("link_JPA");
    public EntityManager entitymanager;

    public ServiceImpl() {
        entitymanager = emfactory.createEntityManager();
    }

    public List<Book> findAll() {
        entitymanager.getTransaction().begin();
        List<Book> books = entitymanager.createQuery("SELECT e FROM Book e").getResultList();
        entitymanager.getTransaction().commit();
        return books;
    }

    public void add(Book value) {
        entitymanager.getTransaction().begin();
        entitymanager.persist(value);
        entitymanager.getTransaction().commit();
    }

    public void merge(Book value) {
        entitymanager.getTransaction().begin();
        entitymanager.merge(value);
        entitymanager.getTransaction().commit();
    }

    public void delete(Long id) {
        Book value = entitymanager.find(Book.class, id);
        if (value != null) {
            entitymanager.getTransaction().begin();
            entitymanager.remove(value);
            entitymanager.getTransaction().commit();
        }
    }

    public List<Book> filterByTitleAndAuthor(String filteredText) {
        entitymanager.getTransaction().begin();
        Query selectedByTitle = entitymanager.createQuery("SELECT e FROM Book e WHERE e.title LIKE '%" + filteredText + "%'");
        Query selectedByAuthor = entitymanager.createQuery("SELECT e FROM Book e WHERE e.author LIKE '%" + filteredText + "%'");

        List<Book> filterByTitleAndAuthor = new ArrayList<>();
        filterByTitleAndAuthor.addAll(selectedByTitle.getResultList());
        filterByTitleAndAuthor.addAll(selectedByAuthor.getResultList());

        entitymanager.getTransaction().commit();
        return filterByTitleAndAuthor;
    }

    public Integer count() {
        return findAll().size();
    }

    public List<Book> displayPage(int pageNumber, int pageSize) {

        CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> from = cq.from(Book.class);
        CriteriaQuery<Book> select = cq.select(from);
        TypedQuery<Book> tq = entitymanager.createQuery(select);

        tq.setFirstResult((pageNumber - 1) * pageSize);
        tq.setMaxResults(pageSize);

        return tq.getResultList();
    }
}




