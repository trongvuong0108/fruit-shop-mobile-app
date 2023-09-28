package com.code.Data.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    public Account findByUsername(String username);
}
