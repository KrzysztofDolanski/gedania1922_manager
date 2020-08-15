package org.gedania1922.manager.peoples;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String surnamePlayer;
    private String namePlayer;
    private String birthDate;
    private double weightPlayer;
    private double growthPlayer;
    private Position positionOnField;
    private boolean rightFooted;
    private boolean leftFooted;
    private double skillsValue;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team teamId;


    public Player(String surnamePlayer, String namePlayer) {
        this.surnamePlayer = surnamePlayer;
        this.namePlayer = namePlayer;
    }

    public Player(String surnamePlayer, String namePlayer, String birthDate, double weightPlayer,
                  double growthPlayer, Position positionOnField, boolean rightFooted, boolean leftFooted, double skillsValue) {
        this.surnamePlayer = surnamePlayer;
        this.namePlayer = namePlayer;
        this.birthDate = birthDate;
        this.weightPlayer = weightPlayer;
        this.growthPlayer = growthPlayer;
        this.positionOnField = positionOnField;
        this.rightFooted = rightFooted;
        this.leftFooted = leftFooted;
        this.skillsValue = skillsValue;
    }

    public enum Position {

        GOALKEEPER, LEFT_FULLBACK, RIGHT_FULLBACK, SWEEPER, CENTER_BACK,
        DEFENSIVE_MIDFIELDER, CENTRAL_MIDFIELDER, ATTACKING_MIDFIELDER, LEFT_MIDFIELDER, RIGHT_MIDFIELDER,
        CENTER_FORWARD, STRIKER, SECOND_STRIKER;

    }

}



