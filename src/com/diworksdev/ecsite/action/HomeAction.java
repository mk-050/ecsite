package com.diworksdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.diworksdev.ecsite.dao.BuyItemDAO;
import com.diworksdev.ecsite.dto.BuyItemDTO;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	
	public String execute{
		String result="login"
				if(session.containsKey("login_user_id")) {
					BuyItemDAO dao=new BuyItemDAO();
					BuyItemDTO dto= dao.getBuyItemInfo();
					session.put("id",dto.getId() );
					session.put("buyItem_name",dto.getItemName() );
					session.put("buyItem_price",dto.getItemPrice() );
					result="SUCCESS";
				}
		return result;
	}
	
	@Override
	public void setSession(Map<String,Object> session) {
		
	}

}
