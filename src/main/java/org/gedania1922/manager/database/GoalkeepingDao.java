package org.gedania1922.manager.database;

import org.gedania1922.manager.skills.Goalkeeping;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class GoalkeepingDao {


    public List<Goalkeeping> findByPlayerId(Class<Goalkeeping> classType, long playerId){
        List<Goalkeeping>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Goalkeeping> criteriaQuery = cb.createQuery(classType);
            Root<Goalkeeping> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("players"), playerId));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }
}

