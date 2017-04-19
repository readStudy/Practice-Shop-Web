<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>會員註冊</title>

<script src="${request.contextPath}/js/jquery-3.1.1.js"></script>
<link rel="stylesheet"
	href="${request.contextPath}/js/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${request.contextPath}/js/bootstrap/css/bootstrap-theme.min.css" />
<script src="${request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>

<script>
	function checkForm() {
		$('input').each(function(index, element){
			$(this).on("blur", function(e) {
				$(this).next().html('');
				if(!$(this).val()){
					$(this).next().html('不能為空');
				}
			});
		});
		
		$('#repassword').add('#password').on("blur", function(e) {
			$('#password').val() != $('#repassword').val() ? 
					$('#repassword').next().html('兩次密碼不同') : $('#repassword').next().html('');
		});
		
		$('#registerForm').submit(function(e) {
			isValid = true;
			$('span').each(function(index, element){
				if($(this).text().indexOf('不能為空') > -1){
					alert('有欄位為空');
					isValid = false;
					return false;
				}
				if($(this).text().indexOf('兩次密碼不同') > -1){
					alert('兩次密碼不同');
					isValid = false;
					return false;
				}
				if($(this).text().indexOf('帳號不可使用') > -1){
					alert('帳號不可使用');
					isValid = false;
					return false;
				}
			});
			if(isValid){
				$("#registerForm").prop("disabled", true).addClass("disabled");
			}
			return isValid;
		});		
	}
	
	function checkUsername() {
		$('#username').on("blur", function(e) {

			var username = $(this).val();
			console.log(username);
			e.preventDefault();
			$.ajax({
				url : '${request.contextPath}/user/register/find/' + username + '/'+new Date().getTime(),
				type : 'GET',
				dataType : "text",
				data : $(this).value,
				success : function(result,status,xhr) {
					$('#usernameSpan').html(result);
				}
			});
		});
	}

	$(document).ready(function() {
		checkUsername();
		checkForm();
	});
</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<h2><strong>會員註冊</strong>USER REGISTER</h2>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<sf:form id="registerForm"
					action="${ request.contextPath }/user/register" method="post"
					commandName="userForm" role="form">
    			
					<div class="form-group">
						帳號：
		                <div class="input-group">
		                  <sf:input path="username"  class="form-control" id="username" maxlength="20" placeholder="請輸入帳號"/>
						  <span class="input-group-addon error" id="usernameSpan"><sf:errors path="username" /></span>	
						</div>
		            </div>
		         
					<div class="form-group">
						密碼：
		                <div class="input-group">
							<sf:password path="password" id="password" class="form-control" maxlength="20"  placeholder="請輸入密碼"/> 
							<span class="input-group-addon error"><sf:errors path="password" /></span>
						</div>
		            </div>
		            
					<div class="form-group">
						確認密碼：
		                <div class="input-group">
							<sf:password path="repassword" id="repassword" class="form-control" maxlength="20"  placeholder="請再次輸入密碼"/> 
							<span class="input-group-addon error"><sf:errors path="repassword" /></span>
						</div>
		            </div>            
		
					<div class="form-group">
						信箱：
		                <div class="input-group">
							<sf:input path="email" id="email" type="email" class="form-control" placeholder="請輸入信箱"/> 
							<span class="input-group-addon"><sf:errors path="email" /></span>
						</div>
		            </div>
		
					<div class="form-group">
						姓氏：
		                <div class="input-group">
							<sf:input path="lastName" id="lastName" type="text" class="form-control" placeholder="請輸入姓氏"/> 
							<span class="input-group-addon"><sf:errors path="lastName" /></span>
						</div>
		            </div>            
					<div class="form-group">
						名字：
		                <div class="input-group">
							<sf:input path="firstName" id="firstName" type="text" class="form-control" placeholder="請輸入名字"/> 
							<span class="input-group-addon"><sf:errors path="firstName" /></span>
						</div>
		            </div>
		            
					<div class="form-group">
		                <div class="input-group">
		                	性別：	
							<sf:radiobutton path="gender" checked="checked" value="男性" />男 
							<sf:radiobutton path="gender" value="女性" />女
						</div>
		            </div>
					<div class="form-group">
						手機：
		                <div class="input-group">
							<sf:input path="cellphone" id="cellphone" type="text" class="form-control" placeholder="請輸入手機號碼"/> 
							<span class="input-group-addon"><sf:errors path="cellphone" /></span>
						</div>
		            </div> 
					<div class="form-group">
						地址：
		                <div class="input-group">
							<sf:input path="address" id="address" type="text" class="form-control" placeholder="請輸入聯絡地址"/> 
							<span class="input-group-addon"><sf:errors path="address" /></span>
						</div>
		            </div> 
		            
					<div class="form-group">
						生日：
		                <div class="input-group">
							<sf:input path="birthday" type="date" data-date-format="mm/dd/yyyy" id="birthday" class="form-control" placeholder="請輸入生日"/> 
							<span class="input-group-addon"><sf:errors path="birthday" /></span>
						</div>
		            </div>
					<div class="form-group ">
						<div class="input-group">
							<input type="submit" class="btn btn-primary btn-lg btn-block login-button" value="註冊" />
						</div>
					</div>                      
		
				</sf:form>
			</div>
			<div class="col-sm-6">
				<label>註冊協議</label>
            	<div style="border: 1px solid #e5e5e5; height: 200px; overflow: auto; padding: 10px;">
					<p>尊敬的使用者</p>
					<p>請遵守以下註冊協議</p>
					<p>...........</p>
					<p>...........</p>
					<p>...........</p>
					<p>...........</p>
					<p>...........</p>
					<p>...........</p>
					<p>...........</p>
					<p>...........</p>
					<p>...........</p>
				</div>
			</div>
		</div>
	</div>

</body>
</html>