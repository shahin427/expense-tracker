package com.example.expensetracker.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExpenseAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        if (userName.equals("anonymousUser")) {
            return Optional.of("system");
        }
        return Optional.of(userName);
    }
}
