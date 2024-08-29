<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="text-align: center;">Edit Employee</h1>
<form:form modelAttribute="emp" action="update_data">
<table style="margin-left: auto; margin-right: auto; color:green; background-color:silver ">
<tr>
            <td>First Name:</td>
            <td><form:input path="firstname" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastname" /></td>
        </tr>
        <tr>
            <td>Employee ID:</td>
            <td><form:input path="empid" readonly="true" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><form:input path="emailid" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save"/></td>
        </tr>
</table>
    <div style="text-align: center"><br>
<a href="./" ><img src="resources/image/home.png" height="50" width="50">Home</a>
</div>
</form:form>