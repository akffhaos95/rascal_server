package com.example.rascalserver.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Games {
        private long gameID;
        private Date date;
        private String location;
        private int type;
        private int status; // 0 생성됨, 1 기록중, 2 기록 끝(기록 끝 상황에서 트리가거 작동, 수정은 가능)
        private String homeTeam;
        private String awayTeam;
        private int homeScore;
        private int awayScore;
}
