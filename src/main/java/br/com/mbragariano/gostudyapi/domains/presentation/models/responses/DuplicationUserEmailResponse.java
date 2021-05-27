package br.com.mbragariano.gostudyapi.domains.presentation.models.responses;

import br.com.mbragariano.gostudyapi.commons.presentation.models.responses.contracts.FailureResponse;
import lombok.Builder;

public class DuplicationUserEmailResponse extends FailureResponse {

  @Builder
  public DuplicationUserEmailResponse(String title, String details) {
    super(title, details);
  }

}
