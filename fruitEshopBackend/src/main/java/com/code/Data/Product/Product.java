package com.code.Data.Product;

import com.code.Data.Category.Category;
import com.code.Data.Product.DTO.CreateOrUpdateProductRequest;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table
public class Product extends ProductBase {
    @Id
    @Column(name = "id", nullable = false)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;
    private boolean enable;
    private String img;
    private LocalDateTime dayCreate;
    private LocalDateTime dayUpdate;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    public Product(
            CreateOrUpdateProductRequest request,
            String img,
            boolean enable,
            LocalDateTime dayCreate,
            LocalDateTime dayUpdate
    ) {
        super(request);
        this.category = request.getCategory();
        this.img = img;
        this.enable = enable;
        this.dayCreate = dayCreate;
        this.dayUpdate = dayUpdate;
    }
    public Product() {

    }
}

