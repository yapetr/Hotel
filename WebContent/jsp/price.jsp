<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
 
 <fmt:setBundle basename = "com.epam.kiev.kpi.javacourses.petrukhno.project4.resource.pagescontext" var="rb"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="price.label.title" bundle="${rb}" /></title>
</head>
<body>
  <c:import url="adminHeader.jsp"/>
  <jsp:useBean id="prices" class="com.epam.kiev.kpi.javacourses.petrukhno.project4.web.bean.PriceQuery" scope="page" />
  <form method="post" action="./EngineServlet">
      <input type="hidden" name="command" value="setPriceList"> 
	  <table border="1">
	   <caption><fmt:message key="price.label.caption" bundle="${rb}" /></caption>
	   <tr>
	    <th><fmt:message key="price.label.roomClass" bundle="${rb}" /></th> 
	    <th><fmt:message key="price.label.places" bundle="${rb}" /></th>
	    <th><fmt:message key="price.label.price" bundle="${rb}" /></th>
	   </tr>
	       <c:forEach var = "elem" items="${prices.priceList}"  varStatus="loop">
	       	<tr>
		        <td>
		       		${ elem.roomClass.name }
		       	</td>
		        <td>
		       		${ elem.beds }
		       	</td>	       	
		        <td>
		       		<input type = "text" name= "price${loop.count}" value="${ elem.price / 100 }"/>
		       		<input type = "hidden" name= "roomClassId${loop.count}"  value=${ elem.roomClass.id }  >
		       		<input type = "hidden" name= "beds${loop.count}"  value=${ elem.beds }  >
		       			       			
		       	</td>
	       	</tr>
	       </c:forEach>
	        
	     </table>
	     <input type="submit" value=<fmt:message key="price.label.apply" bundle="${rb}" />>
  </form>

</body>
</html>