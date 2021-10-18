package com.example.rascalserver.DAO;


import com.example.rascalserver.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameJpaRepo extends JpaRepository<Game, Long> {
    List<Game> findAll();


    //@Query("SELECT Game FROM Game WHERE gameID==%:gameId%")
    //Game findGameByGameId(@Param("gameId") Long gameId);
}
