package com.additi;
import com.additi.Dao.StudentDao;
import com.additi.Dao.StudentDaoImpl;
import com.additi.Entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
	public static void main(String[] args) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = applicationContext.getBean("StudentDaoImplObj", StudentDaoImpl.class);
		//insert
		Student s = new Student(2,"Paul","Delhi");
		int n = studentDao.insert(s);
		System.out.println("Number of rows inserted :"+n);

		//update
		Student s1 = new Student(3,"Raja","Kerala");
		int n1 = studentDao.updateDataById(s1);
		System.out.println("Number of rows updated :"+n1);
		
		//Delete
		int n2 = studentDao.deleteDataById(4);
		System.out.println("Number of rows deleted :"+n2);
	}

}
