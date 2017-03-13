$(function() {
	getL();

	$("#addIBtn").click(function() {
		var iName = $("#iName").val();
		var iIn = $("#iIn").val();
		var iOut = $("#iOut").val();
		var iDescription = $("#iDescription").val();
		var iMName = $("#iMName").val();

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
				"mName" : iMName
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
					var se = "";
					for ( var i = 0; i < data.data.length; i++) {
						var mn = data.data[i].mName;
						var il = data.data[i].iName;
						li += "<ul class='nav nav-stacked nav-pills pi'>"
								+ "<p class='liHead'>" + mn
								+ "<span class='badge pull-right'>" + il.length
								+ "</span></p>";
						for ( var j = 0; j < il.length; j++) {
							li += "<li><a href='#''>" + il[j] + "</a></li>";
						}
						li += "</ul>";

						se += "<option>" + data.data[i].mName + "</option>";
					}
					$("#lList").html(li);

					// ==============动态生成下拉列表===============
					$("#iMName").html(se);

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
		$
				.ajax({
					type : "post",
					url : "getInterface",
					dataType : "json",
					data : {
						"iName" : v
					},
					success : function(data) {
						if (data.code === 1) {
							// =========================动态生成接口信息==============================
							$("#pi").addClass("panel panel-primary");
							$("#phead").html(					// 模块名 & 模块描述
								"<a id='mEdit' style='font-size: 30px;color: white;cursor: pointer' data-toggle='tooltip' data-placement='right' title='"
										+ data.data.mdescription
										+ "'>"
										+ data.data.mname
										+ "</a>");
							$("#itTime").html(data.data.time); 	// 接口时间
							$("#itName").html(					//接口名
									"<div style='font-size: 20px'><strong><u>"
											+ data.data.name
											+ "</u></strong></div>");
							$("#itInput").html(					// 接口输入
									"<hr><strong>输入参数：</strong><kbd>"
											+ data.data.input + "</kbd><hr>");
							var o = data.data.output;
							$("#itOutput").html(				// 接口输出
									"<strong>输出参数：</strong><pre style='background: lemonchiffon'><h5>"
											+ o + "</h5></pre><hr>");
							$("#itDescription").html(			// 接口描述
									"<strong>接口描述：</strong><p>"
											+ data.data.description
											+ "</p><hr>");
							$("#itEdit").html(						// 编辑&删除 按钮
									"<button type='button'"
											+ " class='btn btn-primary'"
											+ " id='itEI'"
											+ " data-toggle='modal'"
											+ " data-target='#itEModal' >编辑</button>"
											+ "&nbsp"
											+ "<button type='button'"
											+ " class='btn btn-danger'"
											+ " id='itDI'"
											+ "  >删除</button>");

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
										if (data.data) {
											$("#itEModal").modal('toggle');
											window.location.reload();
										} else {
											alert(data.msg);
											$("#itEModal").modal('toggle');
											window.location.reload();
										}
									},
									error : function(jqXHR) {
										alert("error");
									}
								});
							});
							// 删除接口
							$("#itDI").click(function() {
								if (!confirm("确认删除该接口？")) {
									return;
								}
								var iid = $("#imId").val();
								$.ajax({
									type : "post",
									url : "deleteInterface",
									dataType : "json",
									data : {
										"id" : iid
									},
									success : function(data) {
										if (data.data) {
											window.location.reload();
										} else {
											alert(data.msg);
											window.location.reload();
										}
									},
									error : function(jqXHR) {
										alert("error");
									}
								});
							});
							$("[data-toggle='tooltip']").tooltip();
							
							$("#mEdit").click(function(){
								alert(1);
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

	$("#deleteModule")
			.click(
					function() {
						$("#delMModal").modal('toggle');
						$
								.ajax({
									type : "post",
									url : "getIM",
									dataType : "json",
									success : function(data) {
										var tt = "";
										for ( var i = 0; i < data.data.length; i++) {
											tt += "<tr class='active'>";
											tt += "<td>" + data.data[i].mId
													+ "</td>";
											tt += "<td>"
													+ data.data[i].mName
													+ "<span class='badge pull-right'>"
													+ data.data[i].iName.length
													+ "</span></td>";
											tt += "<td>" + data.data[i].mDesc
													+ "</td>";
											tt += "<td><button type='button' class='btn btn-sm btn-danger delMI'>Del</button></td>";
											tt += "</tr>";
										}
										$("#delMBody").html(tt);

										// debugger;
										$(".delMI")
												.click(
														function() {
															if (!confirm("确认删除模块以及模块下所有接口？")) {
																return;
															}
															var id = $(this)
																	.parent()
																	.parent()
																	.children(
																			":first")
																	.html();
															$
																	.ajax({
																		type : "post",
																		url : "deleteModule",
																		dataType : "json",
																		data : {
																			"mid" : id
																		},
																		success : function(
																				data) {
																			if (data.data)
																				window.location
																						.reload();
																			else {
																				alert(data.msg);
																				window.location
																						.reload();
																			}
																		},
																		error : function(
																				jqXHR) {

																		}
																	});
														});
									},
									error : function(jqXHR) {
										alert("error");
									}
								});
					});
	$("#createM").click(function() {
		$("#addIModal").modal('toggle');
		$("#addMModal").modal('toggle');
	});

	/*
	 * $("#drTest").hover(function(){ //经过下拉，问题：点击无效
	 * $("#userList").dropdown('toggle'); });
	 */
});
