package br.com.mbragariano.gostudyapi.commons.presentation.models.responses.contracts;

public abstract class ExceptionResponse extends FailureResponse {

  public ExceptionResponse(String title, String details) {
    super(title, details);
  }

}
