<%@page import="board_proj.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=JndiDS.getConnection()%>

	<h1>Hi~~~</h1>
	<h4>${id }</h4>
	<hr>
	<c:choose>
		<c:when test="${id eq null}">
			<a href="loginForm.jsp">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>

</body>
</html>