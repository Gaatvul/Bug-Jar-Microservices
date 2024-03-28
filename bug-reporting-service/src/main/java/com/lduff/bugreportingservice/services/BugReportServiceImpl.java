package com.lduff.bugreportingservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.repositories.BugReportRepositoryImpl;

@Service
public class BugReportServiceImpl implements BugReportService {

    final BugReportRepositoryImpl bugReportRepositoryImpl;

    BugReportServiceImpl(BugReportRepositoryImpl bugReportRepositoryImpl) {
        this.bugReportRepositoryImpl = bugReportRepositoryImpl;
    }

    @Override
    public List<BugReport> getAllBugReports() {
        return bugReportRepositoryImpl.getAllBugReports();
    }

    @Override
    public BugReport getBugReportWithId(Long id) {
        return bugReportRepositoryImpl.getBugReportWithId(id);
    }

    @Override
    public void createNewBugReport(BugReportDto newBugReport){
        //bugReportRepository.createNewBugReport(newBugReport);
    }

    @Override
    public void deleteBugReport(Long id) {
        //bugReportRepository.deleteBugReport(id);
    }

    @Override
    public void updateBugReport(BugReport updatedBugReport) {
        //bugReportRepository.updateBugReport(updatedBugReport);
    }

}
