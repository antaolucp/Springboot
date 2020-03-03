package com.dxh.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxh.Service.BaseDictService;
import com.dxh.dao.BaseDictDao;
import com.dxh.po.BaseDict;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;
	@Override
	public List<BaseDict> findBaseDictByTypeCode(String typecode) {
		return baseDictDao.selectBaseDictByTypeCode(typecode);
	}
	@Override
	public List<BaseDict> findTimeDictByTypeCode(String typecode) {
		// TODO 自动生成的方法存根
		return baseDictDao.selectTimeDictByTypeCode(typecode);
	}
	@Override
	public BaseDict findTimeDictById(Integer dict_id) {
		// TODO 自动生成的方法存根
		return baseDictDao.selectTimeDictById(dict_id);
	}

}
