package com.macl.customer.service.impl;

import com.macl.customer.entity.CustomerEntity;
import com.macl.customer.repository.ICustomerEntityRepository;
import com.macl.customer.service.ICustomerEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 11:48
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Service
public class CustomerEntityServiceImpl implements ICustomerEntityService {

    @Autowired
    ICustomerEntityRepository iCustomerEntityRepository;

    @Override
    public List<CustomerEntity> findAll() {
        return (List<CustomerEntity>) iCustomerEntityRepository.findAll();
    }

    @Override
    public CustomerEntity findById(Long id) {
        return iCustomerEntityRepository.findById(id).orElseGet(CustomerEntity::new);
    }

    @Override
    public CustomerEntity saveOrUpdate(CustomerEntity customerEntity) {
        return iCustomerEntityRepository.save(customerEntity);
    }

    @Override
    public void delete(Long id) {
        iCustomerEntityRepository.deleteById(id);
    }

    @Override
    public CustomerEntity findByCode(String code) {
        return iCustomerEntityRepository.findByCode(code);
    }

    @Override
    public CustomerEntity findByIban(String iban) {
        return iCustomerEntityRepository.findByIban(iban);
    }
}
