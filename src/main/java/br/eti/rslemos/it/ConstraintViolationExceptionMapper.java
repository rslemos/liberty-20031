package br.eti.rslemos.it;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
// public class ConstraintViolationExceptionMapper implements ExceptionMapper<ValidationException> {
// public class ConstraintViolationExceptionMapper implements ExceptionMapper<RuntimeException> {
// public class ConstraintViolationExceptionMapper implements ExceptionMapper<Exception> {
// public class ConstraintViolationExceptionMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(ConstraintViolationException exception) {
  // public Response toResponse(ValidationException exception) {
  // public Response toResponse(RuntimeException exception) {
  // public Response toResponse(Exception exception) {
  // public Response toResponse(Throwable exception) {
    StringWriter writer = new StringWriter();
    exception.printStackTrace(new PrintWriter(writer));
    return Response.status(Status.BAD_REQUEST)
      .entity(writer.toString())
      .build();
  }
}

