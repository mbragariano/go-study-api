package br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.concretes;

import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.contracts.CreateUserFailureHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UnhandledFailureHandler extends CreateUserFailureHandler {

  public UnhandledFailureHandler() {
    super(null);
  }

  @Override
  protected ResponseEntity<?> apply(CreateUserFailure createUserFailure) {
    return ResponseEntity.notFound().build();
  }

  @Override
  protected Boolean isApplicable(CreateUserFailure createUserFailure) {
    return true;
  }

}
