package com.etc.HotelManagement.service;

import java.sql.SQLException;

import com.etc.HotelManagement.dao.UserDao;
import com.etc.HotelManagement.entity.Customer;
import com.etc.HotelManagement.entity.HotelAdmin;
import com.etc.HotelManagement.entity.Reserve;
import com.etc.HotelManagement.entity.Waiter;
import com.etc.HotelManagement.utils.Log;

public class UserService {
	UserDao dao = new UserDao();

	// 用于宾馆管理员注册
	public int HARegister(HotelAdmin ha) {
		int count = 0;
		try {
			dao.getTransaction();
			count = dao.HARegister(ha);
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
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		}
		return count;
	}

	// 用于普通用户注册
	public int CuRegister(Customer cu) {
		int count = 0;
		try {
			dao.getTransaction();
			count = dao.CuRegister(cu);
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
				e.printStackTrace();
				Log.logger.debug(e.getMessage());
			}
		}
		return count;
	}

	// 用于前台小姐注册
	public int WaRegister(Waiter wt) {
		int count = 0;
		try {
			dao.getTransaction();
			count = dao.WaRegister(wt);
			dao.commitTran();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				dao.rollbackTran();
				Log.logger.debug(e.getMessage());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			Log.logger.debug(e.getMessage());
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

	// 此方法用于判断数据库有没有重名的记录，若有则注册失败
	// 此方法用于登录普通用户
	public Customer CustomerLogin(String name, String pwd) {
		Customer cu = null;
		try {
			dao.getCon();
			cu = dao.CustomerLogin(name, pwd);
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
		return cu;
	}

	// 此方法用于实现登入管理员
	public HotelAdmin AdminLogin(String name, String pwd) {
		HotelAdmin ha = null;
		try {
			dao.getCon();
			ha = dao.haLogin(name, pwd);
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
		return ha;

	}
	// 此方法用于实现登录操作员

	public Waiter WatierLogin(String name, String pwd) {
        Waiter w = null;
        try {
			dao.getCon();
			w = dao.WaierLogin(name,pwd);
		} catch (ClassNotFoundException | SQLException e) {
			Log.logger.debug(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}
		return w;

	}
   //实现充值
	public int updateBalance(Double money, Customer cu) {
		int count = 0;
		try {
			dao.getTransaction();
			count = dao.updateBalance(money,cu);
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
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return count;
	}


	public String selectPwd(int wId) {
		String pwd = "";
		try {
			dao.getCon();
			pwd = dao.selectPwdById(wId);
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
		return pwd;
	}

	public int updatePwd(String newPwd, int wId) {
		int count = 0;
		try {
			dao.getTransaction();
			count = dao.updatePwd(newPwd,wId);
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
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}
		
		return count;
	}



	public int reserveRoom(Double totalPrice, Customer cu, int rId, Reserve r) {
		int count = 0;
		try {
			dao.getTransaction();
			//修改账户余额
			dao.updateAcount(totalPrice, cu);
			//修改产品数量
			dao.updateRcount(rId);
			//产生预定表
			dao.InsertReserveM(r);
			//修改房间状态信息
			count = dao.updateRoomState(rId);
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
		}finally {
			try {
				dao.closeCon();
			} catch (SQLException e) {
				Log.logger.debug(e.getMessage());
				e.printStackTrace();
			}
		}
		return count;
	}

}
