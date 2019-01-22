package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.service.RoomService;

@WebServlet("/SelectRNoServlet")
public class SelectRNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String rNoS = request.getParameter("rNo");
		int rNo = 0;
		if (rNoS != null && !rNoS.equals("")) {
			rNo = Integer.parseInt(rNoS);
		}
		RoomService service = new RoomService();
		PrintWriter out = response.getWriter();
		Boolean flag = service.selectRNo(rNo);
		if (flag) {
			out.println("房间号正确");
		} else {
			out.println("没有此房间号");
		}
		out.flush();
		out.close();

	}

}
