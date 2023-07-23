package com.additi;

import com.additi.Dao.StudentDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean("ds")
    public DataSource getDataSource()
    {
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
        managerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        managerDataSource.setUrl("jdbc:mysql://localhost:3306/myhibernatedb");
        managerDataSource.setUsername("root");
        managerDataSource.setPassword("Lisha@1571");
        return managerDataSource;
    }
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        //If not using constructor then setter can be used
        //jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }
    @Bean("StudentDaoImplObj")
    public StudentDaoImpl getStudentDao()
    {
        StudentDaoImpl s = new StudentDaoImpl();
        s.setJdbcTemplate(getJdbcTemplate());
        return s;
    }
}
