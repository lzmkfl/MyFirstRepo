package com.etc.HotelManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.etc.HotelManagement.utils.DbInfo;

public class BaseDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rsResultSet;
	DbInfo dbInfo;
	Statement st;

	public void getTransaction() throws ClassNotFoundException, SQLException {
		if (con == null) {
			getCon();
		}
		con.setAutoCommit(false);
	}

	public void rollbackTran() throws SQLException {
		if (con != null) {
			con.rollback();
		}
	}

	public void commitTran() throws SQLException {
		if (con != null) {
			con.commit();
		}
	}

	public void getCon() throws ClassNotFoundException, SQLException {
		dbInfo = DbInfo.getInstance();
		Class.forName(dbInfo.getDbdriver());
		con = DriverManager.getConnection(dbInfo.getDbURL(), dbInfo.getUname(), dbInfo.getpwd());
	}

	public void closeCon() throws SQLException {
		if (con != null) {
			con.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (rsResultSet != null) {
			rsResultSet.close();
		}
		if (st != null) {
			st.close();
		}
	}
}
