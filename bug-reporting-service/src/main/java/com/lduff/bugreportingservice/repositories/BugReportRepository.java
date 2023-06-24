package com.lduff.bugreportingservice.repositories;

import java.util.Arrays;
import java.util.List;

import com.lduff.bugreportingservice.models.BugReport;

public class BugReportRepository {

    List<BugReport> bugReports = Arrays.asList(
            new BugReport("title1", "description1", null, null, null, null, null, null, null),
            new BugReport("title2", "description2", null, null, null, null, null, null, null));

    public List<BugReport> getAllBugReports() {
        return bugReports;
    }

}
