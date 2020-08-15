package org.gedania1922.manager;


import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.database.HibernateFactory;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.gedania1922.manager.peoples.Trainer;
import org.gedania1922.manager.training.Training;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Application {

    public static void main(String[] args) {
        System.out.println("Zaczynamy");

        HibernateFactory.getSessionFactory();

        Scanner scanner = new Scanner(System.in);

        String userCommand;

        do {
            System.out.println("write command");
            System.out.println("Player add \n" +
                    "Player show \n" +
                    "Player find by id \n" +
                    "Quit");
            userCommand = scanner.nextLine();
            String [] words = userCommand.split(" ");

            if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("show")){
                showPlayers(words);
            } else if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("add")){
                addPlayer(words);
            } else if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("delete")){
                deletePlayer(words);
            } else if (words[0].equalsIgnoreCase("player") && words[1].equalsIgnoreCase("find")
                    && words[2].equalsIgnoreCase("by") && words[3].equalsIgnoreCase("id")){
                findByIdPlayer(words);
            }
        }while (!userCommand.equalsIgnoreCase("quit"));


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

    //Ta metoda ma jakiś problem-------------------------------------------------------
    private static void findByIdPlayer(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        System.out.println("choose player ID to find\n");
        showPlayers(words);
        Scanner scanner = new Scanner(System.in);
        Long playerChoosen = scanner.nextLong();
        Stream<Player> stream = playerEntityDao.findAll(Player.class).stream();
        System.out.println(stream.filter(n -> n.equals(playerChoosen)));
    }

    //Ta metoda ma jakiś problem-------------------------------------------------------
    private static void deletePlayer(String[] words) {
        EntityDao<Player> entityDao = new EntityDao<>();
        System.out.println("choose player number to delete\n");
        showPlayers(words);
        Scanner scanner = new Scanner(System.in);
        Long playerToDeleteFromDataBase = scanner.nextLong();

        entityDao.delete((entityDao.findById(Player.class, playerToDeleteFromDataBase).stream()).findAny().get());
    }

    private static void addPlayer(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write surname");
        String s = scanner.nextLine();
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

        System.out.println("Choose number for position: 1 for GOALKEEPER \n " +
                "2 for LEFT_FULLBACK \n, 3 for RIGHT_FULLBACK \n, 4 for SWEEPER \n, 5 for CENTER_BACK,\n" +
                "6 for DEFENSIVE_MIDFIELDER \n, 7 for CENTRAL_MIDFIELDER \n, 8 for ATTACKING_MIDFIELDER \n , " +
                "9 for LEFT_MIDFIELDER \n, 10 for RIGHT_MIDFIELDER,\n" +
                " 11 for CENTER_FORWARD \n, 12 for STRIKER \n, 13 for SECOND_STRIKER");

        int possition = scanner.nextInt();
        Player.Position choosenPossition;

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

        playerEntityDao.saveOrUpdate(new Player(s, name, LocalDate.of(year, month, day), weight, hight, choosenPossition, rightFootted, leftFooted,skillValue));

    }


    private static void showPlayers(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        playerEntityDao.findAll(Player.class).stream().forEach(System.out::println);
    }

}
