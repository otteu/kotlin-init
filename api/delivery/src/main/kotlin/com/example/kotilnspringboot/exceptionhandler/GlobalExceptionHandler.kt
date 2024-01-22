package com.example.kotilnspringboot.exceptionhandler

import com.example.common.api.Api
import com.example.common.error.ErrorCode
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Order(value = Int.MAX_VALUE)
class GlobalExceptionHandler {

    val logger: Logger = LoggerFactory.getLogger(ApiControllerAdvice::class.java)

    @ExceptionHandler(value = [Exception::class])
    fun exception(exception: Exception?): ResponseEntity<Api<Any>> {
        logger.error("", exception)
        return ResponseEntity
                .status(500)
                .body(Api.ERROR(ErrorCode.SERVER_ERROR))
    }
}