package com.etc.HotelManagement.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.dto.CiRCuThree;
import com.etc.HotelManagement.service.CheckInService;

@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ciIdS = request.getParameter("ciId");
		int ciId = 0;
		if (ciIdS != null && !ciIdS.equals("")) {
			ciId = Integer.parseInt(ciIdS);
		}
		String cuIdS = request.getParameter("cuId");
		int cuId = 0;
		if (cuIdS != null && !cuIdS.equals("")) {
			cuId = Integer.parseInt(cuIdS);
		}
		String rIdS = request.getParameter("rId");
		int rId = 0;
		if (rIdS != null && !rIdS.equals("")) {
			rId = Integer.parseInt(rIdS);
		}
		String rNoS = request.getParameter("rNo");
		int rNo = 0;
		if (rNoS != null && !rNoS.equals("")) {
			rNo = Integer.parseInt(rNoS);
		}
		String totalpriceS = request.getParameter("totalprice");
		double totalprice = 0.0;
		if (totalpriceS != null && !totalpriceS.equals("")) {
			totalprice = Double.parseDouble(totalpriceS);
		}
		CiRCuThree crt = new CiRCuThree();
		crt.setCiId(ciId);
		crt.setCuId(cuId);
		crt.setrId(rId);
		crt.setrNo(rNo);
		crt.setTotalprice(totalprice);

		CheckInService service = new CheckInService();
		int count = service.checkOut(crt);
		if (count != 0) {
			request.setAttribute("result", "退房成功");
		} else {
			request.setAttribute("result", "退房失败");
		}
		request.getRequestDispatcher("czy_user/result.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

	}

}
