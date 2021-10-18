package com.example.rascalserver.Controller;

import com.example.rascalserver.DAO.GameBatterJpaRepo;
import com.example.rascalserver.DTO.Hit;
import com.example.rascalserver.DTO.RecordGameBatter;
import com.example.rascalserver.Entity.Game;
import com.example.rascalserver.Entity.GameBatter;
import com.example.rascalserver.Result.CommonResult;
import com.example.rascalserver.Result.ListResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import com.example.rascalserver.Service.MakeRecord;
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

    private final GameBatterJpaRepo gameBatterJpaRepo;
    private final ResponseService responseService;

    // Get By GameId
    @ApiOperation(value = "Batter Game")
    @GetMapping(value = "/{gameId}")
    public ListResult<GameBatter> getGameBatter(@ApiParam(value = "GameID") @PathVariable("gameId") String gameId) {
        // 게임이 존재하는지 확인
        log.info(String.valueOf(gameId));
        List<GameBatter> gameBatterList = gameBatterJpaRepo.findAllByGameID(Long.valueOf(gameId));
        return responseService.getListResult(gameBatterList);
    }

    // Post Batter Record
    @ApiOperation(value = "Record Batter")
    @PostMapping(value = "/{gameId}")
    public CommonResult recordGame(@ApiParam(value = "GameID") @PathVariable("gameId") String gameId,
                                   @ApiParam(value = "LoginAccount") @RequestBody List<RecordGameBatter> recordGameBatters) {

        // 게임이 존재하는지 확인
        MakeRecord makeRecord = new MakeRecord();

        log.info(String.valueOf(gameId));
        for(RecordGameBatter recordGameBatter: recordGameBatters) {
            log.info(String.valueOf(recordGameBatter.getGameBatterId()));
            GameBatter gameBatter = gameBatterJpaRepo.save(makeRecord.createGameBatter(Long.valueOf(gameId), recordGameBatter));
        }
        return responseService.getSuccessResult();
    }
}
