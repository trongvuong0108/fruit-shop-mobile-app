package com.code.Data.Account.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {
    String username;
    String password;
    String fullName;
    String email;
    String address;
    String phone;
}
