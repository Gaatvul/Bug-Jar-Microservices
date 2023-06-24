package com.lduff.bugreportingservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.services.BugReportService;

@RestController
@RequestMapping("/bug-reports")
public class BugReportController {

    private final BugReportService bugReportService;

    BugReportController(BugReportService bugReportService) {
        this.bugReportService = bugReportService;
    }

    @GetMapping("/")
    public List<BugReport> getAllBugReports() {
        return bugReportService.getAllBugReports();
    }
}
