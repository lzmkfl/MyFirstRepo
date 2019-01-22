package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Customer;
import com.etc.HotelManagement.entity.HotelAdmin;
import com.etc.HotelManagement.entity.Waiter;
import com.etc.HotelManagement.service.UserService;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String pwdS = request.getParameter("pwd2");
		String roleS = request.getParameter("role");
		int role = 0;
		UserService service = new UserService();
		if (roleS != null && !roleS.equals("")) {
			role = Integer.parseInt(roleS);
		}
		int count = 0;
		String result = "";
		if (role == 1) {
			Customer cu = new Customer();
			cu.setCuName(userName);
			cu.setPassword(pwdS);
			count = service.CuRegister(cu);
			if (count != 0) {
				result = "恭喜您成功注册为普通用户";
			}

		} else if (role == 2) {
			HotelAdmin ha = new HotelAdmin();
			ha.setHaName(userName);
			ha.setPassword(pwdS);
			count = service.HARegister(ha);
			if (count != 0) {
				result = "恭喜您成功注册为管理员";
			}
		} else if (role == 3) {
			Waiter wt = new Waiter();
			wt.setwName(userName);
			wt.setPassword(pwdS);
			count = service.WaRegister(wt);
			if (count != 0) {
				result = "恭喜您成功注册为前台服务人员";
			}
		} else {
			result = "恭喜您注册失败，请选择您的身份,并重新注册";
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
