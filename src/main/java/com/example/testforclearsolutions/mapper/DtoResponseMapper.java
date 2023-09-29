package com.example.testforclearsolutions.mapper;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}
