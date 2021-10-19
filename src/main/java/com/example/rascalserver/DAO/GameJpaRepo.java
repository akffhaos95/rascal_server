package com.example.rascalserver.DAO;


import com.example.rascalserver.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GameJpaRepo extends JpaRepository<Game, Long> {
}
