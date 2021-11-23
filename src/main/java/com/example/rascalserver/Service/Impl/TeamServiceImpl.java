package com.example.rascalserver.Service.Impl;

import com.example.rascalserver.DAO.AccountJpaRepo;
import com.example.rascalserver.DAO.AccountToTeamJpaRepo;
import com.example.rascalserver.DAO.TeamJpaRepo;
import com.example.rascalserver.DTO.RegisterTeam;
import com.example.rascalserver.Entity.Account;
import com.example.rascalserver.Entity.AccountToTeam;
import com.example.rascalserver.Entity.Game;
import com.example.rascalserver.Entity.Team;
import com.example.rascalserver.Service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamJpaRepo teamJpaRepo;
    private final AccountJpaRepo accountJpaRepo;
    private final AccountToTeamJpaRepo accountToTeamJpaRepo;

    @Override
    public List<Team> findAllTeam() {
        return teamJpaRepo.findAll();
    }

    @Override
    public Team findTeam(Long teamId) throws Exception{
        return teamJpaRepo.findById(teamId).orElseThrow(Exception::new);
    }

    @Override
    public Team saveTeam(Team team) {
        Date now = new Date();
        Team.TeamBuilder newTeam = Team.builder()
                .image(team.getImage())
                .name(team.getName())
                .createdAt(now)
                .updatedAt(now);
        if(team.getTeam_id() == 0) return teamJpaRepo.save(newTeam.build());
        else return teamJpaRepo.save(newTeam.team_id(team.getTeam_id()).build());
    }

    @Override
    public void deleteTeam(Long TeamID) {

    }

    @Override
    public void inviteMember(Long teamId, Long accountId) {

    }

    @Override
    public void registerMember(RegisterTeam registerTeam) {
        Team team = teamJpaRepo.getById(registerTeam.getTeam_id());
        log.info(team.getName());
        Account account = accountJpaRepo.getById(registerTeam.getUid());
        log.info(account.getName());
        Integer number = registerTeam.getNumber();
        log.info(number.toString());
        accountToTeamJpaRepo.save(AccountToTeam.builder().team(team).account(account).number(number).build());
    }

    @Override
    public void deleteMember(Long teamId, Long accountId) {

    }
}
