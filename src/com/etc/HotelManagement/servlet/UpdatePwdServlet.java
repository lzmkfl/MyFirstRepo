package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Waiter;
import com.etc.HotelManagement.service.UserService;

@WebServlet("/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
		String newPwd = request.getParameter("newPwd");
         UserService service = new UserService();
         Waiter w = (Waiter) request.getSession().getAttribute("waiter");
         int wId = w.getwId();
         int count = 0;
         if(newPwd!= null && !newPwd.equals("")) {
        	 count = service.updatePwd(newPwd,wId);
        	 if(count != 0) {
        		 request.setAttribute("result", "密码修改成功");
        	 }else {
        		 request.setAttribute("result", "密码修改失败");
        	 }
         }else {
        	 request.setAttribute("result", "请按照提示修改");
         }
         request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
