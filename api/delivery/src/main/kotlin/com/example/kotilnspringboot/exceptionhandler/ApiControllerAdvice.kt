package com.example.kotilnspringboot.exceptionhandler

import com.example.common.api.Api
import com.example.common.error.ErrorCode
import com.example.kotilnspringboot.config.filter.LoggerFilter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiControllerAdvice {

    val logger: Logger = LoggerFactory.getLogger(ApiControllerAdvice::class.java)

    @ExceptionHandler(value = [BindException::class])
    fun exception(exception: BindException): ResponseEntity<Api<Any>> {
        logger.error("BindExceptionHandler error", exception)
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(exception.bindingResult.allErrors[0].defaultMessage?.let {
                    Api.ERROR(
                            ErrorCode.PARAMETER_NO_VALIDATION,
                            it)
                    }
                )
    }
}