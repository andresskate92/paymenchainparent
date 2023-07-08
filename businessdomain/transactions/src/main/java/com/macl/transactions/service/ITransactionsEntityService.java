package com.macl.transactions.service;

import com.macl.transactions.entity.TransactionsEntity;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 8/7/2023 - 12:48
 * * @project paymenchainparent
 * * @version 1.0
 **/
public interface ITransactionsEntityService {

    TransactionsEntity findById(Long id);

    List<TransactionsEntity> findAll();

    TransactionsEntity saveOrUpdate(TransactionsEntity transactionsEntity);

    List<TransactionsEntity> findByAccountIban(String accountIban);




}
