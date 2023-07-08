package com.macl.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:39
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Entity
@Table
@Data
public class CustomerProducEntity implements Serializable {

    @Id
    @Column(name = "id_customer_product")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCustomerProduct;

    private Long productId;
    @Transient
    private String productName;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerEntity.class)
    @JoinColumn(name = "customer_id", nullable = true)
    private CustomerEntity customerEntity;

}
