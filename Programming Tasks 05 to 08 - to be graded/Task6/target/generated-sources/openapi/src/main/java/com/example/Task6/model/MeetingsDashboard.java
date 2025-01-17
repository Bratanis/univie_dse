package com.example.Task6.model;

import java.net.URI;
import java.util.Objects;
import com.example.Task6.model.Meeting;
import com.example.Task6.model.Poll;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * MeetingsDashboard
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T15:19:30.908617591+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public class MeetingsDashboard {

  @Valid
  private List<@Valid Meeting> meetings = new ArrayList<>();

  @Valid
  private List<@Valid Poll> polls = new ArrayList<>();

  public MeetingsDashboard meetings(List<@Valid Meeting> meetings) {
    this.meetings = meetings;
    return this;
  }

  public MeetingsDashboard addMeetingsItem(Meeting meetingsItem) {
    if (this.meetings == null) {
      this.meetings = new ArrayList<>();
    }
    this.meetings.add(meetingsItem);
    return this;
  }

  /**
   * Get meetings
   * @return meetings
   */
  @Valid 
  @Schema(name = "meetings", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("meetings")
  public List<@Valid Meeting> getMeetings() {
    return meetings;
  }

  public void setMeetings(List<@Valid Meeting> meetings) {
    this.meetings = meetings;
  }

  public MeetingsDashboard polls(List<@Valid Poll> polls) {
    this.polls = polls;
    return this;
  }

  public MeetingsDashboard addPollsItem(Poll pollsItem) {
    if (this.polls == null) {
      this.polls = new ArrayList<>();
    }
    this.polls.add(pollsItem);
    return this;
  }

  /**
   * Get polls
   * @return polls
   */
  @Valid 
  @Schema(name = "polls", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("polls")
  public List<@Valid Poll> getPolls() {
    return polls;
  }

  public void setPolls(List<@Valid Poll> polls) {
    this.polls = polls;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MeetingsDashboard meetingsDashboard = (MeetingsDashboard) o;
    return Objects.equals(this.meetings, meetingsDashboard.meetings) &&
        Objects.equals(this.polls, meetingsDashboard.polls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(meetings, polls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MeetingsDashboard {\n");
    sb.append("    meetings: ").append(toIndentedString(meetings)).append("\n");
    sb.append("    polls: ").append(toIndentedString(polls)).append("\n");
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

