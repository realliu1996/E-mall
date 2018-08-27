package com.briup.ssm.service.interfaces;

import com.briup.ssm.common.bean.Line;

public interface ILineService {
	
	//保存订单项接口的方法
	void saveLine(Line line);
	
	//删除订单项接口的方法
	void deleteLine(Long id);
	
}
