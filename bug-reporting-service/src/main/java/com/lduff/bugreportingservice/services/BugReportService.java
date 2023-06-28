package com.lduff.bugreportingservice.services;

import java.util.List;

import com.lduff.bugreportingservice.models.BugReport;

public interface BugReportService {
    public List<BugReport> getAllBugReports();
}