package com.diworksdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.diworksdev.ecsite.dto.BuyItemDTO;
import com.diworksdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	private BuyItemDTO dto = new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo() {

		String sql = "select id,item_name,item_price from item_info_transaction";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
