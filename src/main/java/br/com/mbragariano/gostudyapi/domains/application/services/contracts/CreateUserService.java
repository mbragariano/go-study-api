package br.com.mbragariano.gostudyapi.domains.application.services.contracts;

import br.com.mbragariano.gostudyapi.commons.application.services.contracts.Service;
import br.com.mbragariano.gostudyapi.domains.application.failures.contracts.CreateUserFailure;
import br.com.mbragariano.gostudyapi.domains.application.models.input.CreateUserInput;
import br.com.mbragariano.gostudyapi.domains.application.models.output.CreateUserOutput;

public interface CreateUserService extends Service<CreateUserInput, CreateUserOutput, CreateUserFailure> {
}
