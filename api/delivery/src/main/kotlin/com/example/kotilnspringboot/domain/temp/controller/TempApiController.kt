package com.example.kotilnspringboot.domain.temp.controller

import com.example.deliverydb.domain.temp.TempEntity
import com.example.kotilnspringboot.domain.temp.service.TempService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/temp")
class TempApiController (
  private val tempService: TempService
){

    @GetMapping("")
    fun temp(): String {

        var tempEntity = TempEntity(
           name = "hello"
        )

        tempService.temeSave(tempEntity)

        return "hello kotlin sprint boot"
    }

}