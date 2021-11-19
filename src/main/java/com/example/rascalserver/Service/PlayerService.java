package com.example.rascalserver.Service;

import com.example.rascalserver.Entity.Player;

import java.util.List;

public interface PlayerService {
    List<Player> findAllPlayer();

    // 연결
    void savePlayer(Long uid);
}
