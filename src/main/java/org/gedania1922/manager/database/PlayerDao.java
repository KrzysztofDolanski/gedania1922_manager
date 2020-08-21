package org.gedania1922.manager.database;

import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.player_tests.SkillsMachine;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.*;


public class PlayerDao  {

    private HibernateFactory hibernateFactory = new HibernateFactory();

    public List<Player> findBySurname(Class<Player> classType, String surname){
        List<Player>list = new ArrayList<>();

        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<Player> rootTable = criteriaQuery.from(classType);

            // wykonanie zapytania
            criteriaQuery.select(rootTable)
                    .where(
                            // *lastName*
                            // czy wartośćkolumny 'lastName' jest równa wartości zmiennej lastName
                            cb.equal(rootTable.get("surname"), surname)
                    );

            // specification
            list.addAll(session.createQuery(criteriaQuery).list());

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return list;
    }

    public List<Player> findByName(Class<Player> classType, String name){
        List<Player>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);
            Root<Player> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("name"), name));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public List<Player> findByWeight(Class<Player> classType, double weight){
        List<Player>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);
            Root<Player> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("weight"), weight));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public List<Player> findPosition(Class<Player> classType, Player.Position position){
        List<Player>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);
            Root<Player> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("positionOnField"), position));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public List<Player> findByGrowth(Class<Player> classType, double growth){
        List<Player>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);
            Root<Player> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("growth"), growth));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public List<Player> findByDate(Class<Player> classType, LocalDate date){
        List<Player>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);
            Root<Player> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("birthDate"), date));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public List<Player> findLeftFooted(Class<Player> classType, boolean leftFooted){
        List<Player>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);
            Root<Player> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("leftFooted"), leftFooted));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }


    public List<Player> findRightFooted(Class<Player> classType, boolean rightFooted){
        List<Player>list = new ArrayList<>();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Player> criteriaQuery = cb.createQuery(classType);
            Root<Player> rootTable = criteriaQuery.from(classType);
            criteriaQuery.select(rootTable)
                    .where(cb.equal(rootTable.get("rightFooted"), rightFooted));
            list.addAll(session.createQuery(criteriaQuery).list());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public void updateSkills(Class<Player> classType, long id){

        SkillsMachine skillsMachine = new SkillsMachine();
        double skills = skillsMachine.playerSkillsUpdate();
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        Optional<Player> byId = playerEntityDao.findById(classType, id);
        byId.stream().findFirst().get().setSkillsValue(skills);
        playerEntityDao.saveOrUpdate(byId.get());

    }
    }





