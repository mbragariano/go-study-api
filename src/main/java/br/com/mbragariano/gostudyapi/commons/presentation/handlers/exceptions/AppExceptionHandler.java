package br.com.mbragariano.gostudyapi.commons.presentation.handlers.exceptions;

import br.com.mbragariano.gostudyapi.commons.persistence.exception.DatabaseException;
import br.com.mbragariano.gostudyapi.commons.presentation.mappers.ExceptionPresentationMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<?> databaseExceptionHandler(DatabaseException databaseException) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(ExceptionPresentationMapper.mapToDatabaseExceptionResponse(databaseException));
  }

}
