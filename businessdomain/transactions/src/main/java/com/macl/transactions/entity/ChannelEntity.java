package com.macl.transactions.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * * @author ${milton.cabrera} on 8/7/2023 - 12:38
 * * @project paymenchainparent
 * * @version 1.0
 **/
@Entity
@Data
@Table(name = "channel")
public class ChannelEntity implements Serializable {

    @Id
    @Column(name = "id_channel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChannel;

    private String descriptionChannel;


}
