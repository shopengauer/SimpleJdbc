package ru.matritca.SimpleJdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = "ru.matritca.SimpleJdbc.*")
public class SimpleJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleJdbcApplication.class, args);
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/test");
        ds.setUsername("sa");
        ds.setPassword("");
        ds.setInitialSize(5);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }


}
