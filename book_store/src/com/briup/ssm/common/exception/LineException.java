package com.briup.ssm.common.exception;

import org.springframework.stereotype.Component;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 19:59
 * @telephone 17770823458
 */

/**
 * 自定义订单项异常类
 * */
@Component
public class LineException extends Exception{

	private static final long serialVersionUID = -2299443369229122943L;

	public LineException() {
		super();
	}

	public LineException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public LineException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LineException(String arg0) {
		super(arg0);
	}
	public LineException(Throwable arg0) {
		super(arg0);
	}
	
}
