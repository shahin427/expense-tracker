package com.example.expensetracker.mappers;

import com.example.expensetracker.dtos.response.MonthlyReportResDto;
import com.example.expensetracker.entities.MonthlyReportEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface MonthlyReportMapper {

    MonthlyReportResDto toDto(MonthlyReportEntity monthlyReport);

}
