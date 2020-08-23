package org.gedania1922.manager.training;

import lombok.*;
import org.gedania1922.manager.peoples.Player;


import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @CreationTimestamp
    private LocalDate dateOfTraining;

    private String typeOfTraining;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player players;



    public Training(LocalDate dateOfTraining, String typeOfTraining, Player players) {
        this.dateOfTraining = dateOfTraining;
        this.typeOfTraining = typeOfTraining;
        this.players = players;
    }


}
