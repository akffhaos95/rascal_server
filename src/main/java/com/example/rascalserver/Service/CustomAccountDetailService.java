package com.example.rascalserver.Service;

import com.example.rascalserver.Exception.LoginFailedException;
import com.example.rascalserver.DAO.AccountJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomAccountDetailService implements UserDetailsService {

    private final AccountJpaRepo accountJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk) {
        return accountJpaRepo.findByUid(userPk).orElseThrow(LoginFailedException::new);
    }
}
