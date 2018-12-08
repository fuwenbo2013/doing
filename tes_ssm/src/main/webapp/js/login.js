
$(function(){
	//获取cookie中的数据,并添加至用户名框
	$("form #inputName").val(getCookie("loginName"));
	//为login.html的form表单添加submit事件
	$("form").submit(function(){
		return login();
	});

});

function login(){
	//定义变量接收请求提交的参数
	var loginName=$("form #inputName").val();
	var password=$("form #inputPassword").val();	
	var isCheck=$("form input[type=checkbox]").get(0).checked;

	$.ajax({		
		url:basePath+"user/login/"+loginName+"/"+password,
		type:"get",		
		datatype:"json",
		success:function(result){
			if(result.status==1){
				
				window.location.href="index.html";	
				//如果记住用户名复选框选中
				if(isCheck){
					addCookie("loginName",loginName,30);				     
				}				
			}				    	
		},
		error:function(){
			alert("登录失败");
		}
	});
	return false;
}