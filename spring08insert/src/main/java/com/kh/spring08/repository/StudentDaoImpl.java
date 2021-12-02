package com.kh.spring08.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.kh.spring08.entity.StudentDto;


public class StudentDaoImpl implements StudentDao{

	@Override
	public void insert(StudentDto studentDto) throws Exception {
		System.out.println("StudentDaoImpl");
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");

		String sql = "insert into student values(student_seq.nextval, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, studentDto.getName());
		ps.setInt(2, studentDto.getScore());
		ps.execute();

		con.close();
	}

}
