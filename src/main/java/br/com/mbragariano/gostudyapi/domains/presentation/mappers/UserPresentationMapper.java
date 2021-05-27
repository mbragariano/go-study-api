package br.com.mbragariano.gostudyapi.domains.presentation.mappers;

import br.com.mbragariano.gostudyapi.domains.application.failures.concretes.InvalidUserDataFailure;
import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import br.com.mbragariano.gostudyapi.domains.application.models.input.CreateUserInput;
import br.com.mbragariano.gostudyapi.domains.application.models.output.CreateUserOutput;
import br.com.mbragariano.gostudyapi.domains.presentation.models.requests.CreateUserRequest;
import br.com.mbragariano.gostudyapi.domains.presentation.models.responses.CreateUserResponse;
import br.com.mbragariano.gostudyapi.domains.presentation.models.responses.DuplicationUserEmailResponse;
import br.com.mbragariano.gostudyapi.domains.presentation.models.responses.InvalidUserDataResponse;

public class UserPresentationMapper {

  public static CreateUserInput mapToCreateUserInput(CreateUserRequest createUserRequest) {
    return CreateUserInput.builder()
      .name(createUserRequest.name)
      .email(createUserRequest.email)
      .password(createUserRequest.password)
      .type(createUserRequest.type)
      .build();
  }

  public static DuplicationUserEmailResponse mapToDuplicationUserEmailResponse(CreateUserFailure createUserFailure) {
    return DuplicationUserEmailResponse.builder()
      .title(createUserFailure.getTitle())
      .details(createUserFailure.getDetails())
      .build();
  }

  public static InvalidUserDataResponse mapToInvalidUserDataResponse(CreateUserFailure createUserFailure) {
    final var invalidUserDataFailure = (InvalidUserDataFailure) createUserFailure;

    return InvalidUserDataResponse.builder()
      .title(invalidUserDataFailure.getTitle())
      .details(invalidUserDataFailure.getDetails())
      .validations(invalidUserDataFailure.getValidations())
      .build();
  }

  public static CreateUserResponse mapToCreateUserResponse(CreateUserOutput createUserOutput) {
    return CreateUserResponse.builder()
      .id(createUserOutput.id)
      .name(createUserOutput.name)
      .email(createUserOutput.email)
      .password(createUserOutput.password)
      .type(createUserOutput.type)
      .build();
  }
}
