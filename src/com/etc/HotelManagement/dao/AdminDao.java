package com.etc.HotelManagement.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HotelManagement.entity.Employee;

public class AdminDao extends BaseDao{

	public List<Employee> selectEmployee() throws SQLException {
		String sql = "select * from employee";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		List<Employee> list = new ArrayList<>();
		Employee emp = null;
		while(rsResultSet.next()) {
			emp = new Employee();
			emp.seteId(rsResultSet.getInt(1));
			emp.setExperience(rsResultSet.getString(2));
			emp.setSex(rsResultSet.getString(3));
			emp.setAge(rsResultSet.getInt(4));
			emp.setDuty(rsResultSet.getString(5));
			emp.setExperience(rsResultSet.getString(6));
			list.add(emp);
		}
		return list;
	}

	public int InsertEmp(Employee emp) throws SQLException {
		String sql = "INSERT INTO employee(eName,sex,age,duty,experience) VALUES (?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, emp.geteName());
		ps.setString(2, emp.getSex());
		ps.setInt(3, emp.getAge());
		ps.setString(4, emp.getDuty());
		ps.setString(5, emp.getExperience());
		int count = ps.executeUpdate();
		
		return count;
	}

}















