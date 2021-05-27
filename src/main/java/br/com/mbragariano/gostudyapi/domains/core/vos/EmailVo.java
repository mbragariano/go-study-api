package br.com.mbragariano.gostudyapi.domains.core.vos;

import io.vavr.control.Validation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class EmailVo {

  private final String value;

  public static Validation<String, EmailVo> create(String value) {
    if (Objects.isNull(value))
      return Validation.invalid("Email não pode ser nulo");

    if (value.isBlank() || value.isEmpty())
      return Validation.invalid("Email não pode estar em branco");

    return Validation.valid(new EmailVo(value));
  }

}
