package com.example.rascalserver.Service;

import com.example.rascalserver.DTO.RegisterTeam;
import com.example.rascalserver.Entity.Team;

import java.util.List;

public interface TeamService {
    List<Team> findAllTeam();
    Team findTeam(Long teamId) throws Exception;
    Team saveTeam(Team team);
    void deleteTeam(Long teamID);

    //팀 등록
    void inviteMember(Long teamId, Long accountId);
    void registerMember(RegisterTeam registerTeam);
    void deleteMember(Long teamId, Long accountId);
}
