package com.example.expensetracker.mapper;


import com.example.expensetracker.dto.AlertEntityDto;
import com.example.expensetracker.entities.AlertEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlertMapper {

    AlertEntityDto toDto(AlertEntity alert);
}
