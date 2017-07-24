package com.jikexueyuan.task.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jikexueyuan.task.dao.IPoetryDao;
import com.jikexueyuan.task.entity.Poet;
import com.jikexueyuan.task.entity.Poetry;

@Service
public class PoetryService {
	@Resource
	IPoetryDao dao;

	/**
	 * 条件搜索
	 * 
	 * @param name
	 * @return
	 */
	public List<Poet> searchByCondition(Map<String, Object> params) {
		return dao.searchByCondition(params);
	}

	/**
	 * id
	 * 
	 * @param content
	 * @return
	 */
	Poetry searchById(int id) {
		return null;

	}

	public int getCount(Map<String, Object> params) {
		return dao.getCount(params);
	}
}
