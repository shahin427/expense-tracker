package com.example.expensetracker.mappers;


import com.example.expensetracker.dtos.response.AlertEntityDto;
import com.example.expensetracker.entities.AlertEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface AlertMapper {

    AlertEntityDto toDto(AlertEntity alert);
}
