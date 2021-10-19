package com.example.rascalserver.Service.Impl;

import com.example.rascalserver.Config.JwtTokenProvider;
import com.example.rascalserver.DAO.AccountJpaRepo;
import com.example.rascalserver.DTO.LoginAccount;
import com.example.rascalserver.DTO.RegisterAccount;
import com.example.rascalserver.Entity.Account;
import com.example.rascalserver.Exception.LoginFailedException;
import com.example.rascalserver.Service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountJpaRepo accountJpaRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginAccount loginAccount) {
        Account account = accountJpaRepo.findByEmail(loginAccount.getEmail()).orElseThrow(LoginFailedException::new);
        if (!passwordEncoder.matches(loginAccount.getPassword(), account.getPassword())) { throw new LoginFailedException(); }
        return jwtTokenProvider.createToken(String.valueOf(account.getUid()), account.getRoles());
    }

    @Override
    public Account register(RegisterAccount registerAccount) {
        return accountJpaRepo.save(Account.builder()
                .email(registerAccount.getEmail())
                .password(passwordEncoder.encode(registerAccount.getPassword()))
                .name(registerAccount.getName())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }
}
