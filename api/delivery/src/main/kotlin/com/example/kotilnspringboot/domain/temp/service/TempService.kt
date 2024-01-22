package com.example.kotilnspringboot.domain.temp.service

import com.example.deliverydb.domain.temp.TempEntity
import com.example.deliverydb.repository.TempRepository
import org.springframework.stereotype.Service


@Service
class TempService (
    private val tempRepository: TempRepository
){

    fun temeSave(tempEntity: TempEntity): TempEntity {
        return tempRepository.save(tempEntity)
    }

}