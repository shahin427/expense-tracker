package com.example.expensetracker.mappers;


import com.example.expensetracker.dtos.AlertEntityDto;
import com.example.expensetracker.entities.AlertEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlertMapper {

    AlertEntityDto toDto(AlertEntity alert);
}
