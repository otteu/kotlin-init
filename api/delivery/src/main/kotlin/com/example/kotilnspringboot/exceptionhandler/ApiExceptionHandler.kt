package com.example.kotilnspringboot.exceptionhandler

import com.example.common.api.Api
import com.example.common.error.ErrorCode
import com.example.common.exception.ApiException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
@Order(value = Int.MIN_VALUE) // 최우선처리
class ApiExceptionHandler {

    val logger: Logger = LoggerFactory.getLogger(ApiExceptionHandler::class.java)

    @ExceptionHandler(value = [ApiException::class])
    fun apiException(apiException: ApiException): ResponseEntity<Api<Any>> {
        logger.error("ApiExceptionHandler error", apiException)

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Api.ERROR(ErrorCode.SERVER_ERROR))
    }
}