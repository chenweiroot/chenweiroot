<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
   <title>注册页面</title>
  </head>
  
  <body>
    <form name="form1" action="userServlet" method="post">
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="userName" value="" required></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="password" value="" required></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="注册"></td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
