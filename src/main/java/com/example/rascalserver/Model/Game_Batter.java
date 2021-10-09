package com.example.rascalserver.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "Game_Batter")
public class Game_Batter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long game_batter_id;

    @Column(nullable = false)
    private Long game_id;

    @Column(nullable = false)
    private Long player_id;


    @ColumnDefault("0")
    private int pa; // Plate Appearance(타석)

    @ColumnDefault("0")
    private int ab; // At Bat(타수)

    @ColumnDefault("0")
    private int hit; // 안타

    @ColumnDefault("0")
    private int rbi; // Run Batted In(타점)

    @ColumnDefault("0")
    private int r; // Runs Scored(득점)

    @ColumnDefault("0")
    private int sb; // Stolen Base(도루)
}
