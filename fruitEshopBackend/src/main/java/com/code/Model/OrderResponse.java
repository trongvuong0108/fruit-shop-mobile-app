package com.code.Model;

import lombok.Data;

@Data
public class OrderResponse {
    private int id;
    private String createAt ;
    private String name;
    private String address;
    private String phone;
}
