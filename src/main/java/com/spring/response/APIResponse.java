package com.spring.response;

import org.springframework.http.HttpStatus;

public class APIResponse {

 /*
  * Http Status code of response
  */
 private HttpStatus status;

 /*
  * Responce Message
  */
 private String message;

 /*
  * Response Status string:Success or Failure
  */
 private String responseStatus;

 /*
  * Response Status code
  */
 private int statusCode;

 /*
  * Number of returned objects
  */
 private int responseCount;

 public APIResponse(HttpStatus status) {
  this.status = status;
 }

 public APIResponse(HttpStatus status, String message) {
  this(status);
  this.message = message;
 }

 /*
  * this is required while deserializing test response to create object
  */
 public APIResponse() {

 }

 public HttpStatus getStatus() {
  return status;
 }

 public void setStatus(HttpStatus status) {
  this.status = status;
 }

 public String getMessage() {
  return message;
 }

 public void setMessage(String message) {
  this.message = message;
 }

 public String getResponseStatus() {
  return responseStatus;
 }

 public void setResponseStatus(String responseStatus) {
  this.responseStatus = responseStatus;
 }

 public int getStatusCode() {
  return statusCode;
 }

 public void setStatusCode(int statusCode) {
  this.statusCode = statusCode;
 }

 public int getResponseCount() {
  return responseCount;
 }

 public void setResponseCount(int responseCount) {
  this.responseCount = responseCount;
 }

}
