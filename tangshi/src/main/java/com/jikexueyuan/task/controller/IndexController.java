package com.jikexueyuan.task.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jikexueyuan.task.entity.Poet;
import com.jikexueyuan.task.entity.Poetry;
import com.jikexueyuan.task.service.PoetryService;
import com.jikexueyuan.task.util.PageBean;
import com.jikexueyuan.task.util.PageUtil;

@Controller
public class IndexController {

	@Resource
	PoetryService service;
	private static int PAGESIZE = 10;

	@RequestMapping(value = "index")
	public String helloWorld(HttpServletRequest request) {
		return "index";
	}

	@RequestMapping(value = "search")
	public String searchPoetry(HttpServletRequest request) {
		// 获取总记录数
		String currPageStr = request.getParameter("currentPage");
		String typeStr = request.getParameter("type");
		String keyStr = request.getParameter("key");

		int currPage = 1;
		try {
			currPage = Integer.parseInt(currPageStr);
		} catch (Exception e) {
		}
		if(typeStr.equals("0")) 
			PAGESIZE=40;
		Map<String, Object> params = new HashMap<>();
		params.put("type", typeStr);
		params.put("key", keyStr);
		params.put("offset", currPage-1);
		params.put("size", PAGESIZE);

		List<Poet> poets = service.searchByCondition(params);
		// System.out.println("查询------------>"+params+","+poets.size());
		// for (Poet poet : poets) {
		// System.out.println("诗人id="+poet.getId()+","+poet.getName());
		// List<Poetry> poetries=poet.getPoetries();
		// for (Poetry poetry : poetries) {
		// System.out.println("诗人poetid="+poetry.getPoet_id()+",诗词标题="
		// +poetry.getTitle());
		// }
		// }

		int totalSize = service.getCount(params);
		System.out.println("结果总数：" + totalSize);
		PageBean page = new PageBean(currPage, PAGESIZE, totalSize, "search.html",
				"type=" + typeStr + "&key=" + keyStr);

		request.setAttribute("type", typeStr);
		request.setAttribute("poets", poets);
		request.setAttribute("pageBean", PageUtil.genPagination(page));
		return "index";
	}
	@RequestMapping(value = "detail")
	public String searchDetail(HttpServletRequest request) {
		String typeStr = request.getParameter("type");
		String keyStr1 = request.getParameter("key1");
		String keyStr2 = request.getParameter("key2");

		Map<String, Object> params = new HashMap<>();
		params.put("type", typeStr);
		params.put("key1", keyStr1);
		params.put("key2", keyStr2);
		params.put("offset", 0);
		params.put("size", PAGESIZE);
		
		List<Poet> poets = service.searchByCondition(params);

		request.setAttribute("type", typeStr);
		request.setAttribute("poets", poets);
		return "index";
	}

}
