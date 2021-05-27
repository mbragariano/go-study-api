package br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.concretes;

import br.com.mbragariano.gostudyapi.domains.application.failures.concretes.DuplicationUserEmailFailure;
import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.contracts.CreateUserFailureHandler;
import br.com.mbragariano.gostudyapi.domains.presentation.mappers.UserPresentationMapper;
import br.com.mbragariano.gostudyapi.domains.presentation.models.responses.DuplicationUserEmailResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DuplicationUserEmailFailureHandler extends CreateUserFailureHandler {

  public DuplicationUserEmailFailureHandler(
    @Qualifier("invalidUserDataFailureHandler") CreateUserFailureHandler createUserFailureHandler
  ) {
    super(createUserFailureHandler);
  }

  @Override
  protected ResponseEntity<?> apply(CreateUserFailure createUserFailure) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
      .body(UserPresentationMapper.mapToDuplicationUserEmailResponse(createUserFailure));
  }

  @Override
  protected Boolean isApplicable(CreateUserFailure createUserFailure) {
    return createUserFailure instanceof DuplicationUserEmailFailure;
  }

}
