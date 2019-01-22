package com.etc.HotelManagement.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.etc.HotelManagement.entity.Room;
import com.etc.HotelManagement.entity.RoomDetail;

public class RoomBookDao extends BaseDao {

	public List<Room> getRooms() throws SQLException {
		String sql = "select * from room";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		List<Room> list = new ArrayList<>();
		Room room = null;
		while (rsResultSet.next()) {
			room = new Room();
			room.setrId(rsResultSet.getInt(1));
			room.setR_image(rsResultSet.getString(2));
			room.setType(rsResultSet.getString(3));
			room.setDescription(rsResultSet.getString(4));
			room.setDay_price(rsResultSet.getDouble(5));
			room.setBedCount(rsResultSet.getInt(6));
			room.setrCount(rsResultSet.getInt(7));
			list.add(room);
		}
		return list;
	}

	public List<RoomDetail> selectRoomDetail(int offset, int i) throws SQLException {
		String sql = "select * from roomDetail limit " + offset + "," + i;
		ps = con.prepareStatement(sql);
		rsResultSet = ps.executeQuery();
		List<RoomDetail> list = new ArrayList<>();
		RoomDetail rd = null;
		while (rsResultSet.next()) {
			rd = new RoomDetail();
			rd.setRdId(rsResultSet.getInt(1));
			rd.setrNo(rsResultSet.getInt(2));
			rd.setType(rsResultSet.getString(3));
			rd.setState(rsResultSet.getString(4));
			rd.setRemarks(rsResultSet.getString(5));
			rd.setrId(rsResultSet.getInt(6));
			list.add(rd);
		}
		return list;
	}

	// 获取总页数
	public int selectCountAll(int i) throws SQLException {
		String sql = "select count(*) from roomDetail";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		int rCount = 0;
		while (rsResultSet.next()) {
			rCount = rsResultSet.getInt(1);
		}
		int countAll = 0;
		if (rCount % i == 0) {
			countAll = rCount / i;
		} else {
			countAll = (int) (rCount / i) + 1;
		}
		return countAll;
	}

	public Boolean selectRNo(int rNo) throws SQLException {
		String sql = "select * from roomDetail where rNo = " + rNo;
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		Boolean flag = false;
		if (rsResultSet.next()) {
			flag = true;
		}

		return flag;
	}

	public int selectRNoByNP(String cuName, String phoneNum) throws SQLException {
		String sql = "select rNo  from roomDetail where cuName = " + cuName + "and phoneNum = " + phoneNum;
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		int rNo = 0;
		while (rsResultSet.next()) {
			rNo = rsResultSet.getInt(1);
		}
		return rNo;
	}

	public int updateRNo(String cuName, String phoneNum, int currentRNo, String remarks) throws SQLException {
		int count = 0;
		String sql = "update checkin set rNo = " + currentRNo + " and remarks =  '" + remarks + "' where cuName = '"
				+ cuName + "' and phoneNum = '" + phoneNum+"'";
		st = con.createStatement();
		count = st.executeUpdate(sql);
		return count;
	}

	public int selectRIdByType(String type) throws SQLException {
		int rId = 0;
		String sql = "select rId from room where type = '" + type+"'";
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		while (rsResultSet.next()) {
			rId = rsResultSet.getInt(1);
		}
		return rId;
	}

	public int insertRoomDetail(RoomDetail rd) throws SQLException {
		String sql = "INSERT INTO roomdetail(rNo,type,state,remarks,rId) VALUES(?,?,?,?,?) ";
		ps = con.prepareStatement(sql);
		ps.setInt(1, rd.getrNo());
		ps.setString(2, rd.getType());
		ps.setString(3, rd.getState());
		ps.setString(4, rd.getRemarks());
		ps.setInt(5, rd.getrId());
		int count = ps.executeUpdate();
		return count;
	}

	public RoomDetail getRoomDByRdId(int rdId) throws SQLException {
		String sql = "select * from roomDetail where rdId = "+rdId;
		st = con.createStatement();
		RoomDetail rd = null;
		rsResultSet = st.executeQuery(sql);
		while(rsResultSet.next()) {
			rd = new RoomDetail();
			rd.setRdId(rsResultSet.getInt(1));
			rd.setrNo(rsResultSet.getInt(2));
			rd.setType(rsResultSet.getString(3));
			rd.setState(rsResultSet.getString(4));
			rd.setRemarks(rsResultSet.getString(5));
			rd.setrId(rsResultSet.getInt(6));
		}
		
		return rd;
	}

	public int updateRoomDetail(RoomDetail detail) throws SQLException {
		String sql = "update RoomDetail set rNo = ?,type = ?,state = ?,remarks = ?,rId=? where rdId = ? ";
		ps = con.prepareStatement(sql);
		ps.setInt(1, detail.getrNo());
        ps.setString(2, detail.getType());	
        ps.setString(3, detail.getState());
        ps.setString(4, detail.getRemarks());
        ps.setInt(5, detail.getrId());
        ps.setInt(6, detail.getRdId());
        int count = ps.executeUpdate();
		return count;
	}

	public int deleRoomD(int rdId) throws SQLException {
		String sql = "delete from roomDetail where rdId = "+rdId;
		st = con.createStatement();
		int count = st.executeUpdate(sql);
		return count;
	}

	public List<RoomDetail> selectByThree(String type, String state, int rNo) throws SQLException {
		List<RoomDetail> list = new ArrayList<RoomDetail>() ;
		String sql = "select * from RoomDetail where 1=1";
		if(type != null && !type.equals("") ){
			sql += " and type = '"+type+"'";
		}
		if(state != null && !state.equals("")) {
			sql += " and state = '"+state+"'";
		}
		if(rNo != -1) {
			sql += " and rNo = "+rNo;
		}
		st = con.createStatement();
		rsResultSet = st.executeQuery(sql);
		RoomDetail rd = null;
		while(rsResultSet.next()) {
			rd = new RoomDetail();
			rd.setRdId(rsResultSet.getInt(1));
			rd.setrNo(rsResultSet.getInt(2));
			rd.setType(rsResultSet.getString(3));
			rd.setState(rsResultSet.getString(4));
			rd.setRemarks(rsResultSet.getString(5));
			rd.setrId(rsResultSet.getInt(6));
			list.add(rd);
			
		}
		return list;
	}

}









