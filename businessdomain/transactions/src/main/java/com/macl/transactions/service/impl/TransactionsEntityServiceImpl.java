package com.macl.transactions.service.impl;

import com.macl.transactions.entity.TransactionsEntity;
import com.macl.transactions.repository.ITransactionsEntityRepository;
import com.macl.transactions.service.ITransactionsEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 8/7/2023 - 12:49
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Service
@Slf4j
public class TransactionsEntityServiceImpl implements ITransactionsEntityService {

    @Autowired
    ITransactionsEntityRepository iTransactionsEntityRepository;

    @Override
    public TransactionsEntity findById(Long id) {
        return iTransactionsEntityRepository.findById(id).orElseGet(TransactionsEntity::new);
    }

    @Override
    public List<TransactionsEntity> findAll() {
        return (List<TransactionsEntity>) iTransactionsEntityRepository.findAll();
    }

    @Override
    public TransactionsEntity saveOrUpdate(TransactionsEntity transactionsEntity) {
        return iTransactionsEntityRepository.save(transactionsEntity);
    }

    @Override
    public List<TransactionsEntity> findByAccountIban(String accountIban) {
        return iTransactionsEntityRepository.findByAccountIban(accountIban);
    }
}
