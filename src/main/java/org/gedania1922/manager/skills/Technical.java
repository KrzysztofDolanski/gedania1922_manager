package org.gedania1922.manager.skills;

import lombok.*;
import org.gedania1922.manager.peoples.Player;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Technical {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double corners;
    private double crossing;
    private double dribbling;
    private double finishing;
    private double firstTouch;
    private double freeKickTaking;
    private double heading;
    private double longShots;
    private double longThrows;
    private double marking;
    private double passing;
    private double penaltyTaking;
    private double tackling;
    private double technique;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Player player;

}
