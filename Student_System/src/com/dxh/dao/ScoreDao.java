package com.dxh.dao;

import java.util.List;

import com.dxh.po.Score;

public interface ScoreDao {
	public List<Score> selectScoreList(Score Score);
	public Integer selectScoreListCount(Score Score);
	public Score getScoreById(Integer id);
	public int updateScore(Score score);
}
