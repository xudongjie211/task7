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


<div align="center">
<!-- <form action="register" method="post" >
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
			<td><input type="text" name="phone" placeholder="请输入电话号码" required="required"></td>required="required"
		</tr>
		<tr>
		<td>邮箱</td>
			<td><input type="text" name="email" id="email"  placeholder="请输入邮箱" required="required"></td>
			<td><input type="button"  id="emailverify" value="发送邮箱验证码"></td>
			
		</tr>
		<tr>
		<td>邮箱验证码</td>
			<td><input type="password" name="emailverify" value=""></td>
		</tr>
		
			
		<tr>
			<td colspan="2"><input type="submit" value="注册"></td>
		</tr>



	</table>
</form> -->


	<table align="center">
		<tr>
		<td>邮箱</td>
			<td><input type="text" name="email" id="email"  placeholder="请输入邮箱" required="required"></td>
			<!-- <td><input type="button"  id="emailverify" value="发送邮箱验证"></td> -->
			<td> <button id="emailverify" type="button" onclick="invokeSettime('#emailverify')">邮箱激活</button></td>			
		</tr>
		<tr>		
			<td><input type="hidden" value="${stunum}" id="sid" /></td>
		</tr>
	</table>








</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script  type="text/javascript"> 
   $("#emailverify").click(function(){ 
    	//alert("提交成功");
       // var id=document.getElementById('id').value; 
        var email=document.getElementById("email").value; 
        var id=document.getElementById("sid").value;
        var category={"email":email,"sid":id}; 
        var jsonData = JSON.stringify(category);
        var page="${pageContext.request.contextPath}/sendEmail";       
        $.ajax({
                type:"post",
               url: page,
               data:jsonData,
               dataType:"json",
               contentType : "application/json;charset=UTF-8",
               success: function(result){
               }
            });
           alert("提交成功");
 
    });  
  
  function invokeSettime(obj){
	      var countdown=60;
	      settime(obj);
	      function settime(obj) {
	          if (countdown == 0) {
	              $(obj).attr("disabled",false);
	              $(obj).text("获取验证码");
	              countdown = 60;
	              return;
	          } else {
	              $(obj).attr("disabled",true);
	              $(obj).text("(" + countdown + ") s 重新发送");
	              countdown--;
	          }
	          setTimeout(function() {
	                      settime(obj) }
	                  ,1000)
	      }
	  }  
  
  
  
    </script> 

<%-- <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script> --%>
</body>
</html>