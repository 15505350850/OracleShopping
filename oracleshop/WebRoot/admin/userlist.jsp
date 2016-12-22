<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/my_js.js"></script>
	<script type="text/javascript">
	var username = "${sessionScope.username}";
	if (username == "") {
		alert("您还没有登录，请先登录！");
		window.location.href = "/oracleshop/index.jsp";
	}
</script>

  </head>
  
  <body>
  <div class="white_content"></div>
		<div class="main" style="margin-bottom: 0px;">
			<div class="logo">
				<b>在线购物网后台管理</b>
				<a href="${pageContext.request.contextPath}/admin/main.jsp">商品展示</a>
				<a href="${pageContext.request.contextPath}/admin/search.jsp">搜索商品</a>
				<a href="${pageContext.request.contextPath}/admin/addproduct.jsp">添加商品</a>
				<a href="${pageContext.request.contextPath}/admin/productlist.jsp">商品列表</a>
				<a href="#" class="select">用户列表</a>
				<div class="input_search" >
				<a href="#">用户：${sessionScope.username}</a>
				<a href="javascript:if(confirm('确定要退出登录吗?'))location='/oracleshop/UserLogout'">退出登录</a>
				<a href="#">修改密码</a></div>
			</div>
		</div>
		<div class="content_main">
			<div class="content">
				<div class="user_list">
					<table class="table table-striped" style="font-family: '微软雅黑';font-size: 13px">
						<thead>
							<tr>
								<th style="width: 10%;">用户ID</th>
								<th style="width: 10%;">用户名</th>
								<th style="width: 10%;">昵称</th>
								<th style="width: 15%;">生日</th>
								<th style="width: 15%;">电话</th>
								<th style="width: 25%;">地址</th>
								<th style="width: 15%;">操作</th>

							</tr>
						</thead>
						<tbody class="user_list_tb">
							<!-- 此处使用ajax加载数据 -->
						</tbody>
					</table>
				</div>
				
				<div class="modify_userinfo_main">
					<div class="title">修改用户信息 id：<span id="t_userid"></span>
					</div>
					<div class="container">
      <form  method="post"  id="modify_user_info_form" >
      <input  name="t_userid" type="hidden" >
        用户名：<span style="color:#e12d2d;font-size: 11px">*不可修改</span><input type="text " class="form-control " placeholder="请输入用户名 " name="t_name" readonly="readonly" ><br>
        昵称：<input type="text " class="form-control " placeholder="请输入您的昵称 " name="t_nickname"><br>
        联系方式：<input type="text " class="form-control " placeholder="请输入您的手机号 " name="t_tel"><br>
        联系地址：<input type="text " class="form-control " placeholder="请输入地址 " name="t_address"><br>
        <button type="button" id="submit_modify_userinfo" class="btn btn-primary ">确认修改</button> <button type="button"  id="close_modify_userinfo" class="btn btn-danger ">取消</button>
      </form>
    </div> <!-- /container -->
				
				
				
			</div>

		</div>
	</body>
	
	
	
</html>
