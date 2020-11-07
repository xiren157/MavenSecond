var vm = new Vue({
	el: '#myModal',
	data: {
		passwd: '',
		agpasswd: '',
		
	},
	methods:{
		hideMo: function () {
			$('#myModal').modal('hide');
			},
		doupload: function() {
			if (this.passwd == "") {
				alert("密码不能为空");
				return;
			}
			if (this.agpasswd == "") {
				alert("确认密码也不能为空！");
				return;
			}
			if (this.passwd != this.agpasswd) {
				alert("两次输入的密码不一致");
				return;
			}
			$.ajax({
				url: "/upload.ajax",
				type: "post",
				dataType: "JSON",
				data: {
					passwd: this.passwd,
				},
				success: function (resp) {
					alert("修改成功");
					vm.hideMo();
				},
				error: function () {
					alert("系统错误请联系管理员！！");
				}
			});
		}
	}
})