package com.code.Data.Account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    public Optional<Account> findByUsername(String username);
}
