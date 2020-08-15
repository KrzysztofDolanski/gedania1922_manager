package org.gedania1922.manager;


import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.database.HibernateFactory;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.gedania1922.manager.peoples.Trainer;
import org.gedania1922.manager.training.Training;

import java.util.Set;

public class Application {

    public static void main(String[] args) {
        System.out.println("Zaczynamy");


        HibernateFactory.getSessionFactory();
        System.out.println("asd");

        EntityDao<Player> playerEntityDao = new EntityDao<>();
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        EntityDao<Training> trainingEntityDao = new EntityDao<>();

        playerEntityDao.saveOrUpdate(new Player("Dolański", "Krzysztof"));
        trainerEntityDao.saveOrUpdate(new Trainer("Dolański", "Bartosz"));
        teamEntityDao.saveOrUpdate(new Team(1, 1));
        trainingEntityDao.saveOrUpdate(new Training("12.12.12", "skipy"));


    }
}
