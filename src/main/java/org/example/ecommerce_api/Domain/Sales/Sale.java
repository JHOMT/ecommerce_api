package org.example.ecommerce_api.Domain.Sales;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerce_api.Domain.SaleItem.SaleItem;
import org.example.ecommerce_api.Domain.Users.User;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_id")
    private Long saleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "sale_date", nullable = false, updatable = false, insertable = false)
    @Generated(GenerationTime.INSERT)
    private LocalDateTime saleDate;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> saleItems;

    public Sale(@NotNull DataRegisterSale data) {
        this.user = new User(data.userId());
        this.saleItems = data.saleItems().stream()
                .map(item -> new SaleItem(this, item))
                .collect(Collectors.toList());
    }
}
