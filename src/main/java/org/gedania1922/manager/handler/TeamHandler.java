package org.gedania1922.manager.handler;

import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.gedania1922.manager.peoples.Trainer;

import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

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
                addTeam(words);
            } else if (words[0].equalsIgnoreCase("team")
                    && words[1].equalsIgnoreCase("show")) {
                showTeam(words);
            } else if (words[0].equalsIgnoreCase("team")
                    && words[1].equalsIgnoreCase("find")
                    && words[2].equalsIgnoreCase("by")) {
                System.out.println("id\n playerId");
                userCommandTrainer = scanner.nextLine();
                String[] words2 = userCommandTrainer.split(" ");
                if (words2[0].equalsIgnoreCase("id")) {
                    findByIdTeam(words2);
                } else if (words2[0].equalsIgnoreCase("playerId")) {
                    findTeamByPlayerId(words2);
                }
            }

        } while (!userCommandTrainer.equalsIgnoreCase("quit"));
    }

    private void addTeam(String[] words) {
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        EntityDao<Trainer> trainerEntityDao = new EntityDao<>();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Podaj ID zawodnika");
            Long playerID = Long.parseLong(scanner.nextLine());
            System.out.println("Podaj ID trenera");
            Long trainerID = Long.parseLong(scanner.nextLine());
            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerID);
            Set<Trainer> byIdTrainer = trainerEntityDao.findById2(Trainer.class, trainerID);
            System.out.print("podaj nazwę drużyny");
            String teamName = scanner.nextLine();
            teamEntityDao.saveOrUpdate(new Team(teamName, byIdPlayer, byIdTrainer));
        } catch (IllegalArgumentException e) {
            System.err.println("Use letters for find ID");
        }
    }

    private void showTeam(String[] words) {
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        teamEntityDao.findAll(Team.class).stream().forEach(System.out::println);
    }

    private void findByIdTeam(String[] words) {
        EntityDao<Team> teamEntityDao = new EntityDao<>();
        System.out.println("choose team ID to find\n");
        Scanner scanner = new Scanner(System.in);
        try {
            Long teamChoosen = Long.parseLong(scanner.nextLine());
            Optional<Team> resultTeamOptional = teamEntityDao.findById(Team.class, teamChoosen);
            if (resultTeamOptional.isPresent()) {
                System.out.println("Znaleziono " + resultTeamOptional.get());
            } else System.out.println("nie znaleziono");
        } catch (NumberFormatException e) {
            System.err.println("Use numbers to find ID");
        }

    }

    private void findTeamByPlayerId(String[] words) {
        EntityDao<Player> playerEntityDao = new EntityDao<>();
        System.out.println("choose player ID to find team\n");
        Scanner scanner = new Scanner(System.in);
        try {
            Long playerChoosenTeam = Long.parseLong(scanner.nextLine());
            Optional<Player> playerOptional = playerEntityDao.findById(Player.class, playerChoosenTeam);
            if(playerOptional.isPresent()){
                Player player = playerOptional.get();
                Team team = player.getTeamName();
                team.toString();
            }else {
                System.out.println("Nie znaleziono");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Use numbers to find ID");
        }

    }
}
