package com.mkyong.user.bo.impl;
 
import org.springframework.stereotype.Component;

import com.mkyong.user.bo.UserBo;

@Component
public class UserBoImpl implements UserBo{
 
	public void printUser(){
		System.out.println("printUser() is executed...");
	}
 
}