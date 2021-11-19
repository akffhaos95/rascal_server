package com.example.rascalserver.DAO;

import com.example.rascalserver.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJpaRepo extends JpaRepository<Player, Integer> {
}
