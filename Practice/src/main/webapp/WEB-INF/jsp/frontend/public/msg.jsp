<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <meta http-equiv="Refresh" content="3;url=${ request.contextPath }/">--%>
<title>Insert title here</title>

</head>
<body>
	<div id="divcontent">
		<table>
			<tr>
				<td style="padding: 30px; text-align: center">
					<table>
						<tr>
							<td style="width: 98"><img
								src="${request.contextPath}/image/test.jpg"
								width="128" height="128" /></td>
							<td style="padding-top: 30px"><font
								style="font-weight: bold; color: #FF0000"> ${ msg } </font> <br />
								<br /> <a href="${ request.contextPath }/">首頁</a> <a
								href="${ request.contextPath }/user/register">註冊</a> <a
								href="${ request.contextPath }/user/login">登入</a></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>