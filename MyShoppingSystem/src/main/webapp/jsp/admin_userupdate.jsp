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
				<a class="" href="./admin_user.jsp"></a>
				<span class="">&gt;</span>
			</div>
		</div>
		<div class="">
			<div class="">
				<form action="/MyShoppingSystem/ser/admin_douserupdate" method="post">
					<input type="hidden" name="Status" value="${user.USER_STATUS}" />
					<input type="hidden" name="Nowpage" value="${nowpage}" />
					<table class="">
						<tr>
							<th>用户名：</th>
							<td>
								<input class="" id="" name="ID" value="${user.USER_ID}" type="text" readonly="readonly" />
							</td>
						</tr>
						<tr>
							<th>用户姓名：</th>
							<td>
								<input class="" id="" name="Name" value="${user.USER_NAME}" type="text" />
							</td>
						</tr>
						<tr>
							<th>登陆密码：</th>
							<td>
								<input class="" id="" name="PassWord" value="${user.USER_PASSWORD}" type="text" />
							</td>
						</tr>
						<tr>
							<th>性别：</th>
							<td>
								<input type="radio" name="Sex" value="T" ${user.USER_SEX=='T'?"checked":""} >男
								<input type="radio" name="Sex" value="F" ${user.USER_SEX=='F'?"checked":""}>女
							</td>
						</tr>
						<tr>
							<th>出生日期：</th>
							<td>
								<input class="" id="" name="Birthday" value="${user.USER_BIRTHDAY}" type="text" />
							</td>
						</tr>
						<tr>
							<th>手机号码：</th>
							<td>
								<input class="" id="" name="Phone" value="${user.USER_IDENITY_CODE}" type="text" />
							</td>
						</tr>
						<tr>
							<th>电子邮箱：</th>
							<td>
								<input class="" id="" name="Email" value="${user.USER_EMAIL}" type="text" />
							</td>
						</tr>
						<tr>
							<th>送货地址：</th>
							<td>
								<input class="" id="" name="Address" value="${user.USER_ADDRESS}" type="text" />
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