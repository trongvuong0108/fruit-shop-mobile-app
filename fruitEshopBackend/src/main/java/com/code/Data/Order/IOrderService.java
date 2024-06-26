package com.code.Data.Order;

import java.util.List;

public interface IOrderService {
    public void save(Order bill);
    public List<Order> getByUser(String username);
    public List<Order> getAll();
}
