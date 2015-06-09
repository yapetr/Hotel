<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<fmt:setBundle basename = "com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.pagescontext" var="rb"/>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
        <form method="POST" action="./EngineServlet">
            <input type="hidden" name="command" value="logout">
            <input type="submit" name="enter" value="Выйти">
        </form>
<a href="./EngineServlet?command=unprocessedOrders"><fmt:message key="adminHeader.label.ordersProcessing" bundle="${rb}"/></a>
<a href="./EngineServlet?command=price"><fmt:message key="adminHeader.label.prices" bundle="${rb}"/></a>
<a href="./EngineServlet?command=roomClassCatalog"><fmt:message key="adminHeader.label.roomsClasses" bundle="${rb}"/></a>
<a href="./EngineServlet?command=roomsCatalog"><fmt:message key="adminHeader.label.numbers" bundle="${rb}"/></a>
<a href="./EngineServlet?command=usersList"><fmt:message key="adminHeader.label.users" bundle="${rb}"/></a>

<hr/>
</body>
</html>