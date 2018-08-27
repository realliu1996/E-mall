package com.briup.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.briup.ssm.common.bean.Line;
import com.briup.ssm.dao.ILineDao;
import com.briup.ssm.service.interfaces.ILineService;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
public class ILineServiceImpl implements ILineService{
	
	@Autowired
	private ILineDao lineDao;
	
	//保存订单项的实现类方法
	@Override
	public void saveLine(Line line) {
		
		//保存订单项
		lineDao.saveLine(line);
	}
	
	//删除订单项的实现类方法
	@Override
	public void deleteLine(Long id) {
		
		//删除订单项
		lineDao.deleteLine(id);
	}

}
