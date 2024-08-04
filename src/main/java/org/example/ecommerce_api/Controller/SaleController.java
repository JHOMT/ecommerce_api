package org.example.ecommerce_api.Controller;

import jakarta.validation.Valid;
import org.example.ecommerce_api.Domain.Sales.DataRegisterSale;
import org.example.ecommerce_api.Domain.Sales.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid DataRegisterSale data){
        return ResponseEntity.ok(saleService.save(data));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findByUserId(@PathVariable Long id){
        return ResponseEntity.ok(saleService.findByUserId(id));
    }
}
