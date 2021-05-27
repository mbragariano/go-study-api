package br.com.mbragariano.gostudyapi.domains.core.enums;

import io.vavr.control.Validation;
import lombok.Getter;

import java.util.function.Predicate;
import java.util.stream.Stream;

@Getter
public enum UserType {

  STUDENT("ALUNO"),
  TEACHER("INSTRUTOR");

  private final String value;

  UserType(String value) {
    this.value = value;
  }

  public static Validation<String, UserType> getConstantByValue(String value) {
    return Stream.of(UserType.values())
      .filter(byValue(value))
      .findFirst()
      .map(Validation::<String, UserType>valid)
      .orElseGet(() -> Validation.invalid("Tipo de usuário não encontrado para o valor " + value));
  }

  private static Predicate<UserType> byValue(String value) {
    return userType -> userType.getValue().equals(value);
  }
}
