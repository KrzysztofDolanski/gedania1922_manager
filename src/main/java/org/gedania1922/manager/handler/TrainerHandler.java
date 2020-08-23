package org.gedania1922.manager.handler;

import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.database.HibernateFactory;
import org.gedania1922.manager.database.TrainerDao;
import org.gedania1922.manager.peoples.Team;
import org.gedania1922.manager.peoples.Trainer;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TrainerHandler {

    Scanner scanner = new Scanner(System.in);

    public void handle() {
        String userCommandTrainer;

        do {
            System.out.println("write command");
            System.out.println("Trainer add \n" +
                    "Trainer show \n" +
                    "Trainer find by \n" +
                    "Trainer delete\n" +
                    "Quit");
            userCommandTrainer = scanner.nextLine();
            String[] words = userCommandTrainer.split(" ");

            if (words[0].equalsIgnoreCase("trainer")
                    && words[1].equalsIgnoreCase("add")) {
                addTrainer(words);
            } else if (words[0].equalsIgnoreCase("trainer")
                    && words[1].equalsIgnoreCase("find")
                    && words[2].equalsIgnoreCase("by")) {
                System.out.println(" id\n surname\n name\n certyficates");
                userCommandTrainer = scanner.nextLine();
                String[] words2 = userCommandTrainer.split(" ");
                if (words2[0].equalsIgnoreCase("id")) {
                    findByIdTrainer(words2);
                } else if (words2[0].equalsIgnoreCase("surname")) {
                    findBySurnameTrainer(words2);
                } else if (words2[0].equalsIgnoreCase("name")) {
                    findByNameTrainer(words2);
                } else if (words2[0].equalsIgnoreCase("certyficates")) {
                    findByCertyficatesTrainer(words2);
                }
            } else if (words[0].equalsIgnoreCase("trainer")
                    && words[1].equalsIgnoreCase("show")) {
                showTrainers(words);
            } else if (words[0].equalsIgnoreCase("trainer")
                    && words[1].equalsIgnoreCase("delete")) {
                deleteTrainer(words);
            }
        }
        while (!userCommandTrainer.equalsIgnoreCase("quit"));
    }

    private void addTrainer(String[] words) {
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.println("Write surname");
            String surname = scanner.nextLine();
            System.out.println("write name");
            String name = scanner.nextLine();
            System.out.println("write certyficates");
            String certyficates = scanner.nextLine();

            System.out.println("podaj nazwę zespołu");
            EntityDao<Team> teamEntityDao = new EntityDao<>();
            String teamName = scanner.nextLine();

            Team team = new Team(teamName);
            teamEntityDao.saveOrUpdate(team);
            trainerEntityDao.saveOrUpdate(new Trainer(surname, name, certyficates, team));
        } catch (IllegalArgumentException e) {
            System.err.println("use letters");
        }

    }

    private void findByIdTrainer(String[] words) {
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        System.out.println("choose trainer ID to find");
        Scanner scanner = new Scanner(System.in);
        Long trainerChoosen = Long.parseLong(scanner.nextLine());
        Optional<Trainer> resultPlayerOptional = trainerEntityDao.findById(Trainer.class, trainerChoosen);
        if (resultPlayerOptional.isPresent()) {
            System.out.println("Znaleziono " + resultPlayerOptional.get());
        } else System.out.println("nie znaleziono");
    }

    private void findByNameTrainer(String[] words2) {
        TrainerDao trainerDao = new TrainerDao();
        System.out.println("choose trainer name to find");
        Scanner scanner = new Scanner(System.in);
        String trainerChoosen = scanner.nextLine();
        List<Trainer> resultTrainerList = trainerDao.findByName(Trainer.class, trainerChoosen);
        if (resultTrainerList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultTrainerList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    private void findBySurnameTrainer(String[] words2) {
        TrainerDao trainerDao = new TrainerDao();
        System.out.println("choose trainer surname to find");
        Scanner scanner = new Scanner(System.in);
        String trainerChoosen = scanner.nextLine();
        List<Trainer> resultTrainerList = trainerDao.findBySurname(Trainer.class, trainerChoosen);
        if (resultTrainerList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultTrainerList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    private void findByCertyficatesTrainer(String[] words2) {
        TrainerDao trainerDao = new TrainerDao();
        System.out.println("choose trainer certyficate to find");
        Scanner scanner = new Scanner(System.in);
        String trainerChoosen = scanner.nextLine();
        List<Trainer> resultTrainerList = trainerDao.findByCertyficates(Trainer.class, trainerChoosen);
        if (resultTrainerList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultTrainerList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }


    private void deleteTrainer(String[] words) {
        Session session = HibernateFactory.getSessionFactory().openSession();

        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        System.out.println("choose player number to delete");
        Scanner scanner = new Scanner(System.in);
        Long trainerChoosen = Long.parseLong(scanner.nextLine());
        Optional<Trainer> trainerToDeleteFromDataBase = trainerEntityDao
                .findById(Trainer.class, trainerChoosen);
        if (trainerToDeleteFromDataBase.isPresent()) {
            Trainer trainer = trainerToDeleteFromDataBase.get();
            System.out.println("Usuwam" + trainerToDeleteFromDataBase.get());
            trainerEntityDao.delete(trainer);
        } else System.out.println("Nie znaleziono");
        session.close();
    }


    private void showTrainers(String[] words) {
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        trainerEntityDao.findAll(Trainer.class).stream().forEach(System.out::println);
    }

}
