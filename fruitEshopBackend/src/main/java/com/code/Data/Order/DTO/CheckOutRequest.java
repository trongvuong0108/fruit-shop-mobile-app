package com.code.Data.Order.DTO;

import com.code.Model.OrderDetail;
import lombok.Data;

import java.util.List;

@Data
public class CheckOutRequest {
    List<OrderDetail> detailList;
    String name;
    String address;
    String phone;
}
