package br.com.mbragariano.gostudyapi.commons.presentation.models.responses.contracts;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class FailureResponse {

  public String title;

  public String details;

  @JsonGetter("response_type")
  public String getResponseType() {
    return this.getClass().getSimpleName();
  }

}
