package com.code.Controller;

import com.code.Data.Account.IAccountService;
import com.code.Data.Order.DTO.CheckOutRequest;
import com.code.Data.Order.IOrderService;
import com.code.Data.Order.Order;
import com.code.Data.OrderDetail.OrderDetailService;
import com.code.Data.Product.IProductService;
import com.code.Model.OrderResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    private final IOrderService billService ;

    private final IProductService productService ;

    private final OrderDetailService orderDetailService;

    private final IAccountService accountService;

    public BillController(IOrderService billService, IProductService productService, OrderDetailService orderDetailService, IAccountService accountService) {
        this.billService = billService;
        this.productService = productService;
        this.orderDetailService = orderDetailService;
        this.accountService = accountService;
    }

    @PostMapping("/checkout")
    public String save(@RequestBody CheckOutRequest bill_model) throws Exception {
//        Order bill = new Order();
//        bill.setCreateAt(LocalDateTime.now());
//        bill.setName(bill_model.getName());
//        bill.setAddress(bill_model.getAddress());
//        bill.setPhone(bill_model.getPhone());
//        billService.save(bill);
//        for (com.code.Model.OrderDetail detail_BillModel: bill_model.getDetailList()) {
//            Product product = productService.findByName(detail_BillModel.getProductModel().getName());
//            if(product == null) throw new Exception("not find product");
//            if(product.getQuantity() < detail_BillModel.getQuality())
//                    throw new Exception("not enough");
//            else {
//                product.setQuantity(product.getQuantity() - detail_BillModel.getQuality()   );
//                productService.save(product);
//            }
//
//            OrderDetail detail_bill = new OrderDetail();
//            detail_bill.setProduct(product);
//            detail_bill.setQuality(detail_BillModel.getQuality());
//            detail_bill.setBill(bill);
//            orderDetailService.save(detail_bill);
//        }
        return "ok";
    }

    @GetMapping("getAll")
    public List<OrderResponse> getAll(){
        List<OrderResponse> res = new ArrayList<>();
        for (Order bill: billService.getAll()) {
            OrderResponse responeBillModel = new OrderResponse();
            responeBillModel.setId(bill.getId());
            responeBillModel.setName(bill.getName());
            responeBillModel.setAddress(bill.getAddress());
            responeBillModel.setCreateAt(bill.getCreateAt().toString());
            responeBillModel.setPhone(bill.getPhone());
            res.add(responeBillModel);
        }
        return res;
    }

}
