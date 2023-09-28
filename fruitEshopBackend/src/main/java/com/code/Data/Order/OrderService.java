package com.code.Data.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository billRepository ;
    @Override
    public void save(Order bill) {
        billRepository.save(bill);
    }

    @Override
    public List<Order> getAll() {
        return billRepository.findAll();
    }

    @Override
    public List<Order> getByUser(String name) {
        List<Order> bills = getAll();
        List<Order> result = new ArrayList<>();
        for (Order bill: bills) {
            if(bill.getName().equals(name))
                result.add(bill);
        }
        return result;
    }


}
