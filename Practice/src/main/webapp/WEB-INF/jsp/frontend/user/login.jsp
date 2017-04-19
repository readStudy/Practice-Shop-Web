<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>會員登入</title>

<script src="${request.contextPath}/js/jquery-3.1.1.js"></script>
<link rel="stylesheet"
	href="${request.contextPath}/js/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css" />
<script src="${request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<h2>
				<strong>會員登入</strong>USER LOGIN
			</h2>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<sf:form id="loginForm" action="${ request.contextPath }/user/login"
					method="post" novalidate="novalidate" commandName="loginForm"
					role="form">
					<div class="form-group">
						<span><font color="red">${ error }</font></span>
					</div>
					<div class="form-group">
						帳號：
						<div class="input-group">
							<sf:input type="text" id="username" path="username"
								class="form-control" maxlength="20" placeholder="請輸入帳號" />
							<span class="input-group-addon"></span>
						</div>
					</div>
					<div class="form-group">
						密碼：
		                <div class="input-group">
							<sf:password path="password" id="password" class="form-control" maxlength="20"  placeholder="請輸入密碼"/> 
							<span class="input-group-addon error"></span>
						</div>
		            </div>
					<div class="form-group ">
						<div class="input-group">
							<input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="登入" />
						</div>
					</div>   		            				
				</sf:form>
			</div>
			<div class="col-sm-8">
			<img
								src="${request.contextPath}/image/test.jpg"/>
				<dl>
					<dt>還沒有帳號</dt>
					<dd>快速註冊 <a href="${ request.contextPath }/user/register">註冊</a></dd>
				</dl>
			</div>
		</div>

	</div>

</body>
</html>