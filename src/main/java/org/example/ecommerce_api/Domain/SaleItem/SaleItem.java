package org.example.ecommerce_api.Domain.SaleItem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerce_api.Domain.Product.Product;
import org.example.ecommerce_api.Domain.Sales.Sale;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sale_items")
public class SaleItem {

    @EmbeddedId
    private SaleItemId id;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "item_id")
    private Sale sale;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private BigDecimal price;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class SaleItemId implements Serializable {

        @Column(name = "item_id")
        private Long saleId;

        @Column(name = "product_id")
        private Long productId;
    }

    public SaleItem(@NotNull DataRegisterSaleItem data){
        this.product = new Product(data.productId());
        this.quantity = data.quantity();
    }

    public SaleItem(@NotNull Sale sale, @NotNull DataRegisterSaleItem data) {
        this.sale = sale;
        this.product = new Product(data.productId());
        this.quantity = data.quantity();
        this.price = product.getPrice().multiply(BigDecimal.valueOf(data.quantity()));
        this.id = new SaleItemId(sale.getSaleId(), product.getProductId());
    }
}
