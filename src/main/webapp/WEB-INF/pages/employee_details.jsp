<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<c:choose>
<c:when test="${!empty details}">
<h1 style="text-align: center">Employee Details</h1>
<c:choose>
<c:when test="${!empty msg}">
<p style="color: red; text-align: center">${msg}</p>
</c:when>
</c:choose>
<table border="1" style="color: green ; text-align: center; margin-left: auto; margin-right: auto; background-color: silver" >
<tr><th>First Name</th><th>Last Name</th><th>Emp Id</th><th>Email Id</th><th colspan="2">Modification</th></tr>
 <c:forEach var="emp" items="${details}">
<tr>
	<td>${emp.firstname}</td>
	<td>${emp.lastname}</td>
	<td>${emp.empid}</td>
	<td>${emp.emailid}</td>
	<td><a href="edit_form?empid=${emp.empid}"><img src="resources/image/edit.png" height="50" width="50"></a>
	   &nbsp;&nbsp;
	    <a href="delete?empid=${emp.empid}" onclick="return confirm('Do you want to delete ?');"><img src="resources/image/delete.png" height="50" width="50"></a>
	</td>
</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
<h1>Empty Details</h1>
</c:otherwise>
</c:choose>
<div style="text-align: center"><br>
<a href="./" ><img src="resources/image/home.png" height="50" width="50">Home</a>
&nbsp;&nbsp;
<a href="./register" ><img src="resources/image/add.png" height="50" width="50">Add</a>
</div>