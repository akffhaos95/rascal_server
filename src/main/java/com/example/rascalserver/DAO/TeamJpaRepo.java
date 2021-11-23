package com.example.rascalserver.DAO;

import com.example.rascalserver.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamJpaRepo extends JpaRepository<Team, Long> {
}
