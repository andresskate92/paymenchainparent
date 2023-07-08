package com.macl.products.repository;

import com.macl.products.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:18
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Repository
public interface IProductEntityRepository extends CrudRepository<ProductEntity, Long> {
}
