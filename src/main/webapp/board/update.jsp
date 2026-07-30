<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<style>
.row{
	margin: 0px auto;
	width: 800px
}
h3{
	text-align: center
}
</style>
	<div class="container">
		<div class="row">
			<h3>글 수정</h3>
			<form method="post" action="../board/update_ok.do">
				<table class="table">
					<tr>
						<th width="15%" class="text-center success">이름</th>
						<td width="85%">
							<input type="text" name="name" size="20" class="input-sm" value="${vo.name }" required>
							<input type="hidden" name="no" value="${vo.no }">
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center success">제목</th>
						<td width="85%">
							<input type="text" name="subject" size="60" class="input-sm" value="${vo.subject }" required>
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center success">내용</th>
						<td width="85%">
							<textarea rows="10" cols="62" name="content" required>${vo.content }</textarea>
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center success">비밀번호</th>
						<td width="85%">
							<input type="password" name="pwd" size="10" class="input-sm" required>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button class="btn-sm btn-warning" type="submit">등록</button>
							<button class="btn-sm btn-danger" type="button" onclick="location.href='../board/detail.do?no=${vo.no}'">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
<script>
window.onload=function(){
	let msg='${msg}';
	console.log(msg)
	if(msg!=null && msg==='NOPWD'){
		alert('비밀번호가 맞지 않습니다');
	}
};
</script>
</html>