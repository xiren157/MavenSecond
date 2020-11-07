var vm = new Vue({
    el: '.my-body',
    data: {
        list:[],
    },
    methods: {
        // 获取数据
        getData: function (nowIndex) {
            $.ajax({
                url: "/department.ajax",
                type: "post",
                data: {
                    index: nowIndex,
                },
                dataType: "JSON",
                success: function (resp) {
                    vm.list = resp.list;
                },
                error: function () {
                    alert("系统错误请联系管理员！！");
                }
            });
        }
    }
});
vm.getData(1);
