package com.example.rascalserver.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;

    @OneToMany(mappedBy = "player")
    Set<AccountToPlayer> accountToPlayer;

    @OneToMany(mappedBy = "player")
    Set<TeamToPlayer> teamToPlayer;
}
