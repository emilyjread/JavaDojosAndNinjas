<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
</head>
<body>
<h1> Create Ninja</h1>

<form:form action="/ninjas" method="post" modelAttribute="ninja">
 
	<p>
        <form:label path="dojo">Dojo: </form:label>
        <form:errors path="dojo"/>
       	<form:select path="dojo" items="${dojos}" itemLabel="name"/>

    </p> 
    <p>
        <form:label path="firstName">First Name: </form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    
    <p>
        <form:label path="lastName">Last Name: </form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    
      <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input type= "number" path="age"/>
    </p>
 
  
    <input type="submit" value="Create"/>
</form:form>	
	
</body>
</html>