package com.code.Entity;


import com.code.Enum.role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Account")
public class Account {
    @Id
    @Column(
            name = "id"
            , nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private UUID id;
    @Column(
            name = "username",
            nullable = false,
            unique = true
    )
    private String username;
    @Column(
            name = "password",
            nullable = false
    )
    private String password;
    private String fullName ;
    @Column(
            unique = true
    )
    private String email;
    private String address;
    private String phone ;
    private role userRole;
    private boolean enable ;
}
