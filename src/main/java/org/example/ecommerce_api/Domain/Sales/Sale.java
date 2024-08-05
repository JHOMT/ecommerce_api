package org.example.ecommerce_api.Domain.Sales;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ecommerce_api.Domain.SaleItem.SaleItem;
import org.example.ecommerce_api.Domain.Users.User;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.time.LocalDateTime;
import java.util.List;

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
    private Double totalPrice;

    @Column(name = "sale_date")
    private LocalDateTime saleDate;

    public Sale(DataRegisterSale data){
        this.user = new User(data.userId());
        this.saleDate = LocalDateTime.now();
    }
}
