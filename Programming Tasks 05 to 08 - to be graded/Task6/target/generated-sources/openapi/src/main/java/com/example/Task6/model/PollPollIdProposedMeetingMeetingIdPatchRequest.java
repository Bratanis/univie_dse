package com.example.Task6.model;

import java.net.URI;
import java.util.Objects;
import com.example.Task6.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PollPollIdProposedMeetingMeetingIdPatchRequest
 */

@JsonTypeName("_poll__pollId__ProposedMeeting__meetingId__patch_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T15:19:30.908617591+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public class PollPollIdProposedMeetingMeetingIdPatchRequest {

  private User user;

  public PollPollIdProposedMeetingMeetingIdPatchRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PollPollIdProposedMeetingMeetingIdPatchRequest(User user) {
    this.user = user;
  }

  public PollPollIdProposedMeetingMeetingIdPatchRequest user(User user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   */
  @NotNull @Valid 
  @Schema(name = "User", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("User")
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PollPollIdProposedMeetingMeetingIdPatchRequest pollPollIdProposedMeetingMeetingIdPatchRequest = (PollPollIdProposedMeetingMeetingIdPatchRequest) o;
    return Objects.equals(this.user, pollPollIdProposedMeetingMeetingIdPatchRequest.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PollPollIdProposedMeetingMeetingIdPatchRequest {\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
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

