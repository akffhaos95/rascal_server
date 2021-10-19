package com.example.rascalserver.Service.Impl;

import com.example.rascalserver.DAO.GameBatterJpaRepo;
import com.example.rascalserver.DTO.Hit;
import com.example.rascalserver.DTO.RecordGameBatter;
import com.example.rascalserver.Entity.GameBatter;
import com.example.rascalserver.Service.GameBatterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameBatterServiceImpl implements GameBatterService {

    private final GameBatterJpaRepo gameBatterJpaRepo;

    @Override
    public List<GameBatter> findGameBattersById(Long gameId) {
        return gameBatterJpaRepo.findAllByGameID(Long.valueOf(gameId));
    }

    @Override
    public GameBatter findGameBatterById(Long gameBatterId) {
        return gameBatterJpaRepo.findById(gameBatterId).orElseThrow();
    }

    @Override
    public List<GameBatter> saveGameBatters(Long gameId, List<RecordGameBatter> recordGameBatters) {
        String[] pAb = {"GR", "FL", "LL", "IF", "FF","H1", "H2", "H3", "HR"};
        String[] pHit = {"H1", "H2", "H3", "HR"};

        List<GameBatter> gameBatters = new ArrayList<GameBatter>();

        for(RecordGameBatter recordGameBatter: recordGameBatters) {
            int pa=0, ab=0, hits=0;
            ArrayList<String> plusAb = new ArrayList<>(Arrays.asList(pAb));
            ArrayList<String> plusHit = new ArrayList<>(Arrays.asList(pHit));

            for(Hit hit: recordGameBatter.getHits()) {
                pa++;
                if (plusAb.contains(hit.getHitRes())) ab++;
                if (plusHit.contains(hit.getHitRes())) hits++;
            }

            GameBatter.GameBatterBuilder gameBatter = GameBatter.builder()
                    .uid(recordGameBatter.getUid())
                    .gameID(gameId)
                    .pa(pa).ab(ab).hit(hits)
                    .rbi(recordGameBatter.getRbi())
                    .r(recordGameBatter.getR())
                    .sb(recordGameBatter.getSb());

            if (recordGameBatter.getGameBatterId() != 0)  gameBatter.gameBatterID(recordGameBatter.getGameBatterId()); // Update
            gameBatters.add(gameBatterJpaRepo.save(gameBatter.build()));
        }
        return gameBatters;
    }

    @Override
    public void deleteGameBatter(Long gameBatterId) {
        gameBatterJpaRepo.deleteById(gameBatterId);
    }
}
