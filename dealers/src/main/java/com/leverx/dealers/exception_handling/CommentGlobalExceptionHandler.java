package com.leverx.dealers.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentGlobalExceptionHandler {

    @ExceptionHandler/// ,,,???
    public ResponseEntity<CommentIncorrectData> handleException(Exception exception) {
        CommentIncorrectData data = new CommentIncorrectData();
        data.setInfo("No such element !!! Please try again!!" + "Exception message :" + exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
}
