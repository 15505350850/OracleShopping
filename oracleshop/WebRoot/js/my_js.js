$(function() {
	$(".white_content").hide();
	$(".modify_userinfo_main").hide();
	$("#modify_product_info").hide();

	loaduserlist();
	loadproductlist();
	
	
	$("#product_show_page").append("<li><a href='#'>&laquo;</a></li>");
	for(var i = 1; i < 10; i++) {

	$("#product_show_page")
			.append("<li><a href='#'>" + i + "</a></li><li>");
	}
	$("#product_show_page").append("<li><a href='#'>&raquo;</a></li>");

	$("#product_show_page a").click(function() {
		$(this).addClass("active").siblings().removeClass("active");

	});
	
	

	/* 添加商品AJAX提交方法 */
	$("#add_product_button").click(function() {
		$.ajax({
			type: "post",
			url: "/oracleshop/ProductAction?type=add",
			data: $("#add_product_form").serialize(),
			async: true,
			dataType: "text",
			error: function(request) {
				alert("网络请求错误！请重试！");
			},
			success: function(data) {
				// alert("ok");
				if(data == "ok") {
					alert("添加商品成功！");
					$(".form-control").val("");
				} else {
					alert("添加商品失败！");
				}
			}
		});
	});

	
	
	
	$("#close_modify_userinfo").click(function() {
		close_modify_userinfo();
	});
	
	$("#close_modify_product_info").click(function() {
		close_modify_productinfo();
	});
	
	/* 修改用户信息AJAX提交方法 */
	$("#submit_modify_userinfo").click(function() {
		$.ajax({
			type: "post",
			url: "/oracleshop/UserAction?type=modify",
			data: $("#modify_user_info_form").serialize(),
			async: true,
			dataType: "text",
			error: function(request) {
				alert("网络请求错误！请重试！");
			},
			success: function(data) {
				if(data == "ok") {
					alert("信息修改成功！");
					$(".white_content").fadeOut(200);
					$(".modify_userinfo_main").fadeOut(200);
					loaduserlist();
				} else {
					alert("信息修改失败！请重试！");
				}
			}
		});
	});
	
	
	/* 修改商品信息AJAX提交方法 */
	$("#submit_modify_productinfo").click(function() {
		$.ajax({
			type: "post",
			url: "/oracleshop/ProductAction?type=modify",
			data: $("#modify_product_info_form").serialize(),
			async: true,
			dataType: "text",
			error: function(request) {
				alert("网络请求错误！请重试！");
			},
			success: function(data) {
				if(data == "ok") {
					alert("商品信息修改成功！");
					$(".white_content").fadeOut(200);
					$("#modify_product_info").fadeOut(200);
					loadproductlist();
				} else {
					alert("商品信息修改失败！请重试！");
				}
			}
		});
	});
	

}); /* 自加载方法结束 */

$(function() {
	$("#datetimepicker").datetimepicker({
		format: 'yyyy-mm-dd',
		language: 'zh-CN',
		weekStart: 1,
		todayBtn: 1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
	});

});


/**
 * 修改用户信息确认退出对话框
 */
function close_modify_userinfo(){
	var con = confirm("当前信息未保存，确认关闭当前修改框？");
	if(con==true ){
		//按确认后做什么
		$(".white_content").fadeOut(200);
		$(".modify_userinfo_main").fadeOut(200);
		}
		else
		{
		//按否做些什么
			return;
		}
}


/**
 * 加载用户信息的相关方法
 */
function loaduserlist(){
	/**
	 * 加载用户列表方法
	 */
	$.ajax({
			type: "post",
			url: "/oracleshop/UserAction?type=list",
			async: true,
			dataType: "json",
			error: function(request) {
				alert("网络请求错误！请重试！");
			},
			success: function(data) {
				var obj = eval(data);
				var list = obj.userlist;
				var a = list.length;
				$(".user_list_tb").empty();
				for(var i = 0; i < a; i++) {
					$(".user_list_tb")
						.append(
							"<tr><td>" +
							list[i].t_userid +
							"</td>" +
							"<td>" +
							list[i].t_name +
							"</td>" +
							"<td>" +
							list[i].t_nickname +
							"</td>" +
							"<td>1994-12-05</td>" +
							"<td>" +
							list[i].t_tel +
							"</td>" +
							"<td>" +
							list[i].t_address +
							"</td>" +
							"<td><a href='#' class='btn btn-success btn-xs ' >修改</a>   " +
							"<a href='#' class='btn btn-danger btn-xs '>删除</a></td>" +
							"</tr>");
				}
				$(".user_list tr").each(
					function() {
						var tmp = $(this).children().eq(6);
						var btn = tmp.children().eq(0);
						var del = tmp.children().eq(1);
						del.bind("click",function(){
							var t_userid = del.parent().parent().children("td").get(0).innerHTML;
							var t_name = del.parent().parent().children("td").get(1).innerHTML;
							var con = confirm("确定要删除用户："+t_name);
							if(con==true ){
								//按确认后做什么
								/* 删除用户信息AJAX提交方法 */
									$.ajax({
										type: "post",
										url: "/oracleshop/UserAction?type=del",
										data:{id:t_userid},
										async: true,
										dataType: "text",
										error: function(request) {
											alert("网络请求错误！请重试！");
										},
										success: function(data) {
											if(data == "ok") {
												alert("删除用户成功！");
												loaduserlist();
											} else {
												alert("删除用户失败！请重试！");
											}
										}
									});
								}
						});
						btn.bind("click", function() {
							var t_userid = btn.parent().parent().children("td").get(0).innerHTML;
							var t_name = btn.parent().parent().children("td").get(1).innerHTML;
							var t_nickname = btn.parent().parent().children("td").get(2).innerHTML;
							var t_tel = btn.parent().parent().children("td").get(4).innerHTML;
							var t_address = btn.parent().parent().children("td").get(5).innerHTML;
							
							$(".white_content").show();
							$(".white_content").click(function() {
								close_modify_userinfo();
							});
							$(".modify_userinfo_main").fadeIn(500);
							$("#t_userid").empty();
							$("#t_userid").append(t_userid);
							$("#modify_user_info_form > input").eq(0).val(t_userid);
							$("#modify_user_info_form > input").eq(1).val(t_name);
							$("#modify_user_info_form > input").eq(2).val(t_nickname);
							$("#modify_user_info_form > input").eq(3).val(t_tel);
							$("#modify_user_info_form > input").eq(4).val(t_address);
						});
					});
			}
		});
}

/**
 * 加载主页商品展示
 * @returns
 */
function loadproductshow(){
	$.ajax({
		type: "post",
		url: "/oracleshop/ProductAction?type=show",
		async: true,
		dataType: "json",
		error: function(request) {
			alert("网络请求错误！请重试！");
		},
		success: function(data) {
			var obj = eval(data);
			var list = obj.list;
			var a = list.length;
			$("#product_list_tb").empty();
			for(var i = 0; i < a; i++) {
				$("#product_show_con").append(
					"<div class='product_main'><div class='title'><a target='_blank' href='" +
					"/oracleshop/ProductAction?type=id&id=" +
					list[i].t_productid + "'> " +
					list[i].t_productname +
					"</a></div><div class='price'>￥ " +
					list[i].t_price + "</div></div>");
			}
		}
	});
	
}



/**
 * 加载商品列表，并为每一行数据绑定修改操作方法
 */
function loadproductlist(){
	/**
	 * 获取商品列表AJAX方法
	 */
	$.ajax({
			type: "post",
			url: "/oracleshop/ProductAction?type=show",
			async: true,
			dataType: "json",
			error: function(request) {
				alert("网络请求错误！请重试！");
			},
			success: function(data) {
				var obj = eval(data);
				var list = obj.list;
				var a = list.length;
				$("#product_list_tb").empty();
				for(var i = 0; i < a; i++) {
					$("#product_list_tb")
						.append(
							"<tr><td>" +
							list[i].t_productid +
							"</td><td>" +
							list[i].t_productname +
							"</td><td>" +
							list[i].t_price +
							"</td><td>" +
							list[i].t_num +
							"</td><td>" +
							list[i].t_productdate +
							"</td><td>" +
							list[i].t_postage +
							"</td><td>" +
							list[i].t_comment +
							"</td>" +
							"<td><a href='#' class='btn btn-success btn-xs '>修改</a> " +
							"<a href='#' class='btn btn-danger btn-xs '>删除</a></td>" +
							"</tr>");
					$("#product_show_con").append(
						"<div class='product_main'><div class='title'><a target='_blank' href='" +
						"/oracleshop/ProductAction?type=id&id=" +
						list[i].t_productid + "'> " +
						list[i].t_productname +
						"</a></div><div class='price'>￥ " +
						list[i].t_price + "</div></div>");
				}
				/**
				 * 为每行数据绑定点击事件
				 */
				$(".product_list tr").each(
						function() {
							var tmp = $(this).children().eq(7);
							var btn = tmp.children().eq(0);
							var del = tmp.children().eq(1);
							del.bind("click",function(){
								var productid = del.parent().parent().children("td").get(0).innerHTML;
								var productname = del.parent().parent().children("td").get(1).innerHTML;
								var con = confirm("确定要删除商品："+productname);
								if(con==true ){
									//按确认后做什么
									 /*删除商品信息AJAX提交方法 */
										$.ajax({
											type: "post",
											url: "/oracleshop/ProductAction?type=del",
											data:{t_productid:productid},
											async: true,
											dataType: "text",
											error: function(request) {
												alert("网络请求错误！请重试！");
											},
											success: function(data) {
												if(data == "ok") {
													alert("删除商品成功！");
													loadproductlist();
												} else {
													alert("删除商品失败！请重试！");
												}
											}
										});
									}
							});
							btn.bind("click", function() {
								var t_productid = btn.parent().parent().children("td").get(0).innerHTML;
								var t_productname = btn.parent().parent().children("td").get(1).innerHTML;
								var t_price = btn.parent().parent().children("td").get(2).innerHTML;
								var t_num = btn.parent().parent().children("td").get(3).innerHTML;
								var t_productdate = btn.parent().parent().children("td").get(4).innerHTML;
								var t_postage = btn.parent().parent().children("td").get(5).innerHTML;
								var t_comment = btn.parent().parent().children("td").get(6).innerHTML;
								$(".white_content").show();
								$(".white_content").click(function() {
									close_modify_productinfo();
								});
								$("#modify_product_info").fadeIn(500);
								$("#t_productid").empty();
								$("#t_productid").append(t_productid);
								var input = $("#modify_product_info_form > div > div > input");
								input.eq(0).val(t_productid);
								input.eq(1).val(t_productname);
								input.eq(2).val(t_price);
								input.eq(3).val(t_num);
								input.eq(4).val(t_productdate);
								input.eq(5).val(t_postage);
								input.eq(6).val(t_comment);
							});
						});
				
			}
		});
	
}


/**
 * 修改商品信息确认退出对话框
 */
function close_modify_productinfo(){
	var con = confirm("当前信息未保存，确认关闭当前修改框？");
	if(con==true ){
		//按确认后做什么
		$(".white_content").fadeOut(200);
		$("#modify_product_info").fadeOut(200);
		return;
		}
		else
		{
		//按否做些什么
			return false;
		}
}



