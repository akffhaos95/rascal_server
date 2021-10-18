package com.example.rascalserver.DAO;

import com.example.rascalserver.Entity.GameBatter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameBatterJpaRepo extends JpaRepository<GameBatter, Long> {
    List<GameBatter> findAllByGameID(Long gameId);

}
