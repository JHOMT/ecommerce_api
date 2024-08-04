package org.example.ecommerce_api.Domain.TypeProduct;

import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeProductService {
    @Autowired
    private TypeProductRepository typeProductRepository;

    public DataListTypeProduct save(DataRegisterTypeProduct data) {
        TypeProduct typeProduct = new TypeProduct(data);
        typeProductRepository.save(typeProduct);
        return new DataListTypeProduct(typeProduct);
    }

    public DataListTypeProduct update(@NotNull DataUpdateTypeProduct data) {
        if (!typeProductRepository.existsById(data.id())) {
            throw new RuntimeException("TypeProduct not found");
        }

        TypeProduct typeProduct = new TypeProduct(data);

        typeProductRepository.save(typeProduct);
        return new DataListTypeProduct(typeProduct);
    }

    @Transactional
    public void delete(Long id) {
        if (!typeProductRepository.existsById(id)) {
            throw new RuntimeException("TypeProduct not found");
        }
        typeProductRepository.deleteById(id);
    }

    public DataListTypeProduct findByTypeProductId(Long id) {
        TypeProduct typeProduct = typeProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeProduct not found"));
        return new DataListTypeProduct(typeProduct);
    }

    public DataListTypeProduct findByTypeProductName(String name) {
        TypeProduct typeProduct = typeProductRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("TypeProduct not found"));
        return new DataListTypeProduct(typeProduct);
    }

    public List<DataListTypeProduct> findAll() {
        List<TypeProduct> typeProducts = typeProductRepository.findAll();
        return typeProducts.stream().map(DataListTypeProduct::new).collect(Collectors.toList());
    }

}
