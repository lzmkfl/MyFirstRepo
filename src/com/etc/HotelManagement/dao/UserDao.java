package com.etc.HotelManagement.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.etc.HotelManagement.entity.Customer;
import com.etc.HotelManagement.entity.HotelAdmin;
import com.etc.HotelManagement.entity.Reserve;
import com.etc.HotelManagement.entity.Waiter;

public class UserDao extends BaseDao {

	public int HARegister(HotelAdmin ha) throws SQLException {
		String sql = "insert into hotelAdmin(haName,password) values(?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, ha.getHaName());
		ps.setString(2, ha.getPassword());
		int count = ps.executeUpdate();
		return count;
	}

	public int CuRegister(Customer cu) throws SQLException {
		String sql = "insert into customer(cuName,Password) values(?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, cu.getCuName());
		ps.setString(2, cu.getPassword());
		int count = ps.executeUpdate();
		return count;
	}

	public int WaRegister(Waiter wt) throws SQLException {
		String sql = "insert into waiter(wName,password) values(?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, wt.getwName());
		ps.setString(2, wt.getPassword());
		int count = ps.executeUpdate();
		return count;
	}


	public Customer CustomerLogin(String name, String pwd) throws SQLException {
		String sql = "select * from customer where CuName = '" + name + "' and pwd = '" + pwd + "'";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		Customer cu = null;
		while (rsResultSet.next()) {
			 cu = new Customer();
			cu.setCuid(rsResultSet.getInt(1));
			cu.setCuName(rsResultSet.getString(2));
			cu.setPassword(rsResultSet.getString(3));
			cu.setRole(rsResultSet.getInt(4));
			cu.setAcount(rsResultSet.getDouble(5));
			cu.setIdNum(rsResultSet.getString(6));
			cu.setSex(rsResultSet.getString(7));
		}

		return cu;
	}

	public HotelAdmin haLogin(String name, String pwd) throws SQLException {
		String sql = "select * from hoteladmin where haName = '" + name + "' and pwd = '" + pwd+"'";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		HotelAdmin ha = null;
	    while(rsResultSet.next()) {
	    	ha = new HotelAdmin();
	    	ha.setHaId(rsResultSet.getInt(1));
	    	ha.setHaName(rsResultSet.getString(2));
            ha.setPassword(rsResultSet.getString(3));
            ha.setRole(rsResultSet.getInt(4));
	    }
		
		return ha;
	}

	public Waiter WaierLogin(String name, String pwd) throws SQLException {
		String sql = "select * from Waiter where WName = '"+name+"' and pwd = '"+pwd+"'";
			st = con.createStatement();
			rsResultSet = st.executeQuery(sql);
			Waiter w = null;
			while(rsResultSet.next()) {
			  w = new Waiter();
			  w.setwId(rsResultSet.getInt(1));
			  w.setwName(rsResultSet.getString(2));
			  w.setPassword(rsResultSet.getString(3));
			  w.setRole(rsResultSet.getInt(4));
			}
		
		
		return w;
	}

	public int updateBalance(Double money, Customer cu) throws SQLException {
		String sql = "update  customer set acount = acount+"+money+" where cuid = "+cu.getCuid();
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	public int updateAcount(Double totalPrice, Customer cu) throws SQLException {
		String sql = "update  customer set acount = acount - "+totalPrice+"where cuid= "+cu.getCuid();
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	public String selectPwdById(int wId) throws SQLException {
		String sql = "select pwd from waiter where wId="+wId;
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		String pwd = "";
		while(rsResultSet.next()) {
			pwd = rsResultSet.getString(1);
		}
		
		
		return pwd;
	}

	public int updatePwd(String newPwd, int wId) throws SQLException {
		String sql = "update waiter set pwd = '"+newPwd +"' where WId = "+wId;
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	

	public int updateRcount(int rId) throws SQLException {
	    String sql = "update room set rCount = rCount - 1 where rId = "+rId;
	    st = con.createStatement();
	    int count = st.executeUpdate(sql);
	    return count;
	}

	public int InsertReserveM(Reserve r) throws SQLException {
		String sql = "Insert into reserve(reCuName,sex,checkInDate,leaveDate,TotalMoney,remarks,IdNum,type,rId,cuId) VALUES(?,?,?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, r.getReCuName());
		ps.setString(2, r.getSex());
		ps.setDate(3, new Date(r.getCheckInDate().getTime()));
		ps.setDate(4, new Date(r.getLeaveDate().getTime()));
		ps.setDouble(5, r.getTotalMonney());
		ps.setString(6, r.getRemarks());
		ps.setString(7, r.getIdNum());
		ps.setString(8, r.getType());
		ps.setInt(9, r.getrId());
		ps.setInt(10, r.getCuId());
		int count = ps.executeUpdate();
		return count;
	}

	public int updateRoomState(int rId) throws SQLException {
		String sql = "update \r\n" + 
				"roomdetail r1\r\n" + 
				"set \r\n" + 
				"r1.state = '已预订'\r\n" + 
				"WHERE r1.rNo = \r\n" + 
				"(\r\n" + 
				"select r2.rNo from (select * from roomdetail) r2 where r2.rId=? and r2.state = '闲置' limit 1)\r\n" + 
				"";
		ps = con.prepareStatement(sql);
		ps.setInt(1, rId);
		int count = ps.executeUpdate();
		return count;
		
	}
}
