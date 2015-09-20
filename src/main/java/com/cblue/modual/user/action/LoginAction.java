package com.cblue.modual.user.action;



import java.io.PrintWriter;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.cblue.modual.controller.Controller;
import com.cblue.modual.user.bean.UserInfo;
import com.cblue.modual.user.service.UserInfoService;
import com.cblue.webkernel.bean.QueryResult;
import com.cblue.webkernel.utils.FastJsonUtils;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String name ; 
	
	
	@Action(value = "mylogin")   
	public String myLogin() throws Exception {

		System.out.println("aaaa");
		System.out.println("name="+name);
		UserInfoService	userInfoService = (UserInfoService)Controller.getDaoImple("userInfoServiceImpl");
		QueryResult queryResult = userInfoService.getScrollData(1, 5);
			List<UserInfo> list = queryResult.getResultlist();
			String jsonStr = FastJsonUtils.createJsonString(list);
			PrintWriter out = ServletActionContext.getResponse().getWriter();
			out.print(jsonStr);
			out.close();
		return null;

    }

}
