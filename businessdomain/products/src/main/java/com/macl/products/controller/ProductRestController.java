package com.macl.products.controller;

import com.macl.products.entity.ProductEntity;
import com.macl.products.service.IProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:19
 * * @project paymenchainparent
 * * @version 1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    IProductEntityService iProductEntityService;

    @GetMapping
    public List<ProductEntity> findAll() {
        return iProductEntityService.findAll();
    }

    @GetMapping("/find-by-id")
    public ProductEntity findById(@RequestParam("id") Long id) {
        return iProductEntityService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdate(@RequestBody ProductEntity customerEntity) {
        return ResponseEntity.ok(iProductEntityService.saveOrUpdate(customerEntity));
    }

}
