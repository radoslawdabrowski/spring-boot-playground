package com.example.rest.springbootexample.module.account.converter.impl;

import com.example.rest.springbootexample.module.account.converter.AccountConverter;
import com.example.rest.springbootexample.module.account.dto.AccountDto;
import com.example.rest.springbootexample.module.account.entity.Account;

/**
 * Created by rdabrowski on 07.06.2017.
 */
public class AccountConverterImpl implements AccountConverter {

    @Override
    public Account createEntityFromDto(final AccountDto dto) {
        return this.updateEntity(new Account(), dto);
    }

    @Override
    public AccountDto createDtoFromEntity(final Account entity) {
        AccountDto dto = new AccountDto();
        dto.setFistName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }

    @Override
    public Account updateEntity(final Account entity, final AccountDto dto) {
        entity.setFirstName(dto.getFistName());
        entity.setLastName(dto.getLastName());
        return entity;
    }

}
