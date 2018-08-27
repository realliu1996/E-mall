package com.briup.ssm.service.impl;

import java.util.List;

import com.briup.ssm.common.exception.EstoreCommonException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.BookException;
import com.briup.ssm.dao.IBookDao;
import com.briup.ssm.service.interfaces.IBookService;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=true)
public class IBookServiceImpl implements IBookService {
	
	@Autowired
	private IBookDao bookDao;
	
	//查找所有书籍的实现类方法
	@Override
	public List<Book> listAllBooks() throws BookException {
		
		//实现查找所有书籍返回书籍的list集合
		List<Book> queryAll = bookDao.queryAll();
		return queryAll;
	}
	
	//通过书籍id查找书籍的实现类方法
	@Override
	public Book findById(Long id) throws BookException {
		
		//实现通过书籍id查找书籍返回书籍对象
		Book book = bookDao.queryById(id);
		return book;
	}

    @Override
    public PageInfo<Book> finaAllBookWithPage(int page, int row) throws EstoreCommonException {
        PageHelper.startPage(page, row);
        List<Book> books = bookDao.queryAll();
        return new PageInfo<>(books);
    }

}
