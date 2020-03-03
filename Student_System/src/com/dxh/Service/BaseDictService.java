package com.dxh.Service;

import java.util.List;

import com.dxh.po.BaseDict;

public interface BaseDictService {
	public List<BaseDict> findBaseDictByTypeCode(String typecode);
	public List<BaseDict> findTimeDictByTypeCode(String typecode);
	public BaseDict findTimeDictById(Integer dict_id);
}
