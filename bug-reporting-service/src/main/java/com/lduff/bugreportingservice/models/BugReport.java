package com.lduff.bugreportingservice.models;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BugReport {

    @NotEmpty(message = "Title cannot be blank.")
    private String title;

    @NotEmpty(message = "Description cannot be blank.")
    private String description;

    private String status;

    private String severity;

    private String priority;

    @NotEmpty(message = "Reporter cannot be blank.")
    private String reporter;

    private String assignee;

    @NotNull(message = "Reported On must not be blank.")
    private Date reportedOn;

    private Date lastUpdated;

}
