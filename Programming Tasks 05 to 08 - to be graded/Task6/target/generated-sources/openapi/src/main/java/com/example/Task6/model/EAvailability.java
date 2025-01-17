package com.example.Task6.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.annotation.Generated;

/**
 * The availability status of a participant.
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-17T12:23:32.423591700+01:00[Europe/Berlin]", comments = "Generator version: 7.9.0")
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

