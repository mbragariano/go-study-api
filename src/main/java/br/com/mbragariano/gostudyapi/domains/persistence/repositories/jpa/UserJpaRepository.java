package br.com.mbragariano.gostudyapi.domains.persistence.repositories.jpa;

import br.com.mbragariano.gostudyapi.domains.persistence.schemas.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserSchema, UUID> {

  boolean existsByEmail(String email);

}
