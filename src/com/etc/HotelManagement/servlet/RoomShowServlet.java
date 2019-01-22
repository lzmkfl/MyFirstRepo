package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Room;
import com.etc.HotelManagement.service.RoomService;

@WebServlet("/RoomShowServlet")
public class RoomShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoomService service = new RoomService();
		List<Room> list = service.getRooms();
		request.setAttribute("list", list);
		request.getRequestDispatcher("pt_user/Rooms.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
