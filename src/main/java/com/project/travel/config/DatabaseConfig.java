package com.project.travel.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.project.travel.repository")
@EnableTransactionManagement
public class DatabaseConfig {
}
