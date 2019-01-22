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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service = new UserService();
		String name = request.getParameter("userName");
		String pwd = request.getParameter("pwd");
		String roleS = request.getParameter("role");
		int role = 0;
		if (roleS != null) {
			role = Integer.parseInt(roleS);
		}
		if (role != 0) {
				if (role == 1) {
					Customer cu = service.CustomerLogin(name, pwd);
					if(cu != null) {
						request.setAttribute("result", "恭喜用户" + name + "登录成功");
						request.getSession().setAttribute("customer", cu);
						request.getRequestDispatcher("pt_user/Services.jsp").forward(request, response);
					}else {
						request.setAttribute("result", "可惜用户" + name + "登录失败");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				} else if (role == 2) {
					HotelAdmin admin = service.AdminLogin(name, pwd);
					if(admin != null) {
						request.setAttribute("result", "恭喜管理员" + name + "登录成功");
						request.getSession().setAttribute("admin", admin);
						request.getRequestDispatcher("gly_user/base.jsp").forward(request, response);
					}else {
						request.setAttribute("result", "可惜管理员" + name + "登录失败");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
					
				} else if (role == 3) {
					Waiter w = service.WatierLogin(name, pwd);
					if(w != null) {
						request.setAttribute("result", "恭喜操作员" + name + "登录成功");
						request.getSession().setAttribute("waiter", w);
						request.getRequestDispatcher("czy_user/base.jsp").forward(request, response);
					}else {
						request.setAttribute("result", "可惜操作员" + name + "登录失败");
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}

			
		} else {
			request.setAttribute("result", "请选择您的登录身份");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
