package br.com.mbragariano.gostudyapi.commons.application.failures.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Failure {

  private final String title;

  private final String details;

}
