package org.gedania1922.manager.handler;

import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.database.HibernateFactory;
import org.gedania1922.manager.database.PlayerDao;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.*;

public class PlayerHandler {
    Scanner scanner = new Scanner(System.in);

    public void handle() {
        String userCommand;
        do {
            System.out.println("write command");
            System.out.println("Player add \n" +
                    "Player show \n" +
                    "Player find by \n" +
                    "Player delete\n" +
                    "Player update skills\n" +
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
            } else if (words[0].equalsIgnoreCase("player")
                    && words[1].equalsIgnoreCase("update")
                    && words[2].equalsIgnoreCase("skills")) {
                updatePlayerSkills(words);
            }
        } while (!userCommand.equalsIgnoreCase("quit"));
    }

    private void updatePlayerSkills(String[] words) {

        PlayerDao playerDao = new PlayerDao();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Player ID");
        Long playerChoosen = scanner.nextLong();

        playerDao.updateSkills(Player.class, playerChoosen);
    }

    private void findBySurnamePlayer(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player surname to find\n");
        Scanner scanner = new Scanner(System.in);
        String playerChoosen = scanner.nextLine();
        List<Player> resultPlayersList = playerDao.findBySurname(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    private void findByNamePlayer(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player name to find\n");
        Scanner scanner = new Scanner(System.in);
        String playerChoosen = scanner.nextLine();
        List<Player> resultPlayersList = playerDao.findByName(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    private void findByWeightPlayer(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player weight to find\n");
        Scanner scanner = new Scanner(System.in);
        Long playerChoosen = Long.parseLong(scanner.nextLine());
        List<Player> resultPlayersList = playerDao.findByWeight(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    private void findByGrowthPlayer(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("choose player weight to find\n");
        Scanner scanner = new Scanner(System.in);
        Long playerChoosen = Long.parseLong(scanner.nextLine());
        List<Player> resultPlayersList = playerDao.findByGrowth(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }


    private void findByIdPlayer(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        System.out.println("choose player ID to find\n");
        Scanner scanner = new Scanner(System.in);
        Long playerChoosen = Long.parseLong(scanner.nextLine());
        Optional<Player> resultPlayerOptional = playerEntityDao.findById(Player.class, playerChoosen);
        if (resultPlayerOptional.isPresent()) {
            System.out.println("Znaleziono " + resultPlayerOptional.get());
        } else System.out.println("nie znaleziono");
    }

    private void findByDatePlayer(String[] words) {
        PlayerDao playerEntityDao = new PlayerDao();
        System.out.println("choose player birth date to find\n");
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("year");
            int year = scanner.nextInt();
            System.out.println("month");
            int month = scanner.nextInt();
            System.out.println("day");
            int day = scanner.nextInt();
            LocalDate playerChoosen = LocalDate.of(year, month, day);
            List<Player> resultPlayersList = playerEntityDao.findByDate(Player.class, playerChoosen);
            if (resultPlayersList.stream().findFirst().isPresent()) {
                System.out.println("Znaleziono");
                resultPlayersList.forEach(System.out::println);
            } else System.out.println("nie znaleziono");
        } catch (InputMismatchException e) {
            System.err.println("Use yyyy mm dd");
        }
    }

    private void findLeftFootPlayers(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("find leftfooted players:\n");
        boolean playerChoosen = true;
        List<Player> resultPlayersList = playerDao.findLeftFooted(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    private void findRightFootPlayers(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("find rightfooted players:\n");
        boolean playerChoosen = true;
        List<Player> resultPlayersList = playerDao.findRightFooted(Player.class, playerChoosen);
        if (resultPlayersList.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            resultPlayersList.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    public Set<Player> findDoublets(List<Player> list) {
        final Set<Player> setToReturn = new HashSet<Player>();
        final Set<Player> set1 = new HashSet<Player>();

        for (Player yourPlayer : list) {
            if (!set1.add(yourPlayer)) {
                setToReturn.add(yourPlayer);
            }
        }
        return setToReturn;
    }

    private void findBothFootedPlayer(String[] words2) {
        PlayerDao playerDao = new PlayerDao();
        System.out.println("find rightfooted players:\n");
        boolean playerChoosen = true;
        List<Player> resultPlayersList = (playerDao.findRightFooted(Player.class, playerChoosen));
        List<Player> leftFooted = playerDao.findLeftFooted(Player.class, playerChoosen);

        List<Player> margedList = new ArrayList<>();
        margedList.addAll(resultPlayersList);
        margedList.addAll(leftFooted);

        Set<Player> doublets = findDoublets(margedList);

        if (doublets.stream().findFirst().isPresent()) {
            System.out.println("Znaleziono");
            doublets.forEach(System.out::println);
        } else System.out.println("nie znaleziono");
    }

    private void findByPositionPlayer(String[] words2) {
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
                if (resultPlayersList.stream().findFirst().isPresent()) {
                    System.out.println("Znaleziono");
                    resultPlayersList.forEach(System.out::println);
                } else System.out.println("nie znaleziono");
            } catch (InputMismatchException e) {
                System.out.println("podaj poprawnie pozycję");
                scanner.nextLine();
            }
        } while (error);
    }


    private void deletePlayer(String[] words) {
        Session session = HibernateFactory.getSessionFactory().openSession();

        EntityDao<Player> playerEntityDao = new EntityDao<>();
        System.out.println("choose player number to delete\n");
        Scanner scanner = new Scanner(System.in);
        Long playerChoosen = Long.parseLong(scanner.nextLine());
        Optional<Player> playerToDeleteFromDataBase = playerEntityDao.findById(Player.class, playerChoosen);
        if (playerToDeleteFromDataBase.isPresent()) {
            Player player = playerToDeleteFromDataBase.get();
            System.out.println("Usuwam" + playerToDeleteFromDataBase.get());
            playerEntityDao.delete(player);
        } else System.out.println("Nie znaleziono");
        session.close();
    }


    private void addPlayer(String[] words) {
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
                switch (possition) {
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
            } catch (InputMismatchException e) {
                System.out.println("podaj poprawną pozycję");
                scanner.nextLine();
            }

        } while (error);


        System.out.println("Is player foot right?" + " choose y for yes");
        scanner.nextLine();
        String right = scanner.nextLine();
        boolean rightFootted = false;
        if (right.equalsIgnoreCase("y")) {
            rightFootted = true;
        }
        System.out.println("Is player foot left?" + " choose y for yes");
        String left = scanner.nextLine();
        boolean leftFooted = false;
        if (left.equalsIgnoreCase("y")) {
            leftFooted = true;
        }
        System.out.println("Enter acctual skill value of the player");
        double skillValue = scanner.nextDouble();

        System.out.println("Enter team name");
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        scanner.nextLine();
        String teamName = scanner.nextLine();

        Team team = new Team(teamName);
        teamEntityDao.saveOrUpdate(team);


        playerEntityDao.saveOrUpdate(new Player(surname, name, LocalDate.of(year, month, day),
                weight, hight, choosenPossition, rightFootted, leftFooted, skillValue, team));


    }

    private void showPlayers(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        playerEntityDao.findAll(Player.class).stream().forEach(System.out::println);
    }

}
