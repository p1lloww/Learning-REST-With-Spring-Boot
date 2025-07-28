package com.br.neptune.Learning_REST_With_Spring_Boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException {

  public UnsupportedMathOperationException(String message) {
    super(message);
  }
}
