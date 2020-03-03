package com.dxh.Service;

import com.dxh.common.utils.Page;
import com.dxh.po.Score;

public interface ScoreService {
	public Page<Score> findScoreList(Integer page, Integer rows,String Student,String course_tea);

	public Score getScoreById(Integer id);

	public int updateCourse(Score score);
}
