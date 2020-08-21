package org.gedania1922.manager.player_tests;

import org.gedania1922.manager.database.PlayerDao;
import org.gedania1922.manager.peoples.Player;

import java.util.Scanner;

public class SkillsMachine {

    private double mentalSkills;
    private double goalkeepingSkills;
    private double physicalSkills;
    private double technicalSkills;


    Goealkeeping goalkeeping = new Goealkeeping();
    Mental mental = new Mental();
    Physical physical = new Physical();
    Technical technical = new Technical();
    PlayerDao playerDao = new PlayerDao();



    private void goalKeepingSkillsUpdate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write aerial reach");
        double aerialReach = scanner.nextInt();
        goalkeeping.setAerialReach(aerialReach);

        System.out.println("write communication");
        double communication = scanner.nextInt();
        goalkeeping.setCommunication(communication);
        System.out.println("write firstTouch");
        double firstTouch = scanner.nextInt();
        goalkeeping.setFirstTouch(firstTouch);
        System.out.println("write handling");
        double handling = scanner.nextInt();
        goalkeeping.setHandling(handling);
        System.out.println("write kicking");
        double kicking = scanner.nextInt();
        goalkeeping.setKicking(kicking);
        System.out.println("write oneToOnes");
        double oneToOnes = scanner.nextInt();
        goalkeeping.setOneToOnes(oneToOnes);
        System.out.println("write passing");
        double passing = scanner.nextInt();
        goalkeeping.setPassing(passing);
        System.out.println("write reflexes");
        double reflexes = scanner.nextInt();
        goalkeeping.setReflexes(reflexes);
        System.out.println("write rushingOut");
        double rushingOut = scanner.nextInt();
        goalkeeping.setRushingOut(rushingOut);
        System.out.println("write throwing");
        double throwing = scanner.nextInt();
        goalkeeping.setThrowing(throwing);


        goalkeepingSkills = goalkeeping.getAerialReach() +
          goalkeeping.getAerialReach() +
         + goalkeeping.getCommunication() +
         + goalkeeping.getFirstTouch() +
         + goalkeeping.getHandling() +
         + goalkeeping.getKicking() +
         + goalkeeping.getOneToOnes() +
         + goalkeeping.getPassing() +
         + goalkeeping.getReflexes() +
         + goalkeeping.getRushingOut() +
         + goalkeeping.getThrowing();
    }

    public double playerSkillsUpdate(){
        double playerSkills = 0;
        goalKeepingSkillsUpdate();

        playerSkills = goalkeepingSkills;

        return playerSkills;
    }
}
