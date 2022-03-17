<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("login.jsp");
		}
	%>

	<h1>Welcome ${username}</h1>
	<form action="Logout">
	   Enter user id: <input type="text"><br>
		<input type="submit" value="submit">
	</form>
	<h4>Employe id:${eid}</h4>
	<h4>First name:${fname}</h4>
	<h4>Last name:${lname}</h4>
	<h4>Date of birth:${dob}</h4>
	<h4>Contact number:${contact}</h4>
	<h4>Job role:${jobrole}</h4>
	<h4>Monthly salary:${monthlysal}</h4>
	<h4>Yearly Bonus:${yearly_bonus}</h4>
	<h4>Total Anual Salary :${Anual_sal}</h4>
</body>
</html>