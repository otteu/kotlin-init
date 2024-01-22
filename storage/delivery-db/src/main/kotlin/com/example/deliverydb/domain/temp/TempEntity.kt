package com.example.deliverydb.domain.temp

import jakarta.persistence.*

@Entity
@Table(name = "temps")
data class TempEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,

    @Column(name = "name")
    var name: String = "",
)