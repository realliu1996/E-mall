package com.briup.ssm.dao;


import java.util.List;

import com.briup.ssm.common.bean.Order;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 20:28
 * @telephone 17770823458
 */

/**
 * 与数据库交互订单信息的接口
 * */
public interface IOrderDao  {

    /**
     * 把订单对象存入数据库
     * @param 订单
     * */
	void saveOrder(Order order);

    /**
     * 通过订单号返回包含需要信息的订单对象
     * @param 订单id
     * @return 订单
     * */
	Order findOrderById(Long id);

    /**
     * 通过订单对象删除订单
     * @param 订单
     * */
	void deleteOrder(Order order);

    /**
     * 通过用户id查找所有订单
     * @param 订单id
     * @return 所有订单集合
     * */
	List<Order> findByIdReturnList(Long id);
	
	
}
