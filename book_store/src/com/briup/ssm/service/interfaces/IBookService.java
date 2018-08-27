package com.briup.ssm.service.interfaces;

import java.util.List;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.BookException;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.github.pagehelper.PageInfo;

public interface IBookService {
	
	//查找所有书籍的接口方法
	List<Book> listAllBooks() throws BookException ;
	
	//通过书籍id查找书籍的接口方法
	Book findById(Long id) throws BookException;

    PageInfo<Book> finaAllBookWithPage(int page, int row) throws EstoreCommonException;
}
