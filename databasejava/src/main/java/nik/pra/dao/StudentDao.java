package nik.pra.dao;

import java.util.List;

import nik.pra.model.Student;

public interface StudentDao {
	public int insert(int id, String name);

	public int update(int id, String name);

	public int delete(int id);
	
	public List<Student> getall();
}
