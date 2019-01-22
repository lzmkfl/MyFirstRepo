package com.etc.HotelManagement.service;

import java.sql.SQLException;
import java.util.List;

import com.etc.HotelManagement.dao.RoomBookDao;
import com.etc.HotelManagement.entity.Room;
import com.etc.HotelManagement.entity.RoomDetail;
import com.etc.HotelManagement.utils.Log;

public class RoomService {
	RoomBookDao dao = new RoomBookDao();

	// 此方法用于获取数据库中的房间信息
	public List<Room> getRooms() {
		List<Room> list = null;
		try {
			dao.getCon();
			list = dao.getRooms();
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

	public List<RoomDetail> selectRoomDetail(int offset, int i) {
		List<RoomDetail> list = null;
		try {
			dao.getCon();
			list = dao.selectRoomDetail(offset, i);

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

	public int selectCountAll(int i) {
		int countAll = 0;
		try {
			dao.getCon();
			countAll = dao.selectCountAll(i);
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

		return countAll;
	}

	public Boolean selectRNo(int rNo) {
		Boolean flag = false;
		try {
			dao.getCon();
			flag = dao.selectRNo(rNo);
		} catch (ClassNotFoundException | SQLException e) {
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

		return flag;
	}

	public int selectRNoByNP(String cuName, String phoneNum) {
		int rNo = 0;
		try {
			dao.getCon();
			rNo = dao.selectRNoByNP(cuName, phoneNum);
		} catch (ClassNotFoundException | SQLException e) {
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

		return rNo;
	}

	public int updateRNo(String cuName, String phoneNum, int currentRNo, String remarks) {
		int count = 0;
		try {
			dao.getCon();
			count = dao.updateRNo(cuName, phoneNum, currentRNo, remarks);
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
		return count;
	}

	public int insertRoomDetail(RoomDetail rd) {
		int count = 0;
		try {
			dao.getCon();
			// 根据房间类别查询其rId
			int rId = dao.selectRIdByType(rd.getType());
			rd.setrId(rId);
			count = dao.insertRoomDetail(rd);
		} catch (ClassNotFoundException | SQLException e) {
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

	public RoomDetail selectRoomDByRdId(int rdId) {
		RoomDetail rd = null;
		try {
			dao.getCon();
			rd = dao.getRoomDByRdId(rdId);
		} catch (ClassNotFoundException | SQLException e) {
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

		return rd;
	}

	public int updateRoomDetail(RoomDetail detail) {
		int count = 0;
		try {
			dao.getCon();
			count = dao.updateRoomDetail(detail);
		} catch (ClassNotFoundException | SQLException e) {
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

	public int deleRoomD(int rdId) {
		int count = 0;
		try {
			dao.getCon();
			count = dao.deleRoomD(rdId);
		} catch (ClassNotFoundException | SQLException e) {
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

	public List<RoomDetail> selectByThree(String type, String state, int rNo) {
		List<RoomDetail> list = null;
		try {
			dao.getCon();
			list = dao.selectByThree(type, state, rNo);
		} catch (ClassNotFoundException | SQLException e) {
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
		return list;
	}
}
