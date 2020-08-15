package org.gedania1922.manager.peoples;

import lombok.*;
import org.gedania1922.manager.training.Training;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    private int playerID;
    private int trainerID;
    private int trainingId;

    @OneToMany(mappedBy = "teamId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Player> players;

    @OneToMany (mappedBy = "teamId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Trainer> trainer;

    @OneToMany (mappedBy = "teamId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Training> trainings;

    public Team(int playerID, int trainerID) {
        this.playerID = playerID;
        this.trainerID = trainerID;
    }
}
