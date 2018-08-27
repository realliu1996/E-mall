package com.briup.ssm.service.interfaces;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.ShoppingCartException;

public interface IShoppingCartService {


    void saveShoppingCart(ShoppingCar shoppingCar, Customer customer) throws ShoppingCartException;

    void delShoppingCart(Long id) throws ShoppingCartException;

    ShoppingCar findShoppingCart(Long id) throws ShoppingCartException;
}
