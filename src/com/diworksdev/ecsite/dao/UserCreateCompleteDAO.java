package com.diworksdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diworksdev.ecsite.util.DBConnector;
import com.diworksdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "insert into login_user_transaction(login_id,login_pass,user_name,insert_date)values(?,?,?,?)";

	public void createUser(String loginUserId, String loginUserPassword, String userName)
			throws SQLException {

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginUserPassword);
			ps.setString(3, userName);
			ps.setString(4, dateUtil.getDate());
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
