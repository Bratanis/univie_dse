package com.example.Task6.model;

import java.net.URI;
import java.util.Objects;
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
 * PollPollIdPatchRequest
 */

@JsonTypeName("_poll__pollId__patch_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-18T19:11:04.541998563+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public class PollPollIdPatchRequest {

  private Boolean isPublished;

  public PollPollIdPatchRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PollPollIdPatchRequest(Boolean isPublished) {
    this.isPublished = isPublished;
  }

  public PollPollIdPatchRequest isPublished(Boolean isPublished) {
    this.isPublished = isPublished;
    return this;
  }

  /**
   * Indicates whether the poll is published
   * @return isPublished
   */
  @NotNull 
  @Schema(name = "isPublished", description = "Indicates whether the poll is published", requiredMode = Schema.RequiredMode.REQUIRED)
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
    PollPollIdPatchRequest pollPollIdPatchRequest = (PollPollIdPatchRequest) o;
    return Objects.equals(this.isPublished, pollPollIdPatchRequest.isPublished);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isPublished);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PollPollIdPatchRequest {\n");
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

