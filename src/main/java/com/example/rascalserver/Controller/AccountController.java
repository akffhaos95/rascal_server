package com.example.rascalserver.Controller;

import com.example.rascalserver.DTO.EditAccount;
import com.example.rascalserver.Entity.Account;
import com.example.rascalserver.Entity.Game;
import com.example.rascalserver.Result.ResponseService;
import com.example.rascalserver.Result.SingleResult;
import com.example.rascalserver.Service.AccountService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = {"2. Account"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;
    private final ResponseService responseService;

    @ApiImplicitParams({ @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "access_token", required = true, dataType = "String", paramType = "header") })
    @ApiOperation(value = "Profile")
    @GetMapping(value = "/profile")
    public SingleResult<Account> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = (Account) authentication.getPrincipal();
        return responseService.getSingleResult(account);
    }

    @ApiImplicitParams({ @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "access_token", required = true, dataType = "String", paramType = "header") })
    @ApiOperation(value = "Edit Profile")
    @PostMapping(value = "/profile")
    public SingleResult<Account> editProfile(@ApiParam(value = "Account") @RequestBody EditAccount edit_account) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account now_account = (Account) authentication.getPrincipal();
        Account new_account = accountService.editProfile(now_account, edit_account);
        return responseService.getSingleResult(new_account);
    }

//    @ApiOperation(value = "Create/Update Game")
//    @PostMapping(value = "/" )
//    public SingleResult<Game> createUpdateGame(@ApiParam(value = "Game") @RequestBody Game game) {
//        return responseService.getSingleResult(gameService.saveGame(game));
//    }

}
