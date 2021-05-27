package br.com.mbragariano.gostudyapi.commons.presentation.models.responses.concretes;

import br.com.mbragariano.gostudyapi.commons.presentation.models.responses.contracts.ExceptionResponse;
import lombok.Builder;

public class DatabaseExceptionResponse extends ExceptionResponse {

  @Builder
  public DatabaseExceptionResponse(String title, String details) {
    super(title, details);
  }

}
