//绘制饼图
function drawCircle(canvasId, data_arr, color_arr, text_arr)
{
    var c = document.getElementById(canvasId);
    var ctx = c.getContext("2d");

    var radius = c.height / 2 - 30; //半径
    var ox = radius + 20, oy = radius + 20; //圆心

    var width = 30, height = 10; //图例宽和高
    var posX = ox * 2 + 20, posY = 30;   //
    var textX = posX + width + 5, textY = posY + 10;

    var startAngle = 0; //起始弧度
    var endAngle = 0;   //结束弧度
    for (var i = 0; i < data_arr.length; i++)
    {
        //绘制饼图
        endAngle = endAngle + data_arr[i] * Math.PI * 2; //结束弧度
        ctx.fillStyle = color_arr[i];
        ctx.beginPath();
        ctx.moveTo(ox, oy); //移动到到圆心
        ctx.arc(ox, oy, radius, startAngle, endAngle, false);
        ctx.closePath();
        ctx.fill();
        startAngle = endAngle; //设置起始弧度

        //绘制比例图及文字
        ctx.fillStyle = color_arr[i];
        ctx.fillRect(posX, posY + 20 * i, width, height);
        ctx.moveTo(posX, posY + 20 * i);
        ctx.font = 'bold 12px 微软雅黑';    //斜体 30像素 微软雅黑字体
        ctx.fillStyle = color_arr[i]; //"#000000";
        var percent = text_arr[i] + "：" + 100 * data_arr[i] + "%";
        ctx.fillText(percent, textX, textY + 20 * i);
    }
}

function init() {
    //绘制饼图
    //比例数据和颜色
    var color_arr = ["rgb(172,172,172)", "rgb(38,160,218)"];
    var text_arr = ["剩余的空间", "已使用空间"];

    $.ajax({
        url: "/space.ajax",
        type: "post",
        dataType: "JSON",
        data: '',
        success: function (resp) {
            console.log(resp.list);
            var freeC = resp.list[0].freeSpace;
            var usebC = resp.list[0].usableSpace;
            var freeCpoint = freeC/(freeC+usebC);
            var usebCpoint = usebC/(freeC+usebC);
            console.log(freeCpoint);
            console.log(usebCpoint);
            var freeE = resp.list[1].freeSpace;
            var usebE = resp.list[1].usableSpace;
            var freeEpoint = freeE/(freeE+usebE);
            var usebEpoint = usebE/(freeE+usebE);
            var freeF = resp.list[2].freeSpace;
            var usebF = resp.list[2].usableSpace;
            var freeFpoint = freeF/(freeF+usebF);
            var usebFpoint = usebF/(freeF+usebF);
            var data_arrC = [freeCpoint,usebCpoint];
            console.log(data_arrC);
            var data_arrE = [freeEpoint,usebEpoint];
            console.log(data_arrE);
            var data_arrF = [freeFpoint,usebFpoint];
            console.log(data_arrF);

            drawCircle("canvas_circle", data_arrC, color_arr, text_arr);
            drawCircle("canvas_circle1", data_arrE, color_arr, text_arr);
            drawCircle("canvas_circle2", data_arrF, color_arr, text_arr);
        },
        error: function () {
            alert("系统错误请联系管理员！！");
        }
    });
}
//页面加载时执行init()函数
window.onload = init;
