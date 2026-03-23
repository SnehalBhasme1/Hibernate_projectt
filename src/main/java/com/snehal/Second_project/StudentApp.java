package com.snehal.Second_project;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StudentApp {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("name,marks");
	Student s1 = new Student(sc.next(),sc.nextInt());
	Configuration config = new Configuration();
	config.configure("hibernate.cfg.xml");
	
	SessionFactory factory = config.buildSessionFactory();
	
	Session session = factory.openSession();
	
	Transaction transaction = session.beginTransaction();
	session.persist(s1);
		System.out.println("enter the id to be deleted");
	int idd = sc.nextInt();
	Student obj = session.get(Student.class, idd);
	if(obj != null) {
		session.remove(obj);
		System.out.println("deleted successfully");
	}
	else {
		System.out.println("not present");
	}
	
	System.out.println("enter id to update name and marks");
	int roll = sc.nextInt();
	Student objj=session.get(Student.class, roll);
	if(objj != null) {
		System.out.println("new name and marks");
		String newname = sc.next();
		int markss = sc.nextInt();
		objj.setName(newname);
		objj.setMarks(markss);
		session.merge(objj);
		System.out.println("updated successfully");
	}
	else {
		System.out.println("not present");
	}
	transaction.commit();
	session.close();
	factory.close();
	sc.close();
	
	
	}
}
