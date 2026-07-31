<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
.row{
	margin: 0px auto;
	width: 900px
}
h3{
	text-align: center
}
a{
	text-decoration: none;
	color: black
}
</style>
	<div class="container">
		<div class="row">
			<h3>묻고 답하기</h3>
			<table class="table">
				<tr>
					<td>
						<a href="../board/insert.do" class="btn btn-sm btn-warning">등록</a>
					</td>
				</tr>
			</table>
			<table class="table table-hover">
				<tr class="success">
					<th width="10%" class="text-center">번호</th>
					<th width="45%" class="text-center">제목</th>
					<th width="15%" class="text-center">작성자</th>
					<th width="20%" class="text-center">작성일</th>
					<th width="10%" class="text-center">조회수</th>
				</tr>
				<c:set var="count" value="${count }"/>
				<c:forEach var="vo" items="${list }">
				<tr>
					<td width="10%" class="text-center">${count }</td>
					<td width="45%">
					<c:if test="${vo.group_tab>0 }">
						<c:forEach var="i" begin="1" end="${vo.group_tab }">
							&nbsp;&nbsp;
						</c:forEach>
						<img src="../board/re_icon.png">
					</c:if>
					<c:if test="${vo.subject!=msg }">
					<a href="../board/detail.do?no=${vo.no }">
					${vo.subject }&nbsp;</a>
					</c:if>
					<c:if test="${vo.subject==msg }">
					<span style="color: gray">${vo.subject }&nbsp;</span>
					</c:if>
						<c:if test="${vo.dbday==today }"><sup><img src="../board/new.gif"></sup></c:if>
					</td>
					<td width="15%" class="text-center">${vo.name }</td>
					<td width="20%" class="text-center">${vo.dbday}</td>
					<td width="10%" class="text-center">${vo.hit }</td>
				</tr>
				<c:set var="count" value="${count-1 }"/>
				</c:forEach>
			</table>
		</div>
		<div class="row text-center" style="margin-top: 10px">
			<ul class="pagination">
				<c:if test="${startPage>1 }">
				<li><a href="../board/list.do?page=${startPage-1 }">&laquo;</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
				<li ${i==curpage?'class="active"':'' }><a href="../board/list.do?page=${i }">${i }</a></li>
				</c:forEach>
				<c:if test="${endPage<totalpage }">
				<li><a href="../board/list.do?page=${endPage+1 }">&raquo;</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</html>