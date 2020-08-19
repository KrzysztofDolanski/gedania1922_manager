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
    private long id;
    private String surmane;
    private String name;
    private String certyficates;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team teamName;

    public Trainer(String surmane, String name) {
        this.surmane = surmane;
        this.name = name;
    }

    public Trainer(String surmane, String name, String certyficates) {
        this.surmane = surmane;
        this.name = name;
        this.certyficates = certyficates;
    }

    public Trainer(String surmane, String name, String certyficates, Team teamName) {
        this.surmane = surmane;
        this.name = name;
        this.certyficates = certyficates;
        this.teamName = teamName;
    }
}
