function doOutLogin(){
    $.ajax({
        url : "/out.login.ajax",
        type : "POST",
        dataType : "JSON",
        success : function (data) {
            if (data.type) {
                alert("退出成功");
                window.location.href = "login.html";
            } else {
                alert("系统异常");
            }
        },
        error : function () {
            alert("err");
        }
    });
}