package com.example.rascalserver.Service;

import com.example.rascalserver.DTO.Games;
import com.example.rascalserver.Entity.Game;

import java.util.List;

public interface GameService {
    List<Games> findAllGames();
    Game findGame(Long GameId) throws Exception;
    Game createGame(Game game);
}
