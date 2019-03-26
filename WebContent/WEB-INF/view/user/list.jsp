<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align: center;padding-left:100px;">
	<a href="${ctx}/user/add">新增</a>
	<table border="1" cellspacing="0">
		<thead>
			<tr>
				<td>序号</td>
				<td>ID</td>
				<td>用户名</td>
				<td>密码</td>
				<td>年龄</td>
				<td>修改</td>
				<td>删除</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="obj" items="${list}" varStatus="vs">
				<tr>
					<td>${vs.index + 1}</td>
					<td>${obj.id}</td>
					<td>${obj.username}</td>
					<td>${obj.password}</td>
					<td>${obj.age}</td>
					<td><a href="${ctx}/user/edit/${obj.id}">修改</a></td>
					<td><a data-id="${obj.id}" class="del-btn" href="javascript:void(0)">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form id="form1" method="POST">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
</body>
<script type="text/javascript" src="${ctx}/static/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.del-btn').on('click', function() {
			var $this = $(this);
			var id = $this.attr('data-id');
			var url = "${ctx}/user/" + id;
			$('#form1').attr('action', url);
			$('#form1').submit();
		});
	});
</script>
</html>