package br.com.mbragariano.gostudyapi.domains.application.mappers;

import br.com.mbragariano.gostudyapi.domains.application.models.input.CreateUserInput;
import br.com.mbragariano.gostudyapi.domains.application.models.output.CreateUserOutput;
import br.com.mbragariano.gostudyapi.domains.core.datas.CreateUserData;
import br.com.mbragariano.gostudyapi.domains.core.entities.UserEntity;

public class UserApplicationMapper {

  public static CreateUserData mapToCreateUserData(CreateUserInput createUserInput) {
    return CreateUserData.builder()
      .name(createUserInput.name)
      .email(createUserInput.email)
      .password(createUserInput.password)
      .type(createUserInput.type)
      .build();
  }

  public static CreateUserOutput mapToCreateUserOutput(UserEntity userEntity) {
    return CreateUserOutput.builder()
      .id(userEntity.getId())
      .name(userEntity.getNameVo().getValue())
      .email(userEntity.getEmailVo().getValue())
      .password(userEntity.getPasswordVo().getValue())
      .type(userEntity.getType().getValue())
      .build();
  }

}
