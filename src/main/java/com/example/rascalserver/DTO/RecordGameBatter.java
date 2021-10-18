package com.example.rascalserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordGameBatter {
    private Long gameBatterId;
    private Long uid;
    private int rbi;
    private int r;
    private int sb;
    private List<Hit> hits;
}

