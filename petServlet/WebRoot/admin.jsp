<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
	<title>登录页面</title>
  </head>

  <body>
  <script type="text/javascript">
  	alert("注册成功........去登录");
  </script>
<br>你的注册用户名为：${user.name}
<br> 你的注册密码为：${user.password} 
<br>
<form name=form2 action="userServlet2" method="post">
	<table>
		<tr>
			<td>用户名：</td>
			<td><input type="text" name="uName" required></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" name="uPassword" required></td>
		</tr>
		<tr>
			<td><input type="submit" value="登录"></td>
		</tr>
	</table>
</form>
<br>

  </body>
</html>
