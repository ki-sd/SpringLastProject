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
</style>
	<div class="container">
		<div class="row">
			<table class="table">
				<tr>
					<td width="30%" class="text-center" rowspan="3">
						<img src="${vo.goods_poster }" style="width: 290px;height: 250px">
					</td>
					<td colspan="2">
						<h3>${vo.goods_name }&nbsp;<span style="color: red">-${vo.goods_discount }%</span></h3>
					</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray">배송</td>
					<td width="55%">${vo.goods_delivery }</td>
				</tr>
				<tr>
					<td width="15%" style="color: gray">가격</td>
					<c:if test="${vo.goods_price>vo.goods_first_price}">
					<td width="55%"><p style="text-decoration: line-through; color:graytext;">${vo.goods_price}</p>${vo.goods_first_price }</td>
					</c:if>
					<c:if test="${vo.goods_price<vo.goods_first_price}">
					<td width="55%"><p style="text-decoration: line-through; color:graytext;">${vo.goods_first_price}</p>${vo.goods_price }</td>
					</c:if>
				</tr>
				<tr>
					<td colspan="3">${vo.goods_sub }</td>
				</tr>
				<tr>
					<td colspan="3" class="text-right">
						<button onclick="location.href='../goods/list.do'" class="brn btn-sm btn-danger">목록</button>
					</td>
				</tr>
			</table>
		</div>
	</div>
</html>