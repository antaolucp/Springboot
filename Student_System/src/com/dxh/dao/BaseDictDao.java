package com.dxh.dao;

import java.util.List;

import com.dxh.po.BaseDict;

public interface BaseDictDao {
	public List<BaseDict> selectBaseDictByTypeCode(String typecode);
	public List<BaseDict> selectTimeDictByTypeCode(String typecode);
	public BaseDict selectTimeDictById(Integer dict_id);
}
