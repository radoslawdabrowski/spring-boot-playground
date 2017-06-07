package com.example.rest.springbootexample.module.account.converter;

import com.example.rest.springbootexample.module.account.dto.AccountDto;
import com.example.rest.springbootexample.module.account.entity.Account;
import com.example.rest.springbootexample.util.dto.GenericConverter;

/**
 * Created by rdabrowski on 07.06.2017.
 */
public interface AccountConverter extends GenericConverter<Account, AccountDto> {

}
