package br.com.mbragariano.gostudyapi.domains.persistence.mappers;

import br.com.mbragariano.gostudyapi.domains.core.entities.UserEntity;
import br.com.mbragariano.gostudyapi.domains.persistence.schemas.UserSchema;

import java.util.UUID;

public class UserSchemaMapper {

  public static UserSchema mapToUserSchema(UserEntity userEntity) {
    return UserSchema.builder()
      .id(UUID.fromString(userEntity.getId()))
      .name(userEntity.getNameVo().getValue())
      .email(userEntity.getEmailVo().getValue())
      .password(userEntity.getPasswordVo().getValue())
      .type(userEntity.getType().getValue())
      .build();
  }

}
