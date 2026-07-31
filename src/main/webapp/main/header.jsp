<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="../main/main.do">Spring 기타과정</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="../main/main.do">Home</a></li>
				<li><a href="../goods/list.do">스토어</a></li>
				<li><a href="../board/list.do">답변형 게시판</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${sessionScope.id!=null }">
				<li><a href="../member/logout.do"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
				</c:if>
				<c:if test="${sessionScope.id==null }">
				<li><a href="../member/login.do"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				<li><a href="../member/signup.do"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
</html>