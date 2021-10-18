package com.example.rascalserver.Service.Impl;

import com.example.rascalserver.DAO.GameJpaRepo;
import com.example.rascalserver.DTO.Games;
import com.example.rascalserver.Entity.Game;
import com.example.rascalserver.Service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameJpaRepo gameJpaRepo;
    private final ModelMapper modelMapper;

    @Override
    public List<Games> findAllGames() {
        return _findALlGames().stream().map(game -> modelMapper.map(game, Games.class)).collect(Collectors.toList());
    }

    private List<Game> _findALlGames() {
        log.info("find");
        return gameJpaRepo.findAll();
    }

    @Override
    public Game findGame(Long gameId) throws Exception {
        return gameJpaRepo.findById(gameId).orElseThrow(Exception::new);
    }

    @Override
    public Game createGame(Game game) {
        Game.GameBuilder newGame = Game.builder()
                .location(game.getLocation())
                .date(game.getDate())
                .homeTeam(game.getHomeTeam())
                .awayTeam(game.getAwayTeam())
                .status(game.getStatus())
                .type(game.getType());
        if(game.getGameID() == 0) return gameJpaRepo.save(newGame.build());
        else return gameJpaRepo.save(newGame.gameID(game.getGameID()).build());
    }
}
