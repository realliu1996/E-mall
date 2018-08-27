package com.briup.ssm.dao;

import com.briup.ssm.common.bean.Line;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 20:23
 * @telephone 17770823458
 */

/**
 * 与数据库交互订单项信息的接口
 * */
public interface ILineDao  {

    /**
     * 传入line对象保存进数据库
     * @param 订单项
     * */
	void saveLine(Line line);

    /**
     * 通过订单id删除订单项
     * @param 订单id
     * */
	void deleteLine(Long id);
	
}
