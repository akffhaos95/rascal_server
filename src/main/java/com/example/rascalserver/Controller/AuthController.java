package com.example.rascalserver.Controller;

import com.example.rascalserver.Config.JwtTokenProvider;
import com.example.rascalserver.DTO.LoginAccount;
import com.example.rascalserver.DTO.RegisterAccount;
import com.example.rascalserver.Exception.LoginFailedException;
import com.example.rascalserver.Entity.Account;
import com.example.rascalserver.DAO.AccountJpaRepo;
import com.example.rascalserver.Result.CommonResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Slf4j
@Api(tags = {"1. Auth"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AccountJpaRepo accountJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "Login")
    @PostMapping(value = "/login")
    public SingleResult<String> login(@ApiParam(value = "LoginAccount") @RequestBody LoginAccount loginAccount) {
        Account account = accountJpaRepo.findByEmail(loginAccount.getEmail()).orElseThrow(LoginFailedException::new);
        if (!passwordEncoder.matches(loginAccount.getPassword(), account.getPassword())) { throw new LoginFailedException(); }
        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(account.getUid()), account.getRoles()));
    }

    @ApiOperation(value = "Register")
    @PostMapping(value = "/register")
    public CommonResult register(@ApiParam(value = "RegisterAccount") @RequestBody RegisterAccount registerAccount) {
        accountJpaRepo.save(Account.builder()
                .email(registerAccount.getEmail())
                .password(passwordEncoder.encode(registerAccount.getPassword()))
                .name(registerAccount.getName())
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }
}
