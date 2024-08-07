package org.example.ecommerce_api.Domain.Product;

import jakarta.transaction.Transactional;
import org.example.ecommerce_api.Domain.Product.Validations.ValidProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    List<ValidProducts> validProducts;

    @Transactional
    public DataListProduct save(DataRegisterProduct data) {
        validProducts.forEach(valid -> valid.validateRegister(data));

        Product product = new Product(data);
        productRepository.save(product);

        return new DataListProduct(product);
    }

    @Transactional
    public boolean update(DataUpdateProduct data) {
        validProducts.forEach(valid -> valid.validateUpdate(data));
        Product product = productRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.update(data);
        productRepository.save(product);
        return true;
    }

    public List<DataListProduct> findAll() {
        return productRepository.findAll().stream().map(DataListProduct::new).toList();
    }

    public DataListProduct findById(Long id) {
        return new DataListProduct(productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found")));
    }

    public List<DataListProduct> findByName(String name) {
        List<Product> products = productRepository.findByName(name);
        return products.stream().map(DataListProduct::new).toList();
    }

    public List<DataListProduct> findByTypeProductId(Long id) {
        return productRepository.findByTypeProductId(id).stream().map(DataListProduct::new).toList();
    }

    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(product.getProductId());
    }
}