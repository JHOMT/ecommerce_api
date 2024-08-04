package org.example.ecommerce_api.Controller;

import jakarta.validation.Valid;
import org.example.ecommerce_api.Domain.Product.DataRegisterProduct;
import org.example.ecommerce_api.Domain.Product.DataUpdateProduct;
import org.example.ecommerce_api.Domain.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid DataRegisterProduct data){
        return new ResponseEntity<>(productService.save(data), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdateProduct data){
        productService.update(data);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<?> findByTypeProductId(@PathVariable Long id){
        return new ResponseEntity<>(productService.findByTypeProductId(id), HttpStatus.OK);
    }
}
