package com.example.rest.springbootexample.util.dto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by rdabrowski on 06.06.2017.
 */
public interface GenericConverter<E, D> {

    E createEntityFromDto(D dto);

    D createDtoFromEntity(E entity);

    E updateEntity(E entity, D dto);

    default List<D> createFromEntities(final List<E> input) {
        return input.stream().map(this::createDtoFromEntity).collect(Collectors.toList());
    }

    default List<E> createFromDtos(final List<D> input) {
        return input.stream().map(this::createEntityFromDto).collect(Collectors.toList());
    }

}