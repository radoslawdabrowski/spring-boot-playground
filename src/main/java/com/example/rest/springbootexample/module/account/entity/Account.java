package com.example.rest.springbootexample.module.account.entity;

import lombok.Data;

/**
 * Created by rdabrowski on 07.06.2017.
 */
@Data
public class Account {

   private Long id;
   private String firstName;
   private String lastName;
   private Integer age;

}
