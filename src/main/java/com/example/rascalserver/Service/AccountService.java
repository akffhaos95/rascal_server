package com.example.rascalserver.Service;

import com.example.rascalserver.DTO.EditAccount;
import com.example.rascalserver.DTO.LoginAccount;
import com.example.rascalserver.DTO.RegisterAccount;
import com.example.rascalserver.Entity.Account;

public interface AccountService {
    // Auth
    String login(LoginAccount loginAccount);
    Account register(RegisterAccount registerAccount);

    // Account
    Account profile(Long uid);
    Account editProfile(Account now_account, EditAccount editAccount);
    void registerTeam(String uid, String teamId);
}
