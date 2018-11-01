<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/base.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/t11.css" rel="stylesheet" type="text/css">
</head>
<body>


    <div class="top container">
        <p class="hidden-xs">客服热线：010-594-78634</p>
        <img src="${pageContext.request.contextPath}/imges/12321.gif">
        
    </div>

    <div role="navigation" class="nav1 navbar navbar-default">
        <div class="container">
            <div class="header-logo">
            <font color="red"><a href="${pageContext.request.contextPath}/login.jsp">登录</a></font>
<font color="red"><a href="${pageContext.request.contextPath}/register.jsp">注册</a></font>
                <div class="logo-middle"><img src="${pageContext.request.contextPath}/imges/logo.png"></div>
            </div>
            <div class="navbar-header marginTop">
                <button data-target="#example-navbar-collapse" data-toggle="collapse" class="navbar-toggle" type="button">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>

            <div id="example-navbar-collapse" class=" collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <a href="${pageContext.request.contextPath}/homepage"><li>首 页</li></a>
                    <a href="${pageContext.request.contextPath}/coursepage"><li class="border">职 业</li></a>
                    <a href="${pageContext.request.contextPath}/recommend"><li>推 荐</li></a>
                    <a href="${pageContext.request.contextPath}/u/list"><li>列 表</li></a>
                    <a href="${pageContext.request.contextPath}/u/personalpage"><li>个人主页</li></a>
                </ul>
            </div>
        </div>

    </div>



</body>
</html>