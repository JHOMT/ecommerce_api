package org.example.ecommerce_api.Controller;

import jakarta.validation.Valid;
import org.example.ecommerce_api.Domain.TypeProduct.DataRegisterTypeProduct;
import org.example.ecommerce_api.Domain.TypeProduct.DataUpdateTypeProduct;
import org.example.ecommerce_api.Domain.TypeProduct.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/typeProduct")
public class TypeProductController {
    @Autowired
    private TypeProductService typeProductService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid DataRegisterTypeProduct data){
        return new ResponseEntity<>(typeProductService.save(data), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(typeProductService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findByTypeProductId(@PathVariable Long id){
        return new ResponseEntity<>(typeProductService.findByTypeProductId(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdateTypeProduct data){
        return new ResponseEntity<>(typeProductService.update(data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        typeProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> findByTypeProductName(@PathVariable String name){
        return new ResponseEntity<>(typeProductService.findByTypeProductName(name), HttpStatus.OK);
    }
}
