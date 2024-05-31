package com.code.Data.ProductImg;

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
public class ProductImg {
    @Id
    @Column(
            name = "id",
            nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id ;
    private String img ;
    @ManyToOne
    @JoinColumn(
            name = "product_id",
            nullable = false,
            referencedColumnName = "id"
    )
    private Product product;
}
