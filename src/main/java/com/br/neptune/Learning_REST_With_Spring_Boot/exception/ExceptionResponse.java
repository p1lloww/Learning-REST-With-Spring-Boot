package com.br.neptune.Learning_REST_With_Spring_Boot.exception;

import java.util.Date;

public record ExceptionResponse(Date timeStamp, String message, String details) {}
