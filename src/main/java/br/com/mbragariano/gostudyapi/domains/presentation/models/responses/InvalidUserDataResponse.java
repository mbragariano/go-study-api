package br.com.mbragariano.gostudyapi.domains.presentation.models.responses;

import br.com.mbragariano.gostudyapi.commons.presentation.models.responses.FailureResponse;
import lombok.Builder;

import java.util.List;

public class InvalidUserDataResponse extends FailureResponse {

  public List<String> validations;

  @Builder
  public InvalidUserDataResponse(String title, String details, List<String> validations) {
    super(title, details);

    this.validations = validations;
  }

}
