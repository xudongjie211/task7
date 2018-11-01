<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/WEB-INF/date" prefix="out" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>登录页面</h3>


<div align="center">
<form action="login" method="post" >
	<table align="center">
		<tr>
			<td>用户名</td>
			<td><input type="text" name="name" value="" required="required"></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password" value="" required="required"></td>
		</tr>	
		<tr>
			<td>手机号码</td>
			<td><input type="text" name="phone" id="phone" placeholder="请输入手机号" required="required"></td>
			<!-- <td><input type="button" id="verify" value="获取短信验证码"></td> -->
			<td> <button id="verify" type="button" onclick="invokeSettime('#verify')">获取验证码</button></td>
		</tr>		
		<tr>
			<td>验证码</td>
			<td><input type="text" name="verifynum"  placeholder="请输入验证码" required="required"></td>
		</tr>		
		<tr>
			<td colspan="2"><input type="submit" value="登录"></td>
		</tr>
	

	</table>
</form>
</div>


<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script  type="text/javascript"> 
   $("#verify").click(function(){ 
    	//alert("提交成功");
       // var id=document.getElementById('id').value; 
        var phone=document.getElementById("phone").value; 
        var category={"phonenum":phone}; 
        var jsonData = JSON.stringify(category);
        var page="${pageContext.request.contextPath}/sendPhone";       
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

   /*  new invokeSettime("#verify") */
  
   </script> 




</body>
</html>