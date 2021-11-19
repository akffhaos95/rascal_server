package com.example.rascalserver.Service.Impl;

import com.example.rascalserver.DAO.PlayerJpaRepo;
import com.example.rascalserver.Entity.Player;
import com.example.rascalserver.Service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerJpaRepo playerJpaRepo;

    @Override
    public List<Player> findAllPlayer() {
        return playerJpaRepo.findAll();
    }

    @Override
    public void savePlayer(Long uid) {

    }
}
