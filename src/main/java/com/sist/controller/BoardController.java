package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.service.BoardService;
import com.sist.vo.BoardVO;

import lombok.RequiredArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.*;
@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService service;
	
	@GetMapping("board/list.do")
	public String board_list(String page,Model model){
		if(page==null) page="1";
		int curpage=Integer.parseInt(page);
		final int ROWSIZE=10;
		int count=service.boardRowCount();
		int totalpage=(int)Math.ceil(count/10.0);
		count=count-((curpage*ROWSIZE)-ROWSIZE);
		int start=(curpage*ROWSIZE)-ROWSIZE;
		List<BoardVO> list=service.boardListData(start);
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("count", count);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		model.addAttribute("main_jsp", "../board/list.jsp");
		return "main/main";
	}
	@GetMapping("board/insert.do")
	public String board_insert(Model model) {
		model.addAttribute("main_jsp", "../board/insert.jsp");
		return "main/main";
	}
	@PostMapping("board/insert_ok.do")
	public String board_insert_ok(BoardVO vo) {
		service.boardInsert(vo);
		return "redirect:../board/list.do";
	}
	@GetMapping("board/detail.do")
	public String board_detail(int no,Model model) {
		BoardVO vo=service.boardDetailData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../board/detail.jsp");
		return "main/main";
	}
	@GetMapping("board/reply.do")
	public String board_reply(Model model,int no) {
		model.addAttribute("no", no);
		model.addAttribute("main_jsp", "../board/reply.jsp");
		return "main/main";
	}
	@PostMapping("board/reply_ok.do")
	public String board_reply_ok(int pno, BoardVO vo) {
		service.boardReplyInsert(pno, vo);
		return "redirect:../board/list.do";
	}
	@GetMapping("board/update.do")
	public String board_update(int no,Model model) {
		BoardVO vo=service.boardUpdateDetail(no);
		model.addAttribute("vo",vo);
		model.addAttribute("main_jsp", "../board/update.jsp");
		return "main/main";
	}
	@PostMapping("board/update_ok.do")
	public String board_update_ok(int no,BoardVO vo,RedirectAttributes ra,Model model) {
		String msg=service.boardUpdate(no, vo);
		ra.addAttribute("no", no);
		if(msg.equals("OK")) {
			return "redirect:../board/detail.do";
		}else {
			model.addAttribute("msg", msg);
			model.addAttribute("no", no);
			model.addAttribute("vo",vo);
			model.addAttribute("main_jsp", "../board/update.jsp");
			return "main/main";
		}
	}
}
