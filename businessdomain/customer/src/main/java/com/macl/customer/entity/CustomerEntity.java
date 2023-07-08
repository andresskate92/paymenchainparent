package com.macl.customer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:28
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Entity
@Table(name = "customer")
@Data
public class CustomerEntity implements Serializable {

    @Id
    @Column(name = "id_customer")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomer;

    private String code;
    private String name;
    private String phone;
    private String iban;
    private String surname;
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerProducEntity> products;

    @Transient
    private List<?> transanctions;
}
