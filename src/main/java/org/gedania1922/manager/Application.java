package org.gedania1922.manager;


import org.gedania1922.manager.database.*;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.gedania1922.manager.peoples.Trainer;
import org.gedania1922.manager.training.Training;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Table;
import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        System.out.println("Zaczynamy");

        HibernateFactory.getSessionFactory();

        Scanner scanner = new Scanner(System.in);


        String userCommandPrevious;

            do {
                System.out.println("Write witch table in database you wanted to use");
                System.out.println("Player\n" +
                        "Trainer\n" +
                        "Team\n" +
                        "Training\n" +
                        "Quit");
                userCommandPrevious = scanner.nextLine();
                String[] wordsPrevious = userCommandPrevious.split(" ");

                if (wordsPrevious[0].equalsIgnoreCase("player")) {
                    String userCommand;
                    do {
                        System.out.println("write command");
                        System.out.println("Player add \n" +
                                "Player show \n" +
                                "Player find by \n" +
                                "Player delete\n" +
                                "Quit");
                        userCommand = scanner.nextLine();
                        String[] words = userCommand.split(" ");

                        if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("show")) {
                            showPlayers(words);
                        } else if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("add")) {
                            addPlayer(words);
                        } else if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("delete")) {
                            deletePlayer(words);
                        } else if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("find")
                                && words[2].equalsIgnoreCase("by")) {
                            System.out.println(" id\n surname\n name\n weight\n growth \n date\n position\n foot");
                            userCommand = scanner.nextLine();
                            String[] words2 = userCommand.split(" ");
                            if (words2[0].equalsIgnoreCase("id")) {
                                findByIdPlayer(words2);
                            } else if (words2[0].equalsIgnoreCase("surname")) {
                                findBySurnamePlayer(words2);
                            } else if (words2[0].equalsIgnoreCase("name")) {
                                findByNamePlayer(words2);
                            } else if (words2[0].equalsIgnoreCase("weight")) {
                                findByWeightPlayer(words2);
                            } else if (words2[0].equalsIgnoreCase("growth")) {
                                findByGrowthPlayer(words2);
                            } else if (words2[0].equalsIgnoreCase("date")) {
                                findByDatePlayer(words2);
                            } else if (words2[0].equalsIgnoreCase("foot")) {
                                System.out.println("right\n left\n both");
                                userCommand = scanner.nextLine();
                                String[] words3 = userCommand.split(" ");
                                if (words3[0].equalsIgnoreCase("left")) {
                                    findLeftFootPlayers(words3);
                                } else if (words3[0].equalsIgnoreCase("right")) {
                                    findRightFootPlayers(words3);
                                } else if (words3[0].equalsIgnoreCase("both")) {
                                    findBothFootedPlayer(words3);
                                }
                            } else if (words2[0].equalsIgnoreCase("position")) {
                                findByPositionPlayer(words2);
                            }
                        }
                    } while (!userCommand.equalsIgnoreCase("quit"));

                }else if (wordsPrevious[0].equalsIgnoreCase("trainer")) {
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
                                &&words[1].equalsIgnoreCase("add")){
                            addTrainer(words);
                        }else if (words[0].equalsIgnoreCase("trainer")
                                && words[1].equalsIgnoreCase("find")
                                && words[2].equalsIgnoreCase("by")) {
                            System.out.println(" id\n surname\n name\n certyficates");
                            userCommandTrainer = scanner.nextLine();
                            String[] words2 = userCommandTrainer.split(" ");
                            if (words2[0].equalsIgnoreCase("id")) {
                                findByIdTrainer(words2);
                            }else if (words2[0].equalsIgnoreCase("surname")){
                                findBySurnameTrainer(words2);
                            }else if (words2[0].equalsIgnoreCase("name")){
                                findByNameTrainer(words2);
                            }else if (words2[0].equalsIgnoreCase("certyficates")){
                                findByCertyficatesTrainer(words2);
                            }
                        }else if (words[0].equalsIgnoreCase("trainer")
                                && words[1].equalsIgnoreCase("show")){
                            showTrainers(words);
                        }else if (words[0].equalsIgnoreCase("trainer")
                        && words[1].equalsIgnoreCase("delete")){
                            deleteTrainer(words);
                        }
                }
                    while (!userCommandTrainer.equalsIgnoreCase("quit"));

                }else if (wordsPrevious[0].equalsIgnoreCase("trening")){
                    System.out.println("metody do treningu");
                }else if (wordsPrevious[0].equalsIgnoreCase("team")){
                    String userCommandTrainer;

                    do {
                        System.out.println("write command");
                        System.out.println("Team add \n" +
                                "Team show \n" +
                                "Team find by \n" +
                                "Team delete\n" +
                                "Quit");
                        userCommandTrainer = scanner.nextLine();
                        String[] words = userCommandTrainer.split(" ");

                        if (words[0].equalsIgnoreCase("team")
                                && words[1].equalsIgnoreCase("add")) {
                            addTeam(words);
                        }

                    }while (!userCommandPrevious.equalsIgnoreCase("quit"));
                }

            } while (!userCommandPrevious.equalsIgnoreCase("quit"));


//        EntityDao<Player> playerEntityDao = new EntityDao<>();
//        EntityDao<Team> teamEntityDao = new EntityDao<>();
//        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
//        EntityDao<Training> trainingEntityDao = new EntityDao<>();

//        playerEntityDao.saveOrUpdate(new Player("Dolański", "Krzysztof"));
//        trainerEntityDao.saveOrUpdate(new Trainer("Dolański", "Bartosz"));
//        teamEntityDao.saveOrUpdate(new Team(1, 1));
//        trainingEntityDao.saveOrUpdate(new Training(LocalDate.of(1, Month.APRIL, 12), "skipy"));

            scanner.close();
        }

    private static void addTeam(String[] words) {
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ID zawodnika");
        Long playerID = Long.parseLong(scanner.nextLine());
        System.out.println("Podaj ID trenera");
        Long trainerID = Long.parseLong(scanner.nextLine());
        Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerID);
        Set<Trainer> byIdTrainer = trainerEntityDao.findById2(Trainer.class, trainerID);
        System.out.print("podaj nazwę drużyny");
        String teamName = scanner.nextLine();

        teamEntityDao.saveOrUpdate(new Team(teamName, byIdPlayer, byIdTrainer));

    }

    private static void addTrainer(String[] words) {
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write surname");
        String surname = scanner.nextLine();
        System.out.println("write name");
        String name = scanner.nextLine();
        System.out.println("write certyficates");
        String certyficates = scanner.nextLine();

        System.out.println("podaj nazwę zespołu");
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        scanner.nextLine();
        String teamName = scanner.nextLine();

        Team team = new Team(teamName);
        teamEntityDao.saveOrUpdate(team);

        trainerEntityDao.saveOrUpdate(new Trainer(surname, name, certyficates, team));
    }

    private static void findByIdTrainer(String[] words) {
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        System.out.println("choose trainer ID to find\n");
        Scanner scanner = new Scanner(System.in);
        Long trainerChoosen = Long.parseLong(scanner.nextLine());
        Optional<Trainer> resultPlayerOptional = trainerEntityDao.findById(Trainer.class, trainerChoosen);
        if (resultPlayerOptional.isPresent()){
            System.out.println("Znaleziono " + resultPlayerOptional.get());
        }else System.out.println("nie znaleziono");
    }

    private static void findByNameTrainer(String[] words2) {
        TrainerDao trainerDao = new TrainerDao();
        System.out.println("choose trainer name to find\n");
        Scanner scanner = new Scanner(System.in);
        String trainerChoosen = scanner.nextLine();
        List<Trainer> resultTrainerList = trainerDao.findByName(Trainer.class, trainerChoosen);
        if (resultTrainerList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultTrainerList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findBySurnameTrainer(String[] words2) {
        TrainerDao trainerDao = new TrainerDao();
        System.out.println("choose trainer surname to find\n");
        Scanner scanner = new Scanner(System.in);
        String trainerChoosen = scanner.nextLine();
        List<Trainer> resultTrainerList = trainerDao.findBySurname(Trainer.class, trainerChoosen);
        if (resultTrainerList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultTrainerList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findByCertyficatesTrainer(String[] words2) {
        TrainerDao trainerDao = new TrainerDao();
        System.out.println("choose trainer certyficate to find\n");
        Scanner scanner = new Scanner(System.in);
        String trainerChoosen = scanner.nextLine();
        List<Trainer> resultTrainerList = trainerDao.findByCertyficates(Trainer.class, trainerChoosen);
        if (resultTrainerList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultTrainerList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }


    private static void deleteTrainer(String[] words) {
        Session session = HibernateFactory.getSessionFactory().openSession();

        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        System.out.println("choose player number to delete\n");
        Scanner scanner = new Scanner(System.in);
        Long trainerChoosen =  Long.parseLong(scanner.nextLine());
        Optional<Trainer> trainerToDeleteFromDataBase = trainerEntityDao.findById(Trainer.class, trainerChoosen);
        if (trainerToDeleteFromDataBase.isPresent()){
            Trainer trainer = trainerToDeleteFromDataBase.get();
            System.out.println("Usuwam" + trainerToDeleteFromDataBase.get());
            trainerEntityDao.delete(trainer);
        } else System.out.println("Nie znaleziono");
        session.close();
    }


    private static void showTrainers(String[] words) {
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        trainerEntityDao.findAll(Trainer.class).stream().forEach(System.out::println);
    }

    private static void findBySurnamePlayer(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player surname to find\n");
        Scanner scanner = new Scanner(System.in);
        String playerChoosen = scanner.nextLine();
        List<Player> resultPlayersList = playerDao.findBySurname(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findByNamePlayer(String[] words2){
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player name to find\n");
        Scanner scanner = new Scanner(System.in);
        String playerChoosen = scanner.nextLine();
        List<Player> resultPlayersList = playerDao.findByName(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findByWeightPlayer(String[] words2){
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player weight to find\n");
        Scanner scanner = new Scanner(System.in);
        int playerChoosen = scanner.nextInt();
        List<Player> resultPlayersList = playerDao.findByWeight(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findByGrowthPlayer(String[] words2){
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player weight to find\n");
        Scanner scanner = new Scanner(System.in);
        int playerChoosen = scanner.nextInt();
        List<Player> resultPlayersList = playerDao.findByGrowth(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }



    private static void findByIdPlayer(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        System.out.println("choose player ID to find\n");
        Scanner scanner = new Scanner(System.in);
        Long playerChoosen = Long.parseLong(scanner.nextLine());
        Optional<Player> resultPlayerOptional = playerEntityDao.findById(Player.class, playerChoosen);
        if (resultPlayerOptional.isPresent()){
            System.out.println("Znaleziono " + resultPlayerOptional.get());
        }else System.out.println("nie znaleziono");
    }

    private static void findByDatePlayer(String[] words) {
        PlayerDao playerEntityDao = new PlayerDao();
        System.out.println("choose player birth date to find\n");
        Scanner scanner = new Scanner(System.in);
        LocalDate playerChoosen = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        List<Player> resultPlayersList = playerEntityDao.findByDate(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findLeftFootPlayers(String[] words2){
        PlayerDao playerDao = new PlayerDao();
        System.out.println("find leftfooted players:\n");
        boolean playerChoosen = true;
        List<Player> resultPlayersList = playerDao.findLeftFooted(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findRightFootPlayers(String[] words2){
        PlayerDao playerDao = new PlayerDao();
        System.out.println("find rightfooted players:\n");
        boolean playerChoosen = true;
        List<Player> resultPlayersList = playerDao.findRightFooted(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    public static Set<Player> findDoublets (List<Player> list){
        final Set<Player> setToReturn = new HashSet<Player>();
        final Set<Player> set1 = new HashSet<Player>();

        for (Player yourPlayer : list){
            if(!set1.add(yourPlayer)){
                setToReturn.add(yourPlayer);
            }
        }
        return setToReturn;
    }

    private static void findBothFootedPlayer(String[] words2){
        PlayerDao playerDao = new PlayerDao();
        System.out.println("find rightfooted players:\n");
        boolean playerChoosen = true;
        List<Player> resultPlayersList = (playerDao.findRightFooted(Player.class, playerChoosen));
        List<Player> leftFooted = playerDao.findLeftFooted(Player.class, playerChoosen);

        List<Player> margedList = new ArrayList<>();
        margedList.addAll(resultPlayersList);
        margedList.addAll(leftFooted);

        Set<Player> doublets = findDoublets(margedList);

        if (doublets.stream().findFirst().isPresent()){
            System.out.println("Znaleziono");
            doublets.forEach(System.out::println);
        }else System.out.println("nie znaleziono");
    }

    private static void findByPositionPlayer(String[] words2){
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player position to find\n" +
                "GOALKEEPER \n" +
                "LEFT_FULLBACK \n" +
                "RIGHT_FULLBACK \n" +
                "SWEEPER \n" +
                "CENTER_BACK\n" +
                "DEFENSIVE_MIDFIELDER \n" +
                "CENTRAL_MIDFIELDER \n" +
                "ATTACKING_MIDFIELDER \n" +
                "LEFT_MIDFIELDER \n " +
                "RIGHT_MIDFIELDER\n" +
                "CENTER_FORWARD \n" +
                "STRIKER \n" +
                "SECOND_STRIKER");
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        do {
         try {
             Player.Position playerChoosen = Player.Position.valueOf(scanner.nextLine());
             List<Player> resultPlayersList = playerDao.findPosition(Player.class, playerChoosen);
             error = false;
             if (resultPlayersList.stream().findFirst().isPresent()){
                 System.out.println("Znaleziono");
                 resultPlayersList.forEach(System.out::println);
             }else System.out.println("nie znaleziono");
         }catch (InputMismatchException e){
             System.out.println("podaj poprawnie pozycję");
             scanner.nextLine();
         }
        }while (error);
    }


    private static void deletePlayer(String[] words) {
        Session session = HibernateFactory.getSessionFactory().openSession();

        EntityDao<Player> playerEntityDao = new EntityDao<>();
        System.out.println("choose player number to delete\n");
        Scanner scanner = new Scanner(System.in);
        Long playerChoosen =  Long.parseLong(scanner.nextLine());
        Optional<Player> playerToDeleteFromDataBase = playerEntityDao.findById(Player.class, playerChoosen);
        if (playerToDeleteFromDataBase.isPresent()){
            Player player = playerToDeleteFromDataBase.get();
            System.out.println("Usuwam" + playerToDeleteFromDataBase.get());
            playerEntityDao.delete(player);
        } else System.out.println("Nie znaleziono");
        session.close();
    }


    private static void addPlayer(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write surname");
        String surname = scanner.nextLine();
        System.out.println("write name");
        String name = scanner.nextLine();
        System.out.println("Write birth - year");
        int year = scanner.nextInt();
        System.out.println("Write birth - month");
        int month = scanner.nextInt();
        System.out.println("Write birth - day");
        int day = scanner.nextInt();
        System.out.println("Write weight");
        double weight = scanner.nextDouble();
        System.out.println("Write Hight");
        double hight = scanner.nextDouble();

        System.out.println("Choose number for position:\n " +
                "1 for GOALKEEPER \n" +
                "2 for LEFT_FULLBACK \n" +
                "3 for RIGHT_FULLBACK \n" +
                "4 for SWEEPER \n" +
                "5 for CENTER_BACK\n" +
                "6 for DEFENSIVE_MIDFIELDER \n" +
                "7 for CENTRAL_MIDFIELDER \n" +
                "8 for ATTACKING_MIDFIELDER \n" +
                "9 for LEFT_MIDFIELDER \n " +
                "10 for RIGHT_MIDFIELDER\n" +
                " 11 for CENTER_FORWARD \n" +
                "12 for STRIKER \n" +
                "13 for SECOND_STRIKER");

        Player.Position choosenPossition = null;
        boolean error = true;
        do {
            try {
                int possition = scanner.nextInt();
                switch (possition){
                    case 1:
                        choosenPossition = Player.Position.GOALKEEPER;
                        break;
                    case 2:
                        choosenPossition = Player.Position.LEFT_FULLBACK;
                        break;
                    case 3:
                        choosenPossition = Player.Position.RIGHT_FULLBACK;
                        break;
                    case 4:
                        choosenPossition = Player.Position.SWEEPER;
                        break;
                    case 5:
                        choosenPossition = Player.Position.CENTER_BACK;
                        break;
                    case 6:
                        choosenPossition = Player.Position.DEFENSIVE_MIDFIELDER;
                        break;
                    case 7:
                        choosenPossition = Player.Position.CENTRAL_MIDFIELDER;
                        break;
                    case 8:
                        choosenPossition = Player.Position.ATTACKING_MIDFIELDER;
                        break;
                    case 9:
                        choosenPossition = Player.Position.LEFT_MIDFIELDER;
                        break;
                    case 10:
                        choosenPossition = Player.Position.RIGHT_MIDFIELDER;
                        break;
                    case 11:
                        choosenPossition = Player.Position.CENTER_FORWARD;
                        break;
                    case 12:
                        choosenPossition = Player.Position.STRIKER;
                        break;
                    case 13:
                        choosenPossition = Player.Position.SECOND_STRIKER;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + possition);
                }
                error = false;
            }catch (InputMismatchException e){
                System.out.println("podaj poprawną pozycję");
                scanner.nextLine();
            }

        }while (error);


        System.out.println("Is player foot right?" + " choose y for yes");
        scanner.nextLine();
        String right = scanner.nextLine();
        boolean rightFootted = false;
            if (right.equalsIgnoreCase("y")){
            rightFootted = true;
        }
        System.out.println("Is player foot left?" + " choose y for yes");
        String left = scanner.nextLine();
        boolean leftFooted = false;
            if (left.equalsIgnoreCase("y")){
            leftFooted = true;
        }
        System.out.println("Enter acctual skill value of the player");
        double skillValue = scanner.nextDouble();

        System.out.println("podaj nazwę zespołu");
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        scanner.nextLine();
        String teamName = scanner.nextLine();

        Team team = new Team(teamName);
        teamEntityDao.saveOrUpdate(team);

        playerEntityDao.saveOrUpdate(new Player(surname, name, LocalDate.of(year, month, day),
                weight, hight, choosenPossition, rightFootted, leftFooted, skillValue, team));

        
    }

    private static void showPlayers(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        playerEntityDao.findAll(Player.class).stream().forEach(System.out::println);
    }

}
