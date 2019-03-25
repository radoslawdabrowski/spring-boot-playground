package com.coig.intraid.auth.repositories;

import com.coig.intraid.auth.entities.JwtTokenEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtTokenRepository extends CrudRepository<JwtTokenEntity, Long> {

    JwtTokenEntity findByValue(@Param(value = "value") String value);

    void deleteByValue(@Param(value = "value") String value);

}
