package org.gedania1922.manager.training;

import lombok.*;
import org.gedania1922.manager.peoples.Team;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dateOfTraining;
    private String typeOfTraining;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team teamId;


    public Training(String dateOfTraining, String typeOfTraining) {
        this.dateOfTraining = dateOfTraining;
        this.typeOfTraining = typeOfTraining;
    }
}
