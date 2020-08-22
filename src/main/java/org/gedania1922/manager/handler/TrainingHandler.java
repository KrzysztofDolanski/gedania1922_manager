package org.gedania1922.manager.handler;

import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.database.TrainingDao;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Trainer;
import org.gedania1922.manager.training.Training;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class TrainingHandler {

    Scanner scanner = new Scanner(System.in);

    public void handle() {
        String userCommandTrainer;

        do {
            System.out.println("write command");
            System.out.println("Training add \n" +
                    "Training show \n" +
                    "Training find by \n" +
                    "Training delete\n" +
                    "Quit");
            userCommandTrainer = scanner.nextLine();
            String[] words = userCommandTrainer.split(" ");

            if (words[0].equalsIgnoreCase("training")
                    && words[1].equalsIgnoreCase("add")) {
                addTraining(words);
            } else if (words[0].equalsIgnoreCase("training") &&
                    words[1].equalsIgnoreCase("find")
                    && words[2].equalsIgnoreCase("by")) {
                System.out.println("id\n playerId");
                userCommandTrainer = scanner.nextLine();
                String[] words2 = userCommandTrainer.split(" ");
                if (words2[0].equalsIgnoreCase("id")) {
                    findByIdTraining(words2);
                } else if (words2[0].equalsIgnoreCase("playerId")) {
                    findTrainingByPlayerId();
                }
            }

        } while (!userCommandTrainer.equalsIgnoreCase("quit"));
    }

    private void addTraining(String[] words) {
        EntityDao<Training> trainingEntityDao = new EntityDao<>();
        EntityDao<Player> playerEntityDao = new EntityDao<>();

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Write training type");
            String typeOfTraining = scanner.nextLine();
            System.out.println("Write training - year");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.println("Write training - month");
            int month = Integer.parseInt(scanner.nextLine());
            System.out.println("Write training - day");
            int day = Integer.parseInt(scanner.nextLine());
            System.out.println("Write player ID");
            Long playerID = Long.parseLong(scanner.nextLine());
            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerID);

            Player player = byIdPlayer.stream().findFirst().get();

            trainingEntityDao.saveOrUpdate(new Training(LocalDate.of(year, month, day), typeOfTraining, player));
        } catch (IllegalArgumentException e) {
            System.err.println("use yyyy mm dd or letters for ID");
        }
    }

    private void findByIdTraining(String[] words) {
        EntityDao<Training> trainingEntityDao = new EntityDao<>();
        System.out.println("choose training ID to find\n");
        Scanner scanner = new Scanner(System.in);
        try {
            Long trainingChoosen = Long.parseLong(scanner.nextLine());
            Optional<Training> resultTrainingOptional = trainingEntityDao
                    .findById(Training.class, trainingChoosen);
            if (resultTrainingOptional.isPresent()) {
                System.out.println("Znaleziono " + resultTrainingOptional.get());
            } else System.out.println("nie znaleziono");
        } catch (NumberFormatException e) {
            System.err.println("Use numbers to find ID");
        }

    }

    private void findTrainingByPlayerId() {
        TrainingDao trainingDao = new TrainingDao();
        System.out.println("choose player ID to find training\n");
        Scanner scanner = new Scanner(System.in);
        try {
            Long playerChoosen = Long.parseLong(scanner.nextLine());
            List<Training> byPlayerId = trainingDao.findByPlayerId(Training.class, playerChoosen);
            Stream<Training> stream = byPlayerId.stream();
            stream.map(Training::getTypeOfTraining).forEach(System.out::println);
        } catch (NumberFormatException e) {
            System.err.println("Use numbers to find ID");
        }

    }
}
