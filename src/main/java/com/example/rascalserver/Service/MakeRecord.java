package com.example.rascalserver.Service;

import com.example.rascalserver.DTO.Hit;
import com.example.rascalserver.DTO.RecordGameBatter;
import com.example.rascalserver.Entity.GameBatter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class MakeRecord {
    public GameBatter createGameBatter(Long gameId, RecordGameBatter recordGameBatter) {
        int pa=0, ab=0, hits=0;

        // 타격 GR (그라운드), FL (플라이), LL (라인드라이브), IF (인필드 플라이)FF (파울 플라이), FE (파울 플라이 실책), H1 (안타), H2 (2루타), H3 (3루타)HR (홈런)
        // 비타격 BB (볼넷), HP (몸에 맞는 공), KK (삼진), KN (낫아웃), KB (쓰리번트 아웃)KW (낫아웃 와일드피치), KP (낫아웃 패스트볼)

        // 정리 필요
        String[] pAb = {"GR", "FL", "LL", "IF", "FF","H1", "H2", "H3", "HR"};
        String[] pHit = {"H1", "H2", "H3", "HR"};

        ArrayList<String> plusAb = new ArrayList<>(Arrays.asList(pAb));
        ArrayList<String> plusHit = new ArrayList<>(Arrays.asList(pHit));

        for(Hit hit: recordGameBatter.getHits()) {
            pa++;
            if (plusAb.contains(hit.getHitRes())) ab++;
            if (plusHit.contains(hit.getHitRes())) hits++;
        }

        GameBatter.GameBatterBuilder gameBatter = GameBatter.builder()
                .uid(recordGameBatter.getUid())
                //.gameID(gameId)
                .pa(pa).ab(ab).hit(hits)
                .rbi(recordGameBatter.getRbi())
                .r(recordGameBatter.getR())
                .sb(recordGameBatter.getSb());

        if (recordGameBatter.getGameBatterId() == 0) return gameBatter.build(); // Create
        else return gameBatter.gameBatterID(recordGameBatter.getGameBatterId()).build(); // Update
    }

    public void createGamePitcher(Long gameId) {

    }
}
