package com.example.Task6.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Meeting
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T15:19:30.908617591+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public class Meeting {

  private Integer meetingId;

  private String subject;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  public Meeting meetingId(Integer meetingId) {
    this.meetingId = meetingId;
    return this;
  }

  /**
   * Get meetingId
   * minimum: 0
   * maximum: 999
   * @return meetingId
   */
  @Min(0) @Max(999) 
  @Schema(name = "meetingId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("meetingId")
  public Integer getMeetingId() {
    return meetingId;
  }

  public void setMeetingId(Integer meetingId) {
    this.meetingId = meetingId;
  }

  public Meeting subject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * The subject of the meeting
   * @return subject
   */
  
  @Schema(name = "subject", description = "The subject of the meeting", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("subject")
  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public Meeting date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * The date of the meeting
   * @return date
   */
  @Valid 
  @Schema(name = "date", description = "The date of the meeting", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Meeting meeting = (Meeting) o;
    return Objects.equals(this.meetingId, meeting.meetingId) &&
        Objects.equals(this.subject, meeting.subject) &&
        Objects.equals(this.date, meeting.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meetingId, subject, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Meeting {\n");
    sb.append("    meetingId: ").append(toIndentedString(meetingId)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

