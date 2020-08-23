package org.gedania1922.manager.skills;

import lombok.*;
import org.gedania1922.manager.peoples.Player;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Physical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double acceleration;
    private double agility;
    private double balance;
    private double jumpReach;
    private double nauralFitness;
    private double peace;
    private double stamina;
    private double strenght;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player player;

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAgility() {
        return agility;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getJumpReach() {
        return jumpReach;
    }

    public void setJumpReach(double jumpReach) {
        this.jumpReach = jumpReach;
    }

    public double getNauralFitness() {
        return nauralFitness;
    }

    public void setNauralFitness(double nauralFitness) {
        this.nauralFitness = nauralFitness;
    }

    public double getPeace() {
        return peace;
    }

    public void setPeace(double peace) {
        this.peace = peace;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getStrenght() {
        return strenght;
    }

    public void setStrenght(double strenght) {
        this.strenght = strenght;
    }
}
