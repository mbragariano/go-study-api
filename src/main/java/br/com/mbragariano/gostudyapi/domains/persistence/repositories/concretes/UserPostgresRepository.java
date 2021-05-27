package br.com.mbragariano.gostudyapi.domains.persistence.repositories.concretes;

import br.com.mbragariano.gostudyapi.commons.persistence.exception.DatabaseException;
import br.com.mbragariano.gostudyapi.domains.core.entities.UserEntity;
import br.com.mbragariano.gostudyapi.domains.core.repositories.UserRepository;
import br.com.mbragariano.gostudyapi.domains.persistence.mappers.UserSchemaMapper;
import br.com.mbragariano.gostudyapi.domains.persistence.repositories.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserPostgresRepository implements UserRepository {

  private final UserJpaRepository userJpaRepository;

  @Override
  public Boolean existsByEmail(String email) {
    try {
      return this.userJpaRepository.existsByEmail(email);
    } catch (DataAccessException dataAccessException) {
      final var title = "Erro ao verificar existência de usuário pelo email no banco de dados";
      log.error("{}: {}", title, dataAccessException.getMessage());
      throw new DatabaseException(title, dataAccessException.getMessage());
    }
  }

  @Override
  public void save(UserEntity userEntity) {
    try {
      this.userJpaRepository.save(
        UserSchemaMapper.mapToUserSchema(userEntity));
    } catch (DataAccessException dataAccessException) {
      final var title = "Erro ao salvar usuário no banco de dados";
      log.error("{}: {}", title, dataAccessException.getMessage());
      throw new DatabaseException(title, dataAccessException.getMessage());
    }
  }

}
