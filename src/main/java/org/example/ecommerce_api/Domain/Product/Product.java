package org.example.ecommerce_api.Domain.Product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerce_api.Domain.TypeProduct.TypeProduct;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private TypeProduct typeProduct;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "rating")
    private int rating;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public Product(Long id) {
        this.productId = id;
    }

    public Product(DataRegisterProduct data){
        this.name = data.name();
        this.typeProduct = new TypeProduct(data.typeProductId());
        this.price = data.price();
        this.rating = data.rating();
        this.image = data.image();
        this.description = data.description();
        this.quantity = data.quantity();
    }

    public Product(DataUpdateProduct data){
        if (data.productId() == null) throw new RuntimeException("Product id is required");
        if (data.name() != null) this.name = data.name();
        if (data.productType() != null) this.typeProduct = new TypeProduct(data.productType());
        if (data.price() != null) this.price = data.price();
        if (data.rating() != null) this.rating = data.rating();
        if (data.image() != null) this.image = data.image();
        if (data.description() != null) this.description = data.description();
        if (data.quantity() != null) this.quantity = data.quantity();
    }
}
