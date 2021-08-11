package org.example.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory factory;
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        factory = configuration
                .addAnnotatedClass(Catalog.class)
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Reader.class)
                .buildSessionFactory();

        Session session = null;

        try{

//            CREATE
//            session = factory.getCurrentSession();
//            Catalog catalog = new Catalog("Fantasy #10");
//            Catalog catalog4 = new Catalog("Fantasy #13");
//            session.beginTransaction();
//            session.save(catalog);
//            session.save(catalog4);
//            session.getTransaction().commit();

//            session = factory.getCurrentSession();
//            Author author = new Author();
//            author.setName("Rowling");
//            session.beginTransaction();
//            session.save(author);
//            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            Reader reader = session.get(Reader.class, 1L);
            Book book = session.get(Book.class, 2L);
//            reader.getBooks().add(book);
            reader.getBooks().clear();
            session.getTransaction().commit();

//            READ
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog1 = session.get(Catalog.class, 1L);
//            session.getTransaction().commit();
//            System.out.println(catalog1);

//            UPDATE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog2 = session.get(Catalog.class, 2L);
//            session.detach(catalog2);   // отвязываем от Hibernate
//            catalog2.setTitle("Fantasy #13");
//            session.getTransaction().commit();
//            System.out.println(catalog2);

//            DELETE
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Catalog catalog3 = session.get(Catalog.class, 1L);
//            session.delete(catalog3);
//            session.remove(catalog3);
//            session.getTransaction().commit();

//            FILTER
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            List<Catalog> allCatalogs = session.createQuery("from Catalog").getResultList();
//            List<Catalog> filterCatalog = session.createQuery("from Catalog c where c.title = :title")
//                    .setParameter("title", "Fantasy #14").getResultList();
//            System.out.println(allCatalogs);
//            System.out.println(filterCatalog);
//            session.getTransaction().commit();

//            SQL
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.createQuery("update Catalog  set title = 'unknown'").executeUpdate();
//            session.createQuery("delete from Catalog where id = 3").executeUpdate();
//            session.getTransaction().commit();
        } finally {
            factory.close();
            session.close();
        }
    }
}
