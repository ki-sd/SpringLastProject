<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<footer class="footer">
        <div class="container text-center">
            <div class="col-sm-4">
                <h3>인기 맛집</h3>
                <ul>
                	<c:forEach var="vo" items="${fList }">
                		<li><a href="../food/detail.do?no=${vo.no }" style="text-decoration: none;color: black">${vo.name } (${vo.hit })</a></li>
                	</c:forEach>
                </ul>
            </div>
            <div class="col-sm-4">
                <h3>인기 검색어</h3>
            </div>
            <div class="col-sm-4">
                <h3>실시간 뉴스</h3>
            </div>
        </div>
    </footer>
</html>