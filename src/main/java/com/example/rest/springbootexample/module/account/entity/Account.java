package com.example.rest.springbootexample.module.account.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by rdabrowski on 07.06.2017.
 */
public class Account {

   private @Setter @Getter Long id;
   private @Setter @Getter String firstName;
   private @Setter @Getter String lastName;
   private @Setter @Getter Integer age;

}
