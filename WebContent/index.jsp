<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
  
<fmt:setBundle basename = "com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.pagescontext" var="rb"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd>
<html>
<head>
<meta charset="UTF-8">
<title> <fmt:message key="index.label.title" bundle="${rb}" /> </title>
</head>
<body>
 <a href="./EngineServlet?command=SetLocale&locale=en_US">English</a>
 <a href="./EngineServlet?command=SetLocale&locale=ru_RU">Русский</a>
        <form method="POST" action="./EngineServlet">
            <input type="hidden" name="command" value="login">
            <input type="text" name="login">
            <input type="password" name="password">
            <input type="submit" name="enter" value=<fmt:message key="index.label.enter" bundle="${rb}"/> >
        </form>
       
        <br/>${errorMessage} 
		<br/><a href="./registration.jsp" ><fmt:message key="index.label.registration" bundle="${rb}"/></a>  

</body>
</html>