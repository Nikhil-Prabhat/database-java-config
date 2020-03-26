package nik.pra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import nik.pra.model.Student;

public class Studentrowmapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student st = new Student(rs.getInt(1), rs.getString(2));
		return st;
	}

}
