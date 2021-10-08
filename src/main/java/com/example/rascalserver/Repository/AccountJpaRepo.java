package com.example.rascalserver.Repository;

import com.example.rascalserver.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountJpaRepo extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findByUid(String email);
}
