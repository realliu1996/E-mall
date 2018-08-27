package com.briup.ssm.common.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 *  
 * 
 * @author 刘真
 * @date 2018/7/30 19:45
 * @telephone 17770823458
 */

/**
 * 订单类
 * */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 订单id
     * */
	private Long id;

	/**
	 * 订单价钱（总价）
	 * */
	private Double cost;

    /**
     * 订单日期
     * */
	private Date orderDate;

    /**
     * 订单付款方式
     * */
	private String payment;
	
	/**
	 * 关联关系 - 一对多 : 对应多个订单项
	 * */
	private Set<Line> lines = new HashSet<Line>();

	/**
	 * 关联关系 - 多对一 : 对应一个顾客
	 * */
	private Customer customer;
	
	public Order(){
		
	}

	public Order(Long id, Double cost, Date orderDate, String payment) {
		super();
		this.id = id;
		this.cost = cost;
		this.orderDate = orderDate;
		this.payment = payment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public Set<Line> getLines() {
		return lines;
	}

	public void setLines(Set<Line> lines) {
		this.lines = lines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

}
