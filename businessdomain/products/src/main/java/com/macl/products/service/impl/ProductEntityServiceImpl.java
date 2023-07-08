package com.macl.products.service.impl;

import com.macl.products.entity.ProductEntity;
import com.macl.products.repository.IProductEntityRepository;
import com.macl.products.service.IProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:20
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Service
public class ProductEntityServiceImpl implements IProductEntityService {

    @Autowired
    IProductEntityRepository iProductEntityRepository;

    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) iProductEntityRepository.findAll();
    }

    @Override
    public ProductEntity findById(Long id) {
        return iProductEntityRepository.findById(id).orElseGet(ProductEntity::new);
    }

    @Override
    public ProductEntity saveOrUpdate(ProductEntity productEntity) {
        return iProductEntityRepository.save(productEntity);
    }

    @Override
    public void delete(Long id) {
        iProductEntityRepository.deleteById(id);
    }
}
