<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>唐诗搜索</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style type="text/css">
select {
	background: transparent;
	border: none;
	padding-left: 10px;
	width: 60px;
	height: 100%;
}

#ul1 {
	overflow: hidden;
	width: 100%;
	list-style: none;
	padding-left: 0px;
	margin-top: 15px;
}

#ul1 li {
	width: 30.333%;
	float: left;
	line-height: 8px;
	/*background-color: red;*/
	margin-right: 10px;
	padding: 0px;
	margin-top: 0px;
}

.disabled {
	pointer-events: none;
}
</style>
</head>
<body>

	<div class="jumbotron">
		<div class="container">
			<h1>唐诗搜索</h1>
		</div>
	</div>
	<div class="container">
		<form class="form-inline" action="search.html" method="post">
			<div class="form-group">
				<!--<label class="sr-only" for="exampleInputAmount">Amount (in dollars)</label>-->
				<div class="input-group">
					<!--<div class="input-group-addon">$</div>-->
					<input type="text" class="form-control" id="exampleInputAmount"
						name="key" placeholder="">
					<div class="input-group-addon">
						<select name="type">
							<option value="0">作者</option>
							<option value="1">标题</option>
							<option value="2">名句</option>
						</select>
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-info">搜索</button>
		</form>
		<ul id="ul1">
			<c:forEach items="${poets}" var="item">
				<%-- <h1>${item.id}</h1> --%>
				<%
					String type = (String) request.getAttribute("type");
						if (type.equals("0")) {
				%><!-- 作者，显示标题列表 -->
				<c:forEach items="${item.poetries}" var="poetry">
					<li><a href="detail.html?type=3&key1=${poetry.title}&key2=${item.name}" class="active">
							<h6 class="list-group-item-heading">${poetry.title }</h6>
					</a></li>
				</c:forEach>
				<%
					} else if (type.equals("1")) {
				%><!-- 诗词名称，显示唐诗全文-->
				<c:forEach items="${item.poetries}" var="poetry">
					<li class="list-group"><a href="detail.html?type=3&key1=${poetry.title}&key2=${item.name}"
						class="list-group-item ">
							<h4 class="list-group-item-heading">${poetry.title }</h4>
							<h6 class="list-group-item-heading" style="text-align: right;">——${item.name }</h6>
					</a> </li>
				</c:forEach>
				<%
					} else if (type.equals("2")||type.equals("3")) {
				%><!-- 诗词名句，显示唐诗作者、题目、全文-->
				<c:forEach items="${item.poetries}" var="poetry">
					<li class="list-group"><div  
						class="list-group-item active">
							<h4 class="list-group-item-heading">${poetry.title }</h4>
							<h6 class="list-group-item-heading" style="text-align: right;">——${item.name }</h6>
					</div> <div class="list-group-item">
							<h4 class="list-group-item-heading">${poetry.poet.name}</h4>
							<p class="list-group-item-text">${poetry.content }</p>
					</div></li>
				</c:forEach>
				<%
					} 
				%>

			</c:forEach>
		</ul>
		<ul class="pagination" style="list-style:">${pageBean}
		</ul>
	</div>
</body>
</html>