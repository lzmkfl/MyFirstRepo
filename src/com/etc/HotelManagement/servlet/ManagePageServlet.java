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

@WebServlet("/ManagePageServlet")
public class ManagePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p = request.getParameter("page") == null ? "0" : request.getParameter("page");
		int page = Integer.parseInt(p);
		RoomService service = new RoomService();
		int offset = (page - 1) * 5;
		List<RoomDetail> list = service.selectRoomDetail(offset, 5);
		request.setAttribute("list", list);
		request.setAttribute("next", page + 1);
		request.setAttribute("up", page - 1);
		request.setAttribute("page", page);
		int countAll = service.selectCountAll(5);
		request.setAttribute("countAll", countAll);
		request.getRequestDispatcher("czy_user/roomCheck.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
