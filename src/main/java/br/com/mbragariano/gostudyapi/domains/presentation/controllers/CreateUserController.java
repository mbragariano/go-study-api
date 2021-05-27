package br.com.mbragariano.gostudyapi.domains.presentation.controllers;

import br.com.mbragariano.gostudyapi.domains.application.services.contracts.CreateUserService;
import br.com.mbragariano.gostudyapi.domains.presentation.handlers.failures.contracts.CreateUserFailureHandler;
import br.com.mbragariano.gostudyapi.domains.presentation.mappers.UserPresentationMapper;
import br.com.mbragariano.gostudyapi.domains.presentation.models.requests.CreateUserRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController {

  private final CreateUserService createUserService;

  private final CreateUserFailureHandler createUserFailureHandler;

  public CreateUserController(
    CreateUserService createUserService,
    @Qualifier("duplicationUserEmailFailureHandler") CreateUserFailureHandler createUserFailureHandler
  ) {
    this.createUserService = createUserService;
    this.createUserFailureHandler = createUserFailureHandler;
  }

  @PostMapping("/users")
  public ResponseEntity<?> control(@RequestBody CreateUserRequest createUserRequest) {
    final var createUserInput = UserPresentationMapper.mapToCreateUserInput(createUserRequest);
    final var createUserOutputOrFailures = this.createUserService.execute(createUserInput);

    if (createUserOutputOrFailures.isLeft())
      return this.createUserFailureHandler.handle(createUserOutputOrFailures.getLeft());

    return ResponseEntity.status(HttpStatus.CREATED)
      .body(UserPresentationMapper.mapToCreateUserResponse(createUserOutputOrFailures.get()));
  }

}
