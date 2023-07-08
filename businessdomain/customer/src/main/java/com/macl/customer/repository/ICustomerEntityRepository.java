package com.macl.customer.repository;

import com.macl.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:28
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Repository
public interface ICustomerEntityRepository extends CrudRepository<CustomerEntity, Long> {

    @Query("SELECT c FROM CustomerEntity c WHERE c.code=?1")
    CustomerEntity findByCode(String code);
    @Query("SELECT c FROM CustomerEntity c WHERE c.iban=?1")
    CustomerEntity findByIban(String iban);
}
