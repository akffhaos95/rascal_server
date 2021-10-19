package com.example.rascalserver.Service;

import com.example.rascalserver.DTO.LoginAccount;
import com.example.rascalserver.DTO.RegisterAccount;
import com.example.rascalserver.Entity.Account;

public interface AccountService {
    String login(LoginAccount loginAccount);
    Account register(RegisterAccount registerAccount);
}
