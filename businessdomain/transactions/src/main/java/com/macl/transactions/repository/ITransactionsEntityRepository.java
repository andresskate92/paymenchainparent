package com.macl.transactions.repository;

import com.macl.transactions.entity.TransactionsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 8/7/2023 - 12:48
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Repository
public interface ITransactionsEntityRepository extends CrudRepository<TransactionsEntity, Long> {

    @Query("SELECT t FROM TransactionsEntity t WHERE t.accountIban = ?1")
    List<TransactionsEntity> findByAccountIban(String accountIban);
}
