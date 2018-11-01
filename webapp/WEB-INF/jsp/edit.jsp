<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<div style="width:500px;margin:0px auto;text-align:center">

		<form action="${pageContext.request.contextPath}/list/${stu.id}" method="post">
		<input type="hidden" value="PUT" name="_method">			
		qq:	<input type="text" name="qq" value="${stu.qq}"><br>
		name:<input type="text" name="name" value="${stu.name}"><br>
		job:<input type="text" name="job" value="${stu.job}"><br>
			<input type="submit"  value="提交"><br>

		</form>
</div>


</body>
</html>