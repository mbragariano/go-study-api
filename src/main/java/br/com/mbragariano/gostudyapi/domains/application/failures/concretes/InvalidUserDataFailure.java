package br.com.mbragariano.gostudyapi.domains.application.failures.concretes;

import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import lombok.Getter;

import java.util.List;

@Getter
public class InvalidUserDataFailure extends CreateUserFailure {

  private final List<String> validations;

  private static final String DETAILS = "Valores inválidos para criação de usuário, veja as mensagens de validação";

  public InvalidUserDataFailure(List<String> validations) {
    super(DETAILS);

    this.validations = validations;
  }

}
