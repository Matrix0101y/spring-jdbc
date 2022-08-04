package az.spring.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "az.spring.jdbc")
public class SpringJdbcConfig {

    @Bean
    public DataSource dataSource(DatabaseConfig databaseConfig){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(databaseConfig.getDriverClassName());
        driverManagerDataSource.setUrl(databaseConfig.getUrl());
        driverManagerDataSource.setUsername(databaseConfig.getUsername());
        driverManagerDataSource.setPassword(databaseConfig.getPassword());

        return driverManagerDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
