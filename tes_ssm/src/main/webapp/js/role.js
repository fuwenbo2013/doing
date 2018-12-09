//@ sourceURL=role.js
var roleId;
var roleName;

$(function() {
	//sidebar上的超链接点击后的默认展示的页面
	findRoleByPage(1);
	
	//给角色的按钮添加事件
	$("#sidebar ul li:eq(0)").click(function(){
		findRoleByPage(1);
	})

	//新增角色
	$("#addPanel button[type=submit]").click(function() {
		return addRole();
	})

	//按照角色名模糊搜索
	$("#roleSearch").click(function() {		
		return findRoleByPage(1);
	})

	//编辑角色名

	//模态框获取对应的角色名	
	$("#editRoleSubmit").click(function() {		
		var roleName=$("#updateRoleName").val();
		//编辑框为空时				
		if (!roleName) {
		alert("请填上角色名");
		return false;
		}
		//将角色名更新至数据库
		return updateRoleName(roleId,roleName);		
	})
	//删除角色
	$("#delRole").click(function() {		
		//将角色名更新至数据库
		return delRole(roleId);		
	})
	
})
//删除角色
function delRole(roleId) {
	alert(roleId);
	$.ajax({
		url:basePath+"role/delete",		
		dataType:"json",
		type:"post",
		data:{
			"id":roleId			
		},
		success:function(result){
			if (result.status==1) {						
				window.location.href="index.html";
			}else {
				alert("角色删除更新失败");	
			}
		},
		error:function(){
			alert("删除请求失败");		
		}		
	})
	return false;
}

//更新角色名
function updateRoleName(roleId,roleName) {	
	$.ajax({
		url:basePath+"role/update",		
		dataType:"json",
		type:"post",
		data:{
			"id":roleId,
			"name":roleName
		},
		success:function(result){
			if (result.status==1) {				
				$("#tr"+roleId+"  td:eq(2)").val(roleName);	
				window.location.href="index.html";
			}else {
				alert("角色更新失败");	
			}
		},
		error:function(){
			alert("更新请求失败");		
		}		
	})
	return false;	
}

//角色编辑链接点击获取角色id 角色名
function getRoleId(id,name) {	
	roleId=id;
	roleNaem=name;
	//给角色编辑框传送原角色名
	$("#updateRoleName").val(name);

}
//页面展示函数
function findRoleByPage(currentPage) {
	//搜索role关键字
	var roleKW=$("#rolePanel .row input[type='text']").val();
	if (roleKW=="") {
		roleKW="undefined"
	}

	$.ajax({
		url:basePath+"role/findRoleByPage",

		type:"get",
		data:{
			"currentPage":currentPage,
			"roleKW":roleKW			
		},
		dataTybe:"json",
		success:function(result){

			var page=result.data;

			var roles=page.roles;

			var nums=page.nums;

			//清空表格
			$("#rolePanel tbody").html("");
			$(roles).each(function(index,role) {
				if (role.name!="超级管理员"&&role.name!="讲师"&&role.name!="学生") {
					var tr1='<tr>'+
					'<td>'+(index+1)+'</td>'+
					'<td>'+role.id+'</td>'+
					'<td>'+role.name+'</td>'+
					'<td>'+
					'</td>'+
					'</tr>'; 

					$("#rolePanel tbody").append(tr1);
				}else {
					var tr2='<tr id="tr'+role.id+'">'+
					'<td>'+(index+1)+'</td>'+
					'<td>'+role.id+'</td>'+
					'<td>'+role.name+'</td>'+
					'<td>'+
					'<a    href="" onclick="getRoleId(\''+role.id+'\',\''+role.name+'\')"   data-toggle="modal" data-target="#editRole" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑</a>'+
					'<a    href=""  onclick="getRoleId(\''+role.id+'\',\''+role.name+'\')"  data-toggle="modal" data-target=".bs-example-modal-sm"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</a>'+
					'</td>'+
					'</tr>';  
					$("#rolePanel tbody").append(tr2);

				}  			

			})

			//清空分页条			
			$("#role_pagination").html("");

			if (page.totalPages>1) {		
				var prePage='<li>'+
				'<a href="javascript:findRoleByPage('+page.previousPage+')" aria-label="Previous">'+
				'<span aria-hidden="true">&laquo;</span>'+
				'</a>'+
				'</li>';
				$("#role_pagination").append(prePage);



				$(page.nums).each(function(n,value){	

					var midPage='<li><a href="javascript:findRoleByPage('+value+')">'+value+'</a></li>';
					$("#role_pagination").append(midPage);
				})

				var nextPage=
					'<li>'+
					'<a href="javascript:findRoleByPage('+page.nextPage+')" aria-label="Next">'+
					'<span aria-hidden="true">&raquo;</span>'+
					'</a>'+
					'</li>';
				$("#role_pagination").append(nextPage);				
			}			

		},
		error:function(){
			alert("请求失败");
		}		
	})
}
function addRole() {
	var roleName=$("#addRoleName").val();	
	if (!roleName) {
		//提示角色名为空
		alert("角色名称为空");
		//返回页面至列表页面
		return false;

	}
	//异步提交数据
	$.ajax({
		url:basePath+"role/addRole",
		type:"post",
		dataType:"json",
		data:{
			"name":roleName
		},
		success:function(result){
			alert("添加函数");
		},	
		error:function(){
			alert("角色添加请求失败");
		}		
	})
	return false;	
}
