package com.briup.ssm.service.impl;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.ShoppingCartException;
import com.briup.ssm.dao.IBookDao;
import com.briup.ssm.dao.IShoppingCartDao;
import com.briup.ssm.service.interfaces.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(isolation= Isolation.DEFAULT,propagation= Propagation.REQUIRED,readOnly=false)
public class IShoppingCartServiceImpl implements IShoppingCartService {

    @Autowired
    private IShoppingCartDao shoppingCartDao;
    @Autowired
    private IBookDao bookDao;

    @Override
    public void saveShoppingCart(ShoppingCar shoppingCar, Customer customer) throws ShoppingCartException {

        if (shoppingCar!=null){
            Map<Long, Line> lines = shoppingCar.getLines();
            for (Line line: lines.values()) {
                    line.setCustomer(customer);
                    shoppingCartDao.saveShoppingCart(line);
            }
        }
    }

    @Override
    public void delShoppingCart(Long id) throws ShoppingCartException {

        shoppingCartDao.delShoppingCart(id);

    }

    @Override
    public ShoppingCar findShoppingCart(Long id) throws ShoppingCartException {

        List<Line> shoppingCart = shoppingCartDao.findShoppingCart(id);
        ShoppingCar shoppingCar=new ShoppingCar();
        if (shoppingCart!=null) {
            for (Line line : shoppingCart) {
                Long bookid = line.getBook().getId();
                Book book = bookDao.queryById(bookid);
                line.setBook(book);
                shoppingCar.add(line);
            }

            return shoppingCar;

        }

        return shoppingCar;
    }
}
