package org.gedania1922.manager.peoples;

import lombok.*;
import org.gedania1922.manager.training.Training;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "teamId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Player> players = new HashSet<>();

    @OneToMany (mappedBy = "teamId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Trainer> trainer = new HashSet<>();

    @OneToMany
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Training> trainings = new HashSet<>();


}
