package br.com.mbragariano.gostudyapi.domains.application.services.concretes;

import br.com.mbragariano.gostudyapi.domains.application.failures.concretes.DuplicationUserEmailFailure;
import br.com.mbragariano.gostudyapi.domains.application.failures.concretes.InvalidUserDataFailure;
import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import br.com.mbragariano.gostudyapi.domains.application.mappers.UserApplicationMapper;
import br.com.mbragariano.gostudyapi.domains.application.models.input.CreateUserInput;
import br.com.mbragariano.gostudyapi.domains.application.models.output.CreateUserOutput;
import br.com.mbragariano.gostudyapi.domains.application.services.contracts.CreateUserService;
import br.com.mbragariano.gostudyapi.domains.core.entities.UserEntity;
import br.com.mbragariano.gostudyapi.domains.core.repositories.UserRepository;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {

  private final UserRepository userRepository;

  @Override
  public Either<CreateUserFailure, CreateUserOutput> execute(CreateUserInput createUserInput) {
    log.info("Iniciando processo de criação de usuário!");

    final var userOrValidations = UserEntity.create(UserApplicationMapper.mapToCreateUserData(createUserInput));

    if (userOrValidations.isInvalid()) {
      final var validations = userOrValidations.getError();

      log.warn("Valores inválidos para criar um usuário: {}", validations);

      return Either.left(new InvalidUserDataFailure(validations));
    }

    final var userExistsByEmail = this.userRepository.existsByEmail(createUserInput.email);

    if (userExistsByEmail) {
      log.warn("Usuário existente com o email {}", createUserInput.email);

      return Either.left(new DuplicationUserEmailFailure(createUserInput.email));
    }

    final var entity = userOrValidations.get();

    this.userRepository.save(entity);

    return Either.right(UserApplicationMapper.mapToCreateUserOutput(entity));
  }

}
