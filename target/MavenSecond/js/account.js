var vm = new Vue({
	el: '.my-body',
	data: {
		// 表格数据
		dataList: [],
		// 搜索数据
		sd : {
			account: ''
		},
		// 分页对象
		page: {
			index: 1,// 当前页
			max: 1,// 最大页
			list: [],// 分页数
		},
		// 编辑数据
		ed: {
			person_no: 0,
			person_nickname: '',
			person_password: '',
			department_no:'',
			person_name:'',
			person_sex:'',
			person_birthday:'',
			person_phone:'',
			person_email:'',
			person_state:''
		},
		//改变状态
		change:{
			person_no:'',
			person_state:''
		}
	},
	methods : {
		// 获取数据
		getData: function(nowIndex) {
			this.page.index = nowIndex;
			$.ajax({
				url: "/account-list.ajax",
				type: "post",
				data: {
					index: nowIndex,
					account: this.sd.account
				},
				dataType: "JSON",
				success: function (resp) {
					vm.dataList = resp.dataList;
					vm.runPage(resp.pageCount);
				},
				error: function () {
					alert("系统错误请联系管理员！！");
				}
			});
		},
		// 上一页
		goUp: function() {
			if (this.page.index > 1) {
				this.page.index = this.page.index - 1;
				this.getData(this.page.index);
			}
		},
		// 下一页
		goDown: function() {
			if (this.page.index < this.page.max) {
				this.page.index = this.page.index + 1;
				this.getData(this.page.index);
			}
		},
		// 计算分页数
		runPage: function(max) {
			this.page.max = max;
			this.page.list = [];
			for (var i = 1; i <= max; i++) {
				this.page.list.push(i);
			}
		},
		// 编辑方法
		edit: function(data) {
			this.ed.person_no = data.person_no;
			this.ed.person_nickname = data.person_nickname;
			this.ed.person_password = data.person_password;
			this.ed.department_no = data.department_no;
			this.ed.person_name = data.person_name;
			this.ed.person_sex = data.person_sex;
			this.ed.person_birthday = data.person_birthday;
			this.ed.person_phone = data.person_phone;
			this.ed.person_email = data.person_email;
			this.ed.person_state = data.person_state;
			this.openMo();
		},
		// 弹出
		openMo: function () {
			$('#editMo').modal({
				keyboard: false,
				backdrop: 'static'
			});
		},
		// 关闭
		hideMo: function () {
			$('#editMo').modal('hide');
			this.ed = {
				person_no: 0,
				person_nickname: '',
				person_password: '',
				department_no:'',
				person_name:'',
				person_sex:'',
				person_birthday:'',
				person_phone:'',
				person_email:'',
			}
		},
		// 保存
		save : function () {
			$.ajax({
				url: "/account-save.ajax",
				type: "post",
				data: {
					person_no: this.ed.person_no,
					person_nickname: this.ed.person_nickname,
					person_password: this.ed.person_password,
					department_no: this.ed.department_no,
					person_name: this.ed.person_name,
					person_sex: this.ed.person_sex,
					person_birthday: this.ed.person_birthday,
					person_phone: this.ed.person_phone,
					person_email: this.ed.person_email,
					person_state: this.ed.person_state,
				},
				dataType: "JSON",
				success: function (resp) {
					// 成功
					vm.hideMo();
					vm.getData(vm.page.index);
				},
				error: function () {
					alert("系统错误请联系管理员！！");
				}
			});
		},
		// 删除
		del: function(delNo) {
			var type = confirm("确定要删除数据吗？");
			if (type) {
				$.ajax({
					url: "/account-del.ajax",
					type: "post",
					data: {
						no: delNo,
					},
					dataType: "JSON",
					success: function (resp) {
						// 成功
						vm.getData(vm.page.index);
					},
					error: function () {
						alert("系统错误请联系管理员！！");
					}
				});
			}
		},
		// 改变用户状态
		changeState: function(No,state){
			$.ajax({
				url: "/change.state.ajax",
				type: "post",
				data: {
					no: No,
					state:state
				},
				dataType: "JSON",
				success: function (resp) {
					// 成功
					// console.log(111);
					vm.getData(vm.page.index);
				},
				error: function () {
					alert("系统错误请联系管理员！！");
				}
			});
		}
		}
	});
vm.getData(1);
