package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Waiter;
import com.etc.HotelManagement.service.UserService;

@WebServlet("/CheckOPServlet")
public class CheckOPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String oldPwd1 = request.getParameter("oldPwd");
          UserService service = new UserService();
          Waiter w = (Waiter) request.getSession().getAttribute("waiter");
          PrintWriter out = response.getWriter();
          int wId = w.getwId();
          String oldpwd2 = service.selectPwd(wId);
          if(!oldPwd1.equals(oldpwd2)) {
        	  out.println("原密码不正确");
          }else {
        	  out.println("√");
          }	
          out.flush();
          out.close();
          
          
          }

}
