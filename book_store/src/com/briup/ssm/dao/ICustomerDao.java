package com.briup.ssm.dao;


import com.briup.ssm.common.bean.Customer;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 20:13
 * @telephone 17770823458
 */

/**
 * 与数据库交互用户信息的接口
 * */
public interface ICustomerDao  {

    /**
     * 通过用户名查找用户并返回用户对象
     * @param 用户名
     * @return 用户
     * */
	Customer findByName(String name);

    /**
     * 传入用户对象保存到数据库
     * @param 用户
     * */
	void saveCustomer(Customer customer);

    /**
     * 传入修改了的用户对象保存到数据库
     * @param 用户
     * */
	void updateCustomer(Customer customer);

    /**
     * 通过用户名与密码查找用户返回用户对象
     * @param 用户名，用户密码
     * @return 用户
     * */
	Customer findByNamePassword(String name, String password);

    /**
     * 通过用户名查找用户返回用户名字（验证用户名重复）
     * @param 用户名
     * @return 用户名
     * */
	String findByName1(String name);
}
