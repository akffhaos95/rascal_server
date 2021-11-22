package com.example.rascalserver.Controller;

import com.example.rascalserver.DTO.LoginAccount;
import com.example.rascalserver.DTO.RegisterAccount;
import com.example.rascalserver.Result.CommonResult;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import com.example.rascalserver.Service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = {"1. Auth"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AccountService accountService;
    private final ResponseService responseService;

    @ApiOperation(value = "Login")
    @PostMapping(value = "/login")
    public SingleResult<String> login(@ApiParam(value = "LoginAccount") @RequestBody LoginAccount loginAccount) {
        return responseService.getSingleResult(accountService.login(loginAccount));
    }

    @ApiOperation(value = "Register")
    @PostMapping(value = "/register")
    public CommonResult register(@ApiParam(value = "RegisterAccount") @RequestBody RegisterAccount registerAccount) {
        return responseService.getSingleResult(accountService.register(registerAccount));
    }
}
