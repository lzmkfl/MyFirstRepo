package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.RoomDetail;
import com.etc.HotelManagement.service.RoomService;

@WebServlet("/AlterRoomDServlet")
public class AlterRoomDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String type = request.getParameter("type");
		String state = request.getParameter("state");
		String remarks = request.getParameter("remarks");
		String rNoS = request.getParameter("rNo");
		int rNo = 0;
		if(rNoS != null && !rNoS.equals("")) {
			rNo = Integer.parseInt(rNoS);
		}
		String rIdS = request.getParameter("rId");
		int rId = 0;
		if(rIdS != null && !rIdS.equals("")) {
			rId = Integer.parseInt(rIdS);
		}
		String rdIdS = request.getParameter("rdId");
		int rdId = 0;
		if(rdIdS != null && !rdIdS.equals("")) {
			rdId = Integer.parseInt(rdIdS);
		}
		RoomDetail detail = new RoomDetail();
		detail.setType(type);
		detail.setRdId(rdId);
		detail.setRemarks(remarks);
		detail.setrId(rId);
		detail.setrNo(rNo);
		detail.setState(state);
        RoomService service = new RoomService();
        int count = service.updateRoomDetail(detail);
        if(count!= 0) {
        	request.setAttribute("resulst", "更新成功");
        }else {
        	request.setAttribute("resulst", "更新失败");
        }
		request.getRequestDispatcher("czy_user/roomCheck.jsp").forward(request, response);
        
	}

}
