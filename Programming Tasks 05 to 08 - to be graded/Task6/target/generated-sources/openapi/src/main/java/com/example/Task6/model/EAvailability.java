package com.example.Task6.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The availability status of a participant.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T23:12:21.815558952+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
public enum EAvailability {
  
  TRUE("true"),
  
  FALSE("false"),
  
  MAYBE("maybe");

  private String value;

  EAvailability(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static EAvailability fromValue(String value) {
    for (EAvailability b : EAvailability.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

