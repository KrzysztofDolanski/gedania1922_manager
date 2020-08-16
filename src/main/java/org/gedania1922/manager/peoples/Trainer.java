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
    private String surmane;
    private String name;
    private String certyficates;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team teamId;

    public Trainer(String surmane, String name) {
        this.surmane = surmane;
        this.name = name;
    }
}
