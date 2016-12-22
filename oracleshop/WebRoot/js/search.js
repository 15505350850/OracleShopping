$(function() {
	$(".find_num").hide();

	$("#product_like").bind("keypress",function(event){
        if(event.keyCode == "13")    
        {
        searchproduct();
        }
    });
	
	
	$("#search_product_byword").click(function() {
		searchproduct();
	});

});

function searchproduct(){
	$.ajax({
		type : "post",
		url : "/oracleshop/ProductAction?type=search",
		data : {
			product_like : $("#product_like").val()
		},
		async : true,
		dataType : "json",
		error : function(request) {
			alert("网络请求错误！");
		},
		success : function(data) {
			var obj = eval(data);
			var list = obj.list;
			var a = list.length;
			if (a < 1) {
				$(".find_num").show();
				$(".find_num").empty();
				$(".find_num").append("<span>"+"未找到相关商品，换个关键词试试吧！"+"</span>"+
						"");
				$("#product_search_con").empty();
			} else {
				$(".find_num").show();
				$(".find_num").empty();
				$(".find_num").append("搜索：" +"<span>"+$("#product_like").val()+"</span>"+
						"     已为您找到<span>"+a+"</span>件商品" +
						"");
				$("#product_search_con").empty();
				for ( var i = 0; i < a; i++) {
					$("#product_search_con").append(
							"<div class='product_main'><div class='title'><a target='_blank' href='" +
							"/oracleshop/ProductAction?type=id&id=" +
							list[i].t_productid + "'> " +
							list[i].t_productname +
							"</a></div><div class='price'>￥ " +
							list[i].t_price + "</div></div>");

				}

			}

		}
	});
	
}


