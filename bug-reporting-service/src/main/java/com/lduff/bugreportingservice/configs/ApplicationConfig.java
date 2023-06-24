package com.lduff.bugreportingservice.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lduff.bugreportingservice.repositories.BugReportRepository;
import com.lduff.bugreportingservice.services.BugReportService;

@ComponentScan("com.lduff.bugreportingservice")
@Configuration
public class ApplicationConfig {

    @Bean(name = "bugReportService")
    public BugReportService createBugReportService() {
        return new BugReportService();
    }

    @Bean(name = "bugReportRepository")
    public BugReportRepository createBugReportRepository() {
        return new BugReportRepository();
    }
}
