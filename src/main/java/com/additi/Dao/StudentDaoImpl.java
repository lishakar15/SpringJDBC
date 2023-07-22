package com.additi.Dao;

import com.additi.Entities.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public Student getStudentById(int id) {
        String query = "select * from student where id =?";
        RowMapper<Student> rowMapper = new StudentRowMapperImpl();
        Student s = this.jdbcTemplate.queryForObject(query,rowMapper,id);
        return s;
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "Select * from student";
        RowMapper<Student> rowMapper = new StudentRowMapperImpl();
        List<Student> students = this.jdbcTemplate.query(sql,rowMapper);
        return students;
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
