package com.example.rascalserver.Service.Impl;

import com.example.rascalserver.DAO.TeamJpaRepo;
import com.example.rascalserver.Entity.Team;
import com.example.rascalserver.Service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamJpaRepo teamJpaRepo;

    @Override
    public List<Team> findAllTeam() {
        return teamJpaRepo.findAll();
    }
}
