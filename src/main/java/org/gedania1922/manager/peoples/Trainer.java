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
    private String surname;
    private String name;
    private String certyficates;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Team teamName;

    public Trainer(String surname, String name) {
        this.surname = surname;
        this.name = name;
    }

    public Trainer(String surname, String name, String certyficates) {
        this.surname = surname;
        this.name = name;
        this.certyficates = certyficates;
    }

    public Trainer(String surname, String name, String certyficates, Team teamName) {
        this.surname = surname;
        this.name = name;
        this.certyficates = certyficates;
        this.teamName = teamName;
    }
}
