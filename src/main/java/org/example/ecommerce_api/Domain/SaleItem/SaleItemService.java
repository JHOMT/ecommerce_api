package org.example.ecommerce_api.Domain.SaleItem;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemService {
    @Autowired
    private SaleItemRepository saleItemRepository;


    @Transactional
    public SaleItem save(DataRegisterSaleItem saleItem) {
        return saleItemRepository.save(new SaleItem(saleItem));
    }

    public SaleItem update(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }

    public void delete(Long id) {
        saleItemRepository.deleteById(id);
    }

    @Transactional
    public SaleItem findById(Long id) {
        return saleItemRepository.findById(id).orElse(null);
    }
}
