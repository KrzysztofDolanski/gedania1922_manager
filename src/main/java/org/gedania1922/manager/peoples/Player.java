package org.gedania1922.manager.peoples;

import lombok.*;
import org.gedania1922.manager.training.Training;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String surname;
    private String name;
    private LocalDate birthDate;
    private double weight;
    private double growth;

    @Enumerated(value = EnumType.STRING)
    private Position positionOnField;
    private boolean rightFooted;
    private boolean leftFooted;
    private double skillsValue;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team teamName;

    @ManyToMany (fetch = FetchType.EAGER)
    private Set<Training> trainings;


    public Player(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Player(String surname, String name, LocalDate birthDate, double weight,
                  double growth, Position positionOnField, boolean rightFooted, boolean leftFooted, double skillsValue) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        this.growth = growth;
        this.positionOnField = positionOnField;
        this.rightFooted = rightFooted;
        this.leftFooted = leftFooted;
        this.skillsValue = skillsValue;
    }

    public Player(String surname, String name, LocalDate birthDate, double weight, double growth,
                  Position positionOnField, boolean rightFooted, boolean leftFooted, double skillsValue, Team teamName) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
        this.growth = growth;
        this.positionOnField = positionOnField;
        this.rightFooted = rightFooted;
        this.leftFooted = leftFooted;
        this.skillsValue = skillsValue;
        this.teamName = teamName;
    }

    public enum Position {

        GOALKEEPER(1), LEFT_FULLBACK(2), RIGHT_FULLBACK(3), SWEEPER(4), CENTER_BACK(5),
        DEFENSIVE_MIDFIELDER(6), CENTRAL_MIDFIELDER(7), ATTACKING_MIDFIELDER(8), LEFT_MIDFIELDER(9),
        RIGHT_MIDFIELDER(10), CENTER_FORWARD(11), STRIKER(12), SECOND_STRIKER(13);

        Position(int i) {
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(double growth) {
        this.growth = growth;
    }

    public Position getPositionOnField() {
        return positionOnField;
    }

    public void setPositionOnField(Position positionOnField) {
        this.positionOnField = positionOnField;
    }

    public boolean isRightFooted() {
        return rightFooted;
    }

    public void setRightFooted(boolean rightFooted) {
        this.rightFooted = rightFooted;
    }

    public boolean isLeftFooted() {
        return leftFooted;
    }

    public void setLeftFooted(boolean leftFooted) {
        this.leftFooted = leftFooted;
    }

    public double getSkillsValue() {
        return skillsValue;
    }

    public void setSkillsValue(double skillsValue) {
        this.skillsValue = skillsValue;
    }

    public Team getTeamName() {
        return teamName;
    }

    public void setTeamName(Team teamName) {
        this.teamName = teamName;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }
}



