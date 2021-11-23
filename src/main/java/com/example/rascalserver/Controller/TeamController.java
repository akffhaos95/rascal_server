package com.example.rascalserver.Controller;

import com.example.rascalserver.DTO.Games;
import com.example.rascalserver.DTO.RegisterTeam;
import com.example.rascalserver.Entity.Game;
import com.example.rascalserver.Entity.Team;
import com.example.rascalserver.Result.CommonResult;
import com.example.rascalserver.Result.ListResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import com.example.rascalserver.Service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "Get Team")
    @GetMapping(value = "/{teamId}")
    public SingleResult<Team> getTeam(@ApiParam(value = "TeamID") @PathVariable("teamId") String teamId) throws Exception {
        return responseService.getSingleResult(teamService.findTeam(Long.valueOf(teamId)));
    }

    @ApiOperation(value = "Create/Update Team")
    @PostMapping(value = "/" )
    public SingleResult<Team> createUpdateTeam(@ApiParam(value = "Team") @RequestBody Team team) {
        return responseService.getSingleResult(teamService.saveTeam(team));
    }

    @ApiOperation(value = "Register Team")
    @PostMapping(value = "/register" )
    public CommonResult registerMember(@ApiParam(value = "RegisterTeam") @RequestBody RegisterTeam registerTeam) {
        teamService.registerMember(registerTeam);
        return responseService.getSuccessResult();
    }
}
