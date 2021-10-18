package com.example.rascalserver.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "GameBatter")
public class GameBatter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "gameBatterID")
    private long gameBatterID;

    @Column(name = "gameID")
    private long gameID;

    @Column(name = "uid")
    private long uid;

    @Column(name = "pa")
    private int pa;

    @Column(name = "ab")
    private int ab;

    @Column(name = "hit")
    private int hit;

    @Column(name = "rbi")
    private int rbi;

    @Column(name = "r")
    private int r;

    @Column(name = "sb")
    private int sb;
}
