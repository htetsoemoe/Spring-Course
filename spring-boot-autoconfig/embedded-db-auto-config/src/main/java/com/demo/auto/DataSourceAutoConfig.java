package com.demo.auto;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration //must be configuration file
@EnableTransactionManagement // for using @Transactional
@ConditionalOnClass({org.hsqldb.Database.class}) // if hsqldb is exit, the following Bean will work, there's no hsqldb it will not work
public class DataSourceAutoConfig {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .addScript("embedded-database-schema.sql")
                .addScript("embedded-database-data.sql")
                .build();
    }

}
