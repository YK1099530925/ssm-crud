<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工列表</title>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!-- web路径：
不以/开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题。
以/开始的相对路径，找资源，以服务器的路径为标准(http://localhost:3306)；需要加上项目名
		http://localhost:3306/crud
 -->
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<link
	href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH }/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>ssm-crud</h1>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<td>ID</td>
						<td>empName</td>
						<td>gender</td>
						<td>email</td>
						<td>deptName</td>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<td>${emp.empId }</td>
							<td>${emp.empName }</td>
							<td>${emp.gender=="M"?"男":"女" }</td>
							<td>${emp.email }</td>
							<td>${emp.departMent.deptName }</td>
							<th>
								<button class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									编辑
								</button>
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									刪除
								</button>
							</th>
						</tr>
					</c:forEach>
					
				</table>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6">
				当前${pageInfo.pageNum }页,总${pageInfo.pages }页,总${pageInfo.total }记录
			</div>
			
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				  	<li><a href="${APP_PATH }/emps?pageNum=1">首页</a></li>
				  	<c:if test="${pageInfo.hasPreviousPage }">
				  		<li>
					      <a href="${APP_PATH }/emps?pageNum=${pageInfo.pageNum - 1 }" aria-label="Previous">
					        <span aria-hidden="true">&laquo;</span>
					      </a>
					    </li>
				  	</c:if>
				    
				    <c:forEach items="${pageInfo.navigatepageNums }" var="pageNum">
				    	<c:if test="${pageNum == pageInfo.pageNum }">
				    		<li class="active"><a href="#">${pageNum }</a></li>
				    	</c:if>
				    	<c:if test="${pageNum != pageInfo.pageNum }">
				    		<li><a href="${APP_PATH }/emps?pageNum=${pageNum }">${pageNum }</a></li>
				    	</c:if>
				    </c:forEach>
				    <c:if test="${pageInfo.hasNextPage }">
				    	<li>
					      <a href="${APP_PATH }/emps?pageNum=${pageInfo.pageNum + 1 }" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
				    </c:if>
				    
				    <li><a href="${APP_PATH }/emps?pageNum=${pageInfo.pages }">末页</a></li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>