package com.imadiaos.springbootjpa.data.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.imadiaos.springbootjpa.data.repo"})
@EntityScan(basePackages = "com.imadiaos.springbootjpa.data.model")
public class JpaConfig {
}
