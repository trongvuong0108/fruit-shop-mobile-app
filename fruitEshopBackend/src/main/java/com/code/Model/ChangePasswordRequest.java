package com.code.Model;

import lombok.Data;

@Data
public class ChangePasswordRequest {
    private String username;
    private String newPassword;
    private String password;
}
