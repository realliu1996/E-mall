package com.briup.ssm.service.impl;

import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.OrderException;
import com.briup.ssm.dao.ICustomerDao;
import com.briup.ssm.dao.IOrderDao;
import com.briup.ssm.service.interfaces.ILineService;
import com.briup.ssm.service.interfaces.IOrderService;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
public class IOrderServiceImpl implements IOrderService {
	
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private ICustomerDao customerDao;
	@Autowired
	private ILineService lineService;
	
	//订单级联插入的实现类方法
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void confirmOrder(Customer customer, Order order,
			Collection<Line> lines) throws OrderException {
		
		//保存订单
		orderDao.saveOrder(order);
		System.out.println("添加订单成功");
		
		//保存修改的用户信息
		customerDao.updateCustomer(customer);
		
		//遍历订单项集合，取得每一个订单项（此时订单项的信息不完整）
		for (Line line : lines) {
			
			//将订单信息传入订单项，此时订单项信息完整
			line.setOrder(order);
			
			//将一条条完整的订单项保存
			lineService.saveLine(line);
			System.out.println("添加订单项成功");
		}		
	}
	
	//通过订单id删除订单的实现类方法
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void deleteOrder(Long id) throws OrderException {
		
		//通过订单id查找包含所需信息的订单对象
		Order order = orderDao.findOrderById(id);

		//因为订单表与订单项表存在关联，所以需要先删除该订单的所有订单项才能删除该订单
		lineService.deleteLine(id);
		System.out.println("删除订单项成功");

		orderDao.deleteOrder(order);
		System.out.println("删除订单成功");
	}

	//通过订单id查找订单对象的实现类方法
	@Override
	public Order findById(Long id) throws OrderException {
		
		//通过订单id查找并得到订单对象
		Order order = orderDao.findOrderById(id);
		return order;
	}
	
	//通过用户id查找该用户所有订单集合的实现类方法
	@Override
	public List<Order> findByIdReturnList(Long id) throws OrderException {
		
		//通过用户id查找其所有订单并返回订单集合
		List<Order> list = orderDao.findByIdReturnList(id);
		return list;
	}
}
