$(function() {
	
	/**
	 * 用户注册JS
	 */
	
	/* 点击注册验证 */
	$("#go_register").click(function() {
		/**
		 * 注册信息表单验证
		 */
		var username = $("#username  input").val();
		var nickname = $("#nickname  input").val();
		var password1 = $("#password1  input").val();
		var password2 = $("#password2  input").val();
		var tel = $("#tel  input").val()+"";
		var address = $("#address  input").val();
		//alert(username+""+nickname+password1+password2+tel+address);
		/**
		 * 用户名判断
		 */
		var checkusername =  /^[A-Za-z0-9]+$/;
		if(username==""||!checkusername.test(username)){
			$("#username").addClass("has-error");
			$("#username_msg").empty();
			$("#username_msg").append("*用户名不能为空，且只能由字母或数字组成");
			return false;
		}
		/**
		 * 密码验证 一致  没特殊字符
		 */
		if(password1!=password2){
			$("#password1").addClass("has-error");
			$("#password2").addClass("has-error");
			$("#password1_msg").empty();
			$("#password1_msg").append("*两次密码输入不一致，请重新输入！");
			return false;
		}
		if(!checkusername.test(password1)||!checkusername.test(password2)||password1==""||password2==""){
			$("#password1").addClass("has-error");
			$("#password2").addClass("has-error");
			$("#password1_msg").empty();
			$("#password1_msg").append("*密码不能为空，且只能由字母和数字组成");
			return false;
		}
		/**
		 * 昵称判断  非空
		 */
		if(nickname==""){
			$("#nickname").addClass("has-error");
			$("#nickname_msg").empty();
			$("#nickname_msg").append("*昵称不能为空");
			return false;
		}
		/**
		 * 电话号码判断
		 */
		var checktel = /^1[34578]\d{9}$/;
		if(!checktel.test(tel)||tel==""){
			$("#tel").addClass("has-error");
			$("#tel_msg").empty();
			$("#tel_msg").append("*手机号码不能为空，且只能由11位数字组成");
			return false;
		}
		/**
		 * 地址验证  非空
		 */
		if(address==""){
			$("#address").addClass("has-error");
			$("#address_msg").empty();
			$("#address_msg").append("*通信地址不能为空");
			return false;
		}
		to_register();
	});/*注册按钮验证完成*/
	
	/**
	 * 失去焦点验证
	 */
	/*用户名验证*/
	$("#username  input").blur(function(){
		var checkusername =  /^[A-Za-z0-9]+$/;
		var username = $("#username  input").val();
		if(username==""||!checkusername.test(username)){
			$("#username").addClass("has-error");
			$("#username_msg").empty();
			$("#username_msg").append("*用户名不能为空，且只能由字母或数字组成");
			return false;
		}else{
			$("#username").removeClass("has-error");
			$("#username").addClass("has-success");
			$("#username_msg").empty();
		}
	  });
	
	/*密码验证*/
	$("#password2  input").blur(function(){
		var checkusername =  /^[A-Za-z0-9]+$/;
		var password1 = $("#password1  input").val();
		var password2 = $("#password2  input").val();
		if(password1!=password2){
			$("#password1").addClass("has-error");
			$("#password2").addClass("has-error");
			$("#password1_msg").empty();
			$("#password1_msg").append("*两次密码输入不一致，请重新输入！");
			return false;
		}else if(!checkusername.test(password1)||!checkusername.test(password2)||password1==""||password2==""){
			$("#password1").addClass("has-error");
			$("#password2").addClass("has-error");
			$("#password1_msg").empty();
			$("#password1_msg").append("*密码不能为空，且只能由字母和数字组成");
			return false;
		}else{
			$("#password1").removeClass("has-error");
			$("#password2").removeClass("has-error");
			$("#password1_msg").empty();
			$("#password1").addClass("has-success");
			$("#password2").addClass("has-success");
		}
	});
	$("#password1  input").blur(function(){
		var checkusername =  /^[A-Za-z0-9]+$/;
		var password1 = $("#password1  input").val();
		if(!checkusername.test(password1)||password1==""){
			$("#password1").addClass("has-error");
			$("#password1_msg").empty();
			$("#password1_msg").append("*密码不能为空，且只能由字母和数字组成");
			return false;
		}else{
			$("#password1").removeClass("has-error");
			$("#password1_msg").empty();
			$("#password1").addClass("has-success");
		}
	});
	/*昵称验证*/
	$("#nickname  input").blur(function(){
		var nickname = $("#nickname  input").val();
		if(nickname==""){
			$("#nickname").addClass("has-error");
			$("#nickname_msg").empty();
			$("#nickname_msg").append("*昵称不能为空");
			return false;
		}else{
			$("#nickname").removeClass("has-error");
			$("#nickname").addClass("has-success");
			$("#nickname_msg").empty();
		}
	  });
	
	/*手机号码验证*/
	$("#tel  input").blur(function(){
	var tel = $("#tel  input").val();
	var checktel = /^1[34578]\d{9}$/;
	if(!checktel.test(tel)||tel==""){
		$("#tel").addClass("has-error");
		$("#tel_msg").empty();
		$("#tel_msg").append("*手机号码不能为空，且只能由11位数字组成");
		return false;
	}else{
		$("#tel").removeClass("has-error");
		$("#tel").addClass("has-success");
		$("#tel_msg").empty();
	}
	});
	
	/*通信地址验证*/
	$("#address  input").blur(function(){
		var address = $("#address  input").val();
		if(address==""){
			$("#address").addClass("has-error");
			$("#address_msg").empty();
			$("#address_msg").append("*通信地址不能为空");
			return false;
		}else{
			$("#address").removeClass("has-error");
			$("#address").addClass("has-success");
			$("#address_msg").empty();
		}
		});
	
	$("#cancle_register").click(function() {
		var con = confirm("当前信息未保存，确认要取消注册吗？");
		if(con==true ){
			//按确认后做什么
			location.href = "/oracleshop";
			return;
			}
			else
			{
			//按否做些什么
				return false;
			}
	});
	
});/*自加载方法结束*/



function to_register(){
	//alert("可以提交");
	$.ajax({
	type: "post",
	url: "/oracleshop/UserRegister",
	data: $("#register_form").serialize(),
	async: true,
	dataType: "text",
	error: function(request) {
		alert("网络请求错误，请重试！");
	},
	success: function(data) {
		if(data == "ok") {/*注册成功*/
			location.href = "/oracleshop";
			alert("注册成功，请登录！");
		} else {/*注册失败*/
			alert("error");
		}
	}
});

}

