package br.com.mbragariano.gostudyapi.domains.application.failures.concretes;

import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;

public class DuplicationUserEmailFailure extends CreateUserFailure {

  private static final String DETAILS = "Usuário duplicado pelo email %s";

  public DuplicationUserEmailFailure(String email) {
    super(String.format(DETAILS, email));
  }

}
