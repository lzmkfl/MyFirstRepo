package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.CheckIn;
import com.etc.HotelManagement.service.CheckInService;

@WebServlet("/CheckInServlet")
public class CheckInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cuName = request.getParameter("cuName");
		String idNum = request.getParameter("idNum");
		String rNoS = request.getParameter("rNo");
		int rNo = 0;
		if (rNoS != null && !rNoS.equals("")) {
			rNo = Integer.parseInt(rNoS);
		}
		String phoneNum = request.getParameter("phoneNum");
		String remarks = request.getParameter("remarks");
		// 判断是否预定
		CheckInService service = new CheckInService();
		int[] a = service.judgeReserve(cuName, idNum);
		Double total_price = service.selectTotalPrice(cuName, idNum);
		if (a[0] != 0 && a[1] != 0) {
			// 若预定，则删除预定表中的内容
			CheckIn ci = new CheckIn();
			ci.setCheck_Date(new Date());
			ci.setrNo(rNo);
			ci.setRemarks(remarks);
			ci.setPhoneNum(phoneNum);
			ci.setrId(a[0]);
			ci.setCuId(a[1]);
			ci.setCuName(cuName);
			ci.setTotalprice(total_price);
			int count = service.ManageCheckIn(ci, cuName, idNum);
			if (count != 0) {
				request.setAttribute("result", "办理入住成功");
			} else {
				request.setAttribute("result", "办理入住失败");
			}
			System.out.println(request.getAttribute("result"));
			request.getRequestDispatcher("czy_user/result.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
