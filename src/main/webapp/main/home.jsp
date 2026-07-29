<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
.row{
	margin: 0px auto;
	width: 960px
}
p{
	overflow: hidden;
	white-space: nowrap;
	text-overflow: ellipsis;
}
</style>
	<div class="container">
		<div class="row">
			<c:forEach var="vo" items="${list }">
			<div class="col-sm-3">
				<div class="thumbnail">
					<a href="#">
						<img src="${vo.poster }" title="${vo.address }" style="width: 250px;height: 130px;object-fit: cover">
						<p>${vo.name }</p>
					</a>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</html>