package com.code.Data.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService implements ITokenService {

    private final ITokenRepository tokenRepository;

    public TokenService(ITokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token findByToken(String token) {
        return tokenRepository.findByToken(token);
    }

    @Override
    public void save(Token token) {
        tokenRepository.save(token);
    }
}
