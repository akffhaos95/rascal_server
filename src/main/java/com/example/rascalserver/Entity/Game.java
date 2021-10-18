package com.example.rascalserver.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "Game")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Game {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "gameID")
    private long gameID;

    @Column(name="date") // 날짜
    private Date date;

    @Column(name="location") // 장소
    private String location;

    @Column(name="type") // 연습경기, 무슨 리그
    private int type;

    @Column(name="status")
    private int status; // 0 생성됨, 1 기록중, 2 기록 끝(기록 끝 상황에서 트리가거 작동, 수정은 가능)

    @Column(name="homeTeam")
    private String homeTeam;

    @Column(name="awayTeam")
    private String awayTeam;

    @Column(name="homeScore")
    @ColumnDefault("0")
    private int homeScore;

    @Column(name="awayScore")
    @ColumnDefault("0")
    private int awayScore;

    @OneToMany(mappedBy = "gameID", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Basic(fetch = FetchType.LAZY)
    private List<GameBatter> gameBatters = new ArrayList<>();

    @Override
    public String toString(){
        log.info("GameID: " + gameID);
        log.info("Date: " + date + ", Location: " + location);
        log.info("Type: " + type + ", Status: " + status);
        log.info(homeTeam + " " + homeScore + " : " + awayScore + " " + awayTeam);
        return "";
    };
}
