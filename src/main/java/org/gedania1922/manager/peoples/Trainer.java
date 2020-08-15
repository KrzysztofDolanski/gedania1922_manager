package org.gedania1922.manager.peoples;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Trainer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String surmaneTrainer;
    private String nameTrainer;
    private String certyficates;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team teamId;

    public Trainer(String surmaneTrainer, String nameTrainer) {
        this.surmaneTrainer = surmaneTrainer;
        this.nameTrainer = nameTrainer;
    }
}
