package com.code.Data.Account;

import com.code.Entity.account;

import java.util.List;

public interface AccountService {
    public void save(account account);
    public account getByUserName(String username);

    public List<account> getAll();
}
