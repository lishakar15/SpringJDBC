package com.additi;
import com.additi.Dao.StudentDao;
import com.additi.Dao.StudentDaoImpl;
import com.additi.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {
	public static void main(String[] args) {
		//For xml based coniguration
		//ApplicationContext applicationContext= new ClassPathXmlApplicationContext("config.xml");
		//For Annotation based configuration
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		StudentDao studentDao = applicationContext.getBean("StudentDaoImplObj", StudentDaoImpl.class);
		//insert
		Student s = new Student(21,"Roma","Hydrabad");
		int n = studentDao.insert(s);
		System.out.println("Number of rows inserted :"+n);

		//update
		Student s1 = new Student(3,"Raja","Kerala");
		int n1 = studentDao.updateDataById(s1);
		System.out.println("Number of rows updated :"+n1);
		
		//Delete
		int n2 = studentDao.deleteDataById(4);
		System.out.println("Number of rows deleted :"+n2);

		//get Student By id
		Student student = studentDao.getStudentById(1);
		System.out.println("Student details "+student.toString());

		//get all the students list
		List<Student> studentList = studentDao.getAllStudents();
		for (Student student1 : studentList) {
			System.out.println(student1.toString());
		}

		//fetch all students cities as a list
		List<String> citList = studentDao.getAllStudentCities();
		for (String city : citList)
		{
			System.out.println(city);
		}
	}

}
