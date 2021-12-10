package com.leverx.dealers.exceptions;

import com.leverx.dealers.dto.CommentIncorrectData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommentGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CommentIncorrectData> handleException(Exception exception) {
        CommentIncorrectData data = new CommentIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }


}
