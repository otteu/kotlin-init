package com.example.kotilnspringboot.config.jpa

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan(basePackages = ["com.example.deliverydb.domain"])
@EnableJpaRepositories(basePackages = ["com.example.deliverydb.repository"])
class JpaConfig { }