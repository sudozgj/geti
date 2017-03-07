$(function() {
	getL();

	$("#addIBtn").click(function() {
		var iName = $("#iName").val();
		var iIn = $("#iIn").val();
		var iOut = $("#iOut").val();
		var iDescription = $("#iDescription").val();
		var iMName = $("#iMName").val();
		var iMDescription = $("#iMDescription").val();

		if (iName == "" || iOut == "" || iMName == "") {
			alert("信息不完整");
			return;
		}
		$.ajax({
			type : "post",
			url : "addInterface",
			cache : false,
			dataType : "json",
			data : {
				"name" : iName,
				"input" : iIn,
				"output" : iOut,
				"description" : iDescription,
				"mName" : iMName,
				"mDescription" : iMDescription
			},
			success : function(data) {
				if (data.data) {
					$("#addIModal").modal('toggle');
					window.location.reload();
				} else {
					alert(data.msg);
					$("#addIModal").modal('toggle');
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	});
	$("#addMBtn").click(function() {
		var mName = $("#amName").val();
		var mDescription = $("#amDescription").val();
		if (mName == "") {
			alert("信息不完整");
			return;
		}
		$.ajax({
			type : "post",
			url : "addModule",
			cache : false,
			dataType : "json",
			data : {
				"mName" : mName,
				"mDescription" : mDescription
			},
			success : function(data) {
				if (data.data) {
					$("#addMModal").modal('toggle');
					window.location.reload();
				} else {
					alert(data.msg);
					$("#addMModal").modal('toggle');
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	});

	function getL() {
		$.ajax({
			type : "post",
			url : "getIM",
			cache : false,
			dataType : "json",
			success : function(data) {
				if (data.code === 1) {
					var li = "";
					for ( var i = 0; i < data.data.length; i++) {
						var mn = data.data[i].mName;
						var il = data.data[i].iName;
						li += "<ul class='nav nav-stacked nav-pills pi'>"
								+ "<p class='liHead'>" + mn + "</p>";
						for ( var j = 0; j < il.length; j++) {
							li += "<li><a href='#''>" + il[j] + "</a></li>";
						}
						li += "</ul>";
					}
					$("#lList").html(li);

					$(".liHead").click(function() {
						$(this).siblings().slideToggle();
					});
					$(".pi li").click(function() {
						$(".pi li").removeClass("active");
						$(this).addClass("active");
						var v = $(this).children().html();

						// ==============动态生成接口内容===============
						getR(v);
					});
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	}
	function getR(v) {
		$.ajax({
			type : "post",
			url : "getInterface",
			dataType : "json",
			data : {
				"iName" : v
			},
			success : function(data) {
				if (data.code === 1) {
					// =========================动态生成接口信息==============================
					$("#itName").html("<u>" + data.data.name + "</u><hr>");
					// $("#itId").html(data.data.id);
					// $("#itMid").html(data.data.mid);
					$("#itInput").html(
							"<p>输入参数：</p><kbd>" + data.data.input
									+ "</kbd><hr>");
					var o = data.data.output;
					var reg = new RegExp('\n','g');
					var reg2 = new RegExp('\s');
					o = o.replace(reg,'<br/>');
					o = o.replace(reg2,'&nbsp;');
					$("#itOutput").html(
							"<p>输出参数：</p><strong><kbd>" + o
									+ "</kbd></strong><hr>");
					$("#itDescription").html(
							"<p>接口描述：</p>" + data.data.description + "<hr>");
					$("#itTime").html(changeTime(data.data.time * 1000));
					$("#itEdit").html(
							"<button type='button'"
									+ " class='btn btn-primary'" + " id='itEI'"
									+ " data-toggle='modal'"
									+ " data-target='#itEModal' >编辑</button>");

					// =========================动态生成模态框信息========================
					// itEModal 模态框id
					$("#imId").val(data.data.id);
					$("#imName").val(data.data.name);
					$("#imInput").val(data.data.input);
					$("#imOutput").val(data.data.output);
					$("#imDescription").val(data.data.description);
					$("#imTime").val(changeTime(data.data.time * 1000));
					$("#imMid").val(data.data.mid);

					// =========================编辑接口模态框提交事件========================
					$("#editIBtn").click(function() {
						var id = $("#imId").val();
						var name = $("#imName").val();
						var i = $("#imInput").val();
						var o = $("#imOutput").val();
						var de = $("#imDescription").val();
						var t = $("#imTime").val();
						var mid = $("#imMid").val();
						$.ajax({
							type : "post",
							url : "updateInterface",
							dataType : "json",
							data : {
								"id" : id,
								"name" : name,
								"input" : i,
								"output" : o,
								"description" : de,
								"MId" : mid
							},
							success : function(data) {
								alert("编辑成功");
								$("#itEModal").modal('toggle');

								window.location.reload();
							},
							error : function(jqXHR) {
								alert("编辑失败");
							}
						});
					});
				} else {
					alert(data.msg);
				}
			},
			error : function(jqXHR) {
				alert("error");
			}
		});
	}

	function changeTime(ts) { // 时间戳转时间函数
		var timestamp = new Date(ts);
		var dtime = timestamp.toLocaleDateString().replace(/\//g, "/") + " "
				+ timestamp.toTimeString().substr(0, 8);
		return dtime;
	}
	;

});