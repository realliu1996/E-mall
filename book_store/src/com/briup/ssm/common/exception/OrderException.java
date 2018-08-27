package com.briup.ssm.common.exception;

import org.springframework.stereotype.Component;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 20:00
 * @telephone 17770823458
 */

/**
 * 自定义订单异常类
 * */
@Component
public class OrderException extends Exception{

	private static final long serialVersionUID = 4978231283270644326L;

	public OrderException() {
		super();
	}

	public OrderException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public OrderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public OrderException(String arg0) {
		super(arg0);
	}

	public OrderException(Throwable arg0) {
		super(arg0);
	}
	
}
