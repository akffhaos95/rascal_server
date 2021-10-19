package com.example.rascalserver.Service;

import com.example.rascalserver.DTO.RecordGameBatter;
import com.example.rascalserver.Entity.GameBatter;

import java.util.List;

public interface GameBatterService {
    List<GameBatter> findGameBattersById(Long gameId);
    GameBatter findGameBatterById(Long gameBatterId);
    List<GameBatter> saveGameBatters(Long gameId, List<RecordGameBatter> recordGameBatters);
    void deleteGameBatter(Long gameBatterId);
}
