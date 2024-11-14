package com.sxp.app.product.v1.infrastructure.adapter.input.controller.handler;

import com.sxp.app.product.v1.infrastructure.adapter.input.controller.dto.ErrorDto;
import com.sxp.app.product.v1.infrastructure.adapter.input.controller.dto.ErrorsDto;
import com.sxp.app.product.v1.infrastructure.adapter.input.controller.dto.LevelEnumDto;
import com.sxp.app.product.v1.domain.exception.BadRequestException;
import com.sxp.app.product.v1.domain.exception.InternalServerErrorException;
import com.sxp.app.product.v1.domain.exception.NoContentException;
import com.sxp.app.product.v1.domain.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    /**
     * Handle no content response entity. 204
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Void> handleNoContent(NoContentException ex) {
        log.info("NoContentException: {}", ex.getLocalizedMessage());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Handle bad request response entity. 400
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorsDto> handleBadRequest(BadRequestException ex) {
        log.info("BadRequestException: {}", ex.getLocalizedMessage());
        return new ResponseEntity<>(ErrorsDto.builder()
                .errors(List.of(
                        ErrorDto.builder()
                                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                                .message(ex.getMessage())
                                .level(LevelEnumDto.ERROR)
                                .build()))
                .build(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handle not found response entity. 404
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorsDto> handleNotFound(NotFoundException ex) {
        log.info("NotFoundException: {}", ex.getLocalizedMessage());
        return new ResponseEntity<>(ErrorsDto.builder()
                .errors(List.of(
                        ErrorDto.builder()
                                .code(String.valueOf(HttpStatus.NOT_FOUND.value()))
                                .message(ex.getMessage())
                                .level(LevelEnumDto.ERROR)
                                .build()))
                .build(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handle internal server error response entity. 500
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<ErrorsDto> handleInternalServerError(InternalServerErrorException ex) {
        log.error("InternalServerErrorException: {}", ex.getLocalizedMessage());
        return new ResponseEntity<>(ErrorsDto.builder()
                .errors(List.of(
                        ErrorDto.builder()
                                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))  // Código 500
                                .message(ex.getMessage())
                                .level(LevelEnumDto.ERROR)
                                .build()))
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
