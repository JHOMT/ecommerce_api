package org.example.ecommerce_api.Domain.Sales;

import jakarta.transaction.Transactional;
import org.example.ecommerce_api.Domain.Product.Product;
import org.example.ecommerce_api.Domain.Product.ProductRepository;
import org.example.ecommerce_api.Domain.SaleItem.*;
import org.example.ecommerce_api.Domain.Sales.Validations.ValidSale;
import org.example.ecommerce_api.Domain.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        sale = saleRepository.save(sale);

        double totalPrice = 0.0;
        for (DataRegisterSaleItem item : data.saleItems()) {
            Product product = productRepository.findById(item.productId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            System.out.println(product);

            double priceItemSale = product.getPrice()* item.quantity();
            SaleItem saleItem = new SaleItem(item, sale);
            saleItem.setPrice(priceItemSale);
            saleItemRepository.save(saleItem);

            totalPrice += priceItemSale;

            product.setQuantity(product.getQuantity() - item.quantity());
            productRepository.save(product);
            System.out.println("Total Price: " + totalPrice);
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

    public List<DataResponseSale> findByUserId(Long userId) {
        List<DataResponseSale> response = saleRepository.findByUserId(userId).stream()
                .map(sale -> {
                    List<DataListSaleItem> saleItems = saleItemRepository.findBySaleSaleId(sale.getSaleId()).stream()
                            .map(DataListSaleItem::new)
                            .toList();
                    return new DataResponseSale(new DataListSale(sale), saleItems);
                })
                .toList();

        return response;
    }
}

