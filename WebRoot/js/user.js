$(function() {
	$.ajax({
		type : "post",
		url : "getUser",
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data.code===1){
				if(data.data.id!="")
					$("#iId").html(data.data.id);
				if(data.data.username!="")
					$("#iUsername").html(data.data.username);
				if(data.data.name!="")
					$("#iName").html(data.data.name);
				if(data.data.email!="")
					$("#iEmail").html(data.data.email);
				if(data.data.time!="")
					$("#iTime").html(data.data.createTime);
			}else{
				$("#longinWarn").modal('toggle');
			}
				
		},
		error : function(jqXHR) {
			alert("error");
		}
	});
	
	$("#loginButton").click(function(){
		var user={
					"username":$("#modalUsername").val(),
					"password":$("#modalPassword").val()
				};
		$.ajax({
			type:"post",
			url:"login",
			cache:false,
			dataType:"json",
			data:user,
			success:function(data){
				if(data.data){
					location.reload();
					$("#longinWarn").modal('toggle');
				}else{
					alert(data.msg);
				}
			},
			error:function(jqXHR){
				alert("error");
			}
		});
	});
	
//	 href="#editUser"
	$("#iEdit").clicl(function(){
		location.href="#editUser";
		
	});
});