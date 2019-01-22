package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.RoomDetail;
import com.etc.HotelManagement.service.RoomService;

@WebServlet("/AddRoomDetailServlet")
public class AddRoomDetailServlet extends HttpServlet {
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
		String type = request.getParameter("type");
		String state = request.getParameter("state");
		String remarks = request.getParameter("remarks");
		RoomDetail rd = new RoomDetail();
		rd.setrNo(rNo);
		rd.setRemarks(remarks);
		rd.setState(state);
		rd.setType(type);
		RoomService service = new RoomService();
		int count = service.insertRoomDetail(rd);
		if (count != 0) {
			request.setAttribute("result", "新增房间成功");
		} else {
			request.setAttribute("result", "新增房间失败");
		}
		request.getRequestDispatcher("SelectRoomDServlet").forward(request, response);
	}

}
