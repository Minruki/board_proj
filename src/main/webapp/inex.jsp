<%@page import="board_proj.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 테스트</title>

</head>
<body>

나
	<%=JndiDS.getConnection() %>
	<br>
	<a href="boardWriteForm.do">게시판 글쓰기</a>
</body>
</html>