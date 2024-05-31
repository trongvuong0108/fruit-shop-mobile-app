package com.code.Data.OrderDetail;

import com.code.Data.Order.Order;
import com.code.Data.Product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class OrderDetail {
    @Id
    @Column(
            name = "id",
            nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private float quality;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product ;
    @ManyToOne
    @JoinColumn(name = "bill_id",referencedColumnName = "id")
    private Order bill;
}
