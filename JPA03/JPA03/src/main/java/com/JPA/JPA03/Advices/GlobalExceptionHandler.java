package com.JPA.JPA03.Advices;
import com.JPA.JPA03.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler( ResourceNotFoundException.class)
    public ResponseEntity<ApiError> HandlerResourceNotFound(ResourceNotFoundException exception) {
        ApiError apiError = ApiError.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> HandleInternalServerError(Exception e){
        ApiError apiError =ApiError.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> HandelInputValidationError(MethodArgumentNotValidException e){
//        this step is collecting all the error and storing in list to show them there are different portion written
      List<String> errors=e
                .getBindingResult().getAllErrors()
                .stream()
                .map( objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
//       from here we actually throw/show the error this only show what is written in dto class above the field
//        ApiError apiError =ApiError.builder()
//                .httpStatus(HttpStatus.BAD_REQUEST)
//                .message(errors.toString())
//                .build();
//        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);

//        if you want to get them better manner there is another code written
        ApiError apiError =ApiError.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message("input validation failed")
                .subError(errors)
                .build();
        return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Not)
}
