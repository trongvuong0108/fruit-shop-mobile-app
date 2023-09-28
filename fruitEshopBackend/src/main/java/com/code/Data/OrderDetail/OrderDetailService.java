package com.code.Data.OrderDetail;


import com.code.Entity.detailBill;
import com.code.Data.OrderDetail.detail_BillRepository;
import com.code.Data.OrderDetail.detail_BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class detail_BilllServiceImpl implements detail_BillService {
    @Autowired
    private detail_BillRepository detail_billRepository;

    @Override
    public void save(detailBill detail_bill) {
        detail_billRepository.save(detail_bill);
    }
}
