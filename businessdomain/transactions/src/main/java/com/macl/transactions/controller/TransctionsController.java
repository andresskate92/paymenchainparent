package com.macl.transactions.controller;

import com.macl.transactions.entity.TransactionsEntity;
import com.macl.transactions.service.ITransactionsEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * * @author ${milton.cabrera} on 8/7/2023 - 12:28
 * * @project paymenchainparent
 * * @version 1.0
 **/
@RestController
@RequestMapping("/transactions")
public class TransctionsController {

    @Autowired
    ITransactionsEntityService iTransactionsEntityService;


    @GetMapping
    public List<TransactionsEntity> findAll() {
        return iTransactionsEntityService.findAll();
    }

    @GetMapping("/find-by-id")
    public TransactionsEntity findById(@RequestParam("id") Long id) {
        return iTransactionsEntityService.findById(id);
    }

    @GetMapping("/customer")
    public List<TransactionsEntity> findByAccountIban(@RequestParam("accountIban") String accountIban) {
        return iTransactionsEntityService.findByAccountIban(accountIban);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdate(@RequestBody TransactionsEntity transactionsEntity) {
        return new ResponseEntity<>(iTransactionsEntityService.saveOrUpdate(transactionsEntity), HttpStatus.OK);
    }

}
