package org.gedania1922.manager.handler;

import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.gedania1922.manager.peoples.Trainer;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class TeamHandler {

    Scanner scanner = new Scanner(System.in);

    public void handle() {

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
                addTeam();
            } else if (words[0].equalsIgnoreCase("team")
                    && words[1].equalsIgnoreCase("show")) {
                showTeam();
            } else if (words[0].equalsIgnoreCase("team")
                    && words[1].equalsIgnoreCase("find")
                    && words[2].equalsIgnoreCase("by")) {
                System.out.println("id\n playerId");
                userCommandTrainer = scanner.nextLine();
                String[] words2 = userCommandTrainer.split(" ");
                if (words2[0].equalsIgnoreCase("id")) {
                    findByIdTeam();
                } else if (words2[0].equalsIgnoreCase("playerId")) {
                    findTeamByPlayerId();
                }
            }

        } while (!userCommandTrainer.equalsIgnoreCase("quit"));
    }

    private void addTeam() {
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("write player ID");
            Long playerID = Long.parseLong(scanner.nextLine());
            System.out.println("write trainer ID");
            Long trainerID = Long.parseLong(scanner.nextLine());
            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerID);
            Set<Trainer> byIdTrainer = trainerEntityDao.findById2(Trainer.class, trainerID);
            System.out.print("write team name");
            String teamName = scanner.nextLine();
            teamEntityDao.saveOrUpdate(new Team(teamName, byIdPlayer, byIdTrainer));
        } catch (IllegalArgumentException e) {
            System.err.println("Use letters for find ID");
        }
    }

    private void showTeam() {
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        teamEntityDao.findAll(Team.class).stream().forEach(System.out::println);
    }

    private void findByIdTeam() {
        Long teamChoosen;
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        System.out.println("choose team ID to find team");
        Scanner scanner = new Scanner(System.in);
        try {
            teamChoosen = Long.parseLong(scanner.nextLine());
            Optional<Team> resultTeamOptional = teamEntityDao.findById(Team.class, teamChoosen);
            if (resultTeamOptional.isPresent()) {
                System.out.println("Znaleziono " + resultTeamOptional.get());
            } else System.out.println("nie znaleziono");
        } catch (NumberFormatException e) {
            System.err.println("Use numbers to find ID");
        }

    }

    private void findTeamByPlayerId() {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        System.out.println("choose player ID to find team");
        Long playerChoosenTeam = null;
        try {
            Scanner scanner = new Scanner(System.in);
            playerChoosenTeam = Long.parseLong(scanner.nextLine());

            Set<Player> byId2 = playerEntityDao.findById2(Player.class, playerChoosenTeam);

            if(!byId2.isEmpty()){

                Stream<String> stringStream = byId2.stream().map(n -> n.getTeamName().toString());
                stringStream.forEach(System.out::println);

            }else {
                System.out.println("Nie znaleziono");
            }
        } catch (NumberFormatException e){
            System.err.println("User numbers to find player id");

        } catch (NullPointerException e) {
            System.err.println("There is no Player with id " + playerChoosenTeam);
        }

    }
}
