package com.example.rascalserver.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
class TeamToPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
}