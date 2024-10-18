package com.diworksdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.diworksdev.ecsite.dto.LoginDTO;
import com.diworksdev.ecsite.util.DBConnector;

public class LoginDAO {

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	LoginDTO dto = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {

		String sql = "select*from login_user_transaction where login_id=? and login_pass=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));

				if (rs.getString("login_id") != null) {
					dto.setLoginFlg(true);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
