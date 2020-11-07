function checkAccount() {
	var user_name = $("#user_name").val();
	$.ajax({
		url: "/account-check.ajax",
		type: "post",
		dataType: "JSON",
		data: {
			uname: user_name
		},
		success: function (response) {
			var state = response.state;
			if (state == 0) {
				// console.log(state);
				$(".err").hide();
				$(".suc").show();
			} else if(state == -1){
				// console.log(state);
				$(".err").show();
				$(".suc").hide();
			}else{
				// console.log(state);
				alert("请输入用户名");
			}
		},
		error: function () {
			// console.log("000");
			alert("系统错误请联系管理员！！");
		}
	});
}