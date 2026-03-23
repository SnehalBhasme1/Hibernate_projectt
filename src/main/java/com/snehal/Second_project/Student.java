package com.snehal.Second_project;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	public Student() {
		super();
	}
	@Column
	String name;
	@Column
	int marks;
	public Student(int id, String name, int marks) {
		super();
		
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, marks, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id && marks == other.marks && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}
	

}
