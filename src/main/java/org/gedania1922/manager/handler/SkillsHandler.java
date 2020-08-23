package org.gedania1922.manager.handler;

import org.gedania1922.manager.database.EntityDao;
import org.gedania1922.manager.peoples.Player;

import org.gedania1922.manager.skills.Goalkeeping;
import org.gedania1922.manager.skills.Mental;
import org.gedania1922.manager.skills.Physical;
import org.gedania1922.manager.skills.Technical;

import javax.persistence.OptimisticLockException;
import java.util.*;

public class SkillsHandler {


    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String userCommand;
        do {
            System.out.println("write command");
            System.out.println("Skills goalkeeping \n" +
                    "Skills mental \n" +
                    "Skills physical \n" +
                    "Skills technical\n" +

                    "Quit");
            userCommand = scanner.nextLine();
            String[] words = userCommand.split(" ");

            do {
                if (words[0].equalsIgnoreCase("skills") && words[1].equalsIgnoreCase("goalkeeping")) {

                    do {
                        System.out.println(" update\n show\n quit");
                        userCommand = scanner.nextLine();
                        String[] words2 = userCommand.split(" ");
                        if (words2[0].equalsIgnoreCase("update")) {
                            addGoalkeepingSkills();
                        } else if (words2[0].equals("show")) {
                            showGoalkeepingSkills();
                        }

                    } while (!userCommand.equalsIgnoreCase("quit"));


                } else if (words[0].equalsIgnoreCase("skills") && words[1].equalsIgnoreCase("mental")) {

                    do {
                        System.out.println(" update\n show\n quit");
                        userCommand = scanner.nextLine();
                        String[] words2 = userCommand.split(" ");
                        if (words2[0].equalsIgnoreCase("update")) {
                            addMentalSkills();
                        } else if (words2[0].equals("show")) {
                            showMentalSkills();
                        }

                    } while (!userCommand.equalsIgnoreCase("quit"));

                } else if (words[0].equalsIgnoreCase("skills") && words[1].equalsIgnoreCase("physical")) {

                    do {
                        System.out.println(" update\n show\n quit");
                        userCommand = scanner.nextLine();
                        String[] words2 = userCommand.split(" ");
                        if (words2[0].equalsIgnoreCase("update")) {
                            addPhysicalSkills();
                        } else if (words2[0].equals("show")) {
                            showPhysicalSkills();
                        }

                    } while (!userCommand.equalsIgnoreCase("quit"));

                } else if (words[0].equalsIgnoreCase("skills") && words[1].equalsIgnoreCase("technical")) {

                    do {
                        System.out.println(" update\n show\n quit");

                    userCommand = scanner.nextLine();
                    String[] words2 = userCommand.split(" ");

                        if (words2[0].equalsIgnoreCase("update")) {
                            addTechnicalSkills();
                        } else if (words2[0].equals("show")) {
                            showTechnicalSkills();
                        }

                    } while (!userCommand.equalsIgnoreCase("quit"));
                }
            } while (!userCommand.equalsIgnoreCase("quit"));
        } while (!userCommand.equalsIgnoreCase("quit"));
    }



    public void showGoalkeepingSkills() {
        Scanner scanner = new Scanner(System.in);

        try {
            EntityDao<Player> playerEntityDao = new EntityDao<>();
            System.out.println("choose player ID");
            long playerId = Long.parseLong(scanner.nextLine());
            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

                Player player = byIdPlayer.stream().findFirst().get();
                Set<Goalkeeping> goalkeeping = player.getGoalkeeping();
                goalkeeping.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.err.println("Use numbers to find ID");

        }
    }


    public void addGoalkeepingSkills() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("choose player ID");
            long playerId = Long.parseLong(scanner.nextLine());

            EntityDao<Player> playerEntityDao = new EntityDao<>();

            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

            Player player = byIdPlayer.stream().findFirst().get();

            System.out.println("write reach");
            int reach = Integer.parseInt(scanner.nextLine());
            System.out.println("write communication");
            int communication = Integer.parseInt(scanner.nextLine());
            System.out.println("write first touch");
            int firstTouch = Integer.parseInt(scanner.nextLine());
            System.out.println("write handling");
            int handling = Integer.parseInt(scanner.nextLine());
            System.out.println("write kicking");
            int kicking = Integer.parseInt(scanner.nextLine());
            System.out.println("write one to ones");
            int oneToOnes = Integer.parseInt(scanner.nextLine());
            System.out.println("write passing");
            int passing = Integer.parseInt(scanner.nextLine());
            System.out.println("write reflexes");
            int reflexes = Integer.parseInt(scanner.nextLine());
            System.out.println("write rushing out");
            int rushingOut = Integer.parseInt(scanner.nextLine());
            System.out.println("write throwing");
            int throwing = Integer.parseInt(scanner.nextLine());


            EntityDao<Goalkeeping> goalkeepingEntityDao = new EntityDao<>();

            goalkeepingEntityDao.saveOrUpdate(new Goalkeeping(null, reach, communication, firstTouch, handling, kicking
                    , oneToOnes, passing, reflexes, rushingOut, throwing, player));

        } catch (OptimisticLockException e) {
            System.err.println("Use numbers to find ID");
        }

    }

    public void showMentalSkills() {
        Scanner scanner = new Scanner(System.in);

        try {
            EntityDao<Player> playerEntityDao = new EntityDao<>();
            System.out.println("choose player ID");
            long playerId = Long.parseLong(scanner.nextLine());
            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

            Player player = byIdPlayer.stream().findFirst().get();
            Set<Mental> mentals = player.getMental();
            mentals.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.err.println("Use numbers to find ID");

        }
    }

    public void addMentalSkills() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("choose player ID");
            long playerId = Long.parseLong(scanner.nextLine());

            EntityDao<Player> playerEntityDao = new EntityDao<>();

            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

            Player player = byIdPlayer.stream().findFirst().get();

            System.out.println("write aggression");
            int aggression = Integer.parseInt(scanner.nextLine());
            System.out.println("write anticipation");
            int anticipation = Integer.parseInt(scanner.nextLine());
            System.out.println("write bravery");
            int bravery = Integer.parseInt(scanner.nextLine());
            System.out.println("write composure");
            int composure = Integer.parseInt(scanner.nextLine());
            System.out.println("write concentration");
            int concentration = Integer.parseInt(scanner.nextLine());
            System.out.println("write decision");
            int decision = Integer.parseInt(scanner.nextLine());
            System.out.println("write determination");
            int determination = Integer.parseInt(scanner.nextLine());
            System.out.println("write flair");
            int flair = Integer.parseInt(scanner.nextLine());
            System.out.println("write leadership");
            int leadership = Integer.parseInt(scanner.nextLine());
            System.out.println("write off the ball");
            int offTheBall = Integer.parseInt(scanner.nextLine());
            System.out.println("write positioning");
            int positioning = Integer.parseInt(scanner.nextLine());
            System.out.println("write teamWork");
            int teamWork = Integer.parseInt(scanner.nextLine());
            System.out.println("write vision");
            int vision = Integer.parseInt(scanner.nextLine());
            System.out.println("write work rate");
            int workRate = Integer.parseInt(scanner.nextLine());

            EntityDao<Mental> mentalEntityDao = new EntityDao<>();

            mentalEntityDao.saveOrUpdate(new Mental(null, aggression, anticipation, bravery, composure, concentration
                    , decision, determination, flair, leadership, offTheBall, positioning, teamWork, vision, workRate
                    , player));

        } catch (OptimisticLockException e) {
            System.err.println("Use numbers to find ID");
        }

    }

    public void showPhysicalSkills() {
        Scanner scanner = new Scanner(System.in);

        try {
            EntityDao<Player> playerEntityDao = new EntityDao<>();
            System.out.println("choose player ID");
            long playerId = Long.parseLong(scanner.nextLine());
            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

            Player player = byIdPlayer.stream().findFirst().get();
            Set<Physical> physicals = player.getPhysical();
            physicals.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.err.println("Use numbers to find ID");

        }
    }


    public void addPhysicalSkills() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("choose player ID");
            long playerId = Long.parseLong(scanner.nextLine());

            EntityDao<Player> playerEntityDao = new EntityDao<>();

            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

            Player player = byIdPlayer.stream().findFirst().get();

            System.out.println("write acceleration");
            int acceleration = Integer.parseInt(scanner.nextLine());
            System.out.println("write agility");
            int agility = Integer.parseInt(scanner.nextLine());
            System.out.println("write balance");
            int balance = Integer.parseInt(scanner.nextLine());
            System.out.println("write jump reach");
            int jumpReach = Integer.parseInt(scanner.nextLine());
            System.out.println("write naural fitness");
            int nauralFitness = Integer.parseInt(scanner.nextLine());
            System.out.println("write peace");
            int peace = Integer.parseInt(scanner.nextLine());
            System.out.println("write stamina");
            int stamina = Integer.parseInt(scanner.nextLine());
            System.out.println("write strenght");
            int strenght = Integer.parseInt(scanner.nextLine());

            EntityDao<Physical> physicalEntityDao = new EntityDao<>();

            physicalEntityDao.saveOrUpdate(new Physical(null, acceleration, agility, balance, jumpReach
                    , nauralFitness, peace, stamina, strenght, player));

        } catch (OptimisticLockException e) {
            System.err.println("Use numbers to find ID");
        }

    }

    public void showTechnicalSkills() {
        Scanner scanner = new Scanner(System.in);

        try {
            EntityDao<Player> playerEntityDao = new EntityDao<>();
            System.out.println("choose player ID");
            long playerId = Long.parseLong(scanner.nextLine());
            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

            Player player = byIdPlayer.stream().findFirst().get();
            Set<Technical> technical = player.getTechnical();
            technical.forEach(System.out::println);

        } catch (IllegalArgumentException e) {
            System.err.println("Use numbers to find ID");

        }
    }

    public void addTechnicalSkills() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("choose player ID\n");
            long playerId = Long.parseLong(scanner.nextLine());

            EntityDao<Player> playerEntityDao = new EntityDao<>();

            Set<Player> byIdPlayer = playerEntityDao.findById2(Player.class, playerId);

            Player player = byIdPlayer.stream().findFirst().get();

            System.out.println("write corners");
            int corners = Integer.parseInt(scanner.nextLine());
            System.out.println("write crossing");
            int crossing = Integer.parseInt(scanner.nextLine());
            System.out.println("write dribbling");
            int dribbling = Integer.parseInt(scanner.nextLine());
            System.out.println("write finishing");
            int finishing = Integer.parseInt(scanner.nextLine());
            System.out.println("write first touch technic");
            int firstTouchTechnic = Integer.parseInt(scanner.nextLine());
            System.out.println("write free kick taking");
            int freeKickTaking = Integer.parseInt(scanner.nextLine());
            System.out.println("write heading");
            int heading = Integer.parseInt(scanner.nextLine());
            System.out.println("write long shots");
            int longShots = Integer.parseInt(scanner.nextLine());
            System.out.println("write long throws");
            int longThrows = Integer.parseInt(scanner.nextLine());
            System.out.println("write marking");
            int marking = Integer.parseInt(scanner.nextLine());
            System.out.println("write passing technic");
            int passingTechnic = Integer.parseInt(scanner.nextLine());
            System.out.println("write penalty taking");
            int penaltyTaking = Integer.parseInt(scanner.nextLine());
            System.out.println("write tackling");
            int tackling = Integer.parseInt(scanner.nextLine());
            System.out.println("write technique");
            int technique = Integer.parseInt(scanner.nextLine());


            EntityDao<Technical> technicalEntityDao = new EntityDao<>();

            technicalEntityDao.saveOrUpdate(new Technical(null, corners, crossing, dribbling, finishing, firstTouchTechnic
                    , freeKickTaking, heading, longShots, longThrows, marking, passingTechnic, penaltyTaking, tackling
                    , technique, player));

        } catch (OptimisticLockException e) {
            System.err.println("Use numbers to find ID");
        }

    }
}

