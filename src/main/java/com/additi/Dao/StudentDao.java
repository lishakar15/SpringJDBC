package com.additi.Dao;

import com.additi.Entities.Student;

public interface StudentDao {
    public int insert(Student s);

    public int updateDataById(Student s);

    public int deleteDataById(int id);

}
