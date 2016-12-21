<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>${sessionScope.productBean.t_productname}</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
  <div class="main" style="margin-bottom: 0px;">
		<div class="logo">
			<b>在线购物网后台管理</b> <a href="#" class="select">商品展示</a> 
			<a href="${pageContext.request.contextPath}/admin/search.jsp">搜索商品</a>
			<a href="${pageContext.request.contextPath}/admin/addproduct.jsp">添加商品</a>
			<a href="${pageContext.request.contextPath}/admin/productlist.jsp">商品列表</a>
			<a href="${pageContext.request.contextPath}/admin/userlist.jsp">用户列表</a>
			<div class="input_search">
				<a href="#">用户：${sessionScope.username}</a> <a
					href="javascript:if(confirm('确定要退出登录吗?'))location='/shop/UserLogout'">退出登录</a>
				<a href="#">修改密码</a>
			</div>
		</div>
	</div>
	<div class="content_main">
		<div class="content" style="height: 500px;">
				<div class="product_info">
					<div class="title">
						${sessionScope.productBean.t_productname}
					</div>
					<div class="price">
						￥ ${sessionScope.productBean.t_price}
					</div>
					<div class="other">库存：${sessionScope.productBean.t_num}</div>
					<div class="other">上市日期：${sessionScope.productBean.t_productdate}</div>
					<div class="other">运费：${sessionScope.productBean.t_postage}</div>
					<div class="simple">商品简介：</div>
					<div class="simple_main">${sessionScope.productBean.t_comment}</div>
					<div class="buy_now">
						
						<div class="row">
							<div class="col-xs-6 col-xs-6" style="text-align: center;" >
								 <button type="button" class="btn btn-danger">立即购买</button>
							</div>
							<div class="col-xs-6 col-xs-6" style="text-align: center;">
								 <button type="button" class="btn btn-primary">添加到购物车</button>
							</div>

						</div>

					</div>

				</div>

			</div>

	</div>
  </body>
</html>
