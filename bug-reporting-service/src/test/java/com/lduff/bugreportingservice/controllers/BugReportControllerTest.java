package com.lduff.bugreportingservice.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lduff.bugreportingservice.dtos.BugReportDto;
import com.lduff.bugreportingservice.models.BugReport;
import com.lduff.bugreportingservice.services.BugReportService;

@WebMvcTest(controllers = BugReportController.class)
public class BugReportControllerTest {

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private BugReportService bugReportService;

    @Autowired
    private MockMvc mockMvc;

    private List<BugReport> bugReports;
    private List<BugReportDto> bugReportDtos;

    @Value("${URI.bug-report-controller}")
    private String BUG_REPORT_CONTROLLER_URI;

    @Test
    void getAllBugReportsShouldReturnListOfBugReports() throws Exception {
        bugReports = Arrays.asList(
                new BugReport(1L, "title1", "description1", "status1", "severity1", "priority1", "reporter1",
                        "assignee1", new Date(), new Date()),
                new BugReport(2L, "title2", "description2", "status2", "severity2", "priority2", "reporter2",
                        "assignee2", new Date(), new Date()));

        when(bugReportService.getAllBugReports()).thenReturn(bugReports);

        String bugReportsAsJson = mapper.writeValueAsString(bugReports);

        mockMvc.perform(get(BUG_REPORT_CONTROLLER_URI + "/")).andExpectAll(status().isOk(),
                content().json(bugReportsAsJson, false));
    }

    @Test
    void createNewBugReportShouldAddToListOfBugReports() throws Exception {

        String bugReportToAddAsJson = mapper.writeValueAsString(new BugReportDto("title3", "description3",
                "status3", "severity3", "priority3", "reporter3", "assignee3", new Date(), new Date()));

        mockMvc.perform(post(BUG_REPORT_CONTROLLER_URI + "/").contentType(MediaType.APPLICATION_JSON)
                .content(bugReportToAddAsJson)).andExpect(status().isOk());

    }

    @RepeatedTest(7)
    void whenBugReportIsInvalid_ShouldReturnStatus400(RepetitionInfo repetitionInfo) throws Exception {

        BugReportDto nullTitleBugReport = new BugReportDto(null, "description1", "status1", "severity1", "priority1",
                "reporter1", "assignee1", new Date(), new Date());
        BugReportDto blankTitleBugReport = new BugReportDto( "", "description1", "status1", "severity1", "priority1",
                "reporter1", "assignee1", new Date(), new Date());
        BugReportDto nullDescriptionBugReport = new BugReportDto( "title", null, "status1", "severity1", "priority1",
                "reporter1", "assignee1", new Date(), new Date());
        BugReportDto blankDescriptionBugReport = new BugReportDto("title", "", "status1", "severity1", "priority1",
                "reporter1", "assignee1", new Date(), new Date());
        BugReportDto nullReporterBugReport = new BugReportDto("title", "description1", "status1", "severity1", "priority1",
                null, "assignee1", new Date(), new Date());
        BugReportDto blankReporterBugReport = new BugReportDto("", "description1", "status1", "severity1", "priority1",
                "", "assignee1", new Date(), new Date());
        BugReportDto nullReportedOnBugReport = new BugReportDto("", "description1", "status1", "severity1", "priority1",
                "", "assignee1", null, new Date());

        bugReportDtos = Arrays.asList(nullTitleBugReport, blankTitleBugReport, nullDescriptionBugReport,
                blankDescriptionBugReport, nullReporterBugReport, blankReporterBugReport, nullReportedOnBugReport);

        String invalidBugReportAsJson = mapper
                .writeValueAsString(bugReportDtos.get(repetitionInfo.getCurrentRepetition() - 1));

        mockMvc.perform(post(BUG_REPORT_CONTROLLER_URI + "/").contentType(MediaType.APPLICATION_JSON)
                .content(invalidBugReportAsJson)).andExpect(status().isBadRequest());

    }
}