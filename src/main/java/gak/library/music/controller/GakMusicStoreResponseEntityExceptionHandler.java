package gak.library.music.controller;

import gak.library.music.exception.ApiCorruptedResultException;
import gak.library.music.exception.ArtistNotFoundException;
import gak.library.music.exception.ErrorResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class GakMusicStoreResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ArtistNotFoundException.class)
    public ResponseEntity<ErrorResponseEntity> handleArtistNotFoundException(ArtistNotFoundException ex, WebRequest request) {
        ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity(
                HttpStatus.NOT_FOUND.toString(),
                request.getDescription(false),
                ex.getMessage(),
                new Date().getTime());

        return new ResponseEntity<>(errorResponseEntity, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ApiCorruptedResultException.class)
    public ResponseEntity<ErrorResponseEntity> handleApiCorruptedResultException(ApiCorruptedResultException ex, WebRequest request) {
        ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity(
                HttpStatus.EXPECTATION_FAILED.toString(),
                request.getDescription(false),
                ex.getMessage(),
                new Date().getTime()
        );

        return new ResponseEntity<>(errorResponseEntity, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseEntity> handleAllOtherException(Exception ex, WebRequest request) {
        ErrorResponseEntity errorResponseEntity = new ErrorResponseEntity(
                HttpStatus.INTERNAL_SERVER_ERROR.toString(),
                request.getDescription(false),
                ex.getMessage(),
                new Date().getTime()
        );

        return new ResponseEntity<>(errorResponseEntity, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
