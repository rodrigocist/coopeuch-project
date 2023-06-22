package com.coopeuch.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@Data

public class TaskDto {
    private Long id;
    private String description;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date creationDate;
    private boolean validity;
}
