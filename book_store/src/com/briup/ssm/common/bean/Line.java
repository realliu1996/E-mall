package com.briup.ssm.common.bean;

import java.io.Serializable;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 19:43
 * @telephone 17770823458
 */

/**
 * 订单项类
 * */
public class Line implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * 订单项id
     * */
	private Long id;

    /**
     * 书籍本数
     * */
	private Integer num;

	/**
	 * 关联关系 -- 多对一  对应一个订单
	 * */
	private Order order;

	/**
	 * 关联关系 -- 多对一  对应一类书
	 * */
	private Book book;


	private Customer customer;
	
	public Line(){
		
	}
	public Line(Long id, Integer num) {
		this.id = id;
		this.num = num;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + id +
                ", num=" + num +
                ", order=" + order +
                ", book=" + book +
                '}';
    }
}
