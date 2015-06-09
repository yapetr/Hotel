<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  

<fmt:setBundle basename = "com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.pagescontext" var="rb"/>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="users.label.title" bundle="${rb}" /></title>
</head>
<body>
<c:import url="adminHeader.jsp"/>

<jsp:useBean id="rooms" class="com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean.UsersQuery" scope="page" />
    		
  <table border="1">
   <caption><fmt:message key="users.label.caption" bundle="${rb}" /></caption>
   <tr>
    <th><fmt:message key="users.label.name" bundle="${rb}" /></th> 
    <th><fmt:message key="users.label.login" bundle="${rb}" /></th>
    <th><fmt:message key="users.label.administrator" bundle="${rb}" /></th>
    <th><fmt:message key="users.label.delete" bundle="${rb}" /></th>
   </tr>
       <c:forEach var = "elem" items="${rooms.usersList}" >
       	<tr>
	        <td>
	       		${ elem }
	       	</td>
	        <td>
	       		${ elem.login }
	       	</td>	       	
	        <td>
	       		${ elem.administrator }
	       	</td>
	       	<td>
	       		<form method="post" action="./EngineServlet">
	       			<input type="hidden" name="command" value="deleteUser">
	       			<input type="hidden" name="id" value=${ elem.id }>
	       			<input type="submit" value=" X ">
	       		</form>
	       		
	       	</td>	       	
       	</tr>
       </c:forEach>
        
     </table>       
</body>

</html>