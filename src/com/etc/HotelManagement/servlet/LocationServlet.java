package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Customer;

@WebServlet("/LocationServlet")
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String day_priceS = request.getParameter("day_price");
          String typeL = request.getParameter("type");
          String type = new String(typeL.getBytes("ISO-8859-1"),"UTF-8");
//          System.out.println(type);
          Customer cu = (Customer) request.getSession().getAttribute("customer");
          String rId = request.getParameter("rId");
          double day_price = 0.0;
          if(day_priceS != null && !day_priceS.equals("")) {
        	  day_price = Double.parseDouble(day_priceS);
          }
          request.setAttribute("day_price", day_price);
          request.setAttribute("type", type);
          request.setAttribute("rId", rId);
          request.getRequestDispatcher("pt_user/locations.jsp?cuId="+cu.getCuid()).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
