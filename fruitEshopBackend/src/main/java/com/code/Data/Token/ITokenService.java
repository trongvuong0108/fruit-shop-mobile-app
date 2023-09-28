package com.code.Data.Token;

public interface ITokenService {
    public Token findByToken(String token);
    public void save(Token signin_Token);
}
