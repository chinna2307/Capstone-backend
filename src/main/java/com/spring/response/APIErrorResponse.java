package com.spring.response;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class APIErrorResponse extends APIResponse {

 private LocalDateTime timestamp;

 public APIErrorResponse(HttpStatus status, String message, int statusCode) {
  super(status, message);
  this.timestamp = LocalDateTime.now();
  setStatusCode(statusCode);
  setResponseStatus("error");
  setResponseCount(0);

 }

}
