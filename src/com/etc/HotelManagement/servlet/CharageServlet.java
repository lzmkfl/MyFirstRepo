package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Customer;
import com.etc.HotelManagement.service.UserService;

/**
 * Servlet implementation class CharageServlet
 */
@WebServlet("/CharageServlet")
public class CharageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String moneyS = request.getParameter("money");
          Double money = 0.0;
          if(moneyS != null && !moneyS.equals("")) {
        	  money = Double.parseDouble(moneyS);
          }
          Customer cu = (Customer) request.getSession().getAttribute("customer");
          UserService service = new UserService();
          int count = service.updateBalance(money,cu);
          if(count != 0) {
        	  request.setAttribute("result", "充值成功");
        	  request.getRequestDispatcher("pt_user/index.jsp").forward(request, response);
          }else {
        	  request.setAttribute("result", "充值失败");
        	  request.getRequestDispatcher("pt_user/index.jsp").forward(request, response);
          }
	}

}
