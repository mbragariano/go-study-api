package br.com.mbragariano.gostudyapi.commons.presentation.mappers;

import br.com.mbragariano.gostudyapi.commons.persistence.exception.DatabaseException;
import br.com.mbragariano.gostudyapi.commons.presentation.models.responses.concretes.DatabaseExceptionResponse;

public class ExceptionPresentationMapper {

  public static DatabaseExceptionResponse mapToDatabaseExceptionResponse(DatabaseException databaseException) {
    return DatabaseExceptionResponse.builder()
      .title(databaseException.getTitle())
      .details(databaseException.getDetails())
      .build();
  }

}
