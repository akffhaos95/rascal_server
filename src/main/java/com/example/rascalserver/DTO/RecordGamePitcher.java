package com.example.rascalserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordGamePitcher {
    private Long gamePitcherId;
    private Long uid;
    private int r; // 실점
    private int self_r; // 자책
    private List<Hit> hits;
}
