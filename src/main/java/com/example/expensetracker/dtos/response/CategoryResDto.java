package com.example.expensetracker.dtos.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResDto {

    private Long id;

    private String name;

    private AlertEntityDto alert;

    public CategoryResDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
