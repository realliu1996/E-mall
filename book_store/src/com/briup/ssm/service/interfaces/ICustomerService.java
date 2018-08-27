package com.briup.ssm.service.interfaces;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.exception.EstoreCommonException;

public interface ICustomerService {
	
	//注册接口的方法
	void register(Customer customer) throws EstoreCommonException;
	
	//登录接口的方法
	Customer login(String name, String password) throws EstoreCommonException;
	
	//修改用户接口的方法
	void updateCustomer(Customer customer) throws EstoreCommonException;
	
	//通过用户名查找用户接口的方法
	Customer findCustomer(String name) throws EstoreCommonException;
}
