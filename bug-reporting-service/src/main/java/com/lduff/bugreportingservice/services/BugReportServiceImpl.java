package com.lduff.bugreportingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.repositories.BugReportRepository;

public class BugReportServiceImpl implements BugReportService {

    @Autowired
    BugReportRepository bugReportRepository;

    @Override
    public List<BugReport> getAllBugReports() {
        return bugReportRepository.getAllBugReports();
    }

}
