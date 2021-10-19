package com.example.rascalserver.Controller;

import com.example.rascalserver.DTO.RecordGameBatter;
import com.example.rascalserver.Entity.GameBatter;
import com.example.rascalserver.Result.CommonResult;
import com.example.rascalserver.Result.ListResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Service.GameBatterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = {"4. GameBatter"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game/batter")
public class GameBatterController {

    private final GameBatterService gameBatterService;
    private final ResponseService responseService;

    // Get By GameId
    @ApiOperation(value = "Batter Game")
    @GetMapping(value = "/{gameId}")
    public ListResult<GameBatter> getGameBatters(@ApiParam(value = "GameID") @PathVariable("gameId") String gameId) {
        return responseService.getListResult(gameBatterService.findGameBattersById(Long.valueOf(gameId)));
    }

    @ApiOperation(value = "Create/Update Batter")
    @PostMapping(value = "/{gameId}")
    public ListResult<GameBatter> createUpdateGameBatters(@ApiParam(value = "GameID") @PathVariable("gameId") String gameId,
                                   @ApiParam(value = "LoginAccount") @RequestBody List<RecordGameBatter> recordGameBatters) {
        return responseService.getListResult(gameBatterService.saveGameBatters(Long.valueOf(gameId), recordGameBatters));
    }

    @ApiOperation(value = "Delete GameBatter")
    @DeleteMapping(value = "/{gameBatterId}")
    public CommonResult deleteGameBatter(@ApiParam(value = "GameBatterID") @PathVariable("gameBatterId") String gameBatterId) {
        gameBatterService.deleteGameBatter(Long.valueOf(gameBatterId));
        return responseService.getSuccessResult();
    }
}
