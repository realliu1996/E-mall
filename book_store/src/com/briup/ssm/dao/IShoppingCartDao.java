package com.briup.ssm.dao;

import com.briup.ssm.common.bean.Line;

import java.util.List;

public interface IShoppingCartDao {


    void saveShoppingCart(Line line);

    void delShoppingCart(Long id);

    List<Line> findShoppingCart(Long id);

}
