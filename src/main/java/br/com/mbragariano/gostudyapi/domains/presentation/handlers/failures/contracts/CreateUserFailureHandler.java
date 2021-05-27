package br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.contracts;

import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public abstract class CreateUserFailureHandler {

  private final CreateUserFailureHandler createUserFailureHandler;

  public ResponseEntity<?> handle(CreateUserFailure createUserFailure) {
    log.info("Realizando tratamento para " + createUserFailure.getClass().getSimpleName());

    return this.isApplicable(createUserFailure)
      ? this.apply(createUserFailure)
      : this.createUserFailureHandler.handle(createUserFailure);
  }

  protected abstract ResponseEntity<?> apply(CreateUserFailure createUserFailure);

  protected abstract Boolean isApplicable(CreateUserFailure createUserFailure);

}
