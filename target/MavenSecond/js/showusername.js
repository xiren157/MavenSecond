var showUsername = new Vue({
    el: '.dropdown',
    data: {
        user_name:'未定义'
    },
    created() {
        $.ajax({
            url : "/main.ajax",
            type : "POST",
            dataType : "JSON",
            success : function (data) {
                showUsername.user_name = data.user_name;
            }
        })
    }
});