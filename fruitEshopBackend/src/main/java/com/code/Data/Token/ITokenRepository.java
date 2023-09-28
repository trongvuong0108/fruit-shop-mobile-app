package com.code.Data.Token;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepository extends JpaRepository<Token,Integer> {
    public Token findByToken(String token);

}
