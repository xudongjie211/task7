<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/WEB-INF/date" prefix="out" %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/jquery.min.js"></script> --%>
<!-- <script type="text/javascript" src="jquery.min.js"></script> -->
</head>
<body>
<h3>注册页面</h3>



<form action="registersure" method="post" >
	<table align="center">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="name" value=""></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password" value=""></td>
		</tr>
		<tr>
			<td>电话号码</td>
			<td><input type="text" name="phone" placeholder="请输入电话号码" required="required"></td>
		</tr>
		<tr>
		<tr>
			<td colspan="2"><input type="submit" value="注册申请"></td>
		</tr>



	</table>
</form>








<%-- <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> --%>
</body>
</html>