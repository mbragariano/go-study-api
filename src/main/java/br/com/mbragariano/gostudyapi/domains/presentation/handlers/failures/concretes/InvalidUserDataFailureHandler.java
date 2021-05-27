package br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.concretes;

import br.com.mbragariano.gostudyapi.domains.application.failures.concretes.InvalidUserDataFailure;
import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.contracts.CreateUserFailureHandler;
import br.com.mbragariano.gostudyapi.domains.presentation.mappers.UserPresentationMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class InvalidUserDataFailureHandler extends CreateUserFailureHandler {

  public InvalidUserDataFailureHandler(
    @Qualifier("unhandledFailureHandler") CreateUserFailureHandler createUserFailureHandler
  ) {
    super(createUserFailureHandler);
  }

  @Override
  protected ResponseEntity<?> apply(CreateUserFailure createUserFailure) {
    return ResponseEntity.badRequest()
      .body(UserPresentationMapper.mapToInvalidUserDataResponse(createUserFailure));
  }

  @Override
  protected Boolean isApplicable(CreateUserFailure createUserFailure) {
    return createUserFailure instanceof InvalidUserDataFailure;
  }

}
