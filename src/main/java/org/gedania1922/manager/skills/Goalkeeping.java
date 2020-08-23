package org.gedania1922.manager.skills;

import lombok.*;
import org.gedania1922.manager.peoples.Player;
import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Goalkeeping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double aerialReach;
    private double communication;
    private double firstTouch;
    private double handling;
    private double kicking;
    private double oneToOnes;
    private double passing;
    private double reflexes;
    private double rushingOut;
    private double throwing;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player player;


}
