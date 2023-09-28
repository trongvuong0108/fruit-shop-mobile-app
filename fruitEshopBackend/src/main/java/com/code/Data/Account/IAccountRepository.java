package com.code.Data.Account;

import com.code.Entity.account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<account,Integer> {
    public account findByUsername(String username);
}
