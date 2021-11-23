package com.example.rascalserver.DAO;

import com.example.rascalserver.Entity.AccountToTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountToTeamJpaRepo extends JpaRepository<AccountToTeam, Integer> {
}
