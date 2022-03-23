<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="">
		<div class="">
			<div class="">
				<a href=""></a>
				<span class="">&gt;</span>
				<a class="" href="./admin_user.jsp">返回</a>
				<span class="">&gt;</span>
			</div>
		</div>
		<div class="">
			<div class="">
				<form action="/MyShoppingSystem/ser/admin_douseradd" method="post" id="addform" class="addform">
					<table class="">
						<tr>
							<th>用户名：</th>
							<td>
								<input class="" id="" name="ID" value="" type="text" placeholder="id不可为空"/>
							</td>
						</tr>
						<tr>
							<th>用户姓名：</th>
							<td>
								<input class="" id="" name="Name" value="" type="text" placeholder="用户名不可为空"/>
							</td>
						</tr>
						<tr>
							<th>登陆密码：</th>
							<td>
								<input class="" id="" name="PassWord" value="" type="text" placeholder="密码不可为空"/>
							</td>
						</tr>
						<tr>
							<th>性别：</th>
							<td>
								<input type="radio" name="Sex" value="T" checked="checked" >男
								<input type="radio" name="Sex" value="F" >女
							</td>
						</tr>
						<tr>
							<th>出生日期：</th>
							<td>
								<input class="" id="" name="Birthday" value="" type="date" />
							</td>
						</tr>
						<tr>
							<th>手机号码：</th>
							<td>
								<input class="" id="" name="Phone" value="" type="text" />
							</td>
						</tr>
						<tr>
							<th>电子邮箱：</th>
							<td>
								<input class="" id="" name="Email" value="" type="text" />
							</td>
						</tr>
						<tr>
							<th>送货地址：</th>
							<td>
								<input class="" id="" name="Address" value="" type="text" />
							</td>
						</tr>
						<tr>
							<th></th>
							<td>
								<input class="" value="提交" type="submit" />
								<input class="" value="返回" type="button" onclick="" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>