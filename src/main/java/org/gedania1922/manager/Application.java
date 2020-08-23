package org.gedania1922.manager;


import org.gedania1922.manager.database.*;
import org.gedania1922.manager.handler.*;

import java.util.*;


public class Application {

    // TODO: wydzielić handlers
    // todo: zamienic nextInt na Integer.parseInt(scanner.nextLine());
    // todo: usunac zbedne parametry
    // todo: usunac statici
    public static void main(String[] args) {
        System.out.println("Zaczynamy");

        HibernateFactory.getSessionFactory();
        PlayerHandler handler = new PlayerHandler();
        TrainerHandler trainerHandler = new TrainerHandler();
        TrainingHandler trainingHandler = new TrainingHandler();
        TeamHandler teamHandler = new TeamHandler();
        SkillsHandler skillsHandler = new SkillsHandler();

        Scanner scanner = new Scanner(System.in);

        String userCommandPrevious;

        do {
            System.out.println("Write witch table in database you wanted to use");
            System.out.println("Player\n" +
                    "Trainer\n" +
                    "Team\n" +
                    "Training\n" +
                    "Skills\n" +
                    "Quit");
            userCommandPrevious = scanner.nextLine();
            String[] wordsPrevious = userCommandPrevious.split(" ");

            if (wordsPrevious[0].equalsIgnoreCase("player")) {
                handler.handle();

            } else if (wordsPrevious[0].equalsIgnoreCase("trainer")) {
                trainerHandler.handle();

            } else if (wordsPrevious[0].equalsIgnoreCase("training")) {
                trainingHandler.handle();

            } else if (wordsPrevious[0].equalsIgnoreCase("team")) {
                teamHandler.handle();

            } else if (wordsPrevious[0].equalsIgnoreCase("skills")){
                skillsHandler.handle();
            }

        } while (!userCommandPrevious.equalsIgnoreCase("quit"));
    }
}
