package com.jikexueyuan.task.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jikexueyuan.task.entity.Poet;
import com.jikexueyuan.task.entity.Poetry;
@Repository
public interface IPoetryDao {
	/**
	 * 条件搜索
	 * 
	 * @param name
	 * @return
	 */
	List<Poet> searchByCondition(Map<String, Object> params);

	/**
	 * 根据Id搜索
	 * 
	 * @param content
	 * @return
	 */
	Poetry searchById(int id);
	/**
	 * 
	 * @param type 0作者，1标题,2内容
	 * @param key
	 * @return
	 */
	int getCount(Map<String, Object> params);
}
