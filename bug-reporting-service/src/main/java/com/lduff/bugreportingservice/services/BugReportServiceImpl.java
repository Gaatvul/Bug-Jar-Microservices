package com.lduff.bugreportingservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.repositories.BugReportRepository;

@Service
public class BugReportServiceImpl implements BugReportService {

    @Autowired
    BugReportRepository bugReportRepository;

    @Override
    public List<BugReport> getAllBugReports() {
        return bugReportRepository.getAllBugReports();
    }

    @Override
    public void createNewBugReport(BugReportDto newBugReport){
        bugReportRepository.createNewBugReport(newBugReport);
    }

    @Override
    public void deleteBugReport(Long id) {
        bugReportRepository.deleteBugReport(id);
    }

}
