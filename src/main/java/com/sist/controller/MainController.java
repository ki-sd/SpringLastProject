package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

import java.util.*;
@Controller
@RequiredArgsConstructor
public class MainController {
	private final FoodService service;
	@GetMapping("main/main.do")
	public String main_main(String page, Model model) {
		if(page==null) page="1";
		int curpage=Integer.parseInt(page);
		final int ROWSIZE=12;
		int start=(ROWSIZE*curpage)-(ROWSIZE-1);
		int end=(ROWSIZE*curpage);
		List<FoodVO> list=service.foodListData(start, end);
		int totalpage=service.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
}
