package com.lduff.bugreportingservice.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BugReport {

    private String title;
    private String description;
    private String status;
    private String severity;
    private String priority;
    private String reporter;
    private String assignee;
    private Date reportedOn;
    private Date lastUpdated;

}
