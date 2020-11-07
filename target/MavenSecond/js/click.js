$(".my_pg .panel .panel-body>button").bind("click",function(){
					var url = $(this).attr("url");
					$("#my_id").attr("src" , url);
				});