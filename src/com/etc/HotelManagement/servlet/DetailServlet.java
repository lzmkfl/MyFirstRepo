package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.RoomDetail;
import com.etc.HotelManagement.service.RoomService;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rdIdS = request.getParameter("rdId");
		if(rdIdS != null && !rdIdS.equals("")) {
			int rdId = Integer.parseInt(rdIdS);
			RoomService service = new RoomService();
			RoomDetail rd = service.selectRoomDByRdId(rdId);
			if(rd!= null) {
				request.setAttribute("roomDetail", rd);
			}else {
				request.setAttribute("result", "数据库没有这个房间了");
			}
			request.getRequestDispatcher("czy_user/roomCheck-form.jsp").forward(request, response);
		}else {
			System.out.println("rdId为空天下不乱？");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
        
	}

}


