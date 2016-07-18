package com.secoo.spring.jdbc.dao;

import java.util.List;

import com.secoo.spring.jdbc.entity.Student;

public interface StudentDao {

	public void create(String name, Integer age);

	public Student getStudent(Integer id);

	public List<Student> listStudents();

	public void delete(Integer id);

	public void update(Integer id, Integer age);
}
