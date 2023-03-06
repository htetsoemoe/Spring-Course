package com.demo.db;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ConditionalOnClass({org.hsqldb.jdbc.JDBCDriver.class})
public class HsqlAutoConfig {
    @Bean
    public DataSource dataSource() throws SQLException {
        EmbeddedDatabase embeddedDatabase = new EmbeddedDatabaseBuilder()
                .addScript("hsql-schema.sql")
                .addScript("hsql-data.sql")
                .build();

        return new SingleConnectionDataSource(embeddedDatabase.getConnection(),
                false);
    }
}
