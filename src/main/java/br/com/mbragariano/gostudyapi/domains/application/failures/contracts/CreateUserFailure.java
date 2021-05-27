package br.com.mbragariano.gostudyapi.domains.application.failures.contracts;

import br.com.mbragariano.gostudyapi.commons.application.failures.contract.Failure;

public abstract class CreateUserFailure extends Failure {

  private static final String TITLE = "Não foi possível criar usuário";

  public CreateUserFailure(String details) {
    super(TITLE, details);
  }

}
