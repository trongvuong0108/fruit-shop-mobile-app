package com.code.Data.Token;

import com.code.Entity.token;

import com.code.Data.Token.tokenRepository;
import com.code.Data.Token.tokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class tokenServiceImpl implements tokenService {

    @Autowired
    private tokenRepository tokenRepository;
    @Override
    public token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void save(token signin_Token) {
        tokenRepository.save(signin_Token);
    }
}
