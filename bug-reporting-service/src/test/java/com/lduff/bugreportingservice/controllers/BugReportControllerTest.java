package com.lduff.bugreportingservice.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Test
    void getAllBugReportsShouldReturnListOfBugReports() throws Exception {

        List<BugReport> bugReports = Arrays.asList(
                new BugReport("title1", "description1", null, null, null, null, null, null, null),
                new BugReport("title2", "description2", null, null, null, null, null, null, null));

        when(bugReportService.getAllBugReports()).thenReturn(bugReports);

        String bugReportsAsJson = mapper.writeValueAsString(bugReports);

        mockMvc.perform(get("/bug-reports/")).andExpectAll(status().isOk(), content().json(bugReportsAsJson, false));
    }
}
