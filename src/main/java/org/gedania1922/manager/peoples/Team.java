package org.gedania1922.manager.peoples;

import lombok.*;
import org.gedania1922.manager.training.Training;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String teamName;

    @OneToMany(mappedBy = "teamName")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Player> players = new HashSet<>();

    @OneToMany (mappedBy = "teamName")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Trainer> trainer = new HashSet<>();

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Training> trainings = new HashSet<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public Team(String teamName, Set<Player> players, Set<Trainer> trainer) {
        this.teamName = teamName;
        this.players = players;
        this.trainer = trainer;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Set<Trainer> getTrainer() {
        return trainer;
    }

    public void setTrainer(Set<Trainer> trainer) {
        this.trainer = trainer;
    }

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }
}
