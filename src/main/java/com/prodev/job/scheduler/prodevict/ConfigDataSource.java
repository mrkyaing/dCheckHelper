package com.prodev.job.scheduler.prodevict;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConfigDataSource {
    @Bean
    public static DataSource source()
    {
        DataSourceBuilder<?> dSB = DataSourceBuilder.create();
        // MySQL specific url with database name
        dSB.url("jdbc:mysql://localhost:3306/d_check");
        // MySQL username credential
        dSB.username("root");
        // MySQL password credential
        dSB.password("root@123");
        return dSB.build();
    }
}