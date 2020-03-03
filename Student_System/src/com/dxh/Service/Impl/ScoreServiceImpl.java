package com.dxh.Service.Impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxh.Service.ScoreService;
import com.dxh.common.utils.Page;
import com.dxh.dao.ScoreDao;
import com.dxh.po.Score;

@Service("scoreService")
@Transactional
public class ScoreServiceImpl implements ScoreService {
	
	@Autowired
	private ScoreDao scoreDao;
	
	@Override
	public Page<Score> findScoreList(Integer page, Integer rows,
			String Student, String course_tea) {
		// TODO 自动生成的方法存根
		Score score=new Score();
		if(StringUtils.isNoneBlank(Student)){
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(Student);
			if( !isNum.matches() )
				score.setStudent_name(Student);
			else
				score.setStudent_id(Integer.parseInt(Student));
		}
		if(StringUtils.isNoneBlank(course_tea))
			score.setCourse_tea(course_tea);
		score.setStart((page-1)*rows);
		score.setRows(rows);
		List<Score> scores=scoreDao.selectScoreList(score);
		Integer count =scoreDao.selectScoreListCount(score);
		Page<Score> result =new Page<com.dxh.po.Score>();
		result.setPage(page);
		result.setRows(scores);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}

	@Override
	public Score getScoreById(Integer id) {
		Score score= scoreDao.getScoreById(id);
		return score;
	}

	@Override
	public int updateCourse(Score score) {
		// TODO 自动生成的方法存根
		return scoreDao.updateScore(score);
	}

}
