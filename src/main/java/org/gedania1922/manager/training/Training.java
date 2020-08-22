package org.gedania1922.manager.training;

import lombok.*;
import org.gedania1922.manager.peoples.Player;
import org.gedania1922.manager.peoples.Team;
import org.hibernate.annotations.CreationTimestamp;

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
    private long id;

//    @CreationTimestamp
    private LocalDate dateOfTraining;

    private String typeOfTraining;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player players;


    public Training(LocalDate dateOfTraining, String typeOfTraining) {
        this.dateOfTraining = dateOfTraining;
        this.typeOfTraining = typeOfTraining;
    }

    public Training(LocalDate dateOfTraining, String typeOfTraining, Player players) {
        this.dateOfTraining = dateOfTraining;
        this.typeOfTraining = typeOfTraining;
        this.players = players;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateOfTraining() {
        return dateOfTraining;
    }

    public void setDateOfTraining(LocalDate dateOfTraining) {
        this.dateOfTraining = dateOfTraining;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public Player getPlayers() {
        return players;
    }

    public void setPlayers(Player players) {
        this.players = players;
    }
}
