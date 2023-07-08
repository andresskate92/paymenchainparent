package com.macl.customer.service;

import com.macl.customer.entity.CustomerEntity;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:28
 * * @project paymenchainparent
 * * @version 1.0
 **/
public interface ICustomerEntityService {

    List<CustomerEntity> findAll();

    CustomerEntity findById(Long id);

    CustomerEntity saveOrUpdate(CustomerEntity customerEntity);

    void delete(Long id);

    CustomerEntity findByCode(String code);

    CustomerEntity findByIban(String iban);

}
