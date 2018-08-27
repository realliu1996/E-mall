package com.briup.ssm.common.exception;

import org.springframework.stereotype.Component;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 19:57
 * @telephone 17770823458
 */

/**
 * 自定义用户异常类
 * */
@Component
public class CustomerException extends Exception {

	private static final long serialVersionUID = 1L;

	public CustomerException() {
		super();
	}

	public CustomerException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerException(String message) {
		super(message);
	}

	public CustomerException(Throwable cause) {
		super(cause);
	}
}
