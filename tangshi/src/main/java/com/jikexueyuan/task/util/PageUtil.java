package com.jikexueyuan.task.util;

/**
 * 分页工具类
 * 
 * @author Administrator
 *
 */
public class PageUtil {
	
	public PageUtil() {
		// TODO 自动生成的构造函数存根
	}
	
	/**
	 * @return 分页代码
	 */
	public static String genPagination(PageBean page) {
		if (page.getTotalPage() == 0) {
			return "未查询到数据";
		} else {
			StringBuffer pageCode = new StringBuffer();
			pageCode.append("<li><a href='" + page.getTargetUrl() + "?currentPage=1&" + page.getParams() + "'>首页</a></li>");
			/*********************************上一页********************************************/
			if (page.isHasPrevious()) {
				pageCode.append("<li><a href='" + page.getTargetUrl() + "?currentPage=" + (page.getCurrentPage() - 1) + "&"
						+ page.getParams() + "'>上一页</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a href='" + page.getTargetUrl() + "?currentPage="
						+ (page.getCurrentPage() - 1) + "&" + page.getParams() + "'>上一页</a></li>");				
			}
			/*********************************上一页END********************************************/
			for (int i = page.getCurrentPage() - 4; i <= page.getCurrentPage() + 4; i++) {
				if (i < 1 || i > page.getTotalPage()) {
					continue;
				}
				if (i == page.getCurrentPage()) {
					pageCode.append("<li class='active'><a href='" + page.getTargetUrl() + "?currentPage=" + i + "&"
							+ page.getParams() + "'>" + i + "</a></li>");
				} else {
					pageCode.append("<li><a href='" + page.getTargetUrl() + "?currentPage=" + i + "&" + page.getParams() + "'>"
							+ i + "</a></li>");
				}
			}
			if (page.isHasnext() && page.getTotalPage() > 5) {
				pageCode.append("<li><a>...</a></li>");
			}
			/*********************************上一页********************************************/
			if (page.isHasnext()) {
				pageCode.append("<li><a href='" + page.getTargetUrl() + "?currentPage=" + (page.getCurrentPage() + 1) + "&"
						+ page.getParams() + "'>下一页</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a href='" + page.getTargetUrl() + "?currentPage="
						+ (page.getCurrentPage() + 1) + "&" + page.getParams() + "'>下一页</a></li>");
			}
			/*********************************上一页END********************************************/
			pageCode.append("<li><a href='" + page.getTargetUrl() + "?currentPage=" + page.getTotalPage() + "&"
					+ page.getParams() + "'>尾页</a></li>");
			pageCode.append("<li><span class='text-center'>共" + page.getTotalPage() + "页</span></li>");
			/*********************************跳转********************************************/
			pageCode.append("<li><span class='text-center'><form action='"+page.getTargetUrl()+"?"+page.getParams()+"' method='post'>"
					+ " <input type='text' "
					+ "name='currentPage' value='"+page.getCurrentPage()+"'/>"
					+ "<input type='submit' value='跳转'/></form></span></li>");
			System.out.println(pageCode.toString());
			return pageCode.toString();
		}
	}

}
