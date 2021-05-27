package br.com.mbragariano.gostudyapi.domains.core.repositories;

import br.com.mbragariano.gostudyapi.domains.core.entities.UserEntity;

public interface UserRepository {

  Boolean existsByEmail(String email);

  void save(UserEntity entity);

}
