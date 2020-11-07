var vm = new Vue({
    el: '.loginpage',
    data: {
        user_name: '',
        user_no: '',
		pwd:''
    },
    methods: {
        doLogin: function () {
            if (this.user_name == "") {
                swal("用户名不能为空！");
                return;
            }
            if (this.pwd == "") {
                swal("密码不能为空！");
                return;
            }
            $.ajax({
                url: "/login.ajax",
                type: "post",
                dataType: "JSON",
                data: {
                    user_name: this.user_name,
                    user_no: this.user_name,
					pwd: this.pwd
                },
                success: function (resp) {
                    var code = resp.code;
                    if (code == 0) {
                        swal("恭喜您","登录成功","success");
                        window.setTimeout(function(){window.location.href="main.html";}, 2000);
                        // window.location.href = "main.html";
                    } else if(code == -1) {
                        swal("请确认你的账户名密码及账户是否可用");
                    } else {
                        swal("请输入用户名或密码");
                    }
                },
                error: function () {
                    swal("系统错误请联系管理员！！");
                }
            });
        }
    }
});