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
        scanner.close();
    }

    private void mentalSkillsUpdate(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("write aggression");
        double aggression = scanner.nextInt();
        mental.setAggression(aggression);
        System.out.println("write anticipation");
        double anticipation = scanner.nextInt();
        mental.setAnticipation(anticipation);
        System.out.println("write bravery");
        double bravery = scanner.nextInt();
        mental.setBravery(bravery);
        System.out.println("write composure");
        double composure = scanner.nextInt();
        mental.setComposure(composure);
        System.out.println("write concentration");
        double concentration = scanner.nextInt();
        mental.setConcentration(concentration);
        System.out.println("write decision");
        double decision = scanner.nextInt();
        mental.setDecision(decision);
        System.out.println("write determination");
        double determination = scanner.nextInt();
        mental.setDeterminaion(determination);
        System.out.println("write flair");
        double flair = scanner.nextInt();
        mental.setFlair(flair);
        System.out.println("write leadership");
        double leadership = scanner.nextInt();
        mental.setLeadership(leadership);
        System.out.println("write off the ball");
        double offTheBall = scanner.nextInt();
        mental.setOffTheBall(offTheBall);
        System.out.println("write positioning");
        double positioning = scanner.nextInt();
        mental.setPositioning(positioning);
        System.out.println("write Team work");
        double teamWork = scanner.nextInt();
        mental.setTeamWork(teamWork);
        System.out.println("write vision");
        double vision = scanner.nextInt();
        mental.setVision(vision);
        System.out.println("write work rate");
        double workRate = scanner.nextInt();
        mental.setWorkRate(workRate);

        mentalSkills =
        mental.getAggression() +
        mental.getAnticipation() +
        mental.getBravery() +
        mental.getComposure() +
        mental.getConcentration() +
        mental.getDecision() +
        mental.getDeterminaion() +
        mental.getFlair() +
        mental.getLeadership() +
        mental.getOffTheBall() +
        mental.getPositioning() +
        mental.getTeamWork() +
        mental.getVision() +
        mental.getWorkRate();
        scanner.close();
    }

    private void physicalSkillsUpdate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write acceleration");
        double acceleration = scanner.nextInt();
        physical.setAcceleration(acceleration);
        System.out.println("write agility");
        double agility = scanner.nextInt();
        physical.setAgility(agility);
        System.out.println("write balance");
        double balance = scanner.nextInt();
        physical.setBalance(balance);
        System.out.println("write jump reach");
        double jumpReach = scanner.nextInt();
        physical.setJumpReach(jumpReach);
        System.out.println("write fitness");
        double fitness = scanner.nextInt();
        physical.setNauralFitness(fitness);
        System.out.println("write peace");
        double peace = scanner.nextInt();
        physical.setPeace(peace);
        System.out.println("write stamina");
        double stamina = scanner.nextInt();
        physical.setStamina(stamina);
        System.out.println("write strength");
        double strength = scanner.nextInt();
        physical.setStrenght(strength);


        physicalSkills = physical.getAcceleration()+
                physical.getAgility()+
                physical.getBalance()+
                physical.getJumpReach()+
                physical.getNauralFitness()+
                physical.getPeace()+
                physical.getStamina()+
                physical.getStrenght();

        scanner.close();
    }

    public void technicalSkillsUpdate(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("write corners");
        double corners = scanner.nextInt();
        technical.setCorners(corners);
        System.out.println("write crossing");
        double crossing = scanner.nextInt();
        technical.setCrossing(crossing);
        System.out.println("write dribbling");
        double dribbling = scanner.nextInt();
        technical.setDribbling(dribbling);
        System.out.println("write finishing");
        double finishing = scanner.nextInt();
        technical.setFinishing(finishing);
        System.out.println("write first touch");
        double firstTouch = scanner.nextInt();
        technical.setFirstTouch(firstTouch);
        System.out.println("write kick taking");
        double kickTaking = scanner.nextInt();
        technical.setFreeKickTaking(kickTaking);
        System.out.println("write heading");
        double heading = scanner.nextInt();
        technical.setHeading(heading);
        System.out.println("write long shots");
        double longShots = scanner.nextInt();
        technical.setLongShots(longShots);
        System.out.println("write long throws");
        double longThrows = scanner.nextInt();
        technical.setLongThrows(longThrows);
        System.out.println("write marking");
        double marking = scanner.nextInt();
        technical.setMarking(marking);
        System.out.println("write passing");
        double passing = scanner.nextInt();
        technical.setPassing(passing);
        System.out.println("write penalty taking");
        double penaltyTaking = scanner.nextInt();
        technical.setPenaltyTaking(penaltyTaking);
        System.out.println("write tackling");
        double tackling = scanner.nextInt();
        technical.setTackling(tackling);
        System.out.println("write technique");
        double technique = scanner.nextInt();
        technical.setTechnique(technique);

        technicalSkills =
        technical.getCorners()+
        technical.getCrossing()+
        technical.getDribbling()+
        technical.getFinishing()+
        technical.getFirstTouch()+
        technical.getFreeKickTaking()+
        technical.getHeading()+
        technical.getLongShots()+
        technical.getLongThrows()+
        technical.getMarking()+
        technical.getPassing()+
        technical.getPenaltyTaking()+
        technical.getTackling()+
        technical.getTechnique();
    }
    public double playerSkillsUpdate(){
        double playerSkills = 0;
        goalKeepingSkillsUpdate();
        mentalSkillsUpdate();

        playerSkills = goalkeepingSkills + mentalSkills +physicalSkills + technicalSkills;

        return playerSkills;
    }
}
