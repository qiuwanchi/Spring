package com.secoo.spring.jdbc;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;

import com.secoo.spring.jdbc.dao.impl.StudentJDBCTemplate;
import com.secoo.spring.jdbc.entity.Student;

public class StudentDaoTest {

	public static Logger logger = Logger.getLogger(StudentDaoTest.class.getName());

	@Test
	public void test() {

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) SpringUtil.getBean("studentDao");
		logger.info("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);

		logger.info("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student record : students) {
			logger.info("ID : " + record.getId());
			logger.info(", Name : " + record.getName());
			logger.info(", Age : " + record.getAge());
		}

		logger.info("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);

		logger.info("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.getStudent(2);
		logger.info("ID : " + student.getId());
		logger.info(", Name : " + student.getName());
		logger.info(", Age : " + student.getAge());

	}
}
