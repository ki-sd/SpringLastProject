package com.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequiredArgsConstructor
public class MainController {
	private final FoodService fservice;
	@GetMapping("main/main.do")
	public String main_main(String page, Model model,HttpServletRequest request) {
		if(page==null) page="1";
		int curpage=Integer.parseInt(page);
		final int ROWSIZE=12;
		int start=(ROWSIZE*curpage)-(ROWSIZE-1);
		int end=(ROWSIZE*curpage);
		List<FoodVO> list=fservice.foodListData(start, end);
		int totalpage=fservice.foodTotalPage();
		
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage) endPage=totalpage;
		
		model.addAttribute("list",list);
		model.addAttribute("curpage",curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		List<FoodVO> cList=new ArrayList<FoodVO>();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(int i=cookies.length-1;i>0;i--) {
				if(cookies[i].getName().startsWith("food_")) {
					if(cookies[i].getName().equals("food_null")) {
						continue;
					}
					String no=cookies[i].getValue();
					FoodVO vo=fservice.foodDetailData(Integer.parseInt(no));
					cList.add(vo);
				}
			}
		}
		model.addAttribute("cList",cList);
		model.addAttribute("size",cList.size());
		/*
		 *     request/response => cookie / fileupload
		 *     session => 보안 / 회원 관련
		 *     RedirectAttributes => redirect(이미 있는 화면으로 이동)
		 * 
		 */
		
		List<FoodVO> fList=fservice.foodHit7Data();
		model.addAttribute("fList", fList);
		
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
}
