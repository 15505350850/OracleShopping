<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery.min.js" ></script>
	<script type="text/javascript" src="js/bootstrap.js" ></script>

  </head>
  
  <body>
  <div class="main" >
  <div class="logo">
  <a>用户登录</a>
  <input type="text" border="0" class="input_search">
  </div>
  </div>

<div class="content_main" style="background: #ffffff;">
<div class="content">
<div class="container" style="background:#EEE;width: 400px;">
      <form action="${pageContext.request.contextPath}/UserLogin" method="post" >
        <h2 style="text-align: center;">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Email address" name="username"><br>
        <input type="password" class="form-control" placeholder="Password" name="password">
        <div class="checkbox">
          <label>
            <a href="${pageContext.request.contextPath}/register.jsp">没有账号？立即注册</a>
          </label>
        </div>
        ${errMsg}
        <button type="submit" class="btn btn-primary">登录</button>
      </form>
    </div> <!-- /container -->


</div>

</div>
  
    
    

  </body>
</html>
