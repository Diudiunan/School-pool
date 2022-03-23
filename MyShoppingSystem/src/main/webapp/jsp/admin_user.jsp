<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="AU">
		<div class="">
			
		</div>
		<div class="">
			<div class="">
				<form action="/MyShoppingSystem/ser/admin_douserlist" method="get">
					<table class="">
						<tr>
							<td>
								<select name="" id="">
									<option></option>
								</select>
							</td>
							<th>关键字</th>
							<td><input class="" placeholder="关键字" name="keyword" value="${param.keyword}" type="text"></td>
							<td><input class="" name="" value="查询" type="submit"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="">
			<form action="/MyShoppingSystem/ser/admin_douserdelete" id="myform" method="post">
				<div class="">
					<div class="">
						<a href="admin_useradd.jsp">新增用户</a>
						<a id="" href="javascript:deletemore('你确定要删除所选成员吗', 'myform')">批量删除</a>
					</div>
				</div>
				<div id="user_select" class="">
					<table class="">
						<tr>
							<th class=""><input name="" type="checkbox" onclick="selectall(this)"></th>
							<th>ID</th>
							<th>姓名</th>
							<th>性别</th>
							<th>EMAIL</th>
							<th>手机</th>
							<th>操作</th>
						</tr>
						
						<c:forEach var="user" items="${userlist}">
							<tr>
								<td class="user_choice"><input name="idCchoice" value="${user.USER_ID}" type="checkbox"></td>
								<td>${user.USER_ID}</td>
								<td>${user.USER_NAME}</td>
								<td>${user.USER_SEX=='T'?'男':'女'}</td>
								<td>${user.USER_EMAIL}</td>
								<td>${user.USER_PHONE}</td>
								<td>
									<a class="link_user_update" href="/MyShoppingSystem/ser/admin_douserupdate?id=${user.USER_ID}&nowpage=${nowpage}">修改</a>
									<c:if test="${user.USER_STATUS == 1 }">
									<a class="link_user_del" href="javascript:Delete('你确定要删除用户[${user.USER_NAME}]吗？', '/MyShoppingSystem/ser/admin_douserdelete?ID=${user.USER_ID}&Nowpage=${nowpage}')">删除</a>
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>	
					<div class="">
						共${usernumber}条记录，当前${nowpage}/${userpage}页
						<a href="/MyShoppingSystem/ser/admin_douserlist?cp=1${searchparams}">首页</a>
						<a href="/MyShoppingSystem/ser/admin_douserlist?cp=${nowpage-1<1?1:nowpage-1}${searchparams}">上一页</a>
						<a href="/MyShoppingSystem/ser/admin_douserlist?cp=${nowpage+1>userpage?userpage:nowpage+1}${searchparams}">下一页</a>
						<a href="/MyShoppingSystem/ser/admin_douserlist?cp=${userpage}${searchparams}">尾页</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	<script>
		function Delete(mess, url){
			if(confirm(mess)){
				location.href=url;
			}
		}
		
		function selectall(E){
			var LIST = document.getElementsByName("idCchoice");
			for(var i=0; i<LIST.length; i++){
				LIST[i].checked = E.checked;
			}
		}
		
		function deletemore(mess, formname){
			if(confirm(mess)){
				var form = document.getElementById(formname);
			}
			form.submit();
		}
	</script>
</body>
</html>