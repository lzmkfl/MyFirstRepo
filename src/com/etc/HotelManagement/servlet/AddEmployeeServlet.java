package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Employee;
import com.etc.HotelManagement.service.AdminService;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eName = request.getParameter("eName");
		String sex = request.getParameter("sex");
		String ageS = request.getParameter("age");
		int age = 0;
		if (ageS != null && !ageS.equals("")) {
			age = Integer.parseInt(ageS);
		}
		String duty = request.getParameter("duty");
		String experience = request.getParameter("experience");
		Employee emp = new Employee();
		emp.seteName(eName);
		emp.setAge(age);
		emp.setDuty(duty);
		emp.setExperience(experience);
		emp.setSex(sex);
		AdminService service = new AdminService();
        int count = service.addEmployee(emp);
        if(count != 0) {
        	request.setAttribute("result", "添加成功");
        }else {
        	request.setAttribute("result", "添加失败");
        }
        request.getRequestDispatcher("SelectEmpServlet").forward(request, response);
        
	}

}
