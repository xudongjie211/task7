<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <div width="1000px" align="center"><!--style="width:1000px;margin:0px auto;text-align:center"  -->
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>password</td>
            <td>create_at</td>
        </tr>
        <c:forEach items="${cs}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                 <td>${c.password}</td>
                <td>${c.create_at}</td>
                <td><a href="${pageContext.request.contextPath}/edit/${c.id}">编辑</a></td>
      <th>
    <form action="${pageContext.request.contextPath}/list/${c.id}" method="post">
    <input type="hidden" value="DELETE" name="_method">
    <input type="submit" value="点击删除">
    </form>
    </th>
 
  <%--   <th>
    <form action="${pageContext.request.contextPath}/list/${c.id}" method="post">
    <input type="submit" value="修改">
    <input type="hidden" value="put" name="_method">
    </form>

    </th> --%>
            </tr>
        </c:forEach>
    </table>
    <div style="text-align:center">
        <a href="?start=0">首  页</a>
        <a href="?start=${page.start-page.count}">上一页</a>
        
        <a   <c:if test="${page.start+page.count<=page.last}">   href="?start=${page.start+page.count}"</c:if>>下一页</a>
        <a href="?start=${page.last}">末  页</a>
    </div>
 </div>
</body>
</html>