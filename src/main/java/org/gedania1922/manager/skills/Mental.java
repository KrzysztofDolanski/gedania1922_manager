package org.gedania1922.manager.skills;

import lombok.*;
import org.gedania1922.manager.peoples.Player;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Mental {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double aggression;
    private double anticipation;
    private double bravery;
    private double composure;
    private double concentration;
    private double decision;
    private double determination;
    private double flair;
    private double leadership;
    private double offTheBall;
    private double positioning;
    private double teamWork;
    private double vision;
    private double workRate;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player player;


    public Mental(double aggression, double anticipation, double bravery, double composure, double concentration, double decision, double determinaion, double flair, double leadership,
                  double offTheBall, double positioning, double teamWork, double vision, double workRate, Player player) {
        this.aggression = aggression;
        this.anticipation = anticipation;
        this.bravery = bravery;
        this.composure = composure;
        this.concentration = concentration;
        this.decision = decision;
        this.determination = determinaion;
        this.flair = flair;
        this.leadership = leadership;
        this.offTheBall = offTheBall;
        this.positioning = positioning;
        this.teamWork = teamWork;
        this.vision = vision;
        this.workRate = workRate;
        this.player = player;
    }
}
