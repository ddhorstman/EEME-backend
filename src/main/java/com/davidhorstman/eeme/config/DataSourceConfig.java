package com.davidhorstman.eeme.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${local.run.db:h2}")
    private String dbType;

    @Value("${spring.datasource.url:}")
    private String dbURL;

    @Bean
    public DataSource dataSource(){
        if(dbType.equalsIgnoreCase("POSTGRESQL")){
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("org.postgresql.Driver");
            config.setJdbcUrl(dbURL);
            return new HikariDataSource(config);
        } else {
            String urlString = "jdbc:mem:testdb";
            String driverClass = "org.h2.Driver";
            String dbUser = "sa";
            String password = "leaveitatdefault";
            return DataSourceBuilder.create()
                    .username(dbUser)
                    .password(password)
                    .url(urlString)
                    .driverClassName(driverClass)
                    .build();
        }
    }
}
