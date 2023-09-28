package com.code.Data.Token;

import com.code.Entity.token;

public interface tokenService {
    public token findByToken(String token);
    public void save(token signin_Token);
}
