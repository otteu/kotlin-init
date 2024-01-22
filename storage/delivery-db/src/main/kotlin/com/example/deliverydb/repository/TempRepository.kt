package com.example.deliverydb.repository

import com.example.deliverydb.domain.temp.TempEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TempRepository : JpaRepository<TempEntity, Long> {

}