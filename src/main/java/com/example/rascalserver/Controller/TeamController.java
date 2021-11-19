package com.example.rascalserver.Controller;

import com.example.rascalserver.DTO.Games;
import com.example.rascalserver.Entity.Team;
import com.example.rascalserver.Result.ListResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"3. Team"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team")
public class TeamController {

    private final TeamService teamService;
    private final ResponseService responseService;

    @ApiOperation(value = "Get Teams")
    @GetMapping(value = "/")
    public ListResult<Team> getTeams() {
        return responseService.getListResult(teamService.findAllTeam());
    }

}
