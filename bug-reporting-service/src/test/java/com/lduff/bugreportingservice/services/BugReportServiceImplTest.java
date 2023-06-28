package com.lduff.bugreportingservice.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.repositories.BugReportRepository;

@SpringBootTest
public class BugReportServiceImplTest {

    @Autowired
    private BugReportServiceImpl bugReportService;

    @MockBean
    private BugReportRepository bugReportRepository;

    private List<BugReport> bugReports;

    @BeforeEach
    void setup() {
        bugReports = Arrays.asList(
                new BugReport(1L, "title", "description1", "status1", "severity1", "priority1",
                        "reporter1", "assignee1", new Date(), new Date()),
                new BugReport(2L, "", "description1", "status1", "severity1", "priority1",
                        "reporter1", "assignee1", new Date(), new Date()));
    }

    @Test
    void getAllBugReports_ShouldReturnAListOfBugReports() throws Exception {

        when(bugReportRepository.getAllBugReports()).thenReturn(bugReports);

        assertThat(bugReportService.getAllBugReports()).isEqualTo(bugReports);
    }

    @Test
    void createNewBugReport_ShouldAddToList() throws Exception {

        BugReportDto bugReportToCreate = new BugReportDto("new bug report", "desc", "status", "severity", "priority",
                "reporter", "assignee", new Date(), new Date());

        bugReportService.createNewBugReport(bugReportToCreate);

        verify(bugReportRepository).createNewBugReport(bugReportToCreate);
    }
}
