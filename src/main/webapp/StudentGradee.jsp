<%@page import="dto.StudentGrade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Grade</h1>
			<% 
			List<StudentGrade> list = (List<StudentGrade>) request.getAttribute("list"); 
			%>
		<table border="1px">
			<tr>
				<td>Name</td>
				<td>Class</td>
				<td>Subject1</td>
				<td>Subject2</td>
				<td>Subject3</td>
				<td>Subject4</td>
				<td>Subject5</td>
				<td>Subject6</td>
				<td>Total</td>
				<td>Percentage %</td>
				<td>Grade</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<%
			for (StudentGrade grade : list){
			%>
			<tr>
			<td><%=grade.getName() %></td>
			<td><%=grade.getClasss() %></td>
			<td><%=grade.getSub1() %></td>
			<td><%=grade.getSub2() %></td>
			<td><%=grade.getSub3() %></td>
			<td><%=grade.getSub4() %></td>
			<td><%=grade.getSub5() %></td>
			<td><%=grade.getSub6() %></td>
			<td><button>Total</button></td>
			<td><button>percentage</button></td>
			<td><button>Grade</button></td>
			<td><button>Edit</button></td>
			<td><button>delete</button></td>
			</tr>
			<%
			}
			%>
		</table>
	<a href="AddStudent.html"><button>Add Student</button></a>
</body>
</html>