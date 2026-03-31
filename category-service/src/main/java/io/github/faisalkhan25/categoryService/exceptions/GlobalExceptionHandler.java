package io.github.faisalkhan25.categoryService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<ErrorResponse> illegalArgumentException(IllegalArgumentException e, WebRequest webRequest) {
//        ErrorResponse errorResponse = ErrorResponse.builder()
//                .timestamp(LocalDateTime.now())
//                .status(HttpStatus.BAD_REQUEST.value())
//                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                .message(e.getMessage())
//                .path(webRequest.getDescription(false).replace("uri=", ""))
//                .build();
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
//    }
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e, WebRequest webRequest) {
//
//    }
}
