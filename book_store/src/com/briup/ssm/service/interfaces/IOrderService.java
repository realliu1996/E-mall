package com.briup.ssm.service.interfaces;

import java.util.Collection;
import java.util.List;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.OrderException;

public interface IOrderService {
	
	//订单的级联插入接口的方法
	void confirmOrder(Customer customer, Order order, Collection<Line> lines) throws OrderException;
	
	//通过订单id删除订单接口的方法
	void deleteOrder(Long id) throws OrderException;
	
	//通过订单id查找包含所需信息订单接口的方法
	Order findById(Long id) throws OrderException;
	
	//通过用户id查找该用户的所有订单接口的方法
	List<Order> findByIdReturnList(Long id)throws OrderException;
}
