package org.example.ecommerce_api.Domain.Sales;

import jakarta.transaction.Transactional;
import org.example.ecommerce_api.Domain.Product.Product;
import org.example.ecommerce_api.Domain.Product.ProductRepository;
import org.example.ecommerce_api.Domain.SaleItem.DataRegisterSaleItem;
import org.example.ecommerce_api.Domain.SaleItem.SaleItem;
import org.example.ecommerce_api.Domain.SaleItem.SaleItemRepository;
import org.example.ecommerce_api.Domain.Sales.Validations.ValidSale;
import org.example.ecommerce_api.Domain.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private List<ValidSale> validations;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SaleItemRepository saleItemRepository;

    @Transactional
    public DataListSale save(DataRegisterSale data) {
        validations.forEach(validation -> validation.validateRegister(data));

        var user = userRepository.findById(data.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Sale sale = new Sale();
        sale.setUser(user);
        sale.setSaleDate(LocalDateTime.now());

        BigDecimal totalPrice = BigDecimal.ZERO;
        for (DataRegisterSaleItem item : data.saleItems()) {
            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found"));

            BigDecimal price = product.getPrice().multiply(BigDecimal.valueOf(item.quantity()));
            totalPrice = totalPrice.add(price);

            SaleItem saleItem = new SaleItem();
            saleItem.setSale(sale);
            saleItem.setProduct(product);
            saleItem.setQuantity(item.quantity());
            saleItem.setPrice(price);
            saleItemRepository.save(saleItem);

            product.setQuantity(product.getQuantity() - item.quantity());
            productRepository.save(product);
        }

        sale.setTotalPrice(totalPrice);
        saleRepository.save(sale);

        return new DataListSale(sale);
    }

    public List<DataListSale> findAll() {
        return saleRepository.findAll().stream()
                .map(DataListSale::new)
                .collect(Collectors.toList());
    }

    public List<DataListSale> findByUserId(Long userId) {
        return saleRepository.findByUserId(userId).stream()
                .map(DataListSale::new)
                .collect(Collectors.toList());
    }
}

