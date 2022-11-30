<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/member/signup" method="post">
		아이디: <input type="text" name="memberId"><br>
		비밀번호: <input type="password" name="password"><br>
		이름: <input type="text" name="name"><br>
		이메일: <input type="email" name="email"><br>
		생년월일: <input type="date" name="birth"><br>
		성별: 남자<input type="radio" name="gender" value="male">
		여자<input type="radio" name="gender" value="female"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>