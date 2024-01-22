package com.example.kotilnspringboot.config.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.util.*
import java.util.function.Consumer

@Component
class LoggerFilter : Filter {

    val logger: Logger = LoggerFactory.getLogger(LoggerFilter::class.java)

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {

        val req = ContentCachingRequestWrapper((request as HttpServletRequest?)!!)
        val res = ContentCachingResponseWrapper((response as HttpServletResponse?)!!)

        logger.info("INIT URI : {}", req.requestURI)

        chain!!.doFilter(req, res)


        // request 정보


        // request 정보
        val headerNames = req.headerNames
        val headerValues = StringBuilder()

        headerNames.asIterator().forEachRemaining { headerKey: String? ->
            val headerValue = req.getHeader(headerKey)

            // authorization-token : ??? , user-agent : ???
            headerValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ")
        }

        val requestBody = String(req.contentAsByteArray)
        val uri = req.requestURI
        val method = req.method

        logger.info(">>>>> uri : {} , method : {} , header : {} , body : {}", uri, method, headerValues, requestBody)


        // response 정보


        // response 정보
        val responseHeaderValues = StringBuilder()

        res.headerNames.forEach(Consumer { headerKey: String? ->
            val headerValue = res.getHeader(headerKey)
            responseHeaderValues
                    .append("[")
                    .append(headerKey)
                    .append(" : ")
                    .append(headerValue)
                    .append("] ")
        })

        val responseBody = String(res.contentAsByteArray)

        logger.info("<<<<< uri : {} , method : {} , header : {} , body : {}", uri, method, responseHeaderValues, responseBody)

        res.copyBodyToResponse()
    }
}