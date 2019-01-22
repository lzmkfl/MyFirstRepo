package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.service.RoomService;



@WebServlet("/SelectRNoByNpServlet")
public class SelectRNoByNpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String  cuName = request.getParameter("cuName");
		String  phoneNum = request.getParameter("phoneNum");
		String  rNoS = request.getParameter("rNo");
		int rNoPage = 1;
		if(rNoS != null && !rNoS.equals("")) {
			rNoPage = Integer.parseInt(rNoS);
		}
		RoomService service = new RoomService();
		int rNo = service.selectRNoByNP(cuName,phoneNum);
		PrintWriter out = response.getWriter();
		
		if(rNo == rNoPage) {
			out.println("房间号正确");
		}else {
			out.println("房间号错误");
		}
        out.flush();
        out.close();
	}

}

