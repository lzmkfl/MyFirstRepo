package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.service.RoomService;

@WebServlet("/DeleRoomDServlet")
public class DeleRoomDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rdIdS = request.getParameter("rdId");
		int rdId =0;
		if(rdIdS != null && !rdIdS.equals("")) {
			rdId = Integer.parseInt(rdIdS);
		}
		RoomService service = new RoomService();
		int count = service.deleRoomD(rdId);
		if(count!= 0) {
			request.setAttribute("result", "删除成功");
		}else {
			request.setAttribute("result", "删除失败");
		}
		request.getRequestDispatcher("czy_user/roomCheck.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
        
	}

}


