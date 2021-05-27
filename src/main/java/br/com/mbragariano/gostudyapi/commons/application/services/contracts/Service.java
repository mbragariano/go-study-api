package br.com.mbragariano.gostudyapi.commons.application.services.contracts;

import io.vavr.control.Either;

public interface Service<I, O, F> {

  Either<F, O> execute(I input);

}
