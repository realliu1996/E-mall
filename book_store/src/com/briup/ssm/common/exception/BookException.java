package com.briup.ssm.common.exception;

import org.springframework.stereotype.Component;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 19:55
 * @telephone 17770823458
 */

/**
 * 自定义书籍异常类
 * */
@Component
public class BookException extends Exception {

	private static final long serialVersionUID = 1L;

	public BookException() {
		super();
	}

	public BookException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BookException(String message, Throwable cause) {
		super(message, cause);
	}

	public BookException(String message) {
		super(message);
	}

	public BookException(Throwable cause) {
		super(cause);
	}
}
