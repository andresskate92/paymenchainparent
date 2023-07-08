package com.macl.products.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * * @author ${milton.cabrera} on 1/7/2023 - 0:16
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Entity
@Table(name = "product")
@Data
public class ProductEntity implements Serializable {

    @Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduct;
    private String code;
    private String name;
}
