package br.com.mbragariano.gostudyapi.domains.persistence.repositories.concretes;

import br.com.mbragariano.gostudyapi.domains.core.entities.UserEntity;
import br.com.mbragariano.gostudyapi.domains.core.repositories.UserRepository;
import br.com.mbragariano.gostudyapi.domains.persistence.mappers.UserSchemaMapper;
import br.com.mbragariano.gostudyapi.domains.persistence.repositories.jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPostgresRepository implements UserRepository {

  private final UserJpaRepository userJpaRepository;

  @Override
  public Boolean existsByEmail(String email) {
    return this.userJpaRepository.existsByEmail(email);
  }

  @Override
  public void save(UserEntity userEntity) {
    this.userJpaRepository.save(
      UserSchemaMapper.mapToUserSchema(userEntity));
  }

}
