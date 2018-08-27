package com.briup.ssm.dao;

import java.util.List;

import com.briup.ssm.common.bean.Book;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 20:05
 * @telephone 17770823458
 */

/**
 * 与数据库交互书籍信息的接口
 * */
public interface IBookDao  {

    /**
     * 查找所有书籍信息返回包含书籍的list集合
     * @return 所有书籍集合
     * */
	List<Book> queryAll();

    /**
     * 通过书籍id查找书籍
     * @param 书籍id
     * @return 书籍
     * */
	Book queryById(Long id);
}
