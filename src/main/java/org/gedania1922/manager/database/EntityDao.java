package org.gedania1922.manager.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.*;

public class EntityDao <T>{

    public void saveOrUpdate(T entity) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);

            transaction.commit();

        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Optional<T> findById(Class<T> classType, Long id) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // istnieje prawdopodobieństwo, że rekord nie zostanie odnaleziony
            return Optional.ofNullable(session.get(classType, id));
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return Optional.empty();
    }


    public Set<T> findById2(Class<T> classType, Long id) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // istnieje prawdopodobieństwo, że rekord nie zostanie odnaleziony
            return Set.of(session.get(classType, id));
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return Set.of();
    }

//    public Optional<T> findByBirthDate(Class<T> classType, LocalDate date) {
//        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//
//            // istnieje prawdopodobieństwo, że rekord nie zostanie odnaleziony
//            return Optional.ofNullable(session.get(classType, date));
//        } catch (HibernateException he) {
//            he.printStackTrace();
//        }
//        return Optional.empty();
//


    public void delete(T entity) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            // instrukcja która służy do usuwania z bazy danych
            session.delete(entity);

            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<T> findAll(Class<T> classType) {
        List<T> list = new ArrayList<>();

        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<T> criteriaQuery = cb.createQuery(classType);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<T> rootTable = criteriaQuery.from(classType);

            // wykonanie zapytania
            criteriaQuery.select(rootTable);

            // specification
            list.addAll(session.createQuery(criteriaQuery).list());

            // poznanie uniwersalnego rozwiązania które działa z każdą bazą danych
            // używanie klas których będziecie używać na JPA (Spring)

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }
}
