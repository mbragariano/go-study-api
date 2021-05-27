package br.com.mbragariano.gostudyapi.domains.core.vos;

import io.vavr.control.Validation;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class NameVo {

  private final String value;

  public static Validation<String, NameVo> create(String value) {
    if (Objects.isNull(value))
      return Validation.invalid("Nome não pode ser nulo");

    if (value.isBlank() || value.isEmpty())
      return Validation.invalid("Nome não pode estar em branco");

    if (value.trim().split(" ").length <= 1)
      return Validation.invalid("Nome e sobrenome devem ser informados");

    return Validation.valid(new NameVo(value));
  }

}
