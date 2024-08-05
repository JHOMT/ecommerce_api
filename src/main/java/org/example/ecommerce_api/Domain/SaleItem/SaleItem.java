package org.example.ecommerce_api.Domain.SaleItem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerce_api.Domain.Product.Product;
import org.example.ecommerce_api.Domain.Sales.Sale;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale_items")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    public SaleItem(DataRegisterSaleItem data, Sale sale) {
        this.product = new Product(data.productId());
        this.quantity = data.quantity();
        this.sale = sale;
    }
}
