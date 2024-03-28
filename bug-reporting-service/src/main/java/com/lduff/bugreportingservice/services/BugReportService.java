package com.lduff.bugreportingservice.services;

import java.util.List;

import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;

public interface BugReportService {
    public List<BugReport> getAllBugReports();

    public BugReport getBugReportWithId(Long id);

    public void createNewBugReport(BugReportDto newBugReport);

    public void deleteBugReport(Long id);

    public void updateBugReport(BugReport updatedBugReport);
}