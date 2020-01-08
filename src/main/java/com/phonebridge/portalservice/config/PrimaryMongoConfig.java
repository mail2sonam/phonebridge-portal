package com.phonebridge.portalservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.phonebridge.portalservice.repo.primary",
        mongoTemplateRef = "primaryMongoTemplate")
public class PrimaryMongoConfig {

}

