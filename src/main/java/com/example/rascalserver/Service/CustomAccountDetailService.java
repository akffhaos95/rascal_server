package com.example.rascalserver.Service;

import com.example.rascalserver.Exception.LoginFailedException;
import com.example.rascalserver.Repository.AccountJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomAccountDetailService implements UserDetailsService {
    private final AccountJpaRepo accountJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return accountJpaRepo.findByUid(userPk).orElseThrow(LoginFailedException::new);
    }
}
