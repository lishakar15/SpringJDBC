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
		Student s = new Student(3,"Mano","Delhi");
		int n = studentDao.insert(s);
		System.out.println("Number of rows insertedd :"+n);
	}

}
