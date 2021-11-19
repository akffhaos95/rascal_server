package com.example.rascalserver.Entity;

import javax.persistence.*;

@Entity
class AccountToPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;

    @ManyToOne
    @JoinColumn(name = "player_id")
    Player player;
}