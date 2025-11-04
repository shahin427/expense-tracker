package com.example.expensetracker.scheduler;

import com.example.expensetracker.entities.CategoryEntity;
import com.example.expensetracker.entities.MonthlyReportEntity;
import com.example.expensetracker.repositories.ExpenseRepository;
import com.example.expensetracker.services.CategoryService;
import com.example.expensetracker.services.MonthlyReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class ReportJob {
    private final CategoryService categoryService;
    private final ExpenseRepository expenseRepository;
    private final MonthlyReportService monthlyReportService;

    //    @GetMapping("/run-report")
    @Scheduled(cron = "0 0 1 1 * ?") // First day of every month 1 AM
    public void generateMonthlyReport() {
        YearMonth previousMonth = YearMonth.now().minusMonths(1);
        LocalDateTime startOfTheMonth = previousMonth.atDay(1).atStartOfDay();
        LocalDateTime endOfTheMonth = startOfTheMonth.plusMonths(1).toLocalDate().atStartOfDay();

        log.info("Monthly Report Generated at {} ", LocalDateTime.now());
        List<CategoryEntity> categories = categoryService.getAllCategories();
        for (CategoryEntity category : categories) {
            try {
                log.info("Category {} is being processed", category.getName());
                Long totalSpentAmount = expenseRepository.totalSpentForCategoryBetween(category, startOfTheMonth, endOfTheMonth);
                MonthlyReportEntity monthlyReportEntity = MonthlyReportEntity.builder()
                        .reportTime(LocalDate.from(previousMonth))
                        .category(category)
                        .totalSpent(totalSpentAmount)
                        .monthlyLimit(category.getAlert() != null ? category.getAlert().getMonthlyLimit() : 0)
                        .build();
                monthlyReportService.saveMonthlyReport(monthlyReportEntity);
            } catch (Exception ex) {
                log.warn("Error handling category {}: {}", category.getName(), ex.getMessage(), ex);                // Do Nothing
            }
        }
        log.info("Monthly Report Finished at {}", LocalDateTime.now());
    }
}
