package com.coig.intraid.account.repositories;

import com.coig.intraid.account.entities.TokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends CrudRepository<TokenEntity, Long> {

    TokenEntity findByValue(@Param(value = "value") String value);

}
