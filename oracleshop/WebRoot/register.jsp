<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>用户注册</title>

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

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/register.js"></script>
</head>

<style>
.erroemsg{
	color: #F82A0D;
	font-family: "微软雅黑";
	font-size: 12px;
}
</style>

<body>
	<div class="main">
		<div class="logo">
			<a href="index.jsp">用户登录</a>
		</div>
	</div>

	<div class="content_main">
		<div class="content" style="height: 600px;" >
			<div class="product_info" style="padding-right: 50px;">
				<div class="title">用户注册</div>

				<form class="form-horizontal" role="form" id="register_form">
					<div class="form-group" id="username">
						<label for="firstname" class="col-sm-2 control-label">用户名：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"  name="username"
								placeholder="用户名一旦注册不可更改">
								<span class="erroemsg" id="username_msg"></span>
						</div>
						
					</div>
					<div class="form-group" id="password1">
						<label for="firstname" class="col-sm-2 control-label">密码：</label>
						<div class="col-sm-10">
							<input type="password" class="form-control"  name="password1"
								placeholder="请输入密码">
								<span class="erroemsg" id="password1_msg"></span>
						</div>
					</div>
					<div class="form-group" id="password2">
						<label for="firstname" class="col-sm-2 control-label">确认密码：</label>
						<div class="col-sm-10">
							<input type="password" class="form-control"  name="password2"
								placeholder="请再次输入密码">
						</div>
					</div>
					<div class="form-group" id="nickname">
						<label for="lastname" class="col-sm-2 control-label">昵称：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"  name="nickname"
								placeholder="请输入昵称">
								<span class="erroemsg" id="nickname_msg"></span>
						</div>
					</div>
					<div class="form-group" id="tel">
						<label for="lastname" class="col-sm-2 control-label">手机号：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"  name="tel"
								placeholder="请输入11位手机号码">
								<span class="erroemsg" id="tel_msg"></span>
						</div>
					</div>
					<div class="form-group" id="address">
						<label for="lastname" class="col-sm-2 control-label">住址：</label>
						<div class="col-sm-10">
							<input type="text" class="form-control"  name="address"
								placeholder="请输入通讯地址">
								<span class="erroemsg" id="address_msg"></span>
						</div>
					</div>
					</form>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button style="float: left; margin-left: 50px;"  class="btn btn-success" id="go_register">立即注册</button>
							<button style="float: right; margin-right: 50px;"  class="btn btn-danger" id="cancle_register">取消注册</button>
						</div>
						
					</div>
				



			</div>
		</div>
	</div>


</body>
</html>
