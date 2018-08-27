package com.briup.ssm.common.exception;


import org.springframework.stereotype.Component;

@Component
public class ShoppingCartException extends Exception {

    public ShoppingCartException() {
        super();
    }

    public ShoppingCartException(String arg0, Throwable arg1, boolean arg2,
                          boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public ShoppingCartException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public ShoppingCartException(String arg0) {
        super(arg0);
    }

    public ShoppingCartException(Throwable arg0) {
        super(arg0);
    }
}
