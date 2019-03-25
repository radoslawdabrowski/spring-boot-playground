package com.coig.intraid.account.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "iid_tokens")
@Data
public class TokenEntity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "value")
    private String value;

    @ManyToOne
    private UserEntity user;

}
