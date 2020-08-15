package org.gedania1922.manager.training;

import lombok.*;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateOfTraining;
    private String typeOfTraining;

    @ManyToMany (mappedBy = "trainings")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Player> players;


    public Training(LocalDate dateOfTraining, String typeOfTraining) {
        this.dateOfTraining = dateOfTraining;
        this.typeOfTraining = typeOfTraining;
    }
}
