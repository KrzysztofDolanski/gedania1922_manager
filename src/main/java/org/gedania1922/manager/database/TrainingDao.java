package org.gedania1922.manager.database;

import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Trainer;
import org.gedania1922.manager.training.Training;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TrainingDao {

    public List<Training> findByPlayerId(Class<Training> classType, long playerId){
        List<Training>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Training> criteriaQuery = cb.createQuery(classType);
            Root<Training> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("playerId"), playerId));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }
}
