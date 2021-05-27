package br.com.mbragariano.gostudyapi.commons.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class AppException extends RuntimeException {

  private final String title;

  private final String details;

}
