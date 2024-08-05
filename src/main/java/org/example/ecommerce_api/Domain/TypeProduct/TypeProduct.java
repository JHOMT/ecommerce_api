package org.example.ecommerce_api.Domain.TypeProduct;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_product")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "name", nullable = false)
    private String name;

    public TypeProduct(@NotNull DataUpdateTypeProduct data){
        if (data.id() == null) throw new RuntimeException("Id is required");
        if (data.name() != null) this.name = data.name();
    }

    @Contract(pure = true)
    public TypeProduct(@NotNull DataRegisterTypeProduct data){
        this.name = data.name();
    }

    public TypeProduct(Long typeId) {
        this.typeId = typeId;
    }
}