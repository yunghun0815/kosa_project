<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<h1>테스트서버</h1>
	<sec:authorize access="isAnonymous()">
		<a href="/member/login">로그인</a>
		<a href="/member/signup">회원가입</a>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
		<span>${sessionScope.name}님</span>
		<a href="/member/logout">로그아웃</a>
	</sec:authorize>
</body>
</html>