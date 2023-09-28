package com.code.Entity;

import com.code.Data.Order.Order;
import com.code.Data.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class detailBill {
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
