<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	@font-face {
	    font-family: 'NEXON Lv1 Gothic OTF Light';
	    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-04@2.1/NEXON Lv1 Gothic OTF Light.woff') format('woff');
	    font-weight: normal;
	    font-style: normal;
	}
	
	*{
		box-sizing: border-box;
		font-family: 'NEXON Lv1 Gothic OTF Light', 'Malgun Gothic', Sans-Serif;
		margin: 0;
		padding: 0;
	}
	a{
		text-decoration: none;
		color: black;
	}
	.login-box{
		width: 400px;
		height: 500px;
		margin: 200px auto 0;		
		text-align: center;
	}
	.default{
		background-color: black;
	    color: white;
	    border-radius: 5px;
	    font-size: 18px !important;
	    line-height: 45px !important;
	    cursor: pointer;
	    padding: 0 !important;
	}
	.form-data{
		display: inline-block;
		width: 100%;
		height: 50px;
		border-radius: 5px;
	    margin-bottom: 10px;
	    padding-left: 15px;
	    border: 1px solid #ccc;
	    font-weight: bold;
	}
	.login{
		display: inline-block;
		width: 100%;
		height: 50px;
	    font-weight: bold;
	    font-size: 16px;
	    text-align: center;
	    line-height: 50px;
	    margin-top: 10px;
	    position: relative;
	    padding-left: 20px;
	    border-radius: 5px;
	}
	.google{
	    background-color: white;
	    border: 1px solid #ccc;
	    color: black;
	}
	.google>img{
		position: absolute;
	    width: 26px;
	    top: 12px;
	    left: 15px;
	}
	.naver{
		background-color: #01c73c;
	    border: 1px solid #01c73c;
	    color: #fff;
	    
	}
	.naver>img{
		position: absolute;
	    width: 50px;
	    top: -1px;
	    left: 4px;
	}
	.kakao{
		background-color: #FEE500;
		border: 1px solid #FEE500;
	    color: black;
	}
	.kakao>img{
		position: absolute;
	    left: 10px;
	    width: 38px;
	    top: 5px;
	}
	.line{
   		width: 100%;
	    display: inline-block;
	    background-color: #ccc;
	    height: 1px;
	}
	.sns-alert-text{
		margin-top: 20px;
	}
	.sns-alert-text .sns-login{
		position: relative;
	    bottom: 15px;
	    background-color: white;
	    padding: 0 10px;
	}
	.other-menu{
	    display: flex;
	    font-size: 12px;
	    margin-top: 8px;
	    font-weight: bold;
	    justify-content: space-around;
	}
	.exception{
		font-size: 12px;
	    padding: 8px 0;
	    background-color: #ff6060;
	    color: white;
	    margin-bottom: 5px;
	}
</style>
<body>
	<section class="login-box">
		<c:if test="${not empty exception}">
			<p class="exception">${exception}</p>
		</c:if>
		<form action="/member/login" method="post">
			<input class="form-data" type="text" name="memberId" placeholder="아이디를 입력하세요."><br>
			<input class="form-data" type="password" name="password" placeholder="비밀번호를 입력하세요."><br>
			<input class="login default" type="submit" value="로그인">
		</form>
		<div class="other-menu">
			<a href="/member/signup">회원가입</a>
			<a href="#">ID 찾기</a>
			<a href="#">PW 찾기</a>
		</div>
		<div class="sns-alert-text">
			<span class="line"></span>
			<span class="sns-login">SNS 로그인</span>
		</div>
		<div>
			<a class="login google" href="/oauth2/authorization/google">
				<img src="/image/member/google.svg">
				<span>구글로 로그인</span>
			</a>
			<a class="login naver" href="/oauth2/authorization/naver">
				<img src="/image/member/naver.png">
				<span>네이버로 로그인</span>
			</a>
			<a class="login kakao" href="/oauth2/authorization/kakao">
				<img src="/image/member/kakao.svg">
				<span>카카오로 로그인</span>
			</a>
		</div>
	</section>
</body>
</html>