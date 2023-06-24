package com.lduff.bugreportingservice.services;

import java.util.List;

import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.repositories.BugReportRepository;

public class BugReportService {

    private final BugReportRepository bugReportRepository;

    BugReportService(BugReportRepository bugReportRepository) {
        this.bugReportRepository = bugReportRepository;
    }

    public List<BugReport> getAllBugReports() {
        return bugReportRepository.getAllBugReports();
    }

}
