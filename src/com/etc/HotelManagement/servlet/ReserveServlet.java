package com.etc.HotelManagement.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.HotelManagement.entity.Customer;
import com.etc.HotelManagement.entity.Reserve;
import com.etc.HotelManagement.service.UserService;
import com.etc.HotelManagement.utils.Log;

@WebServlet("/ReserveServlet")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer cu = (Customer) request.getSession().getAttribute("customer");
		if (cu != null) {
			// 求出总价格

			String day_priceS = request.getParameter("day_price");
			double day_price = 0.0;
			if (day_priceS != null && !day_priceS.equals("")) {
				day_price = Double.parseDouble(day_priceS);
			}
			String checkInDateS = request.getParameter("checkInDate");
			String leaveDateS = request.getParameter("leaveDate");
			SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
			int cuId = cu.getCuid();
			Date checkInDate = null;
			Date leaveDate = null;
			int a = 0;
			if (checkInDateS != null && !checkInDateS.equals("") && leaveDateS != null && !leaveDateS.equals("")) {
				try {
					checkInDate = sdf.parse(checkInDateS);
					leaveDate = sdf.parse(leaveDateS);
				} catch (ParseException e) {
					Log.logger.debug(e.getMessage());
					e.printStackTrace();
				}
				long m = leaveDate.getTime() - checkInDate.getTime();
				a = (int) (m / (1000 * 60 * 60 * 21));
			}
			Double totalPrice = day_price * a;
		    Map<Integer,Double> cuId_TotalPrice = new HashMap<>();
		    cuId_TotalPrice.put(cuId, totalPrice);
		    request.getSession().setAttribute("cuId_TotalPrice", cuId_TotalPrice);
			// 得到账户余额
			Double acount = cu.getAcount();
			if (acount >= totalPrice) {
				UserService service = new UserService();

				// 修改账户余额
				// 修改产品数量
				String rIdS = request.getParameter("rId");
				int rId = 0;
				if (rIdS != null && !rIdS.equals("")) {
					rId = Integer.parseInt(rIdS);
				}
				// 产生预定表

				String reCuName = new String(request.getParameter("reCuName").getBytes("ISO-8859-1"), "UTF-8");
				String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"), "UTF-8");
				String remarks = new String(request.getParameter("remarks").getBytes("ISO-8859-1"), "UTF-8");
				String idNum = new String(request.getParameter("idNum").getBytes("ISO-8859-1"), "UTF-8");
				String type = new String(request.getParameter("type").getBytes("ISO-8859-1"), "UTF-8");
				Reserve r = new Reserve();
				r.setReCuName(reCuName);
				r.setSex(sex);
				r.setCheckInDate(checkInDate);
				r.setLeaveDate(leaveDate);
				r.setTotalMonney(totalPrice);
				r.setRemarks(remarks);
				r.setIdNum(idNum);
				r.setType(type);
				r.setrId(rId);
				r.setCuId(cuId);
				int count = service.reserveRoom(totalPrice, cu, rId, r);
				if(count != 0) {
					request.setAttribute("result", "预定成功");
				}else {
					request.setAttribute("result", "预定失败");
				}
				request.getRequestDispatcher("pt_user/index.jsp").forward(request, response);
				
			} else {
				request.setAttribute("result", "账户余额不足，请及时充值");
				request.setAttribute("cuName", cu.getCuName());
				request.setAttribute("acount", cu.getAcount());
				request.getRequestDispatcher("pt_user/charge.jsp").forward(request, response);
			}

		} else {
			request.setAttribute("result", "请先登录,再预定房间");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
