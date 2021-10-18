package com.example.rascalserver.Controller;

import com.example.rascalserver.DTO.Games;
import com.example.rascalserver.Entity.Game;
import com.example.rascalserver.Result.ListResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import com.example.rascalserver.Service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = {"3. Game"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;
    private final ResponseService responseService;

    @ApiOperation(value = "Get Games")
    @GetMapping(value = "/")
    public ListResult<Games> getGames() {
        return responseService.getListResult(gameService.findAllGames());
    }

    @ApiOperation(value = "Get Game")
    @GetMapping(value = "/{gameId}")
    public SingleResult<Game> getGame(@ApiParam(value = "GameID") @PathVariable("gameId") String gameId) throws Exception {
        return responseService.getSingleResult(gameService.findGame(Long.valueOf(gameId)));
    }

    @ApiOperation(value = "Create/Update Game")
    @PostMapping(value = "/" )
    public SingleResult<Game> createUpdateGame(@ApiParam(value = "Game") @RequestBody Game game) {
        return responseService.getSingleResult(gameService.createGame(game));
    }

    @ApiOperation(value = "Delete Game")
    @PostMapping(value = "/{gameId}" )
    public SingleResult<Game> deleteGame(@ApiParam(value = "Game") @RequestBody Game game) {
        return responseService.getSingleResult(gameService.createGame(game));
    }
}
