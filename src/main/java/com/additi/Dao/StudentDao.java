package com.additi.Dao;

import com.additi.Entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student s);

    public int updateDataById(Student s);

    public int deleteDataById(int id);

    public Student getStudentById(int id);

    public List<Student> getAllStudents();

    public List<String> getAllStudentCities();

}
