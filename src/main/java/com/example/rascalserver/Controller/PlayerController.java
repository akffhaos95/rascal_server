package com.example.rascalserver.Controller;

import com.example.rascalserver.Entity.Player;
import com.example.rascalserver.Entity.Team;
import com.example.rascalserver.Result.ListResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"2. Player"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;
    private final ResponseService responseService;

    @ApiOperation(value = "Get Players")
    @GetMapping(value = "/")
    public ListResult<Player> getPlayers() {
        return responseService.getListResult(playerService.findAllPlayer());
    }

}
