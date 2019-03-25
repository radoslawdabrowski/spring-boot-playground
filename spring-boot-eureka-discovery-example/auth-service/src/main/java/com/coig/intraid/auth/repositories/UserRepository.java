package com.coig.intraid.auth.repositories;

import com.coig.intraid.auth.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends CrudRepository<UserEntity, Long> {

    UserEntity findByLogin(@Param(value = "login") String login);

}
