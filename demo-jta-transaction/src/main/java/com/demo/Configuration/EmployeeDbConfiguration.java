package com.demo.Configuration;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.demo.db.employees.dao"},
        entityManagerFactoryRef = "employeeEntityManagerFactory"
)
public class EmployeeDbConfiguration {
    @Bean
    @Autowired
    public LocalContainerEntityManagerFactoryBean employeeEntityManagerFactory(DataSource employeesDataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setJtaDataSource(employeesDataSource);
        em.setPackagesToScan("com.demo.db.employees.entities");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    // create employeesDataSource object first! 1.
    @Bean
    public DataSource employeesDataSource() throws SQLException {
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        mysqlXADataSource.setUser("root");
        mysqlXADataSource.setPassword("admin");
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        // add MySQl datasource to Jta Third-Party Library
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("employeesDb");
        return atomikosDataSourceBean;
    }
}
