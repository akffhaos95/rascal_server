package com.example.rascalserver.Service.Impl;

import com.example.rascalserver.Config.JwtTokenProvider;
import com.example.rascalserver.DAO.AccountJpaRepo;
import com.example.rascalserver.DTO.EditAccount;
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
import java.util.Date;

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
        Date now = new Date();
        return accountJpaRepo.save(Account.builder()
                .email(registerAccount.getEmail())
                .image(registerAccount.getImage())
                .password(passwordEncoder.encode(registerAccount.getPassword()))
                .name(registerAccount.getName())
                .createdAt(now)
                .updatedAt(now)
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }

    @Override
    public Account profile(Long uid) {
        return accountJpaRepo.getById(uid);
    }

    @Override
    public Account editProfile(Account now_account, EditAccount new_account) {
        now_account.setName(new_account.getName());
        now_account.setImage(new_account.getImage());
        return accountJpaRepo.save(now_account);

    }

    @Override
    public void registerTeam(String uid, String teamId) {

    }
}
