package com.additi.Dao;

import com.additi.Entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public int insert(Student s) {
        String insertQuery = "insert into student values (?,?,?)";
        int r = this.jdbcTemplate.update(insertQuery,s.getId(),s.getName(),s.getCity());
        return r;
    }

    /**
     * Getter method
     * @return
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * Setter method
     * @param jdbcTemplate
     */
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
