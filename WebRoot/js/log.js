$(function() {
	$.ajax({
		type : "post",
		url : "getLogList",
		cache : false,
		dataType : "json",
		async: true,
		success : function(data) {
			if (data.code === 1) {
				//============================动态生成表格=============================
				var tableData;
				var limit = data.data.list.length; // limit 行数限制
				for ( var i = 0; i < limit; i++) {
					tableData += "<tr>" + "<td>" + data.data.list[i].id
							+ "</td>" + "<td>" + data.data.list[i].username
							+ "</td>" + "<td>"
							+ data.data.list[i].operation + "</td>"
							+ "<td>" + data.data.list[i].time + "</td>"
							+ "</tr>";
				}
				$("#logTable tbody").html(tableData);

				//============================根据总数和limit计算page页数===================
				var count = data.data.count; // 总数
				var page;
				if (count % 15 === 0) // 页数
					page = parseInt(count / 15); // 除
				else
					page = Math.ceil(count / 15); // 上取整 count/15+1
				var pTmp = page;
				
				//============================动态创建分页导航栏=============================
				var pageLi = "<li id='preLi'><a href='#'>First</a></li>";
				for ( var j = 0; j < page; j++) {
					var p = j + 1;
					pageLi += "<li><a href='#'>" + p + "</a></li>";
				}
				pageLi += "<li><a href='#'>Last</a></li>";
				$("#pageIndex").html(pageLi);
				$("#pageIndex li").eq(1).addClass("active");
				
				// ===========================事件：点击分页按钮查询===============================
				$("#pageIndex li a").click(function() {
					$("#pageIndex li").removeClass("active");		//清除分页按钮选中状态
					$(this).parent().addClass("active");			//选中按钮
					var page = $(this).html(); // 页数
					if (page === "First") { //===========返回首页===========
						getLogList(0, 15);
					} else if (page === "Last") { //===========返回末页===========
						var s = (pTmp-1)*15;
						getLogList(s, 15);
					} else {				//===========返回定位页===========
						var start = (page - 1) * 15; // start 起始
						getLogList(start, 15);
					}
				});
			} else {
				$("#longinWarn").modal('toggle');
			}

		},
		error : function(jqXHR) {
			alert("error");
		}
	});

	function getLogList(start,limit){
		$.ajax({
			type : "post",
			url : "getLogList",
			cache : false,
			dataType : "json",
			async: true,
			data : {
				"start":start,
				"limit":limit
			},
			success : function(data) {
				if (data.code === 1) {
					var tableData;
					var limit = data.data.list.length; // limit 行数限制
					for ( var i = 0; i < limit; i++) {
						tableData += "<tr>" + "<td>" + data.data.list[i].id
						+ "</td>" + "<td>" + data.data.list[i].username
						+ "</td>" + "<td>"
						+ data.data.list[i].operation + "</td>"
						+ "<td>" + data.data.list[i].time + "</td>"
						+ "</tr>";
					}
					$("#logTable tbody").html(tableData);
				}else{
					$("#longinWarn").modal('toggle');
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	}
	

	function getLimit(){		//获取下拉列表中的值，值为行数
		var line= $("#lineNum").find("option:selected").text();
		return line;
	}
	
	$("#lineNum").bind("change",function(){
		var limit = getLimit();
		getLogList(0, limit);
	});
	
	$("#loginButton").click(function() {
		var user = {
			"username" : $("#lUsername").val(),
			"password" : $("#lPassword").val()
		};
		$.ajax({
			type : "post",
			url : "login",
			cache : false,
			dataType : "json",
			data : user,
			success : function(data) {
				if (data.data) {
					location.reload();
					$("#longinWarn").modal('toggle');
				} else {
					alert(data.msg);
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	});

	$("#preLi").click(function() {
		alert("this is li");
	});
});