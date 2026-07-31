<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
body {
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    margin: 0;
}
.container {
    flex: 1;
}
.footer {
    width: 100%;
    padding: 25px 0;
    margin-top: 30px;
    background-color: #f5f5f5;
}
.footer ul {
    list-style: none;
    padding-left: 0;
    margin: 10px 0 0 0;
}
.footer li {
    line-height: 1.8;
}
.footer h3 {
    margin-top: 0;
    font-size: 16px;
    font-weight: bold;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="${main_jsp }"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>