package com.lduff.bugreportingservice.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.services.BugReportServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("${URI.bug-report-controller}")
public class BugReportController {

    final BugReportServiceImpl bugReportService;

    BugReportController(BugReportServiceImpl bugReportService) {
        this.bugReportService = bugReportService;
    }

    @GetMapping("/")
    public List<BugReport> getAllBugReports() {
        return bugReportService.getAllBugReports();
    }

    @PostMapping("/")
    public void createNewBugReport(@Valid @RequestBody BugReportDto bugReport) {

    }

    @DeleteMapping("/{id}")
    public void deleteBugReport(@PathVariable Long id) {

    }

    @PutMapping("/")
    public void updateBugReport(@Valid @RequestBody BugReport bugReport) {
        
    }

}
