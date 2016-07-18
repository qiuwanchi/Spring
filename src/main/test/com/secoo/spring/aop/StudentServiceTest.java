package com.secoo.spring.aop;

import java.util.logging.Logger;

import org.junit.Test;

import com.secoo.spring.jdbc.service.StudentService;

public class StudentServiceTest {

	public static Logger logger = Logger.getLogger(StudentServiceTest.class.getName());
	
	@Test
	public void test() {

		StudentService studentService = (StudentService) SpringUtil.getBean("studentService");
		logger.info("------Records Creation--------");
		studentService.insert();

	}
}
