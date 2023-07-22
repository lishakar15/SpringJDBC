package com.additi.Dao;

import com.additi.Entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate jdbcTemplate;

    public int insert(Student s) {
        String insertQuery = "insert into student values (?,?,?)";
        int r = this.jdbcTemplate.update(insertQuery,s.getId(),s.getCity(),s.getName());
        return r;
    }

    public int updateDataById(Student s) {
        String updateQuery = "update student set name = ?,city =? where id = ?";
        int r = this.jdbcTemplate.update(updateQuery,s.getName(),s.getCity(),s.getId());

        return r;
    }

    public int deleteDataById(int id) {
        String deleteQuery = "delete from student where id =?";
        int r = this.jdbcTemplate.update(deleteQuery,id);
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
