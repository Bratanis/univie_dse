package com.example.Task6.model;

import java.net.URI;
import java.util.Objects;
import com.example.Task6.model.ProposedMeeting;
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
 * Poll
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-18T19:11:04.541998563+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public class Poll {

  private Integer pollId;

  @Valid
  private List<@Valid ProposedMeeting> proposals = new ArrayList<>();

  private Boolean isPublished;

  public Poll pollId(Integer pollId) {
    this.pollId = pollId;
    return this;
  }

  /**
   * Get pollId
   * minimum: 0
   * maximum: 999
   * @return pollId
   */
  @Min(0) @Max(999) 
  @Schema(name = "pollId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("pollId")
  public Integer getPollId() {
    return pollId;
  }

  public void setPollId(Integer pollId) {
    this.pollId = pollId;
  }

  public Poll proposals(List<@Valid ProposedMeeting> proposals) {
    this.proposals = proposals;
    return this;
  }

  public Poll addProposalsItem(ProposedMeeting proposalsItem) {
    if (this.proposals == null) {
      this.proposals = new ArrayList<>();
    }
    this.proposals.add(proposalsItem);
    return this;
  }

  /**
   * Get proposals
   * @return proposals
   */
  @Valid 
  @Schema(name = "proposals", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("proposals")
  public List<@Valid ProposedMeeting> getProposals() {
    return proposals;
  }

  public void setProposals(List<@Valid ProposedMeeting> proposals) {
    this.proposals = proposals;
  }

  public Poll isPublished(Boolean isPublished) {
    this.isPublished = isPublished;
    return this;
  }

  /**
   * Get isPublished
   * @return isPublished
   */
  
  @Schema(name = "isPublished", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isPublished")
  public Boolean getIsPublished() {
    return isPublished;
  }

  public void setIsPublished(Boolean isPublished) {
    this.isPublished = isPublished;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Poll poll = (Poll) o;
    return Objects.equals(this.pollId, poll.pollId) &&
        Objects.equals(this.proposals, poll.proposals) &&
        Objects.equals(this.isPublished, poll.isPublished);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pollId, proposals, isPublished);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Poll {\n");
    sb.append("    pollId: ").append(toIndentedString(pollId)).append("\n");
    sb.append("    proposals: ").append(toIndentedString(proposals)).append("\n");
    sb.append("    isPublished: ").append(toIndentedString(isPublished)).append("\n");
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

