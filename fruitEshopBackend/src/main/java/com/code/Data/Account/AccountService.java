package com.code.Data.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.code.Enum.Role.CLIENT;

@Service
public class AccountService implements IAccountService, UserDetailsService {

    private final IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void save(Account account) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setUserRole(CLIENT);
        accountRepository.save(account);
    }

    @Override
    public Account getByUserName(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = getByUserName(username);
        if(account == null ) throw new UsernameNotFoundException("User not find");
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(account.getUserRole().getText()));
        return  new org.springframework.security.core.userdetails
                .User(account.getUsername(),account.getPassword(),true,true,true,true,auth);
    }
}
