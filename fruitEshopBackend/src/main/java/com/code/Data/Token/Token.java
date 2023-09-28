package com.code.Entity;

import com.code.Data.Account.Account;
import com.code.Enum.TokenType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class token {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id ;
    @Column(nullable = false)
    private String token ;
    @Column(nullable = false)
    private LocalDateTime createAt;
    @Column(nullable = false)
    private LocalDateTime expiryAt;
    private LocalDateTime confirmAt;
    private TokenType tokenType;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "account_id"
    )
    private Account account;
    public void genNewToken(){
        this.token = UUID.randomUUID().toString();
        this.createAt = LocalDateTime.now();
        this.expiryAt = LocalDateTime.now().plusMinutes(15);
    }
    public boolean validateToken(){
        if(this.expiryAt.isAfter(LocalDateTime.now()))
            return false;
        return true;
    }
}
