package com.briup.ssm.service.impl;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.dao.ICustomerDao;
import com.briup.ssm.service.interfaces.ICustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	
	//注册的实现类方法
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void register(Customer customer) throws EstoreCommonException {

	    if (customer==null){
            throw EstoreCommonException.getException(401);
        }

        customerDao.saveCustomer(customer);//若没有重复将用户信息入库

    }
	
	//登录的实现类方法
	@Override
	public Customer login(String name, String password)
			throws EstoreCommonException {

	    if (StringUtils.isBlank(name) || StringUtils.isBlank(password)){
            throw EstoreCommonException.getException(401);
        }
		
		//通过传进来的用户名和密码查找数据库中的用户
		Customer customer = customerDao.findByNamePassword(name, password);

		if (customer==null){
            throw EstoreCommonException.getException(402);
        }
		//若查到则返回有信息的用户对象，若没有查到则返回null
		return customer;
	}
	
	//修改用户信息的实现类方法
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void updateCustomer(Customer customer) throws EstoreCommonException {

	    if (customer==null){
            throw EstoreCommonException.getException(401);
        }

		//更新用户信息
		customerDao.updateCustomer(customer);
	}

	//通过用户名查找用户对象的实现类方法（为上面验证用户名是否重复服务）
	@Override
	public Customer findCustomer(String name) throws EstoreCommonException {

	    if (StringUtils.isBlank(name)){
            throw EstoreCommonException.getException(401);
        }

		//通过用户名查找用户
		Customer customer = customerDao.findByName(name);
		
		//若查到则返回有信息的用户对象，若没有查到则返回null
		return customer;
	}

}
