package br.com.mbragariano.gostudyapi.domains.core.entities;

import br.com.mbragariano.gostudyapi.commons.core.entities.Entity;
import br.com.mbragariano.gostudyapi.domains.core.datas.CreateUserData;
import br.com.mbragariano.gostudyapi.domains.core.enums.UserType;
import br.com.mbragariano.gostudyapi.domains.core.vos.EmailVo;
import br.com.mbragariano.gostudyapi.domains.core.vos.NameVo;
import br.com.mbragariano.gostudyapi.domains.core.vos.PasswordVo;
import io.vavr.Function4;
import io.vavr.Value;
import io.vavr.control.Validation;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends Entity {

  private final NameVo nameVo;

  private final EmailVo emailVo;

  private final PasswordVo passwordVo;

  private final UserType type;

  @Builder
  private UserEntity(
    String id,
    NameVo nameVo,
    EmailVo emailVo,
    PasswordVo passwordVo,
    UserType type
  ) {
    super(id);

    this.nameVo = nameVo;
    this.emailVo = emailVo;
    this.passwordVo = passwordVo;
    this.type = type;
  }

  public static Validation<List<String>, UserEntity> create(CreateUserData createUserData) {
    return NameVo.create(createUserData.name).mapError(Collections::singletonList)
      .combine(EmailVo.create(createUserData.email).mapError(Collections::singletonList))
      .combine(PasswordVo.create(createUserData.password).mapError(Collections::singletonList))
      .combine(UserType.getConstantByValue(createUserData.type).mapError(Collections::singletonList))
      .ap(crateEntity(createUserData))
      .mapError(Value::toJavaList)
      .mapError(Collection::stream)
      .mapError(listStream -> listStream.flatMap(Collection::stream).collect(Collectors.toList()));
  }

  private static Function4<NameVo, EmailVo, PasswordVo, UserType, UserEntity> crateEntity(CreateUserData createUserData) {
    return (nameVo, emailVo, passwordVo, type) -> {
      final var id = Objects.isNull(createUserData.id) ? UUID.randomUUID().toString() : null;
      return UserEntity.builder()
        .id(id)
        .nameVo(nameVo)
        .emailVo(emailVo)
        .passwordVo(passwordVo)
        .type(type)
        .build();
    };
  }

}
