<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
.row{
	margin: 0px auto;
	width: 350px
}
h3{
	text-align: center
}
</style>
	<div class="container">
		<div class="row">
			<h3>삭제</h3>
			<form method="post" action="../board/delete_ok.do">
				<table class="table">
					<tr>
						<td class="text-center">
							비밀번호:<input type="password" name="pwd" size="15" class="input-sm" required>
							<input type="hidden" name="no" value="${no }">
						</td>
					</tr>
					<tr>
						<td class="text-center">
							<button type="submit" class="btn-sm btn-warning">삭제</button>
							<button type="button" class="btn-sm btn-primary" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</html>