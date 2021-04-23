<%@page import="board_proj.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=JndiDS.getConnection() %>
<br>
<a href="boardWriteForm.do">게시판 글쓰기</a>
<br>
<a href="boardList.do">게시판 목록</a>
<br>
<br>
<hr>
<h4>${id }</h4>
	<c:choose>
		<c:when test="${id eq null}">
			<a href="loginForm.html">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>


</body>
</html>