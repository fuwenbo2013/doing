//@ sourceURL=user.js

$(function(){
	//第一次点击导航栏用户模块时触发
	listUserByPage(1);	
	//
	$("#userPanel input:eq(0)").keydown(function(event){
		alert("sssss");
		if (event.which==13) {
			var userKW=$("#userPanel").find("input").eq(0).val();
			alert("8888");			
		}
	})
	
	
})

//根据模糊关键字和当前页展示用户信息
function listUserByPage(currentPage) {
	
	var userKW=$("#userPanel input:eq(0)").val();
	alert(userKW);
	
	//发送异步请求获取列表信息
	
	$.ajax({
		url:basepath+"user/listUserByPage",
		type:"get",
		dataType:"json",
		data:{
			"userKW":userKW,
			"currentPage":currentPage
			
		},		
		success:function(result){
			var users=result.data;			
			$(users).each(function(index,user){
				//put the user details into list
				
				var roleString=user.roles;
				//clear the user tbody
				$("#userPanel table tbody").html("");
				
				var tr=
				`<tr>
                <td>${index+1}</td>
                <td>${user.loginName}</td>
                <td>${user.nickName}</td>
                <td>${user.type}</td>
                <td>${user.score}</td>
                <td>${user.regDate}</td>
                <td>${user.isLock}</td>
                <td>${user.roles}</td>
                <td>
                  <a href="" data-toggle="modal" data-target="#editUser"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</a>
                  <a href="" data-toggle="modal" data-target=".bs-example-modal-sm"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</a>
                </td>
              </tr>`
					
					
				
			})
			
			
		},
		error:function(){
			alert("list user request failure!");
		}
		
	})
}