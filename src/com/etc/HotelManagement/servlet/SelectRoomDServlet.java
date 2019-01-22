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



@WebServlet("/SelectRoomDServlet")
public class SelectRoomDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RoomService service = new RoomService();
		//给jsp赋予page,next,up
		String p = request.getParameter("page") == null ? "1" : request.getParameter("page");
		int page = Integer.parseInt(p);
		request.setAttribute("page", page);
		request.setAttribute("next", page+1);
        request.setAttribute("up", page-1);
        //给jsp赋予总页码
         int countAll = service.selectCountAll(5);
         request.setAttribute("countAll", countAll);
//         System.out.println(request.getAttribute("countAll"));
         //根据页码查出数据并返回list
         int offset = (page-1) *5;
		List<RoomDetail> list = service.selectRoomDetail(offset,5);		
		request.setAttribute("list", list);
        request.getRequestDispatcher("czy_user/roomCheck.jsp").forward(request, response);
	}

}

