package org.gedania1922.manager.database;

import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.gedania1922.manager.training.Training;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {

//    public void findByPlayerId( Player player){
//        List<Team>list = new ArrayList<>();
//        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
//        try (Session session = sessionFactory.openSession()) {
//            CriteriaBuilder cb = session.getCriteriaBuilder();
//            CriteriaQuery<Team> criteriaQuery = cb.createQuery(Team.class);
//            Root<Team> rootTable = criteriaQuery.from(Team.class);
//            criteriaQuery.select(rootTable)
//                    .where(cb.equal(rootTable.get("players"), playerId));
//            list.addAll(session.createQuery(criteriaQuery).list());
//            System.out.println(list.stream().map(Team::getTeamName));
//
//        } catch (HibernateException he) {
//            he.printStackTrace();
//        };
//    }
}
