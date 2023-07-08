package com.macl.transactions.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * * @author ${milton.cabrera} on 8/7/2023 - 12:29
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Entity
@Data
@Table(name = "transaction")
public class TransactionsEntity implements Serializable {

    @Id
    @Column(name = "id_transaction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;

    private String reference;
    private String accountIban;
    private LocalDateTime date;
    private Double amount;
    private Double fee;
    private String description;
    private String status;
    private String channel;


    @PrePersist
    private void loadDateTme() {
        this.date = LocalDateTime.now();
    }
}




