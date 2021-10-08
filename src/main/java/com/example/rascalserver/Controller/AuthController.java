package com.example.rascalserver.Controller;

import com.example.rascalserver.Config.JwtTokenProvider;
import com.example.rascalserver.Exception.LoginFailedException;
import com.example.rascalserver.Model.Account;
import com.example.rascalserver.Repository.AccountJpaRepo;
import com.example.rascalserver.Result.CommonResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

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
    public SingleResult<String> login(@ApiParam(value = "Email", required = true) @RequestParam("email") String email,
                                      @ApiParam(value = "Password", required = true) @RequestParam("password") String password) {
        Account account = accountJpaRepo.findByEmail(email).orElseThrow(LoginFailedException::new);
        if (!passwordEncoder.matches(password, account.getPassword())) { throw new LoginFailedException(); }
        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(account.getUid()), account.getRoles()));
    }

    @ApiOperation(value = "Register")
    @PostMapping(value = "/register")
    public CommonResult register(@ApiParam(value = "Email", required = true) @RequestParam("email") String email,
                                 @ApiParam(value = "Password", required = true) @RequestParam("password") String password,
                                 @ApiParam(value = "Name", required = true) @RequestParam("name") String name) {
        accountJpaRepo.save(Account.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }
}
