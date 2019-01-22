package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.service.RoomService;

@WebServlet("/ChangeRoomServlet")
public class ChangeRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cuName = request.getParameter("cuName");
		String phoneNum = request.getParameter("phoneNum");
		String currentRNoS = request.getParameter("currentRNo");
		int currentRNo = 0;
		String remarks = request.getParameter("remarks");
		if (currentRNoS != null && !currentRNoS.equals("")) {
			currentRNo = Integer.parseInt(currentRNoS);
			RoomService service = new RoomService();
			int count = service.updateRNo( cuName, phoneNum,currentRNo,remarks);
			if(count != 0) {
				request.setAttribute("result", "调换房间成功");
			}else {
				request.setAttribute("result", "调换房间失败");
			}
			request.getRequestDispatcher("czy_user/result.jsp").forward(request, response);
		}else {
			System.out.println("房间号输入为空");
		}
	}

}
