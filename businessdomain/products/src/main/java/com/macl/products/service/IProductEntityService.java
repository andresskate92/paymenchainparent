package com.macl.products.service;

import com.macl.products.entity.ProductEntity;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:20
 * * @project paymenchainparent
 * * @version 1.0
 **/
public interface IProductEntityService {

    List<ProductEntity> findAll();

    ProductEntity findById(Long id);

    ProductEntity saveOrUpdate(ProductEntity productEntity);

    void delete(Long id);

}
