package com.etc.HotelManagement.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HotelManagement.dao.AdminDao;
import com.etc.HotelManagement.entity.Employee;
import com.etc.HotelManagement.utils.Log;

public class AdminService {
	AdminDao dao = new AdminDao();

	public List<Employee> selectEmplyee() {
		List<Employee> list = null;
         try {
        	dao.getCon();
			list = dao.selectEmployee();
		} catch (SQLException | ClassNotFoundException e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		}
		return list;
	}

	public int addEmployee(Employee emp) {
		int count = 0;
		try {
			dao.getCon();
			count = dao.InsertEmp(emp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return count;
	}

}
