package com.etc.HotelManagement.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HotelManagement.dto.CheckInEvolve;
import com.etc.HotelManagement.dto.CiRCuThree;
import com.etc.HotelManagement.entity.Acount;
import com.etc.HotelManagement.entity.CheckIn;

public class CheckInDao extends BaseDao {

	public int insertCheckIn(CheckIn ci) throws SQLException {

		String sql = "insert INTO checkin(check_date,rNo,remarks,phoneNum,rId,cuId,cuName,Totalprice) VALUES (?,?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setDate(1, new java.sql.Date(ci.getCheck_Date().getTime()));
		ps.setInt(2, ci.getrNo());
		ps.setString(3, ci.getRemarks());
		ps.setString(4, ci.getPhoneNum());
		ps.setInt(5, ci.getrId());
		ps.setInt(6, ci.getCuId());
		ps.setString(7, ci.getCuName());
		ps.setDouble(8, ci.getTotalprice());
		int count = ps.executeUpdate();
		return count;
	}

	public List<CheckInEvolve> selectCheckIn() throws SQLException {
		List<CheckInEvolve> list = new ArrayList<>();
		String sql = "select ci.ciId,cu.cuName,ci.rNo,ci.check_date,r.type,ci.phoneNum,ci.remarks\r\n"
				+ "from customer cu INNER JOIN checkin ci on cu.cuid=ci.cuId INNER JOIN room  r on r.rId = ci.rId\r\n"
				+ "";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		CheckInEvolve cie = null;
		while (rsResultSet.next()) {
			cie = new CheckInEvolve();
			cie.setCiId(rsResultSet.getInt(1));
			cie.setCuName(rsResultSet.getString(2));
			cie.setrNo(rsResultSet.getInt(3));
			cie.setCheck_date(new java.util.Date(rsResultSet.getDate(4).getTime()));
			cie.setType(rsResultSet.getString(5));
			cie.setPhoneNum(rsResultSet.getString(6));
			cie.setRemarks(rsResultSet.getString(7));
			list.add(cie);
		}

		return list;
	}

	public int[] judgeReserve(String cuName, String idNum) throws SQLException {
		int[] a = new int[2];
		String sql = "select rId,cuId from Reserve where reCuName = '" + cuName + "' and idNum = '" + idNum + "'";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		int rId = 0;
		int cuId = 0;
		if (rsResultSet.next()) {
			rId = rsResultSet.getInt(1);
			cuId = rsResultSet.getInt(2);
		}
		a[0] = rId;
		a[1] = cuId;
		return a;
	}
	public Double selectTotalprice(String cuName, String idNum) throws SQLException {
		String sql = "select TotalMoney from Reserve where reCuName = '" + cuName + "' and idNum = '" + idNum + "'";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		Double total_price = 0.0 ;
		if(rsResultSet.next()) {
			total_price = rsResultSet.getDouble(1);
		}
		return total_price;
		
	}

	public int deleReserve(String cuName, String idNum) throws SQLException {
		String sql = "delete from Reserve where reCuName = '" + cuName + "' and idNum= '" + idNum + "'";
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	public int updateRoomDetail(int rNo) throws SQLException {
		String sql = "update roomDetail set state = '已入住' where rNo= " + rNo;
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	public List<CiRCuThree> selectThree() throws SQLException {
		String sql = "select * from ciRcuThree";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		List<CiRCuThree> list = new ArrayList<>();
		CiRCuThree crt = null;
		while (rsResultSet.next()) {
			crt = new CiRCuThree();
			crt.setCiId(rsResultSet.getInt(1));
			crt.setrNo(rsResultSet.getInt(2));
			crt.setRemarks(rsResultSet.getString(3));
			crt.setCuId(rsResultSet.getInt(4));
			crt.setCuName(rsResultSet.getString(5));
			crt.setrId(rsResultSet.getInt(6));
			crt.setType(rsResultSet.getString(7));
			crt.setTotalprice(rsResultSet.getDouble(8));
			list.add(crt);
		}
		return list;
	}

	public int updateRCount(int rId) throws SQLException {
		String sql = "update room set rCount = rCount+1 where rId = " + rId;
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	public int updatRoomDState(int rNo) throws SQLException {
		String sql = "update roomDetail set state = '闲置' where rNo=" + rNo;
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	public int deleCheckIn(int ciId) throws SQLException {
		String sql = "delete from checkIn where ciId = " + ciId;
		st = con.createStatement();
		int count = st.executeUpdate(sql);

		return count;

	}

	public int InsertAcount(CiRCuThree crt) throws SQLException {
		String sqla = "select cuName,idNum from customer where cuid = " + crt.getCuId();
		st = con.createStatement();
		rsResultSet = st.executeQuery(sqla);
		String cuName = null;
		String IdNum = null;
		while (rsResultSet.next()) {
			cuName = rsResultSet.getString(1);
			IdNum = rsResultSet.getString(2);
		}

		String sql = "Insert into acount(cuName,idNum,rNo,amount,pay_date) VALUES (?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, cuName);
		ps.setString(2, IdNum);
		ps.setInt(3, crt.getrNo());
		ps.setDouble(4, crt.getTotalprice());
		ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
		int count = ps.executeUpdate();
		return count;

	}

	public List<Acount> selectAcount() throws SQLException {
		String sql = "select * from acount";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		List<Acount> list = new ArrayList<>();
		Acount a = null;
		while (rsResultSet.next()) {
			a = new Acount();
			a.setaId(rsResultSet.getInt(1));
			a.setCuName(rsResultSet.getString(2));
			a.setIdNum(rsResultSet.getString(3));
			a.setrNo(rsResultSet.getInt(4));
			a.setAmount(rsResultSet.getDouble(5));
			a.setPay_date(new java.util.Date(rsResultSet.getDate(6).getTime()));
			list.add(a);
		}

		return list;
	}


}
