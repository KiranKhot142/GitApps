package com.csi.basics;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {
	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setEmpName("Mahesh");
		employee.setEmpSalary(24345.26);
		session.save(employee);
		transaction.commit();
		
		getAllData();

	}
	static void getAllData(){
		Session session = factory.openSession();
		
		List<Employee> empList = session.createQuery("from Employee").list();
		
		empList.forEach(System.out:: println);
		
	}
}
