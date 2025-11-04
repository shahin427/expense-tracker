package com.example.expensetracker.scheduler;

import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReportJob {
    private final CategoryService categoryService;

    @Async
    @Scheduled(cron = "0 0 1 1 * ?") // 1st of every month 1 AM
    public void generateMonthlyReport() {
        YearMonth yearMonth = YearMonth.now().minusMonths(1);
        LocalDateTime startOfTheMonth = yearMonth.atDay(1).atStartOfDay();
        LocalDateTime endOfTheMonth = startOfTheMonth.plusMonths(1).toLocalDate().atStartOfDay();

        List<CategoryEntity> categories = categoryService.getAllCategories();

        for (CategoryEntity category : categories) {
            Long spentAmount =
        }

    }
}
