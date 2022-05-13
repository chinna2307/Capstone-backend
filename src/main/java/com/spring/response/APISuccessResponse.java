package com.spring.response;

import java.util.List;

import org.springframework.http.HttpStatus;

public class APISuccessResponse extends APIResponse {

 /*
  * Response object can be an array of object or single object
  */
 Object responceObject;

 public APISuccessResponse(HttpStatus status) {
  super(status);
  setResponseStatus("Success");
  setStatusCode(0);
 }

 public APISuccessResponse(HttpStatus status, String message, Object responceObject) {
  super(status, message);
  this.responceObject = responceObject;
  setResponseStatus("Success");
  setStatusCode(0);
  setResponseCount(responceObject instanceof List<?> ? ((List<?>) responceObject).size() : 1);
 }

 public APISuccessResponse(HttpStatus status, Object responceObject) {
  super(status);
  this.setResponceObject(responceObject);
 }

 public Object getResponceObject() {
  return responceObject;
 }

 public void setResponceObject(Object responceObject) {
  this.responceObject = responceObject;
 }

}
