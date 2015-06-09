<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
<fmt:setBundle basename = "com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.pagescontext" var="rb"/>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="admin.label.title" bundle="${rb}" /></title>
</head>
<body>
<c:import url="adminHeader.jsp"/>
</body>
</html>