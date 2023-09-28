package com.code.Data.Account;

import com.code.Entity.account;
import com.code.Data.Account.AccountRepository;
import com.code.Data.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

import static com.code.Enum.role.CLIENT;

@Service
public class accountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void save(account account) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setUserRole(CLIENT);
        accountRepository.save(account);
    }

    @Override
    public account getByUserName(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<account> getAll() {
        return accountRepository.findAll();
    }
}
