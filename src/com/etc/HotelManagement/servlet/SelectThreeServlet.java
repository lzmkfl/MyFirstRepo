package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.dto.CiRCuThree;
import com.etc.HotelManagement.service.CheckInService;

@WebServlet("/SelectThreeServlet")
public class SelectThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckInService service = new CheckInService();
		List<CiRCuThree> list = service.selectThree();
		request.setAttribute("list", list);
        request.getRequestDispatcher("czy_user/returnPay.jsp").forward(request, response); 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
        
	}

}


