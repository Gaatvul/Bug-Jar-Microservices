package com.lduff.bugreportingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.services.BugReportService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("${URI.bug-report-controller}")
public class BugReportController {

    @Autowired
    BugReportService bugReportService;

    @GetMapping("/")
    public List<BugReport> getAllBugReports() {
        return bugReportService.getAllBugReports();
    }

    @PostMapping("/")
    public void createNewBugReport(@Valid @RequestBody BugReportDto bugReport) {

    }

}
