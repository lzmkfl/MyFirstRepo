package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Employee;
import com.etc.HotelManagement.service.AdminService;

@WebServlet("/SelectEmpServlet")
public class SelectEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminService service = new AdminService();
		List<Employee> list = service.selectEmplyee();
		request.setAttribute("list", list);
		request.getRequestDispatcher("gly_user/employCheck.jsp").forward(request, response);
	}

}
