package com.code.Data.Order;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Bill")
public class Order {
    @Id
    @Column(
            name = "id",
            nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private LocalDateTime createAt ;
    private String name;
    private String address;
    private String phone;
}
