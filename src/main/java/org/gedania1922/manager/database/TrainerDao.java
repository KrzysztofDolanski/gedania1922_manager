package org.gedania1922.manager.database;

import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Trainer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TrainerDao {

    public List<Trainer> findByName(Class<Trainer> classType, String name){
        List<Trainer>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Trainer> criteriaQuery = cb.createQuery(classType);
            Root<Trainer> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("name"), name));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public List<Trainer> findBySurname(Class<Trainer> classType, String surname){
        List<Trainer>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Trainer> criteriaQuery = cb.createQuery(classType);
            Root<Trainer> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("surname"), surname));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public List<Trainer> findByCertyficates(Class<Trainer> classType, String certyficates){
        List<Trainer>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Trainer> criteriaQuery = cb.createQuery(classType);
            Root<Trainer> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("certyficates"), certyficates));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }
}
