package com.sist.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardRestController {
	private final BoardService service;
	
	@PostMapping(value="board/delete_ok.do",produces = "text/html;charset=UTF-8")
	public String board_delete_ok(int no,String pwd) {
		String result="";
		boolean bCheck=service.boardDelete(no, pwd);
		if(bCheck) {
			result="<script>"
					+ "location.href=\'../board/list.do\'"
					+ "</script>";
		}else {
			result="<script>"
					+ "alert(\"비밀번호가 틀립니다!!\");"
					+ "history.back();"
					+ "</script>";
		}
		return result;
	}
}
