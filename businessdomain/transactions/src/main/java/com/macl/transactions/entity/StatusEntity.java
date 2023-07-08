package com.macl.transactions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * * @author ${milton.cabrera} on 8/7/2023 - 12:35
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Data
@Entity
@Table(name = "status")
public class StatusEntity implements Serializable {

    @Id
    @Column(name = "id_status")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStatus;
    private String codeStatus;
    private String descriptionStatus;


}
