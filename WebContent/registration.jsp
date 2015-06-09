<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="./EngineServlet">
	<input type = "hidden" name = "command" value = "register">
	<br/>Login<input type = "text" name = "login">
	<br/>Имя <input type = "text" name = "name">
	<br/>e-mail<input type = "text" name = "email">
	<br/>Пароль<input type = "password" name = password>
	<br/>Подтверждение пароля <input type = "password" name = "confirmPassword">  
	<br/>${errorMessage}  
	<br/><input type = "submit" name = "register" value = "Зарегистрироваться">
</form>
<hr/>
</body>
</html>