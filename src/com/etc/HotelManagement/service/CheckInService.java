package com.etc.HotelManagement.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HotelManagement.dao.CheckInDao;
import com.etc.HotelManagement.dto.CheckInEvolve;
import com.etc.HotelManagement.dto.CiRCuThree;
import com.etc.HotelManagement.entity.Acount;
import com.etc.HotelManagement.entity.CheckIn;
import com.etc.HotelManagement.utils.Log;

public class CheckInService {
	CheckInDao dao = new CheckInDao();

	public int ManageCheckIn(CheckIn ci, String cuName, String idNum) {
		int count = 0;
		try {
			dao.getTransaction();
			//得到cuId_total_price
			dao.deleReserve(cuName, idNum);
			dao.insertCheckIn(ci);
			count = dao.updateRoomDetail(ci.getrNo());
			dao.commitTran();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				dao.rollbackTran();
			} catch (SQLException e1) {
				Log.logger.debug(e.getMessage());
				e1.printStackTrace();
			}
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}

		return count;
	}

	public List<CheckInEvolve> selectCheckIn() {
		List<CheckInEvolve> list = null;
		try {
			dao.getCon();
			list = dao.selectCheckIn();
		} catch (ClassNotFoundException | SQLException e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		}

		return list;
	}

	public int[] judgeReserve(String cuName, String idNum) {
		int[] a= null;
		try {
			dao.getCon();
			a = dao.judgeReserve(cuName, idNum);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		} 
		return a;
	}

    public Double selectTotalPrice(String cuName, String idNum) {
    	double total_price = 0.0;
    	try {
			dao.getCon();
			total_price = dao.selectTotalprice(cuName, idNum);
		} catch (ClassNotFoundException | SQLException e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}
		return total_price;
    	
    }
	public List<CiRCuThree> selectThree() {
		List<CiRCuThree> list = null;
		try {
			dao.getCon();
			list = dao.selectThree();
		} catch (ClassNotFoundException | SQLException e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		}

		return list;
	}

	public int checkOut(CiRCuThree crt) {
		int count = 0;
		try {
			dao.getTransaction();
			// 修改room的数量
			dao.updateRCount(crt.getrId());
			// 修改roomDetail的状态
			dao.updatRoomDState(crt.getrNo());
			// 删除入住表的数据
			dao.deleCheckIn(crt.getCiId());
			// 生成账单表的数据
		
			count = dao.InsertAcount(crt);
			dao.commitTran();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				dao.rollbackTran();
			} catch (SQLException e1) {
				Log.logger.debug(e.getMessage());
				e1.printStackTrace();
			}
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		} finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}

		return count;
	}

	public List<Acount> selectAcount() {
		List<Acount> list = null;
		try {
			dao.getCon();
			list = dao.selectAcount();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		}
		
		return list;
	}

}
