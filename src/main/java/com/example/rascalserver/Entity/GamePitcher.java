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
@Table(name = "GamePitcher")
public class GamePitcher {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "gamePitcherID")
    private long gamePitcherID;

    @Column(name = "gameID")
    private long gameID;

    @Column(name = "uid")
    private long uid;

    @Column(name = "res") // 승패
    private String res; // "", "승", "패", "홀", "세"

    @Column(name = "inn")
    private float inn;

    @Column(name = "pa")
    private int pa; // 타자

    @Column(name = "ab")
    private int ab; // 타수

    @Column(name = "hit")
    private int hit; // 피안

    @Column(name = "bb")
    private int bb; // 4구

    @Column(name = "hb")
    private int hb; // 사구

    @Column(name = "kk")
    private int kk; // 삼진

    @Column(name = "r")
    private int r; // 실점

    @Column(name = "mr")
    private int mr; // 자책
}
