<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,nik.pra.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Getting the data</h1>

<form action="getall">

Click the button to view: <input type="submit">
</form>

<% 
	List<Student> students = (List<Student>)request.getAttribute("students");
	out.print(students);
	

		


%>

</body>
</html>