package com.example.rascalserver.Controller;

import com.example.rascalserver.Entity.Account;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import com.example.rascalserver.Service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = {"2. Account"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;
    private final ResponseService responseService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "Profile")
    @PostMapping(value = "/profile")
    public SingleResult<Account> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //log.info(authentication);
        accountService.profile();
        return responseService.getSingleResult(Account.builder().build());
    }

}
