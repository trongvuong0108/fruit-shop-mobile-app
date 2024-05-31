package com.code.Data.Account;

import java.util.List;

public interface IAccountService {
    public void save(Account account);
    public Account getByUserName(String username);
    public List<Account> getAll();
    public void softDelete(int id);
}
