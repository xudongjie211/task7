<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h3>个人页面</h3>
<div>
<form>
	编号<input  type="text" name="id" id="id" value="${stu.id}" disabled="disabled"><br>
	姓名<input type="text" name="name" id="name" value="${stu.name}"><input type="button" id="namehandle" value="修改" ><br>
	电话<input type="text" name="phone" id="phone" value="${stu.phone}"><input type="button" id="phonehandle" value="修改" ><br>
	邮箱<input type="text" name="email" id="email" value="${stu.email}"><input type="button" id="emailhandle" value="修改"><br>
</form>
<img src="${stu.image}"><br>
<input type="button" id="deleteimage" value="删除图片"><a href="${stu.image}" target="_blank">下载图片</a>
<p>个人头像</p>
</div>
<br>
<form action="${pageContext.request.contextPath}/u/imagehandle" enctype="multipart/form-data" method="post">
选择图片:<input type="file" name="file" accept="image/*" /> <br>
		<input type="submit" value="上传图片或修改">
</form>



<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script  type="text/javascript"> 
$("#namehandle").click(function(){  
    var myname=document.getElementById("name").value; 
    var category={"name":myname}; 
    var jsonData = JSON.stringify(category);
    $.ajax({
          type: "put",
          url: "${pageContext.request.contextPath}/namehandle",
          data:jsonData,
          dataType:"json",
          contentType : "application/json;charset=UTF-8",
          success : function(data) {
              //接收并处理返回结果
              /* document.write(data); */
        	    alert("提交成功,姓名改为："+data.name);
              } ,
              error : function(data) {
            	  alert("提交失败");
              } 

        });

}); 

$("#phonehandle").click(function(){  
    var myphone=document.getElementById("phone").value; 
    var category={"phone":myphone}; 
    var jsonData = JSON.stringify(category);
    $.ajax({
          type: "put",
          url: "${pageContext.request.contextPath}/phonehandle",
          data:jsonData,
          dataType:"json",
          contentType : "application/json;charset=UTF-8",
          success : function(data) {
              //接收并处理返回结果
              /* document.write(data); */
        	    alert("提交成功,电话改为："+data.phone);
              } ,
              error : function(data) {
            	  alert("提交失败");
              } 

        });

}); 

$("#emailhandle").click(function(){  
    var myemail=document.getElementById("email").value; 
    var category={"email":myemail}; 
    var jsonData = JSON.stringify(category);
    $.ajax({
          type: "put",
          url: "${pageContext.request.contextPath}/emailhandle",
          data:jsonData,
          dataType:"json",
          contentType : "application/json;charset=UTF-8",
          success : function(data) {
              //接收并处理返回结果
              /* document.write(data); */
        	    alert("提交成功,邮箱改为："+data.email);
              } ,
              error : function(data) {
            	  alert("提交失败");
              } 

        });

}); 

$("#deleteimage").click(function(){  
    var myid=document.getElementById("id").value; 
    var category={"id":myid}; 
    var jsonData = JSON.stringify(category);
    $.ajax({
          type: "delete",
          url: "${pageContext.request.contextPath}/imagedelete",
          data:jsonData,
          dataType:"json",
          contentType : "application/json;charset=UTF-8",
          success : function(data) {
        	    
              } 

        });
    alert("删除成功");
}); 


</script> 












</body>
</html>