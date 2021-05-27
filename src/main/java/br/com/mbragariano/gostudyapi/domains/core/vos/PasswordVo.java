package br.com.mbragariano.gostudyapi.domains.core.vos;

import io.vavr.control.Validation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class PasswordVo {

  private final String value;

  public static Validation<String, PasswordVo> create(String value) {
    if (Objects.isNull(value))
      return Validation.invalid("Senha não pode ser nula");

    if (value.isBlank() || value.isEmpty())
      return Validation.invalid("Senha não pode estar em branca");

    return Validation.valid(new PasswordVo(value));
  }

}
