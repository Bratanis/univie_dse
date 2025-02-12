package com.example.Task6.model;

import java.net.URI;
import java.util.Objects;
import com.example.Task6.model.EAvailability;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ProposedMeeting
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-18T19:11:04.541998563+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public class ProposedMeeting {

  private Integer meetingId;

  private String subject;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  @Valid
  private Map<String, EAvailability> participants = new HashMap<>();

  public ProposedMeeting meetingId(Integer meetingId) {
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

  public ProposedMeeting subject(String subject) {
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

  public ProposedMeeting date(LocalDate date) {
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

  public ProposedMeeting participants(Map<String, EAvailability> participants) {
    this.participants = participants;
    return this;
  }

  public ProposedMeeting putParticipantsItem(String key, EAvailability participantsItem) {
    if (this.participants == null) {
      this.participants = new HashMap<>();
    }
    this.participants.put(key, participantsItem);
    return this;
  }

  /**
   * A map of participant names to their availability.
   * @return participants
   */
  @Valid 
  @Schema(name = "participants", description = "A map of participant names to their availability.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("participants")
  public Map<String, EAvailability> getParticipants() {
    return participants;
  }

  public void setParticipants(Map<String, EAvailability> participants) {
    this.participants = participants;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProposedMeeting proposedMeeting = (ProposedMeeting) o;
    return Objects.equals(this.meetingId, proposedMeeting.meetingId) &&
        Objects.equals(this.subject, proposedMeeting.subject) &&
        Objects.equals(this.date, proposedMeeting.date) &&
        Objects.equals(this.participants, proposedMeeting.participants);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meetingId, subject, date, participants);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProposedMeeting {\n");
    sb.append("    meetingId: ").append(toIndentedString(meetingId)).append("\n");
    sb.append("    subject: ").append(toIndentedString(subject)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    participants: ").append(toIndentedString(participants)).append("\n");
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

