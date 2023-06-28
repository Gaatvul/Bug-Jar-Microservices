package com.lduff.bugreportingservice.repositories;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;

public class BugReportRepository {

    List<BugReport> bugReports = Arrays.asList(
            new BugReport(1L, "title1", "description1", "status1", "severity1", "priority1", "reporter1",
                    "assignee1", new Date(), new Date()),
            new BugReport(2L, "title2", "description2", "status2", "severity2", "priority2", "reporter2",
                    "assignee2", new Date(), new Date()));

    public List<BugReport> getAllBugReports() {
        return bugReports;
    }

    public void createNewBugReport(BugReportDto bugReport) {
    }

    public void deleteBugReport(long id) {
    }

    public void updateBugReport(BugReport updatedBugReport) {
    }

}
