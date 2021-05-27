package br.com.mbragariano.gostudyapi.commons.persistence.exception;

import br.com.mbragariano.gostudyapi.commons.shared.exceptions.AppException;

public class DatabaseException extends AppException {

  public DatabaseException(String title, String details) {
    super(title, details);
  }

}
