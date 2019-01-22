package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.RoomDetail;
import com.etc.HotelManagement.service.RoomService;

@WebServlet("/SelectByTServlet")
public class SelectByTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		String state = new String(request.getParameter("state").getBytes("ISO-8859-1"),"UTF-8");
		String rNoS = new String(request.getParameter("rNo").getBytes("ISO-8859-1"),"UTF-8");
		int rNo = 0;
		if(rNoS != null && !rNoS.equals("")) {
			rNo = Integer.parseInt(rNoS);
		}else {
			rNo = -1;
		}
		RoomService service = new RoomService();
		List<RoomDetail> list = service.selectByThree(type,state,rNo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("czy_user/roomCheck.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
        
	}

}


