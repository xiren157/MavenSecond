// 注册界面
	// 设置检查状态
	var error_name = true;
	var error_pwd = true;
	var error_check_pwd = true;
	var error_email = true;
	var error_check = false;

	// 定义获取变量值
	var $name = $('#user_name');
	var $pwd = $('#pwd');
	var $cpwd = $('#cpwd');
	var $email = $('#email');
	var $allow = $('#allow');

	// 当离开时触发事件
		// 触发检查用户名
		$name.blur(function() {
			check_user_name();
		}).click(function() {
			$(this).next().hide();
		});

		// 触发检查密码
		$pwd.blur(function() {
			check_pwd();
		}).click(function() {
			$(this).next().hide();
		});
		
		// 触发检查二次密码
		$cpwd.blur(function() {
			check_cpwd();
		}).click(function() {
			$(this).next().hide();
		});
		
		// 触发检查邮箱
		$email.blur(function() {
			check_email();
		}).click(function() {
			$(this).next().hide();
		});

		// 触发检查勾选
		$allow.click(function() {
			if($(this).is(':checked'))
			{
				error_check = false;
				$(this).siblings('span').hide();
			}else{
				error_check = true;
				$(this).siblings('span').html('请勾选同意');
				$(this).siblings('span').show();
			}
		});

	// 检查功能
		// 定义用户名规则
		function check_user_name(){
			//数字字母或下划线
			var reg = /^\w{6,15}$/;
			var val = $name.val();
		// 检查用户名
			if(val==''){
				$name.next().html('用户名不能为空！').show();
				//$name.next().show();
				error_name = true;
				return;
			}
			if(reg.test(val))
			{
				$name.next().hide();
				error_name = false;
			}else{
				$name.next().html('用户名是6到15个英文或数字，还可包含“_”');
				$name.next().show();
				error_name = true;
			}
		}

		// 定义密码规则
		function check_pwd(){
			var reg = /^[\w@!#$%&^*]{6,15}$/;
			var val = $pwd.val();
		// 检查密码
			if(val==''){
				$pwd.next().html('输入的密码不能为空！');
				$pwd.next().show();
				error_cpwd = true;
				return;
			}
			if(reg.test(val))
			{
				$pwd.next().hide();
				error_pwd = false;
			}else{
				$pwd.next().html("密码是6到15位字母、数字，还可包含@!#$%^&*字符");
				$pwd.next().show();
				error_pwd = true;
			}
		}

		// 检查二次密码
		function check_cpwd(){
			var pass = $('#pwd').val();
			var cpass = $('#cpwd').val();
			
			if(cpass==''){
				$cpwd.next().html('输入的密码不能为空！');
				$cpwd.next().show();
				error_pwd = true;
				return;
			}
			if(pass!=cpass)
			{
				$cpwd.next().html('两次输入的密码不一致');
				$cpwd.next().show();
				error_check_pwd = true;
			}else{
				$cpwd.next().hide();
				error_check_pwd = false;
			}
		}
		
		// 定义邮箱规则
		function check_email(){
			var re = /^[a-z0-9][\w\.\-]*@[a-z0-9\-]+(\.[a-z]{2,5}){1,2}$/;
			var val = $email.val();
		// 检查邮箱
			if(val==''){
				$email.next().html('邮箱不能为空！');
				$email.next().show();
				error_email = true;
				return;
			}
			if(re.test(val))
			{
				$email.next().hide();
				error_email = false;
			}else{
				$email.next().html('你输入的邮箱格式不正确');
				$email.next().show();
				error_email = true;
			}
		}
		// 检查整表
		$('#SignUp').click(function() {
			if(error_name == false && error_pwd == false && error_check_pwd == false && error_email == false && error_check == false)
			{
				$.ajax({
					url: "/register.ajax",
					cache:false,
					type: "post",
					dataType: "JSON",
					data: {
						"user_name": $name.val(),
						"pwd": $pwd.val(),
						"email": $email.val(),
					},
					success: function (resp) {
						var code = resp.code;
						if (code == 0) {
							swal("恭喜您","注册成功","success");
							window.setTimeout(function(){window.location.href="login.html";}, 2000);
						} else if(code == -1) {
							swal("不好意思，注册失败");
						} else {
							swal("请检查你输入的是否符合条件");
						}
					},
					error: function () {
						swal("系统错误请联系管理员！！");
					}
				});
				// alert("注册成功");
				return true;
			} else {
				swal("信息不完成，请补充完整");
				return false;
			}
		});

