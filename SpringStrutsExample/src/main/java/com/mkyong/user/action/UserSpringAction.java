package com.mkyong.user.action;
 
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.mkyong.user.bo.UserBo;
import com.opensymphony.xwork2.ActionSupport;

//@Namespace("/")
//@ResultPath(value="/")
//@Result(name="success",location="pages/user.jsp")
public class UserSpringAction extends ActionSupport{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	UserBo userBo;
 
	public UserBo getUserBo() {
		return userBo;
	}
 
	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}
 
	public String execute() throws Exception {
 
		userBo.printUser();
		return "success";
 
	}
}