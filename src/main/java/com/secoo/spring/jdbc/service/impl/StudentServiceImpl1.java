package com.secoo.spring.jdbc.service.impl;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.secoo.spring.jdbc.dao.StudentDao;
import com.secoo.spring.jdbc.service.StudentService;

public class StudentServiceImpl1 implements StudentService {

	private PlatformTransactionManager txManager;

	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public PlatformTransactionManager getTxManager() {
		return txManager;
	}

	public void setTxManager(PlatformTransactionManager txManager) {
		this.txManager = txManager;
	}

	@Override
	public void insert() {
		
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		TransactionStatus status = txManager.getTransaction(def);

		try {
			studentDao.create("qiuwanchi", 27);
			studentDao.create("qiuwanchi2", 28);

			if (true) {
				throw new Exception();
			}
			txManager.commit(status);
		} catch (Exception e) {
			txManager.rollback(status);
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
